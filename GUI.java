import java.awt.event.*;
import javax.swing.*;

class GUI extends JFrame implements ActionListener {
	static JTextField course;
	static JTextField timestart;
	static JTextField timeend;
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
		submitCourse = new JButton("Submit Courses");
		generate = new JButton("Generate New Schedule");
		submitTest = new JButton("Add Test Reminder!");
		GUI te = new GUI();
		course = new JTextField("Enter your class", 16);
		timestart = new JTextField("Enter beginning time", 16);
		timeend = new JTextField("Enter ending time", 16);
		JPanel p = new JPanel();
		sched = new JPanel();
		tests = new JPanel();
		testclass = new JTextField("Which class is this test for?", 16);
		timetot = new JTextField("In how many days till the test?", 16);
		tests.add(testclass);
		tests.add(timetot);
		tests.add(submitTest);
		submitCourse.addActionListener(te);
		generate.addActionListener(te);
		submitTest.addActionListener(te);
		p.add(course);
		p.add(timestart);
		p.add(timeend);
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
			if (course.getText().trim() == null)
				course.setText("Please Enter a Course!");
			text.setText(course.getText().replaceAll(" ", "") + " from " + timestart.getText().replaceAll(" ", "")
					+ " to " + timeend.getText().replaceAll(" ", ""));
			course.setText("  ");
			timestart.setText("  ");
			timeend.setText("  ");
		} else if (s.equals("Generate New Schedule")) {
			String[][] data = { { "", "CS 240", "MATH 327", "CS 301", "", "", "" },
					{ "", "ANTH 166", "MATH 330", "IT", "", "", "" }, { "", "", "", "", "", "", "" } };
			// Column Names
			String[] columnNames = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

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
