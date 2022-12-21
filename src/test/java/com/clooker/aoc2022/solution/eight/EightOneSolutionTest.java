package com.clooker.aoc2022.solution.eight;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class EightOneSolutionTest {

  private final Solution<Integer> solution = new EightOneSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(21, solution.apply("8-demo-input.txt")),
      () -> assertEquals(1782, solution.apply("8-input.txt"))
    );
  }
}
