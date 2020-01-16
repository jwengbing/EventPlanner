import java.util.ArrayList;

public class Course {
	String name;
	int timestart;
	int timeend;
	String[] days;

	Course(String n, int ts, int te,String[] day){
		name = n;
		timestart = ts;
		timeend = te;
		days = day;
	}
	void addCourse(ArrayList<Course> courses,Course c) {
		courses.add(c);
	}

	String getCourse(Course c) {
		return name;
	}

	Course updateCourse(Course c, String n, int ts, int te) {
		c.name = n;
		c.timestart = ts;
		c.timeend = te;
		return c;
	}

	int getTimeStart(Course c) {
		return c.timestart;
	}

	int getTimeEnd(Course c) {
		return c.timeend;
	}

	int getTimeDiff(Course c) {
		return getTimeEnd(c) - getTimeStart(c);
	}

	String getName(Course c) {
		return c.name;
	}

	String[] returnDays(Course c){
		return c.days;
	}
	boolean checkValidTime(int timest, int timeend) {
		if(timeend>=timest)return false;
		return true;
	}

	//inserting data into the table
	String[][] returnData(){
		String[][] ret = new String[10][8];
		int time = 9;
		for(int i = 0 ;i<ret.length;i++) {
			if(time>12)time-=12;
			ret[i][0] = Integer.toString(time)+":00";
			time++;
		}
		//insert the classes in the times based on day String[0][1-8] depending on weekday
		return ret;
	}


}
