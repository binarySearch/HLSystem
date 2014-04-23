/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package driver;

import static driver.Driver.s;

/**
 *
 * @author Abacus
 */
    public class myRunnable implements Runnable
    {
        
        @Override
        public void run() {
            s.iterate();
        }
        
    }