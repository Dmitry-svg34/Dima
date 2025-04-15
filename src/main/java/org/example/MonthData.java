package org.example;

public class MonthData {
    final int daysInMonth = 30;
    int[] days = new int[daysInMonth];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + "-й день: " + days[i]);
        }
    }

    void printFirstDay() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + "-й день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeris = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                ++currentSeris;
            } else {
                currentSeris = 0;
            }
            if (currentSeris > finalSeries) {
                finalSeries = currentSeris;
            }
        }
        return finalSeries;
    }
}


