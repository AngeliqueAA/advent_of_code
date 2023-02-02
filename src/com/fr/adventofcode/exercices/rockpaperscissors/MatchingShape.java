package com.fr.adventofcode.exercices.rockpaperscissors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum MatchingShape {
    ELF_ROCK("A ", "ROCK", 1),
    ELF_PAPER("B ", "PAPER",2),
    ELF_SCISSORS("C ", "SCISSORS", 3),

    ROCK("X", "ROCK", 1),
    PAPER("Y", "PAPER", 2),
    SCISSORS("Z", "SCISSORS", 3);

    public final String label;
    public final String shape;
    public final int point;


    private MatchingShape(String label, String shape, int point) {
        this.label = label;
        this.shape = shape;
        this.point = point;
    }

    public static List<String> getDrawCombination() {
        List<String> drawCombination = new ArrayList<>();
        drawCombination.add(MatchingShape.ELF_ROCK.label + MatchingShape.ROCK.label);
        drawCombination.add(MatchingShape.ELF_PAPER.label + MatchingShape.PAPER.label);
        drawCombination.add(MatchingShape.ELF_SCISSORS.label + MatchingShape.SCISSORS.label);
        return drawCombination;
    }

    public static List<String> getWinningCombination() {
        List<String> winningCombination = new ArrayList<>();
        winningCombination.add(MatchingShape.ELF_SCISSORS.label + MatchingShape.ROCK.label);
        winningCombination.add(MatchingShape.ELF_PAPER.label + MatchingShape.SCISSORS.label);
        winningCombination.add(MatchingShape.ELF_ROCK.label + MatchingShape.PAPER.label);
        return winningCombination;
    }

    public static int getNumberOfPointForGivenShape(String label) {
        int result = 0;
        for(MatchingShape matchingShape : MatchingShape.values()) {
            if(Objects.equals(matchingShape.label, label)) {
                result = matchingShape.point;
            }
        }

        return result;
    }
}
