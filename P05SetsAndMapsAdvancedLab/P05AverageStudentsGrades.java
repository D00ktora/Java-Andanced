/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 7:25
 */
package P05SetsAndMapsAdvancedLab;

import javax.xml.namespace.QName;
import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            Double grade = Double.parseDouble(input.split("\\s+")[1]);

            if (students.containsKey(name)) {
                List<Double> tempList = students.get(name);
                tempList.add(grade);
                students.put(name,tempList);
            } else {
                List<Double> tempList = new ArrayList<>();
                tempList.add(grade);
                students.put(name,tempList);
            }
        }

        for (String student : students.keySet()) {
            double averageGrade = 0;
            List<Double> tempList = students.get(student);
            for (Double aDouble : tempList) {
                averageGrade += aDouble;
            }
            averageGrade = averageGrade / tempList.size();
            System.out.printf("%s -> ", student);
            for (Double aDouble : tempList) {
                System.out.printf("%.2f ",aDouble);
            }
            System.out.printf("(avg: %.2f)%n",averageGrade);
        }
    }
}
