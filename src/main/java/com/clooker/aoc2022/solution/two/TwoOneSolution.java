package com.clooker.aoc2022.solution.two;

import static com.clooker.aoc2022.solution.two.RpsChoice.PAPER;
import static com.clooker.aoc2022.solution.two.RpsChoice.ROCK;
import static com.clooker.aoc2022.solution.two.RpsChoice.SCISSORS;

import java.util.Map;

public class TwoOneSolution extends TwoSolution {

  @Override
  protected RpsChoice[] getRpsChoices(String line) {
    Map<String, RpsChoice> RPS_CHOICE_BY_SYMBOL = Map.of(
      "A",
      ROCK,
      "B",
      PAPER,
      "C",
      SCISSORS,
      "X",
      ROCK,
      "Y",
      PAPER,
      "Z",
      SCISSORS
    );

    String[] choiceSymbols = line.split(" ");
    RpsChoice c1 = RPS_CHOICE_BY_SYMBOL.get(choiceSymbols[0]);
    RpsChoice c2 = RPS_CHOICE_BY_SYMBOL.get(choiceSymbols[1]);

    return new RpsChoice[] { c1, c2 };
  }
}
