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

    public static void taskC() {
        String[] subjects = new String[results.length];
        double[] sums = new double[results.length];
        int[] counts = new int[results.length];
        int сounter = 0;

        for (int i = 0; i < results.length; i++) {
            String subj = results[i].getSubject();
            int index = -1;
            // ищем предмет в уже собранных
            for (int j = 0; j < сounter; j++) {
                if (subjects[j].equalsIgnoreCase(subj)) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                subjects[сounter] = subj;
                sums[сounter] = results[i].getGrade();
                counts[сounter] = 1;
                сounter++;
            } else {
                sums[index] += results[i].getGrade();
                counts[index]++;
            }
        }

        double[] averages = new double[сounter];
        for (int i = 0; i < сounter; i++) {
            averages[i] = sums[i] / counts[i];
        }

        for (int i = 0; i < сounter - 1; i++) {
            for (int j = 0; j < сounter - 1 - i; j++) {
                if (averages[j] < averages[j + 1]) {
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    String tempSubj = subjects[j];
                    subjects[j] = subjects[j + 1];
                    subjects[j + 1] = tempSubj;
                }
            }
        }

        // 4. Вывод результата
        System.out.println("\nПредметы по убыванию среднего балла:");
        for (int i = 0; i < сounter; i++) {
            System.out.printf("Предмет: %-15s | Средний балл: %.2f%n", subjects[i], averages[i]);
        }
    }
}
