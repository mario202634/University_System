/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rmi.DoctorInterface;
import rmi.EmployeeInterface;
import rmi.MaterialInterface;
import rmi.TAInterface;
import universitymanagementsystemclient.GUIs.Login;
import universitymanagementsystemclient.GUIs.TAViewMaterials;

/**
 *
 * @author ahmedwaleed
 */
public class TAMaterialsController {

    TAViewMaterials gui;
    Registry r;
    EmployeeInterface employee;
    TAInterface ta;

    public TAMaterialsController(TAViewMaterials gui, Registry r, TAInterface ta) {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) ta;

        gui.getMaterialidtb().setEditable(false);

        gui.getShowbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

//                    System.out.println("Line 1");
                    TAInterface doctor = (TAInterface) r.lookup("tainterface");
//                    System.out.println("Line 2");
                    DefaultTableModel model = new DefaultTableModel();
//                    System.out.println("Line 3");
                    model.setColumnCount(0);
//                    System.out.println("Line 4");
                    String header[] = new String[]{"ID", "Title", "Visibility", "CourseID"};
//                    System.out.println("Line 5");
                    model.setColumnIdentifiers(header);
//                    System.out.println("Line 6");
                    gui.getMaterialstbl().setModel(model);
//                    System.out.println("Line 7");
                    MaterialInterface std;
//                    System.out.println("Line 8");
                    int doctoridd;
                    doctoridd = Integer.parseInt(gui.getCidbtn().getText());
                    System.out.println(doctor.getMaterialss(doctoridd));
//                    System.out.println("Line 9");
                    for (int i = 0; i < doctor.getMaterialss(doctoridd).size(); i++) {

                        //String id = stud.getCoursesID().get(i);
                        std = (MaterialInterface) doctor.getMaterialss(doctoridd).get(i);
                        int id = std.getID();
                        String title = std.getMaterialTitle();
                        boolean vis = std.isMaterialVisibility();
                        int cid = std.getCourseID();

                        model.addRow(new Object[]{id, title, vis, cid});
                    }

                } catch (RemoteException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        gui.getBackbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           gui.getBackbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           try{
                Login am = new Login();
                        am.setLocationRelativeTo(null);
                        am.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        LoginController amc = new LoginController(am, r);
                        gui.dispose();
           }    catch (RemoteException ex) {
                    Logger.getLogger(ManageTAsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
            }
        });
        gui.getMaterialstbl().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel defaulttablemodelmodel = (DefaultTableModel) gui.getMaterialstbl().getModel();
                int index = gui.getMaterialstbl().getSelectedRow();
                gui.getMaterialidtb().setText(defaulttablemodelmodel.getValueAt(index, 0).toString());
                gui.getTitletb().setText(defaulttablemodelmodel.getValueAt(index, 1).toString());
                gui.getVisibilitytb().setText(defaulttablemodelmodel.getValueAt(index, 2).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        gui.getUpdatebtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TAInterface doctor = (TAInterface) r.lookup("tainterface");
                    int id = Integer.parseInt(gui.getMaterialidtb().getText());
                    String title = gui.getTitletb().getText();
                    boolean visibility = Boolean.parseBoolean(gui.getVisibilitytb().getText());

                    doctor.UpdateMaterialTitle(id, title);
                    doctor.UpdateMaterialVisibility(id, visibility);

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(DoctorMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

}
