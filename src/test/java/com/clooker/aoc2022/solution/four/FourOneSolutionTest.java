package com.clooker.aoc2022.solution.four;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class FourOneSolutionTest {

  private final Solution<Long> solution = new FourOneSolution();

  @Test
  void apply() {
    assertEquals(2, solution.apply("4-demo-input.txt"));
    assertEquals(582, solution.apply("4-input.txt"));
  }
}
