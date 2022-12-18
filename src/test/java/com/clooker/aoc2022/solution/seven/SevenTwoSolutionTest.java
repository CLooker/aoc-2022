package com.clooker.aoc2022.solution.seven;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class SevenTwoSolutionTest {

  private final Solution<Long> solution = new SevenTwoSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(24933642, solution.apply("7-demo-input.txt")),
      () -> assertEquals(7490863, solution.apply("7-input.txt"))
    );
  }
}
