/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import Employee.*;
import Student.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.bson.Document;
import rmi.MaterialInterface;
import rmi.TAInterface;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public class TA extends Employee implements TAInterface{

    public TA() throws RemoteException {

    }
    int courseID;

    public TA(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, int courseID) throws RemoteException {
        super(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
        this.courseID = courseID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    
    
        @Override
    public void UpdateMaterialTitle(int matid, String title) throws RemoteException {
        Material m = new Material();
        m.UpdateMaterialTitle(matid, title);
    }
    
    @Override
    public void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException {
        Material m = new Material();
        m.UpdateMaterialVisibility(matid, vis);
    }
   
 @Override   
 public ArrayList<MaterialInterface> getMaterialss(int courseID)  throws RemoteException{
     Material m = new Material();
     return m.getMaterialss(courseID);
 }


    public void setStudentAttendance(Course course, Student student) {

    }

    public void setStudentContribution(Course course, String Cotrib) {

    }

    public void setCourseMaterialVisbility(Material courseMaterial, Boolean isVibile) {

    }

    public void HandleComplaint() {

    }

}
