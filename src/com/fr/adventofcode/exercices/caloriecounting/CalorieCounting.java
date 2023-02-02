package com.fr.adventofcode.exercices.caloriecounting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {
    public CalorieCounting() {}

    public int sumOfHighestCaloriesForGivenElves(File fileToRead, int numberOfElves) throws IOException {
        List<Integer> allCalories = countAllCaloriesByElves(fileToRead);
        int result = 0;

            Collections.sort(allCalories);
            List<Integer> caloriesToAdd = allCalories.subList(Math.max(0, allCalories.size() - numberOfElves), allCalories.size());

            for (int i : caloriesToAdd) {
                result += i;
            }

        return result;
    }


    private List countAllCaloriesByElves(File fileToRead) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));
        List<Integer> allCalories = new ArrayList<>();
        int result = 0;
        String read = "";

        while((read = bufferedReader.readLine()) != null) {
            if(!read.isEmpty()) {
                result+= Integer.parseInt(read);
            } else {
                allCalories.add(result);
                result = 0;
            }
        }

        return allCalories;

    }
}
