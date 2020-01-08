import java.util.ArrayList;

public class Course {
	String name;
	int timestart;
	int timeend;
	ArrayList<Course> courses;

	Course(String n, int ts, int te){
		n = name;
		ts = timestart;
		te = timeend;
	}
	void addCourse(Course c) {
		courses.add(c);
	}

	Course getCourse(Course c) {
		return c;
	}

	Course updateCourse(Course c, String n, int ts, int te) {
		c.name = n;
		c.timestart = ts;
		c.timeend = te;
		return c;
	}

}
