package SetsAndMaps.Lab;

import java.util.*;

public class _5_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        //4
        //Alex 4.50
        //Peter 3.00
        //Alex 5.00
        //Peter 3.66

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String studentInfo = sc.nextLine();
            String studentName = studentInfo.split("\\s+")[0];
            double studentGrade = Double.parseDouble(studentInfo.split("\\s+")[1]);
            studentGrades.putIfAbsent(studentName, new ArrayList<>());
            List<Double> grades = studentGrades.get(studentName);
            grades.add(studentGrade);
            studentGrades.put(studentName, grades);
        }
        //Alex -> 2.00 3.00 (avg: 2.50)

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", getAverageGrade(entry.getValue()));
        }
    }

    private static double getAverageGrade(List<Double> grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}
