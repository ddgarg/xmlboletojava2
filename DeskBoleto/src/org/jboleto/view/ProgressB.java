package org.jboleto.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import org.jboleto.view.Aguarde;
import org.jboleto.view.ProgressBar;

public class ProgressB extends JPanel {

   /**
    *
    */

   public static void main(String args[]) {

      final ProgressBar barra = new ProgressBar();
      Aguarde a = new Aguarde();
      a.show(true);
      JFrame frame = new JFrame("Progress Bar Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(barra);
      frame.pack();
      frame.setVisible(true);
      frame.setLocation(400, 300);

      for (int i = 1; i <= 1000; i++) {
         final int percent = i;
         try {
            
                  //barra.atualizaBarra(percent);
               
            
            Thread.sleep(100);
         } catch (InterruptedException e) {
            ;
         }
      }
      a.setVisible(false);
   }
}

