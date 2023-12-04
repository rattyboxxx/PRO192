public class Main {

    public static void main(String[] args) {
        ComputeGrades gradeComputer = new ComputeGrades();
        gradeComputer.ProcessData("C:\\Java\\Data.txt");
        System.out.println("OUTPUT:");
        System.out.println("The Student's list:");
        gradeComputer.PrintResult();
        System.out.println("\nThe Student's list sorted by the Name order:");
        gradeComputer.SortByName();
        gradeComputer.PrintResult();

    }
   
}
