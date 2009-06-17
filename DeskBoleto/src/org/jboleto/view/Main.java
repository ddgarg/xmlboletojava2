/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jboleto.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author wanderson
 */
public class Main {
    public static void main(String args[]) {
        
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
             System.out.println("Error setting native LAF: " + e);
        }
        
        FrmMain frmMain = new FrmMain();
        frmMain.show(true);
                
    }
}
