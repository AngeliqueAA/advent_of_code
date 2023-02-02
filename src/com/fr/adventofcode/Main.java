package com.fr.adventofcode;

import com.fr.adventofcode.exercices.caloriecounting.CalorieCounting;
import com.fr.adventofcode.exercices.rockpaperscissors.RockPaperScissors;

import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        File calorieCountingFile = new File("src/com/fr/adventofcode/exercices/resources/caloriecountinginput.txt");
        File rockPaperScissorsFile = new File("src/com/fr/adventofcode/exercices/resources/rockpaperscissorsinput.txt");


        CalorieCounting calorieCounting = new CalorieCounting();
        RockPaperScissors rockPaperScissors = new RockPaperScissors();


        System.out.println("Maximum de calories - DAY ONE : " + calorieCounting.sumOfHighestCaloriesForGivenElves(calorieCountingFile, 1));
        System.out.println("Total maximum de calories pour 3 Elfes - DAY ONE : " + calorieCounting.sumOfHighestCaloriesForGivenElves(calorieCountingFile, 3));

        System.out.println("Score TOTAL rock/paper/scissors - DAY TWO : " + rockPaperScissors.countAllWinningCombination(rockPaperScissorsFile));
        System.out.println("Score TOTAL rock/paper/scissors - DAY TWO PART PART_TWO: " + rockPaperScissors.countCombination_PartTwo(rockPaperScissorsFile));


    }
}
