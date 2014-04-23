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
public class Driver implements Runnable{
    
    
    public static void main (String args[]){
        StarterGUI s = new StarterGUI();
        s.setVisible(true);
        Thread t = new Thread();
        
        s.promptPass();
        s.iterate();

    }

    @Override
    public void run() {
        System.out.println("I am running on a thread..._>");
    }
    
}
