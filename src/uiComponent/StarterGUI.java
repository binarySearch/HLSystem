/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uiComponent;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Armando
 */
public class StarterGUI extends javax.swing.JFrame {
    
    /**
     * Creates new form StarterGUI
     */
    public static boolean Access = false;
    
    public StarterGUI() {
        initComponents();
        setProperties();
        fillBar();//waits forthe user access to start loading the progress bar 
        promptPass();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        status = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HL Manager");
        setMaximumSize(new java.awt.Dimension(600, 450));
        setMinimumSize(new java.awt.Dimension(600, 450));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 450));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar1.setForeground(new java.awt.Color(230, 76, 4));
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 423, 260, -1));

        status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status.setText("Prompting Password...");
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, 20));

        version.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        version.setText("v1.0");
        getContentPane().add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sources/hl logo trans 600x600.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 470));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sources/BG.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    private void promptPass(){
        new Thread(new TempoPrompting()).start();
    }
    
    private void fillBar(){
        new Thread(new TempoFilling()).start();
    }
    
    private void disposeWin(){
        this.dispose();
    }
    
   
    
    private void setProperties() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("login-1-512 orange.png")));
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel status;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
   
    class TempoPrompting implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 50; i ++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StarterGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            new LoginGUI().setVisible(true);
        }
        
    }
    
    class TempoLastDelay implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 50; i ++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StarterGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            disposeWin();
        }
        
    }
    
    class TempoFilling implements Runnable{
        
        @Override
        public void run() {
            while(Access == false){
                //waits intul changes to different state
                System.out.print(".");
            }
            
            status.setText("Connecting... Please Wait");
            
            for(int i = 0; i <= 100; i ++){
                    try {
                        jProgressBar1.setValue(i);
                        jProgressBar1.repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StarterGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                new Thread(new TempoLastDelay()).start();
            
        }
        
    }
    
}
