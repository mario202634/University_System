/**
 *
 * @author infolos
 */

import Admin.Admin;
import Student.Student;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import universitymanagementsystem.Observer;

public class TestStudentSignUp {
    
    /*
        private int StudentID;
    private String StudentFName;
    private String StudentLName;
    private String Email;
    private String Password;
    private float StudentOverAllGrade;
    private boolean isGraduated;
    private boolean paidTutionFees;
    private String Major;
    private String Faculty;
    private ArrayList<String> Courses;
    */
    ArrayList<String> coursess = new ArrayList<>();
    Student stud = null;
    
    
    
    @BeforeClass
    public static void setUpClass() {
                System.out.println("Testing is Running for the class");
    }

    @AfterClass
    public static void tearDownClass() {

                System.out.println("Tesing Done for the class");
    }
    
    
    
    @Before
    public void setUpClass(){
        try {
            coursess.add("Course 1");
            //Student(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty, ArrayList<String> Courses, ArrayList<Observer> Observers) throws RemoteException {

            stud = new Student(5,"Test","test2","test@test.com","testing", (float)1.2,false,true,"SE","ICS",coursess, null);
       
        } catch (RemoteException ex) {
            Logger.getLogger(TestStudentSignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @Test
    public void testRegister() throws RemoteException{
        ArrayList<Student> stds = new ArrayList<>();
        Admin admin = new Admin();
        admin.RegisterStudent(stud.getStudentID(), stud.getStudentFName(), stud.getStudentLName(), stud.getEmail(), stud.getPassword(), stud.getStudentOverAllGrade(), false, true, stud.getMajor(), stud.getFaculty());
        int targetId = 5;
        stds = admin.getStudents();
        boolean found = false;
        for(int i = 0; i < stds.size(); i++){
            if(stds.get(i).getStudentID() == targetId){
                found = true;
                break;
            } 
        }
        if(found){
            System.out.println("It works! and the student got registered succesfully");
        }
        
    }
    
    
}