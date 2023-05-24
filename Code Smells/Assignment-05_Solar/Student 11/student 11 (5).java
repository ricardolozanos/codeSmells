import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SolarSystem extends JPanel implements ActionListener {
    static final int WINDOW_WIDTH = 1000, WINDOW_HEIGHT = 1000;
    Sun sun = new Sun("Solar",120, Color.ORANGE,WINDOW_WIDTH/2,WINDOW_HEIGHT/2);
    ArrayList<Planet> entity;
    Timer timer;
    public SolarSystem(){
         entity = new ArrayList<>(){{{
            add(new Planet("Mercury",4, Color.RED));
            get(0).setParent(sun);
            get(0).setDistanceFromParent(5);
            get(0).setMaxRevolutionPeriod(87);
            add(new Planet("Venus",12,Color.PINK));
            get(1).setParent(sun);
            get(1).setDistanceFromParent(10);
            get(1).setMaxRevolutionPeriod(224);
            add(new Planet("Earth",12,Color.BLUE));
            get(2).setParent(sun);
            get(2).setDistanceFromParent(15);
            get(2).setMaxRevolutionPeriod(365);
            add(new Planet("Mars",6,Color.PINK));
            get(3).setParent(sun);
            get(3).setDistanceFromParent(23);
            get(3).setMaxRevolutionPeriod(686);
            add(new Planet("Jupiter",14,new Color(165,42,42)));
            get(4).setParent(sun);
            get(4).setDistanceFromParent(78);
            get(4).setMaxRevolutionPeriod(4328);
            add(new Planet("Saturn",12,Color.CYAN));
            get(5).setParent(sun);
            get(5).setDistanceFromParent(144);
            get(5).setMaxRevolutionPeriod(10752);
            add(new Planet("Uranus",5,Color.BLUE));
            get(6).setParent(sun);
            get(6).setDistanceFromParent(290);
            get(6).setMaxRevolutionPeriod(30663);
            add(new Planet("Neptune",5,Color.GRAY));
            get(7).setParent(sun);
            get(7).setDistanceFromParent(300);
            get(7).setMaxRevolutionPeriod(60148);
        }}};
        timer = new Timer(1,this);
        timer.start();
    }
    public static void main(String ... args){
        JFrame frame = new JFrame("Solar System");
        SolarSystem system = new SolarSystem();
        system.setVisible(true);
        frame.add(system);
        frame.setTitle("Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void drawPlanetRelativeToSun(Sun sun, Planet planet, Graphics g){
        int x = sun.getCenterX(), y = sun.getCenterY();
        int offset = sun.getRadius() / 2;
        int r = planet.getDistanceFromParent() + offset;
        planet.draw(
                x - (int)(r * Math.cos(planet.getDegreeFromParent() * (Math.PI/180))),
                y - (int)(r * Math.sin(planet.getDegreeFromParent() * (Math.PI/180))),
                g
        );
    }
    @Override
    public void paintComponents(Graphics g){
        super.paintComponents(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        sun.draw(g);
        entity.forEach(e -> drawPlanetRelativeToSun(sun,(Planet)e,g));
    }
    @Override
    public void paintComponent(Graphics g){
        paintComponents(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
        entity.forEach(Planet::incrementCurrentPeriod);
    }
}
