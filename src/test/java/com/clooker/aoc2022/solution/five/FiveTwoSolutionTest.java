package com.clooker.aoc2022.solution.five;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class FiveTwoSolutionTest {

  private final Solution<String> solution = new FiveTwoSolution();

  @Test
  void apply() {
    assertEquals("MCD", solution.apply("5-demo-input.txt"));
    assertEquals("VRQWPDSGP", solution.apply("5-input.txt"));
  }
}
