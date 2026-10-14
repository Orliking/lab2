package lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cycle: while (true) {
            System.out.println("\n1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Определить сколько человек не сдали информатику");
            System.out.println("4. Определить сколько групп сдавали экзамены 11.06.18");
            System.out.println("5. Упорядочить предметы по убыванию среднего балла");
            System.out.println("6. Выход");
            System.out.println("Выберете пункт меню (1..6)");

            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                case 1: ExamResult.fillResults(); break;
                case 2: ExamResult.printResults(); break;
                case 3: ExamResult.taskA(); break;
                case 4: ExamResult.taskB(); break;
                case 5: ExamResult.taskC(); break;
                default: break cycle;
            }
        }
    }
}