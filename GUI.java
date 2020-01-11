import java.awt.event.*;
import javax.swing.*;

class GUI extends JFrame implements ActionListener {
	static JTextField course;
	static JTextField timestart;
	static JTextField timeend;
	static JFrame frame1;
	static JFrame frame2;
	static JButton submit;
	static JButton generate;
	static JLabel text;
	static JTable schedule;
	static JPanel panel;

	public static void main(String[] args) {
		try {
			frame1 = new JFrame("Event Planner");
			frame2 = new JFrame("Updated Schedule");
			text = new JLabel("No Classes Registered");
			submit = new JButton("Submit Courses");
			generate = new JButton("Generate New Schedule");
			GUI te = new GUI();
			course = new JTextField("Enter your class", 16);
			timestart = new JTextField("Enter beginning time", 16);
			timeend = new JTextField("Enter ending time", 16);
			JPanel p = new JPanel();
			panel = new JPanel();
			submit.addActionListener(te);
			generate.addActionListener(te);
			p.add(course);
			p.add(timestart);
			p.add(timeend);
			p.add(submit);
			p.add(text);
			p.add(generate);
			frame1.add(p);
			frame1.setSize(300, 300);
			frame1.setVisible(true);
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(null, t.getClass().getSimpleName() + ": " + t.getMessage());
			throw t;
		}
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Submit Courses")) {
			if (course.getText().trim() == null)
				course.setText("Please Enter a Course!");
			text.setText(course.getText().replaceAll(" ", "") + " from " + timestart.getText().replaceAll(" ", "")
					+ " to " + timeend.getText().replaceAll(" ", ""));
			course.setText("  ");
			timestart.setText("  ");
			timeend.setText("  ");
		} else if (s.equals("Generate New Schedule")) {
			String[][] data = { { "CS 240", "MATH 327", "CS 301","" }, { "ANTH 166", "MATH 330", "IT","" } ,{"","","",""}};

			// Column Names
			String[] columnNames = {"Monday", "Tuesday","Wednesday", "Friday" };

			// Initializing the JTable
			schedule = new JTable(data, columnNames);
			schedule.setBounds(0, 0, 1000, 2000);
			panel.add(schedule);
			frame2.add(panel);
			JScrollPane sp = new JScrollPane(schedule);
	        frame2.add(sp);
			frame2.setSize(1000,400);
			frame2.setVisible(true);
		}
	}

}
