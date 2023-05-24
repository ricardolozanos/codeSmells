import java.awt.*;
import javax.swing.*;


public class Solar extends JComponent {
  private static final int WIDTH = 600;
  private static final int HEIGHT = 600;

  private static final int SUN_DIAMETER = 100;
  private static final int EARTH_DIAMETER = 25;
  private static final int EARTH_ORBIT_RADIUS = 100;
  private static final int EARTH_TRAVEL_DEGREES = 65;
  private static final int MARS_ORBIT_RADIUS = 150;
  private static final int MARS_DIAMETER = 50;
  private static final int JUPITER_ORBIT_RADIUS = 200;
  private static final int JUPITER_DIAMETER = 70;
  private static final int MERCURY_ORBIT_RADIUS = 75;
  private static final int MERCURY_DIAMETER = 30;
 
  private static final int MOON_DIAMETER = 10;
  private static final int MOON_ORBIT_RADIUS = 50;
  private static final int MOON_TRAVEL_DEGREES = 5;


  private int earthTravel = 0;
  private int marsTravel= 0 ;
  private int jupiterTravel= 0 ;
  private int mercuryTravel= 0 ;

  private int moonTravel = 0;


  /**
 * 
 */
public Solar() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setDoubleBuffered(true);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    Dimension d = getSize();
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, d.width, d.height);
    g.setFont(new Font("San-serif", Font.BOLD, 24));
    g.setColor(new Color(130, 215,0));
    g.drawString("Javier Venegas", 100, 40);
    g.drawString("Jose Barajas", 300, 40);

    

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    // Draw the sun
    int sunX = WIDTH / 2 - SUN_DIAMETER / 2;
    int sunY = HEIGHT / 2 - SUN_DIAMETER / 2;
    g2d.setColor(Color.YELLOW);
    g2d.fillOval(sunX, sunY, SUN_DIAMETER, SUN_DIAMETER);

    // Draw the Earth
    int earthX = (int) (WIDTH / 2 + Math.cos(Math.toRadians(earthTravel)) * EARTH_ORBIT_RADIUS);
    int earthY = (int) (HEIGHT / 2 + Math.sin(Math.toRadians(earthTravel)) * EARTH_ORBIT_RADIUS);
    g2d.setColor(Color.BLUE);
    g2d.fillOval(earthX, earthY, EARTH_DIAMETER, EARTH_DIAMETER);

    g2d.setColor(Color.BLACK);
    g2d.drawString("Earth", earthX, earthY);

    int moonX = (int) (earthX + Math.cos(Math.toRadians(moonTravel)) * MOON_ORBIT_RADIUS);
    int moonY = (int) (earthY + Math.sin(Math.toRadians(moonTravel)) * MOON_ORBIT_RADIUS);
    g2d.setColor(Color.GRAY);
    g2d.fillOval(moonX, moonY, MOON_DIAMETER, MOON_DIAMETER);



    int marsX = (int) (WIDTH / 2 + Math.cos(Math.toRadians(marsTravel)) * MARS_ORBIT_RADIUS);
    int marsY = (int) (HEIGHT / 2 + Math.sin(Math.toRadians(marsTravel)) * MARS_ORBIT_RADIUS);
    g2d.setColor(Color.RED);
    g2d.fillOval(marsX, marsY, MARS_DIAMETER, MARS_DIAMETER);

    int moon2X = (int) (marsX + Math.cos(Math.toRadians(moonTravel)) * MOON_ORBIT_RADIUS);
    int moon2Y = (int) (marsY + Math.sin(Math.toRadians(moonTravel)) * MOON_ORBIT_RADIUS);
    g2d.setColor(Color.GRAY);
    g2d.fillOval(moon2X, moon2Y, MOON_DIAMETER, MOON_DIAMETER);

    int moon3X = (int) (marsX + Math.cos(Math.toRadians(moonTravel)) * MOON_ORBIT_RADIUS);
    int moon3Y = (int) (marsY + Math.sin(Math.toRadians(moonTravel)) * MOON_ORBIT_RADIUS);
    g2d.setColor(Color.GRAY);
    g2d.fillOval(moon3X, moon3Y, MOON_DIAMETER, MOON_DIAMETER);

    int jupiterX = (int) (WIDTH / 2 + Math.cos(Math.toRadians(jupiterTravel)) * JUPITER_ORBIT_RADIUS);
    int jupiterY = (int) (HEIGHT / 2 + Math.sin(Math.toRadians(jupiterTravel)) * JUPITER_ORBIT_RADIUS);
    g2d.setColor(Color.GREEN);
    g2d.fillOval(jupiterX, jupiterY, JUPITER_DIAMETER, JUPITER_DIAMETER);

    int mercuryX = (int) (WIDTH / 2 + Math.cos(Math.toRadians(mercuryTravel)) * MERCURY_ORBIT_RADIUS);
    int mercuryY = (int) (HEIGHT / 2 + Math.sin(Math.toRadians(mercuryTravel)) * MERCURY_ORBIT_RADIUS);
    g2d.setColor(Color.ORANGE);
    g2d.fillOval(mercuryX, mercuryY, MERCURY_DIAMETER, MERCURY_DIAMETER);


    earthTravel += EARTH_TRAVEL_DEGREES;
    marsTravel += EARTH_TRAVEL_DEGREES;
    jupiterTravel += EARTH_TRAVEL_DEGREES;
    mercuryTravel += EARTH_TRAVEL_DEGREES;
    moonTravel += MOON_TRAVEL_DEGREES;

    
    if (earthTravel >= 360) {
      earthTravel = 0;
    }
    if (marsTravel >= 400) {
        marsTravel = 0;
    }
    if (jupiterTravel >= 450) {
        jupiterTravel = 0;
    }
    if (mercuryTravel >= 280) {
        mercuryTravel = 0;
    }
      
      
      
  }
  
  

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Solar());
    frame.pack();
    frame.setVisible(true);
  }
}


