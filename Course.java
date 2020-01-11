import java.util.ArrayList;

public class Course {
	String name;
	int timestart;
	int timeend;

	Course(String n, int ts, int te){
		name = n;
		timestart = ts;
		timeend = te;
	}
	ArrayList<Course> addCourse(ArrayList<Course> courses,Course c) {
		courses.add(c);
		return courses;
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

	int getTimeStart(Course c) {
		return timestart;
	}

	int getTimeEnd(Course c) {
		return timeend;
	}

	int getTimeDiff(Course c) {
		return getTimeEnd(c) - getTimeStart(c);
	}

	String getName() {
		return name;
	}

	boolean checkValidTime(int timest, int timeend) {
		return true;
	}
}
