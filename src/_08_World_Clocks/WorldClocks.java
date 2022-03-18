package _08_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener, KeyListener {
    ClockUtilities clockUtil;
    Timer timer;
    TimeZone timeZone;

    JFrame frame;
    JPanel panel;
    ArrayList<JTextArea> updater = new ArrayList<>();
    ArrayList<String> cityArray = new ArrayList<>();
    JTextArea textArea;
    
    String city;
    String dateStr;
    String timeStr;
    
    JFrame jframe = new JFrame();
    JPanel jpanel = new JPanel();
    JButton button = new JButton();
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JLabel l = new JLabel();
    JTextField text = new JTextField(10);
    
    HashMap<String, TimeZone> cities = new HashMap<>();
    
    public WorldClocks() {
    	jframe.add(jpanel);
    	jpanel.add(button);
    	f.add(p);
    	p.add(text);
    	f.show();
    	f.pack();
    	text.addKeyListener(this);
    	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        clockUtil = new ClockUtilities();
        frame = new JFrame();
        panel = new JPanel();
        frame.add(panel);
        textArea = new JTextArea();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame.setSize(100, 100);


        // The format for the city must be: city, country (all caps)

        
        
       
    }
    public void citySelector() {
    	 // Sample starter program
        textArea = new JTextArea();
        panel.add(textArea);
        textArea.setText(city + "\n" + dateStr);
        updater.add(textArea);
        
        // This Timer object is set to call the actionPerformed() method every
        // 1000 milliseconds
        timer = new Timer(1000, this);
        timer.start();
		city = text.getText();
		cityArray.add(city);
    	timeZone = clockUtil.getTimeZoneFromCityName(city);
        cities.put(city, timeZone);
        Calendar calendar = Calendar.getInstance(timeZone);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        frame.pack();
        frame.setVisible(true);
        System.out.println(dateStr);

       
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    	int count = 0;
    	for (String four : cities.keySet()) {
        	timeZone = clockUtil.getTimeZoneFromCityName(four);
    		Calendar c = Calendar.getInstance(timeZone);
            String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
            String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
            timeStr = militaryTime + twelveHourTime;
            System.out.println(timeStr);
            updater.get(count).setText(cityArray.get(count) + "\n" + dateStr + "\n" + timeStr);
            count++;
		}
    	frame.pack();
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == e.VK_ENTER) {
			//System.out.println("Key pressed");
			if (e.getSource()==text) {
				citySelector();
			}
			else {
				System.out.println("How did this happen");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
