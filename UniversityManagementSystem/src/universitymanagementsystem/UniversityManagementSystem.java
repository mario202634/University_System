/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

//import universitymanagementsystemclient.GUIs.SplashScreen;
import Admin.Admin;
import Doctor.Doctor;
import Employee.Employee;
import Finance.Finance;
import rmi.user;
import Student.Student;
import SuperiorAdmin.SuperiorAdmin;
import TA.TA;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.AdminInterface;
import rmi.DoctorInterface;
import rmi.FinanceInterface;
import rmi.MaterialInterface;
import rmi.SuperiorAdminInterface;
import rmi.TAInterface;

// import PackageName.ClassName;
/**
 *
 * @author ahmedwaleed
 */
public class UniversityManagementSystem {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        //Calling the class for the database 
        DBConnect db = new DBConnect();

        // Here we create our remote object
        user student = new Student();
        user superior = new SuperiorAdmin();
        user admin = new Admin();
        user finance = new Finance();
        user doctor = new Doctor();
        user tas = new TA();
        user employee = new Employee();
        
        //user fin = new Finance();

        MaterialInterface material = new Material();
        AdminInterface adminInterface = new Admin();
        SuperiorAdminInterface superiorinterface = new SuperiorAdmin();
        FinanceInterface financeinterface = new Finance();
        Registry r = LocateRegistry.createRegistry(1099);
        DoctorInterface doctorr = new Doctor();
        TAInterface tainterface = new TA();
        // Our remote object g is binded to the name "grade"
        r.bind("database", db);
        r.bind("student", student);
        r.bind("employee", employee);
        r.bind("admin", admin);
        r.bind("doctor", doctor);
        r.bind("ta", tas);
        r.bind("finance", finance);
        r.bind("superior", superior);

        r.bind("admininterface", adminInterface);
        r.bind("financeinterface", financeinterface);
        r.bind("superiorinterface", superiorinterface);
        r.bind("material", material);
        r.bind("doctorinterface", doctorr);
        r.bind("tainterface", tainterface);

        Material m = new Material();
//        m.AddCourseMaterial(1, "Lecture 5", true, 2);
//        m.AddCourseMaterial(2, "Lecture 6", true, 2);
//        m.AddCourseMaterial(3, "Lecture 7", true, 2);
//        m.AddCourseMaterial(4, "Lecture 8", true, 2);

        System.out.println("Server is ready");
    }

}
