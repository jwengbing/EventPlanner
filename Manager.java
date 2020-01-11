import java.util.ArrayList;

public class Manager {
	ArrayList<Course> courses;
	ArrayList<String> names;
	ArrayList<Integer> timest;
	ArrayList<Integer> timeends;

	String setSchedule(ArrayList<Course >courses) {
		for(Course c: courses) {
			//get time availability and course names
			names.add(c.getName());
			timest.add(c.getTimeStart(c));
			timeends.add(c.getTimeEnd(c));
		}
		return "";
	}
}
