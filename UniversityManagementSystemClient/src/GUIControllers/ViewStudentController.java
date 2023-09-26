package GUIControllers;


import GUIControllers.StudentHomeController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.Student;
import rmi.StudentDTO;
import rmi.StudentFacadeInterface;
import universitymanagementsystemclient.GUIs.StudentHome;
import universitymanagementsystemclient.GUIs.StudentView;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author infolos
 */
public class ViewStudentController {
    StudentView sd;
    Registry reg;
    Student stud;

    public ViewStudentController(StudentView sd, Registry reg, Student studs) throws RemoteException {
        this.sd = sd;
        this.reg = reg;
        this.stud = studs;
        
        sd.getPassword().setText(stud.getPassword());
        sd.getEmail().setText(stud.getEmail());
        sd.getFname().setText(stud.getStudentFName());
        sd.getLname().setText(stud.getStudentLName());
        sd.getPass().addActionListener(new PassChange());
        sd.getCancel().addActionListener(new Cancel());
    }
    
    class Cancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                StudentHome guii = new StudentHome();
                guii.setVisible(true);
                sd.setVisible(false);
                StudentHomeController newCont = new StudentHomeController(guii,reg,  stud);
            } catch (RemoteException ex) {
                Logger.getLogger(ViewStudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    class PassChange implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
        
        
    }
    
}
