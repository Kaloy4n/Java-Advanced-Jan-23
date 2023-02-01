package SetsAndMaps.Lab;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _8_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> gradesPerStudent = new TreeMap<>();

        for (int i = 0; i < studentCount; i++) {
            String name = scanner.nextLine();
            String[] inputGrades = scanner.nextLine().split(" ");
            Double[] grades = new Double[inputGrades.length];

            for (int j = 0; j < inputGrades.length; j++) {
                grades[j] = Double.parseDouble(inputGrades[j]);
            }

            gradesPerStudent.put(name, grades);
        }
        
        for (String studentName : gradesPerStudent.keySet()) {
            Double[] grades = gradesPerStudent.get(studentName);
            
            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            double avgScore = sum / grades.length;
            DecimalFormat df = new DecimalFormat("#.#");
            df.format(avgScore);
            System.out.printf("%s is graduated with ", studentName);
            System.out.println(avgScore);
        }
    }
}
