package coursedatabasepackage;
import java.io.*;
import java.util.*;

public class CourseDBManager implements CourseDBManagerInterface {
private CourseDBStructure db;
    
    public CourseDBManager() {
        db = new CourseDBStructure(20);
    }
    
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        db.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
    }
    
    public CourseDBElement get(int crn) {
        try {
            return db.get(crn);
        } catch (IOException e) {
            return null;
        }
    }
    
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            add(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], data[4]);
        }
        scanner.close();
    }
    
    public ArrayList<String> showAll() {
        return db.showAll();
    }
}

