package com.fr.adventofcode.exercices.rockpaperscissors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class RockPaperScissors {

    final int POINT_FOR_WINNING_COMBINATION = 6;
    final int POINT_FOR_DRAW_COMBINATION = 3;
    
    final int POINT_FOR_ROCK = 1;
    final int POINT_FOR_PAPER = 2;
    final int POINT_FOR_SCISSORS = 3;

    List<String> winningCombination = MatchingShape.getWinningCombination();
    List<String> drawCombination = MatchingShape.getDrawCombination();
    

    public int countAllWinningCombination(File fileToRead) throws IOException {
        int result = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));
        String read = "";

        while((read = bufferedReader.readLine()) != null) {

            if (winningCombination.contains(read)) {
                result += POINT_FOR_WINNING_COMBINATION;
            } else if (drawCombination.contains(read)) {
                result += POINT_FOR_DRAW_COMBINATION;
            }

            result += MatchingShape.getNumberOfPointForGivenShape(read.substring(2));

        }

        return result;
    }

    public int countCombination_PartTwo(File fileToRead) throws IOException {
        int result = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));
        String read = "";

        while((read = bufferedReader.readLine()) != null) {
            String currentShape = read.substring(2);
            String currentElfShape = read.substring(0,2);

            if(currentShape.equals(MatchingShape.PAPER.label)) {
                result+= POINT_FOR_DRAW_COMBINATION;
                result+= MatchingShape.getNumberOfPointForGivenShape(currentElfShape);

            } else if(currentShape.equals(MatchingShape.ROCK.label)) {

                result += getPointForShapeWhenLoseBattle(currentElfShape);
            } else {
                result += getPointForShapeWhenWinBattle(currentElfShape);
                result+= POINT_FOR_WINNING_COMBINATION;
            }
        }

        return result;
    }

    private int getPointForShapeWhenLoseBattle(String currentElfShape) {
        int result = 0;
        switch (currentElfShape) {
            case "A " -> result += POINT_FOR_SCISSORS;
            case "B " -> result += POINT_FOR_ROCK;
            case "C " -> result += POINT_FOR_PAPER;
            default -> result += 0;
        }
        return result;
    }

    private int getPointForShapeWhenWinBattle(String currentElfShape) {
        int result = 0;
        switch (currentElfShape) {
            case "A " -> result += POINT_FOR_PAPER;
            case "B " -> result += POINT_FOR_SCISSORS;
            case "C " -> result += POINT_FOR_ROCK;
            default -> result += 0;
        }
        return result;
    }


}
