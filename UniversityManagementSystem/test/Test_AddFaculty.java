
import SuperiorAdmin.SuperiorAdmin;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rmi.FacultyInterface;



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
public class Test_AddFaculty {

    SuperiorAdmin sa = null;

    @BeforeClass
    public void AddFaculty() {
        System.out.println("Add Faculty Test is Running for Class Superior Admin");
    }

    @AfterClass
    public static void tearDownClass() {

        System.out.println("Tesing Done for the class");
    }

    @Before
    public void setUp() throws RemoteException {
        sa = new SuperiorAdmin();
        System.out.println("This object needed before each test");
    }

    @After
    public void tearDown() {
        System.out.println("This is running after each test");

    }

    @Test
    public void TestAddFaculty() throws RemoteException {
        sa.AddFaculty(1, "ICS", "Mahmoud", "ahmed@waleed.com", 1);
        ArrayList<FacultyInterface> faculties = new ArrayList<>();
        faculties = sa.getFaculties();
        boolean found = false;
        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).getName().equals("ICS") && faculties.get(i).getMail().equals("ahmed@waleed.com")) {
                found = true;
                break;
            }
        }
        if (found == true) {
            System.out.println("3azama");
        }
    }

}
