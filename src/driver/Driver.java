/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package driver;

import uiComponent.StarterGUI;

/**
 *
 * @author Armando
 */
public class Driver {
    
    
    public static void main (String args[]){
        StarterGUI s = new StarterGUI();
        s.setVisible(true);
        Thread t = new Thread();
        
        s.promptPass();
        s.iterate();
        System.out.print("sadfdesrgwergovieariufrvnefioudvsdf");
    }
    
}
