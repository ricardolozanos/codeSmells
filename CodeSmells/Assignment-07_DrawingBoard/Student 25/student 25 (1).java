@Supress Warnings("Serial")
public class HelloWorld extends NoApplet{
    public HelloWorld(){
        
    }
    public HelloWorld(String[] params){
        super(params);
    }

    protected void paintComponent(Graphics g){
        Shape circle = new Shape(100, 100, Color.yellow);

        Shape triangle = new Shape(10, 20, Color.red);

        Shape square = new Shape(100, 100, Color.pink);

        Shape name = new Shape(50, 50, Color.black);

        circle.circle(100, g);
        triangle.triangle(10, 10, g);
        square.square(100, 100, g);
        name.name(g);



    }
}