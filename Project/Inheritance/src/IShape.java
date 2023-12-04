public interface IShape {
    double pi = 3.14; //public static final
    String name = "Shape";
    double perimeter();
    double are();
    
    static void display()
    {
        System.out.println("Display shape");
    }
    
    default void print()
    {
        System.out.println("Print shape");
    }
}
