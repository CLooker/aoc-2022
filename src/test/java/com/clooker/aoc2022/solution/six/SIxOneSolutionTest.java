package com.clooker.aoc2022.solution.six;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class SIxOneSolutionTest {

  private final Solution<Integer> solution = new SixOneSolution();

  @Test
  void apply() {
    assertEquals(7, solution.apply("6-demo-1-input.txt"));
    assertEquals(5, solution.apply("6-demo-2-input.txt"));
    assertEquals(6, solution.apply("6-demo-3-input.txt"));
    assertEquals(10, solution.apply("6-demo-4-input.txt"));
    assertEquals(11, solution.apply("6-demo-5-input.txt"));
    assertEquals(1175, solution.apply("6-input.txt"));
  }
}
