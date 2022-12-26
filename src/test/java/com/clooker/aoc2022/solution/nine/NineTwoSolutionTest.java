package com.clooker.aoc2022.solution.nine;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class NineTwoSolutionTest {

  private final Solution<Long> solution = new NineTwoSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(1, solution.apply("9-demo-1-input.txt")),
      () -> assertEquals(36, solution.apply("9-demo-2-input.txt")),
      () -> assertEquals(2493, solution.apply("9-input.txt"))
    );
  }
}
