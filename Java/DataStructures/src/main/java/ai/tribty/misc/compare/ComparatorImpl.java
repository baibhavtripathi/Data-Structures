package ai.tribty.misc.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    Integer rollNumber;

    public Student(String name, Integer rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "{Roll Number: "+ rollNumber +", Name: " + name +"}";
    }
}

public class ComparatorImpl {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Chitranshu", 5),
            new Student("Ankit Mishra", 2),
            new Student("Ankit Tiwari", 1),            
            new Student("Bhumika", 4),
            new Student("Anurag", 3)
        );

        // Printing Students without Sorting 
        students.forEach(System.out::println);
        System.out.println("-".repeat(10));
        // Sorting
        students.sort(Comparator.comparing(Student::getRollNumber).thenComparing(Student::getName));
        // Collections.sort(students, new StudentComparator());
        
        // Printing Students without Sorting 
        students.forEach(System.out::println);
    }
    
}

class StudentComparator implements Comparator<Student> {
    
    public int compare(Student s1, Student s2) {
        int rollNumberComparator = s1.getRollNumber().compareTo(s2.getRollNumber());
        int nameComparator = s1.getName().compareTo(s2.getName());

        return (rollNumberComparator == 0)? nameComparator: rollNumberComparator;
    }
        
}