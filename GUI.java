import java.awt.event.*;
import javax.swing.*;

class GUI extends JFrame implements ActionListener {
	static JTextField course;
	static JTextField timestart;
	static JTextField timeend;
	static JTextField days;
	static JTextField testclass;
	static JTextField timetot;
	static JFrame frame1;
	static JFrame frame2;
	static JButton submitCourse;
	static JButton generate;
	static JButton submitTest;
	static JLabel text;
	static JTable schedule;
	static JPanel sched;
	static JPanel tests;
	static JTabbedPane test;

	public static void main(String[] args) {
		try {
			createGUI();
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(null, t.getClass().getSimpleName() + ": " + t.getMessage());
			throw t;
		}
	}

	static void createGUI() {
		frame1 = new JFrame("Event Planner");
		frame2 = new JFrame("Updated Schedule");
		text = new JLabel("No Classes Registered");
		//Buttons for Different Factors
		submitCourse = new JButton("Submit Courses");
		generate = new JButton("Generate Schedule");
		submitTest = new JButton("Add Test Reminder!");
		GUI te = new GUI();
		//Texts for Course Input
		course = new JTextField("Enter your class", 16);
		timestart = new JTextField("Enter beginning time", 16);
		timeend = new JTextField("Enter ending time", 16);
		days = new JTextField("Which days?",16);
		JPanel p = new JPanel();
		sched = new JPanel();
		tests = new JPanel();
		//Texts for Test Input
		testclass = new JTextField("Which class is this test for?", 16);
		timetot = new JTextField("In how many days till the test?", 16);
		//Adding texts to panel
		tests.add(testclass);
		tests.add(timetot);
		tests.add(submitTest);
		//Adding button Listeners
		submitCourse.addActionListener(te);
		generate.addActionListener(te);
		submitTest.addActionListener(te);
		//Adding All Components to First Panel
		p.add(course);
		p.add(timestart);
		p.add(timeend);
		p.add(days);
		p.add(submitCourse);
		p.add(text);
		p.add(generate);
		frame1.add(p);
		test = new JTabbedPane();
		frame1.add(test);
		test.addTab("Add Courses", p);
		test.addTab("Add Tests", tests);
		frame1.setSize(600, 600);
		frame1.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Submit Courses")) {
			if (course.getText().trim().isEmpty()) {
				text.setText("Please Enter a Course!");
				course.setText("  ");
				return;
			}
			else if(timestart.getText().trim().isEmpty()) {
				text.setText("Please Enter a Beginning Time!");
				timestart.setText("  ");
				return;
			}
			else if(timeend.getText().trim().isEmpty()) {
				text.setText("Please Enter an Ending Time!");
				timeend.setText("  ");
				return;
			}
			text.setText(course.getText().replaceAll(" ", "") + " from " + timestart.getText().replaceAll(" ", "")
					+ " to " + timeend.getText().replaceAll(" ", ""));
			course.setText("  ");
			timestart.setText("  ");
			timeend.setText("  ");
		} else if (s.equals("Generate Schedule")) {
			String[] days = {"Monday","Wednesday","Friday"};
			Course c = new Course("CS 120",330,430,days);
			String[][] data = c.returnData();
			// Column Names
			String[] columnNames = {"Times","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

			// Initializing the JTable
			schedule = new JTable(data, columnNames);
			schedule.setBounds(0, 0, 1000, 2000);
			sched.add(schedule);
			frame2.add(sched);
			JScrollPane sp = new JScrollPane(schedule);
			frame2.add(sp);
			frame2.setSize(1000, 400);
			frame2.setVisible(true);
		} else if (s.equals("Add Test Reminder!")) {
			System.out.print("Test for " + testclass.getText() + " in " + timetot.getText());
		}
	}

}
