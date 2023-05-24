package noapplet.example;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter {
    Map map;
    int x,y;
    MapSize ms;
    DrawBoard d;
    GUI main;
    public MouseEventHandler(Map m, MapSize ms, DrawBoard d, GUI main) {
        map=m;
        this.ms=ms;
        this.d=d;
        this.main=main;
    }
    @Override
    public void mousePressed(MouseEvent g) {
        super.mousePressed(g);
        System.out.println("mouse");
        int x=(int)Math.round(g.getX()/(double)ms.getCell())-1;
        int y=(int)Math.round(g.getY()/(double)ms.getCell())-2;

        if(x<0||x>19||y<0||y>19)
            return;
        if(map.getXY(y, x)==map.getBlack()||map.getXY(y, x)==map.getWhite())
            return;

        System.out.println(x+" "+y);
        map.setMap(y, x);
        map.changeCheck();
        d.repaint();
        if(map.winCheck(x, y))
            if(map.getCheck()==true)
                main.popUp("White Stone Victory!");
            else
                main.popUp("Black Stone Victory!");
    }
}