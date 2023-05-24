import java.awt.*;

public class Planet extends Circle{
    private int currentPeriod;
    private int maxRevolutionPeriod;
    public Planet(String name,int radius, Color color){
       super(name,radius,color);
    }
    public void setMaxRevolutionPeriod(int period){
        this.maxRevolutionPeriod = period;
    }
    public void incrementCurrentPeriod(){
        if(currentPeriod >= maxRevolutionPeriod) {
            super.incrementDegreeFromParent();
            currentPeriod = 0;
            return;
        }
        currentPeriod += 15;
    }

}
