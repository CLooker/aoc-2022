package com.clooker.aoc2022.solution.nine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class NineOneSolutionTest {

  private final Solution<Long> solution = new NineOneSolution();

  @Test
  void apply() {
    assertEquals(13, solution.apply("9-demo-1-input.txt"));
    assertEquals(6087, solution.apply("9-input.txt"));
  }
}
