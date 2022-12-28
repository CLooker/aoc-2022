package com.clooker.aoc2022.solution.one;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class OneTwoSolutionTest {

  private final Solution<Integer> solution = new OneTwoSolution();

  @Test
  void apply() {
    assertEquals(45000, solution.apply("1-demo-input.txt"));
    assertEquals(199628, solution.apply("1-input.txt"));
  }
}
