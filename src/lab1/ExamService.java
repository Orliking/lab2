package lab1;

public class ExamService {
    public static void printResults() {
        System.out.println("\nИнформация экзаменов:");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

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
}
