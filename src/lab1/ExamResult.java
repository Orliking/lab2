package lab1;

import java.util.Scanner;

public class ExamResult {
    private String subject;
    private String groupNumber;
    private String examDate;
    private String studentLastName;
    private int grade;

    private static ExamResult[] results;

    static {
        results = new ExamResult[]{
                new ExamResult("Информатика", "101", "11.06.18", "Иванов", 2),
                new ExamResult("Информатика", "101", "11.06.18", "Петров", 4),
                new ExamResult("Информатика", "102", "12.06.18", "Сидоров", 2),
                new ExamResult("Информатика", "103", "11.06.18", "Кузнецов", 5),
                new ExamResult("Математика", "101", "10.06.18", "Иванов", 3),
                new ExamResult("Математика", "102", "10.06.18", "Сидоров", 4),
                new ExamResult("Физика", "101", "15.06.18", "Петров", 5),
                new ExamResult("Физика", "103", "15.06.18", "Кузнецов", 4)
        };
    }

    public ExamResult(String subject, String groupNumber, String examDate, String studentLastName, int grade) {
        this.setSubject(subject);
        this.setGroupNumber(groupNumber);
        this.setExamDate(examDate);
        this.setStudentLastName(studentLastName);
        this.setGrade(grade);
    }

    public ExamResult() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Предмет : ");
        this.setSubject(sc.nextLine());
        System.out.print("Номер группы : ");
        this.setGroupNumber(sc.nextLine());
        System.out.print("Дата экзамена : ");
        this.setExamDate(sc.nextLine());
        System.out.print("Фамилия студента : ");
        this.setStudentLastName(sc.nextLine());
        System.out.print("Оценка : ");
        this.setGrade(sc.nextInt());
    }

    public String toString() {
        return String.format(" Предмет: %s | Группа: %s | Дата: %s | Студент: %s | Оценка: %d",
                subject, groupNumber, examDate, studentLastName, grade);
    }

    public String getSubject() { return subject; }
    public void setSubject(String value) {
        if (value.isEmpty()) System.out.println("Недопустимое значение");
        else this.subject = value;
    }

    public String getGroupNumber() { return groupNumber; }
    public void setGroupNumber(String value) {
        if (value.isEmpty()) System.out.println("Недопустимое значение");
        else this.groupNumber = value;
    }

    public String getExamDate() { return examDate; }
    public void setExamDate(String value) {
        if (value.isEmpty()) System.out.println("Недопустимое значение");
        else this.examDate = value;
    }

    public String getStudentLastName() { return studentLastName; }
    public void setStudentLastName(String value) {
        if (value.isEmpty()) System.out.println("Недопустимое значение");
        else this.studentLastName = value;
    }

    public int getGrade() { return grade; }
    public void setGrade(int value) {
        if (value < 2 || value > 5) System.out.println("Недопустимое значение (оценка от 2 до 5) !");
        else this.grade = value;
    }

    public static void fillResults() {
        System.out.println("Введите количество записей: ");
        int n = (new Scanner(System.in)).nextInt();
        results = new ExamResult[n];
        System.out.println("Введите информацию о сдаче экзаменов: ");
        for (int i = 0; i < results.length; i++) {
            System.out.println("Запись " + (i + 1) + ":");
            results[i] = new ExamResult();
        }
    }

    public static void printResults() {
        System.out.println("\nИнформация экзаменов:");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

    //сколько человек не сдали информатику
    public static void taskA() {
        int failedCount = 0;
        System.out.println("\nСтуденты, не сдавшие информатику:");
        for (int i = 0; i < results.length; i++) {
            if (results[i].getSubject().equalsIgnoreCase("Информатика") && results[i].getGrade() < 3) {
                System.out.println("Фамилия: " + results[i].getStudentLastName() +
                        ", Группа: " + results[i].getGroupNumber());
                failedCount++;
            }
        }
        System.out.println("Всего не сдали информатику: " + failedCount + " человек");
    }

    //определить сколько групп сдавали экзамены 11.06.18
    public static void taskB() {
        String[] groups = new String[results.length];
        int groupCount = 0;

        for (int i = 0; i < results.length; i++) {
            if (results[i].getExamDate().equals("11.06.18")) {
                String gr = results[i].getGroupNumber();
                boolean exists = false;
                for (int j = 0; j < groupCount; j++) {
                    if (groups[j].equals(gr)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    groups[groupCount] = gr;
                    groupCount++;
                }
            }
        }

        System.out.println("\nКоличество групп, сдававших экзамены 11.06.18: " + groupCount);
        System.out.print("Номера групп: ");
        for (int i = 0; i < groupCount; i++) {
            System.out.print(groups[i] + " ");
        }
        System.out.println();
    }

}