/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.4.2023 г.
 * Time: 8:37
 */
package P19JavaAdvancedRetakeExam14December2022.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (checkStuden(student, data)) {
            return "Student is already in the hall.";
        } else {
            if (this.capacity > 0) {
                data.add(student);
                capacity--;
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            } else {
                return "The hall is full.";
            }
        }
    }

    public String remove(Student student) {
        if (checkStuden(student, data)) {
            for (Student datum : data) {
                if (datum.getFirstName().equals(student.getFirstName())) {
                    data.remove(datum);
                    return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
                }
            }
        } else {
            return "Student not found.";
        }
        return null;
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student datum : data) {
            if (datum.getFirstName().equals(firstName) && datum.getLastName().equals(lastName)) {
                return datum;
            }
        }
        return null;
    }

    public String getStatistics() {

        StringBuilder builder = new StringBuilder();
        builder.append("Hall size: ");
        builder.append(this.data.size());
        builder.append(System.lineSeparator());
        for (Student datum : data) {
            builder.append(datum.toString());
            builder.append(System.lineSeparator());
        }
        String result = builder.toString().trim();
        return result;
    }

    private boolean checkStuden(Student student, List<Student> data) {
        for (Student datum : data) {
            if (datum.equals(student)) {
                return true;
            }
        }
        return false;
    }
}
