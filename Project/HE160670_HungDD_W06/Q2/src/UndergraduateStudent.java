public class UndergraduateStudent extends Student{
    
    @Override
    public void computeCourseGrade() {

      int total = 0;
      for(int i : test) total += i;
      if (total / NUM_OF_TESTS >= 70) courseGrade = "Pass";
      else courseGrade = "No Pass";
      
    }
    
}
