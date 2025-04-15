package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class StepTracker {
    int goalByStepsPerDay = 10000;
    Scanner scanner = new Scanner(System.in);
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();

    StepTracker() {
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:\n 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май," +
                " 6 - Июнь,\n 7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        int numberMonth = scanner.nextInt();
        if (numberMonth < 1 || numberMonth > 12) {
            System.out.println("Такого месяца нет");
            return;
        }
        System.out.println("Введите день");
        int numberDay = scanner.nextInt();
        if (numberDay < 1 || numberDay > 30) {
            System.out.println("В этом месяце нет этого дня");
            return;
        }
        System.out.println("Введите количество пройденых шагов");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Ошибка! Значение должно быть положительное!");
            return;
        }
        MonthData monthData = monthToData[numberMonth - 1];
        monthData.days[numberDay - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите новое количетво шагов");
        int newGoalByStepsPerDay = scanner.nextInt();
        if (newGoalByStepsPerDay <= 0) {
            System.out.println("Введите коректное значение!");
            return; // Лишний, потому что любое условие заканчивает функцию
        } else {
            System.out.println("Новая цель по количеству шагов в день " + newGoalByStepsPerDay);
            goalByStepsPerDay = newGoalByStepsPerDay;
        }

    }

    void printStatistic() {
        System.out.println("Введите номер месяца:\n 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май," +
                " 6 - Июнь,\n 7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");

        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Ошибка! Введите корректный номер.");
        } else {
            MonthData monthData = monthToData[month - 1];
            int sumSteps = monthData.sumStepsFromMonth();
            monthData.printDaysAndStepsFromMonth();
            System.out.println("Всего шагов за месяц: " + sumSteps);
            System.out.println("Максимально пройдено шагов за месяц: " + monthData.maxSteps());
            System.out.println("Среднее количество шагов в день: " + sumSteps / monthData.days.length);
            System.out.println("Пройдено за месяц: " + converter.convertStepsToKm(sumSteps) + " км.");
            System.out.println("Сожжено килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
            System.out.println("Лучшая серия дней: " + monthData.bestSeries(goalByStepsPerDay));
        }
    }



}
