/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboleto.view;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author WaNdErSoN
 */
public class ProgressBar extends JPanel {

    JProgressBar pbar;
    static final int MY_MINIMUM = 0;
    static final int MY_MAXIMUM = 100;

    public ProgressBar() {
        pbar = new JProgressBar();
        pbar.setStringPainted(true);
        pbar.setMinimum(MY_MINIMUM);
        pbar.setMaximum(MY_MAXIMUM);
        add(pbar);
    }

    public void atualizaBarra(int valor) {
        pbar.setValue(valor);
    }
}

