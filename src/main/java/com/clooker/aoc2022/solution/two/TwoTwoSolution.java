package com.clooker.aoc2022.solution.two;

import static com.clooker.aoc2022.solution.two.RpsChoice.PAPER;
import static com.clooker.aoc2022.solution.two.RpsChoice.ROCK;
import static com.clooker.aoc2022.solution.two.RpsChoice.SCISSORS;

import java.util.Map;

public class TwoTwoSolution extends TwoSolution {

  @Override
  protected RpsChoice[] getRpsChoices(String line) {
    String[] symbols = line.split(" ");
    RpsChoice c1 = Map.of("A", ROCK, "B", PAPER, "C", SCISSORS).get(symbols[0]);
    RpsChoice c2 = getMyRpsChoice(c1, symbols[1]);

    return new RpsChoice[] { c1, c2 };
  }

  private RpsChoice getMyRpsChoice(RpsChoice c1, String symbol) {
    enum Outcome {
      WIN,
      LOSE,
      DRAW,
    }

    Outcome desiredOutcome =
      switch (symbol) {
        case "X" -> Outcome.LOSE;
        case "Y" -> Outcome.DRAW;
        case "Z" -> Outcome.WIN;
        default -> throw new IllegalArgumentException("failed handling " + symbol);
      };

    return desiredOutcome.equals(Outcome.DRAW)
      ? c1
      : switch (c1) {
        case ROCK -> desiredOutcome.equals(Outcome.WIN) ? PAPER : SCISSORS;
        case PAPER -> desiredOutcome.equals(Outcome.WIN) ? SCISSORS : ROCK;
        case SCISSORS -> desiredOutcome.equals(Outcome.WIN) ? ROCK : PAPER;
      };
  }
}
