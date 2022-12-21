package com.clooker.aoc2022.solution.eight;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class EightTwoSolutionTest {

  private final Solution<Integer> solution = new EightTwoSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(8, solution.apply("8-demo-input.txt")),
      () -> assertEquals(474606, solution.apply("8-input.txt"))
    );
  }
}
