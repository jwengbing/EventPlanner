import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class GUI extends JFrame implements ActionListener {
	    static JTextField course;
	    static JTextField timestart;
	    static JTextField timeend;
	    static JFrame f;
	    static JButton b;
	    static JLabel l;

	    public static void main(String[] args) {
	    	f = new JFrame("Event Planner"); 
	        l = new JLabel("No Classes Registered");
	        b = new JButton("submit");
	        GUI te = new GUI();
	        b.addActionListener(te);
	        course = new JTextField("Enter your class",16);
	        timestart = new JTextField("Enter beginning time" ,16);
	        timeend = new JTextField("Enter ending time" ,16);
	        JPanel p = new JPanel();
	        p.add(course);
	        p.add(timestart);
	        p.add(timeend);
	        p.add(b);
	        p.add(l);
	        f.add(p);
	        f.setSize(300, 300);
	        f.show();
	    }
	    public void actionPerformed(ActionEvent e)
	    {
	    	String s = e.getActionCommand();
	    	if (s.equals("submit")) {
	    		l.setText(course.getText()+" from "+timestart.getText()+" to "+timeend.getText());
	    		course.setText("  ");
	    		timestart.setText("  ");
	    		timeend.setText("  ");
        }
    }

}
