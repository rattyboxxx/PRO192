import java.io.*;
import java.util.Arrays;
public class ComputeGrades {
    
    private final String UNDER_GRAD = "U";
    private final String GRAD = "G";
    private Student[] roster;

    public void ProcessData(String file) {
        try {
            buildRoster(file);
            computeGrade();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buildRoster(String filename) throws FileNotFoundException, IOException {

        int studentCount = 0;
        File f = new File(filename);
        if(!f.exists()) return;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String input = null;
        while((input = br.readLine()) != null) studentCount++;
        br.close();
        fr.close();

        roster = new Student[studentCount];
        studentCount = 0;
        fr = new FileReader(f);
        br = new BufferedReader(fr);
        input = null;
        while ((input = br.readLine()) != null)
        {
            Student student = createStudent(input);
            if (student != null) roster[studentCount++] = student;
        }
        br.close();
        fr.close();   

    }

    private void computeGrade() {
        for (Student st : roster) {
            st.computeCourseGrade();
        }
    }

    private Student createStudent(String line) {

        String[] tokens = line.split(" ");
        if (tokens.length < Student.NUM_OF_TESTS + 3) {
            return null;
        }
        Student student;
        if (tokens[0].equals(UNDER_GRAD)) {
            student = new UndergraduateStudent();  
        } else if (tokens[0].equals(GRAD)) {
            student = new GraduateStudent();       
        } else {
            return null;
        }
        //set the student name
        student.setName(tokens[1] + " " + tokens[2]);
        try {
            //set the student test scores
            for (int testNum = 0; testNum < Student.NUM_OF_TESTS; testNum++) {
               student.setTestScore(testNum, Integer.parseInt(tokens[testNum + 3])); 
            }
        } catch (Exception e) {
            student = null;
        }
        return student;
    }


    public void PrintResult() {
        for (Student st : roster) {
            //print one student
            if (st instanceof UndergraduateStudent) System.out.print("U"); 
            else System.out.print("G");
            System.out.print("\t" + st.getName());
            for (int testNum = 0; testNum < Student.NUM_OF_TESTS; testNum++) {
                System.out.print("\t" + st.getTestScore(testNum));
            }
            System.out.println("\t" + st.getCourseGrade());
        }
    }

    public void SortByName()
    {
        Arrays.sort(roster, new NameComparer());
    }

}
