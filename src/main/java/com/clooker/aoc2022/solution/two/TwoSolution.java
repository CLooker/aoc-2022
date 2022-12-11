package com.clooker.aoc2022.solution.two;

import static com.clooker.aoc2022.solution.two.RpsChoice.PAPER;
import static com.clooker.aoc2022.solution.two.RpsChoice.ROCK;
import static com.clooker.aoc2022.solution.two.RpsChoice.SCISSORS;

import com.clooker.aoc2022.solution.Solution;
import java.util.List;
import java.util.Map;

public abstract class TwoSolution extends Solution<Integer> {

  @Override
  protected Integer apply(List<String> lines) {
    return lines
      .stream()
      .map(this::getRpsChoices)
      .map(this::getPoints)
      .map(points -> points[1])
      .reduce(0, Integer::sum);
  }

  protected abstract RpsChoice[] getRpsChoices(String line);

  private Integer[] getPoints(RpsChoice[] rpsChoices) {
    RpsChoice c1 = rpsChoices[0];
    RpsChoice c2 = rpsChoices[1];
    Map<RpsChoice, Integer> pointsByRpsChoice = Map.of(ROCK, 1, PAPER, 2, SCISSORS, 3);
    Integer[] points = new Integer[] { pointsByRpsChoice.get(c1), pointsByRpsChoice.get(c2) };
    boolean tied = c1.equals(c2);

    if (tied) {
      points[0] += 3;
      points[1] += 3;
    } else {
      int winnerIdx =
        switch (c1) {
          case ROCK -> c2.equals(SCISSORS) ? 0 : 1;
          case PAPER -> c2.equals(ROCK) ? 0 : 1;
          case SCISSORS -> c2.equals(PAPER) ? 0 : 1;
        };

      points[winnerIdx] += 6;
    }

    return points;
  }
}
