package org.example;

public class Converter {
    final  int caloriesInKilocalories = 1000;
    final  int metresInKilometres = 1000;

    int convertStepsToKm(int steps) {
        return steps / 4 * 3 / metresInKilometres;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * 50 / caloriesInKilocalories;
    }
}
