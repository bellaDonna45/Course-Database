package coursedatabasepackage;
import java.io.*;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {
    private MyHashTable<Integer, CourseDBElement> table;
    private int size;
    
    public CourseDBStructure(int size) {
    	this.table = new MyHashTable<>(size);        
        this.size = table.nextPrime(size);
    }
    
    public CourseDBStructure(String name, int size) {
    	this.size = size;
        table = new MyHashTable<>(size);
        
    }
    
    public void add(CourseDBElement element) {
        table.put(element.getCRN(), element);
    }
    
    public CourseDBElement get(int crn) throws IOException {
        CourseDBElement element = table.get(crn);
        if (element == null) throw new IOException("Course not found");
        return element;
    }
    
    public ArrayList<String> showAll() {
        ArrayList<String> allCourses = new ArrayList<>();
        for (int i = 0; i < table.bucketCount; i++) {
            for (MyHashTable.Entry<Integer, CourseDBElement> entry : table.buckets[i]) {
                allCourses.add(entry.value.toString());
            }
        }
        return allCourses;
    }
    
    public int getTableSize() {
        return size;
    }

    }
	    

