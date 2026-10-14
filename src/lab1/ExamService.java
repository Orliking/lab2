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
