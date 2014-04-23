/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package driver;

import java.util.logging.Level;
import java.util.logging.Logger;
import uiComponent.StarterGUI;

/**
 *
 * @author Armando
 */
public class Driver {
    
    public static StarterGUI s = new StarterGUI();
    public static void main (String args[]){
        
        s.setVisible(true);
        Runnable threadJob = new myRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        try {
            Thread.sleep((long) 1000.0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.promptPass();
        
    }
   
}
