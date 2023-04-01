/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 7:26
 */
package P05SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> students = new TreeMap<>();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split("\\s+");
            double sumOfGrades = 0;

            for (int j = 0; j < grades.length; j++) {
                sumOfGrades += Double.parseDouble(grades[j]);
            }

            double average = sumOfGrades / grades.length;
            students.put(name, average);
        }

        for (String student : students.keySet()) {
            //String pattern = "#0.00#";
            //double number = students.get(student);
            //DecimalFormat format = new DecimalFormat(pattern);

            //System.out.printf("%s is graduated with %s%n",student, format.format(number));
            System.out.printf("%s is graduated with %s%n",student, students.get(student));
        }
    }
}
