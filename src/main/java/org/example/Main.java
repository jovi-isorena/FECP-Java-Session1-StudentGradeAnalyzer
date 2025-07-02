package org.example;

import java.util.*;

public class Main{
    static Scanner sc ;
    static int topGrade;
    static ArrayList<String> topStudents;
    static final char[] GRADE_CHARS = {'A', 'B', 'C', 'D', 'F'};
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        topGrade = 0;
        topStudents = new ArrayList<String>();
        int studentCount;

        System.out.print("Enter number of students: ");
        try{
            String input = sc.nextLine();
            studentCount = Integer.parseInt(input);
            int[] scores = new int[studentCount];
            int[] gradesCount = new int[5];
            for (int i = 0; i < studentCount; i++) {
                inputGrade(i, scores, gradesCount);
            }
            displayResult(scores, gradesCount);
        }catch (NumberFormatException e){

        }
    }

    public static void inputGrade(int index, int[] scores, int[] gradesCount) {
        System.out.printf("Enter name of student %d: ", index+1);
        String name = sc.next();
        System.out.printf("Enter score for %s: ", name);
        int score = Integer.parseInt(sc.next());
        scores[index] = score;
        if(score>topGrade){
            topGrade = score;
            topStudents.clear();
            topStudents.add(name);
        }else if(score == topGrade){
            topStudents.add(name);
        }
        char grade;
        if(score>=90 && score<=100){
            grade = 'A';
            gradesCount[0]++;
        }else if(score>=80 && score<=89){
            grade = 'B';
            gradesCount[1]++;
        }else if(score>=70 && score<=79){
            grade = 'C';
            gradesCount[2]++;
        }else if(score>=60 && score<=69){
            grade = 'D';
            gradesCount[3]++;
        }else{
            grade = 'F';
            gradesCount[4]++;
        }
        System.out.printf("%s got grade: %c\n\n", name, grade);
    }

    public static void displayResult(int[] scores, int[] gradeCounts) {
        System.out.println("----- Class Summary -----");
        double average = Arrays.stream(scores).average().orElse(0);
        System.out.printf("Average Score: %.2f", average);
        System.out.print("\nGrade Counts: ");
        for (int i = 0; i < gradeCounts.length; i++) {
            System.out.printf("%c:%d ",GRADE_CHARS[i],gradeCounts[i]);
        }
        System.out.print("\nTop Student(s): ");
        for (int i = 0; i < topStudents.size(); i++) {
            System.out.printf("%s (%d) ", topStudents.get(i), topGrade);
        }
    }
}
