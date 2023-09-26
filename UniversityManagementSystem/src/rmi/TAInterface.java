/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author ahmedwaleed
 */
public interface TAInterface extends Remote {

    public void UpdateMaterialTitle(int matid, String title) throws RemoteException;

    public void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException;
    
     public ArrayList<MaterialInterface> getMaterialss(int courseID)  throws RemoteException;
}
