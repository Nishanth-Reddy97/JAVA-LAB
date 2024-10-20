import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] sem1Credits;
    int[] sem1Marks;
    int[] sem2Credits;
    int[] sem2Marks;
    int numSubjectsSem1;
    int numSubjectsSem2;

    void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.println("\nEntering the following details for sem 1:");
        System.out.print("Enter number of subjects for sem 1: ");
        numSubjectsSem1 = sc.nextInt();
        sem1Credits = new int[numSubjectsSem1];
        sem1Marks = new int[numSubjectsSem1];
        for (int i = 0; i < numSubjectsSem1; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + " in sem 1: ");
            sem1Credits[i] = sc.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + " in sem 1: ");
            sem1Marks[i] = sc.nextInt();
        }

        System.out.println("\nEntering the following details for sem 2:");
        System.out.print("Enter number of subjects for sem 2: ");
        numSubjectsSem2 = sc.nextInt();
        sem2Credits = new int[numSubjectsSem2];
        sem2Marks = new int[numSubjectsSem2];
        for (int i = 0; i < numSubjectsSem2; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + " in sem 2: ");
            sem2Credits[i] = sc.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + " in sem 2: ");
            sem2Marks[i] = sc.nextInt();
        }
    }

    void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);

        System.out.println("\nCredits and Marks for sem 1:");
        for (int i = 0; i < numSubjectsSem1; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + sem1Credits[i] + ", Marks = " + sem1Marks[i]);
        }

        System.out.println("\nCredits and Marks for sem 2:");
        for (int i = 0; i < numSubjectsSem2; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + sem2Credits[i] + ", Marks = " + sem2Marks[i]);
        }
    }

    void calculateSGPA() {
        System.out.println("\nSGPA Calculation:");

        double sgpaSem1 = calculateSemesterSGPA(sem1Credits, sem1Marks, numSubjectsSem1);
        System.out.printf("SGPA for sem 1: %.2f\n", sgpaSem1);

        double sgpaSem2 = calculateSemesterSGPA(sem2Credits, sem2Marks, numSubjectsSem2);
        System.out.printf("SGPA for sem 2: %.2f\n", sgpaSem2);

        double cgpa = (sgpaSem1 + sgpaSem2) / 2;
        System.out.printf("CGPA (Cumulative GPA): %.2f\n", cgpa);
    }

    double calculateSemesterSGPA(int[] credits, int[] marks, int numSubjects) {
        int totalCredits = 0;
        int weightedSum = 0;
        for (int i = 0; i < numSubjects; i++) {
            int gradePoint = calculateGradePoint(marks[i]);
            weightedSum += gradePoint * credits[i];
            totalCredits += credits[i];
        }
        return (double) weightedSum / totalCredits;
    }

    int calculateGradePoint(int marks) {
        if (marks >= 90) return 10; // O grade
        else if (marks >= 80) return 9; // A grade
        else if (marks >= 70) return 8; // B grade
        else if (marks >= 60) return 7; // C grade
        else if (marks >= 50) return 6; // D grade
        else if (marks >= 40) return 4; // P grade
        else return 0;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.acceptDetails();
        student.displayDetails();
        student.calculateSGPA();
    }
}
