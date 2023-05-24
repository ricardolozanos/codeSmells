package noapplet.example;

import java.awt.*;

public class Map{
    short[][] map;
    final short BLACK=1;
    final short WHITE=-1;
    boolean checkBNW=true;

    MapSize ms;
    public Map(MapSize ms){
        this.ms=ms;
        map=new short[ms.getSize()][];
        for(int i=0;i<map.length;i++)
            map[i]=new short[ms.getSize()];

        System.out.println("map");
    }
    public short getBlack() {
        return BLACK;
    }
    public short getWhite() {
        return WHITE;
    }
    public short getXY(int y,int x) {
        return map[y][x];
    }
    public boolean getCheck() {
        return checkBNW;
    }
    public void changeCheck() {
        if(checkBNW)
            checkBNW=false;
        else
            checkBNW=true;
    }
    public void setMap(int y,int x) {
        if(checkBNW)
            map[y][x]=BLACK;
        else
            map[y][x]=WHITE;
    }
    public boolean winCheck(int x,int y){
        if(winCheckL(x, y)||winCheckLD(x, y)||winCheckLU(x, y)||winCheckR(x, y)
                ||winCheckRD(x, y)||winCheckRU(x, y)||winCheckUp(x, y)||winCheckDown(x, y)
                ||winCheckOneDown(x, y)||winCheckOneL(x, y)||winCheckOneLD(x, y)||winCheckOneLU(x, y)
                ||winCheckOneR(x, y)||winCheckOneRD(x, y)||winCheckOneUp(x, y)||winCheckOneRU(x, y)
                ||winCheckCenterLU(x, y)||winCheckCenterRL(x, y)||winCheckCenterRU(x, y)||winCheckCenterUD(x, y))
            return true;
        else
            return false;
    }

    //topside
    public boolean winCheckUp(int x,int y) {
        for(int i=y;i<y+5;i++){
            if(map[y][x]!=map[i][x])
                return false;
        }
        return true;
    }
    //down
    public boolean winCheckDown(int x,int y) {
        for(int i=y;i>y-5;i--){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //upper right diagonal
    public boolean winCheckRU(int x,int y) {
        for(int i=y, z=x;i>y-5;i--,z++){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    //upper left diagonal
    public boolean winCheckLU(int x,int y) {
        for(int i=y, z=x;i>y-5;i--,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    //right
    public boolean winCheckR(int x,int y) {
        for(int z=x;z<x+5;z++){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }

    //left
    public boolean winCheckL(int x,int y) {
        for(int z=x;z>x-5;z--){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }

    //diagonal lower right
    public boolean winCheckRD(int x,int y) {
        for(int i=y, z=x;i<y+5;i++,z++){
            if(map[y][x]!=map[i][z]||i>19||z>19||i<0||z<0)
                return false;
        }

        return true;
    }

    //diagonal lower left
    public boolean winCheckLD(int x,int y) {
        for(int i=y, z=x;i<y+5;i++,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }
    //one space up
    public boolean winCheckOneUp(int x,int y) {
        for(int i=y-1;i<y+4;i++){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //one space down
    public boolean winCheckOneDown(int x,int y) {
        for(int i=y+1;i>y-4;i--){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //diagonal upper right
    public boolean winCheckOneRU(int x,int y) {
        for(int i=y+1, z=x-1;i>y-4;i--,z++){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    //diagonal upper left
    public boolean winCheckOneLU(int x,int y) {
        for(int i=y+1, z=x+1;i>y-4;i--,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    //one space to the right
    public boolean winCheckOneR(int x,int y) {
        for(int z=x-1;z<x+4;z++){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }

    //one space left
    public boolean winCheckOneL(int x,int y) {
        for(int z=x+1;z>x-4;z--){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }

    //Diagonal down one space to the right
    public boolean winCheckOneRD(int x,int y) {
        for(int i=y-1, z=x-1;i<y+4;i++,z++){
            if(map[y][x]!=map[i][z]||i>19||z>19||i<0||z<0)
                return false;
        }

        return true;
    }

    //Diagonal one space lower left
    public boolean winCheckOneLD(int x,int y) {
        for(int i=y-1, z=x+1;i<y+4;i++,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }
    //center up down
    public boolean winCheckCenterUD(int x,int y) {
        for(int i=y-2;i<y+3;i++){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //center right left
    public boolean winCheckCenterRL(int x,int y) {
        for(int z=x-2;z<x+3;z++){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }
    //center light diagonal
    public boolean winCheckCenterRU(int x,int y) {
        for(int i=y+2, z=x-2;i>y-3;i--,z++){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }
    //center left diagonal
    public boolean winCheckCenterLU(int x,int y) {
        for(int i=y+2, z=x+2;i>y-4;i--,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }
}