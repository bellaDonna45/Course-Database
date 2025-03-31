package coursedatabasepackage;
import java.io.*;
import java.util.*;

public class CourseDBElement {
	String id, room, instructor;
    int crn, credits;
    
    public CourseDBElement(String id, int crn, int credits, String room, String instructor) {
        this.id = id;
        this.crn = crn;
        this.credits = credits;
        this.room = room;
        this.instructor = instructor;
    }
    
    public int getCRN() {
    	return crn;
    	}
    public String getID() { 
    	return id;
    	}
    public String getRoomNum() { 
    	return room;
    	}
    
    public String toString() {
        return "\nCourse:" + id + " CRN:" + crn + " Credits:" + credits +  " Instructor:" + instructor + " Room:" + room;
    }
}



