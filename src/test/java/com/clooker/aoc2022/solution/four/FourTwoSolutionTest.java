package com.clooker.aoc2022.solution.four;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class FourTwoSolutionTest {

  private final Solution<Long> solution = new FourTwoSolution();

  @Test
  void apply() {
    assertEquals(4, solution.apply("4-demo-input.txt"));
    assertEquals(893, solution.apply("4-input.txt"));
  }
}
