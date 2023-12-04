
public class Main {
    public static void main(String[] args) {
        ScholarshipList sl = new ScholarshipList();
        sl.loadFromFile("data.txt");
        sl.check();
        sl.saveToFile("output.txt");
    }
}
