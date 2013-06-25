/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testscrollpane;

/**
 *
 * @author Lets'go
 */
import javax.swing.JFrame;

public class Timer {
 
    public static void main (String[] args)
    {

        TimerShow show = new TimerShow();
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setSize(350, 80);
        show.setVisible(true);
    }
}
