package noapplet.example;

import java.awt.*;

/**
 * Sample use of the AnimationNoApplet class to bounce a ball.
 * Need to override only two methods: initAnimation() and paint().
 */
@SuppressWarnings("serial")
class BouncingBallAnimation extends AnimationNoApplet {
    CircleBall ball1 = new CircleBall(new int[] {100, 250});
    RectBall ball3 = new RectBall(new int[] {250, 100}, 20, 40);
    CircleBall ball2 = new CircleBall(new int[] {getSize().height/2, getSize().width/2});
    CircleBall ball4 = new CircleBall(new int[] {getSize().height/2 + 100, getSize().width/2});
    Ball[] ballArray = new Ball[] {ball1, ball2, ball3, ball4};
    int[][] ballPositions = new int[ballArray.length][2];

    public BouncingBallAnimation(String[] args) {
        super(args);
    }

    @Override
    protected void initAnimation() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // fill the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);

        for (int i = 0; i < ballArray.length; i++) {
            ballPositions[i] = ballArray[i].getPosition();
        }

        for (Ball ball: ballArray){
            for (Ball otherBall: ballArray){
                if (ball == otherBall){
                    continue;
                }
                boolean overlapInXUp = ball.getLeftEdge() < otherBall.getLeftEdge() && ball.getRightEdge() >  otherBall.getLeftEdge();
                boolean overlapInXDown = otherBall.getLeftEdge() < ball.getLeftEdge() && otherBall.getRightEdge() >  ball.getLeftEdge();
                boolean overlapInYUp = ball.getDownEdge() > otherBall.getDownEdge() && ball.getUpEdge() <  otherBall.getDownEdge();
                boolean overlapInYDown = otherBall.getDownEdge() > ball.getDownEdge() && otherBall.getUpEdge() <  ball.getDownEdge();
                if ((overlapInXUp || overlapInXDown) && (overlapInYDown || overlapInYUp)) {
                    ball.setDx(-ball.getDx());
                    otherBall.setDx(-otherBall.getDx());
                    ball.setDy(-ball.getDy());
                    otherBall.setDy(-otherBall.getDy());
                }
            }
            ball.draw(g, dim);
        }

        g.setColor(Color.WHITE);
        g.drawString("Tadeo de la Rocha", 25, 25);
    }

}
