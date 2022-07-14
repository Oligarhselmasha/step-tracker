import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (true) {
            if (userInput == 1) {

                    System.out.println("За какой месяц Вы хотите ввести шаги? (0 - январь, 11 - декабрь)");
                int month = scanner.nextInt();
                while (true) {
                    if (month >= 0 && month <= 11) {
                        break;
                    } else {
                        System.out.println("Недопустимое значение месяца, попробуйте еще раз");
                        month = scanner.nextInt();
                        continue;
                    }
                }
                System.out.println("За какой день Вы хотите ввести шаги? (Для простоты будем считать, что в месяце 30 дней)");
                int day = scanner.nextInt();
                while (true) {
                    if (day >= 1 && day <= 30) {
                        break;
                    } else {
                        System.out.println("Недопустимое значение дня, попробуйте еще раз");
                        day = scanner.nextInt();
                        continue;
                    }
                }
                System.out.println("Введите количество шагов");
                int stepAmount = scanner.nextInt();
                stepTracker.saveSteps(month, day, stepAmount);
                printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
                userInput = scanner.nextInt();

            } else if (userInput == 2) {

                    System.out.println("За какой месяц Вы хотите получить статистику? (0 - январь, 11 - декабрь)");
                    int month = scanner.nextInt();
                    while (true) {
                    if (month >= 0 && month <= 11) {
                        stepTracker.printStatMonth(month);
                        break;
                    } else {
                        System.out.println("Недопустимое значение месяца, попробуйте еще раз");
                        month = scanner.nextInt();
                        continue;
                    }

                    }
                    printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
                    userInput = scanner.nextInt();
                }
            else if (userInput == 3) {
                    System.out.println("Какую цель Вы хотите себе поставить?");
                    int goal = scanner.nextInt();
                    while (true) {
                        if (goal >= 0) {
                            stepTracker.changeGoal(goal);
                            break;
                        } else {
                            System.out.println("Количество шагов должно быть положительным, попробуйте еще раз");
                            goal = scanner.nextInt();
                            continue;
                        }
                    }
                    printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
                    userInput = scanner.nextInt();


                } else if (userInput == 4) {

                    break;
                } else {
                    System.out.println("Попробуйте ввести команду еще раз...");
                    printMenu();// обработка разных случаев
                    userInput = scanner.nextInt();
                }

            }
            System.out.println("Программа завершена. До свидания :-)");
        }

        public static void printMenu () {
            System.out.println("Какую команду Вы хотите выполнить:");
            System.out.println("1 - Ввести количество шагов, пройденных за день;");
            System.out.println("2 - Вывести статистику за месяц;");
            System.out.println("3 - Изменить цель по количеству шагов;");
            System.out.println("4 - Выйти.");
        }
    }
