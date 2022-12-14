package com.clooker.aoc2022.solution.two;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class TwoOneSolutionTest {

  private final Solution<Integer> solution = new TwoOneSolution();

  @Test
  void apply() {
    assertEquals(15, solution.apply("2-demo-input.txt"));
    assertEquals(10718, solution.apply("2-input.txt"));
  }
}
