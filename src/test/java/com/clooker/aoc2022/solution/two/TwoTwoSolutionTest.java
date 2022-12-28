package com.clooker.aoc2022.solution.two;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class TwoTwoSolutionTest {

  private final Solution<Integer> solution = new TwoTwoSolution();

  @Test
  void apply() {
    assertEquals(12, solution.apply("2-demo-input.txt"));
    assertEquals(14652, solution.apply("2-input.txt"));
  }
}
