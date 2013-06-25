/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testscrollpane;

/**
 *
 * @author Lets'go
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;


public class TimerShow extends JFrame {

    public static Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            countDown();
        }
    });


        private static JTextField field;
        private JButton buttonStart;
        private JButton buttonStop;
        private JButton buttonReset;

        public static String s;

        private static int hours;
        private static int minutes;
        private static int seconds;

        public static String time = String.format("%d:%d:%d", hours, minutes, seconds);


        public TimerShow()  {
            super("Timer");
            setLayout(new FlowLayout());

            field = new JTextField("00:00:00");
            add(field);

            buttonStart = new JButton("Start");
            add(buttonStart);
            buttonStop = new JButton("Stop");
            add(buttonStop);
            buttonReset = new JButton("Reset");
            add(buttonReset);

            ActionMaker maker = new ActionMaker();

            buttonStart.addActionListener(maker);
            // buttonStop.addActionListener(maker);
            // buttonReset.addActionListener(maker);

        }

        private class ActionMaker implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==buttonStart)
                {

                    s = field.getText();

                    hours   = Integer.parseInt(s.substring(0,2));
                    minutes = Integer.parseInt(s.substring(3,5));
                    seconds = Integer.parseInt(s.substring(6,8));

                    timer.start();

                }


            }
        }



        public static void countDown()  {
            
            
            
            if (hours == 0 && minutes == 0 && seconds == 0 )
            {
               timer.stop();

               JOptionPane.showMessageDialog(null, "Time out!");
            } else {
             
                
              if (seconds == 0 ){
                  
                if( minutes != 0 && seconds == 0){
                    minutes--;
                    seconds = 59;
                    if( hours != 0 && minutes == 0 && seconds == 0 ){
                        hours--;
                        minutes = 59;
                        seconds = 59;
                    }
                }
              } seconds--;  
              
            }
           showTime();
        }



    public static void showTime()
    {
        if (hours < 10 && minutes < 10 && seconds < 10)
        {
            time  = String.format("0%d:0%d:0%d", hours, minutes, seconds);
        }
        if (hours < 10 && minutes < 10 && seconds >= 10)
        {
            time  = String.format("0%d:0%d:%d", hours, minutes, seconds);
        }
        if (hours < 10 && minutes >= 10 && seconds >= 10)
        {
            time  = String.format("0%d:%d:%d", hours, minutes, seconds);
        }

        if ( hours >= 10 && minutes < 10 && seconds >= 10)
        {
            time  = String.format("%d:0%d:%d", hours, minutes, seconds);
        }

        if ( hours >= 10 && minutes >= 10 && seconds < 10)
        {
            time  = String.format("%d:%d:0%d", hours, minutes, seconds);
        }
        if ( hours == 0 && minutes == 0 && seconds == 0)
        {
            time  = String.format("0%d:0%d:0%d", hours, minutes, seconds);
        }





        field.setText(time);
    }




    }


