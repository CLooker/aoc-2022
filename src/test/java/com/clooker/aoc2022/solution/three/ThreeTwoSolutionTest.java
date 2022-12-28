package com.clooker.aoc2022.solution.three;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class ThreeTwoSolutionTest {

  private final Solution<Integer> solution = new ThreeTwoSolution();

  @Test
  void apply() {
    assertEquals(70, solution.apply("3-demo-input.txt"));
    assertEquals(2639, solution.apply("3-input.txt"));
  }
}
