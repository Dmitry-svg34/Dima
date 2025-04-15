package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int cmd;
        while (true) {
            printMenu();
            cmd = scanner.nextInt();
            switch (cmd) {
                case 1: {
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                }
                case 2: {
                    stepTracker.changeStepGoal();
                    break;
                }
                case 3: {
                    stepTracker.printStatistic();
                    break;
                }
                case 4: {
                    System.out.println("До новых встреч!");
                    return;
                }
                default: {
                    System.out.println("Такого пункта меню нет");
                }
            }


        }


    }

    static void printMenu() {
        System.out.println(
                "Введите номер команды: \n" +
                        "1 - Ввести количество шагов за определённый день\n" +
                        "2 - Изменить цель по количеству шагов\n" +
                        "3 - Напечатать статистику за определённый месяц\n" +
                        "4 - Выйти из приложения");
    }
}
