public class Main
{
    public static void main(String[] args)
    {
        Rectangle[] rectangles = new Rectangle[2];
        
        rectangles[0] = new Rectangle(20,10);
        System.out.println("Peri = " + rectangles[0].perimeter());
        rectangles[0].display();
        
        Circle c = new Circle(5);
        System.out.println(c.perimeter() + "\n" + c.are());
        
        rectangles[1] = new Box(20,10,30);             
        ((Box)rectangles[1]).setHeight(100);
        
        for(Rectangle r : rectangles)
        {           
            if(r instanceof Box)
            {
                System.out.println("Box's information:");
                System.out.println((Box)r);
            }
            else
            {                
                System.out.println("Rectangle's information:");
                System.out.println(r);
            }
        }
    }
}
