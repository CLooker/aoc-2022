package com.clooker.aoc2022.solution.seven;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class SevenOneSolutionTest {

  private final Solution<Long> solution = new SevenOneSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(95437, solution.apply("7-demo-input.txt")),
      () -> assertEquals(1390824, solution.apply("7-input.txt"))
    );
  }
}
