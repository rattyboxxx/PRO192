/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author 叫我Ratty
 */
public class Mark {
    private String studentID;
    private String subjectID;
    private double marks;

    public Mark() {
    }

    public Mark(String studentID, String subjectID, double marks) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.marks = marks;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    public String toString() {
        return studentID + ";" + subjectID + ";" + marks;
    }
}
