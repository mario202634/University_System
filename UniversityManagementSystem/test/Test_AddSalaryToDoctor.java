
import Employee.Employee;
import Finance.Finance;
import java.rmi.RemoteException;
import java.util.ArrayList;

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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmedwaleed
 */
public class Test_AddSalaryToDoctor {

    Finance f= null;

    

     @BeforeClass
    public static void setUpClass() {
                System.out.println("Testing is Running for the class");
    }

    @AfterClass
    public static void tearDownClass() {

                System.out.println("Tesing Done for the class");
    }

    @Before
    public void setUp() {
                Finance f = null;
                System.out.println("This object needed before each test");
    }

    public void addSalary() throws RemoteException{


            f.setDoctorSalary(1, 60.00);


            ArrayList<Employee> finance = new ArrayList<>();
            finance=f.getDoctors();
            boolean found = false;
            for(int i = 0 ; i<=finance.size();i++){

            if(finance.get(i).getEmployeeSalary()==60.00&&finance.get(i).getEmployeeID()==1){

                System.out.println("test done");

            }
            }
    }
}

