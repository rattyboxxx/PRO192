public class Baby {
    String name;
    double weight;
    public static class leg
    {
        double length;
        
        public leg(double length)
        {
            this.length = length;
        }
        
        public void print()
        {
            System.out.println("Chan dai: " + length);
        }
    }
}
