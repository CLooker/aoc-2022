package com.clooker.aoc2022.solution.six;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class SIxTwoSolutionTest {

  private final Solution<Integer> solution = new SixTwoSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(19, solution.apply("6-demo-1-input.txt")),
      () -> assertEquals(23, solution.apply("6-demo-2-input.txt")),
      () -> assertEquals(23, solution.apply("6-demo-3-input.txt")),
      () -> assertEquals(29, solution.apply("6-demo-4-input.txt")),
      () -> assertEquals(26, solution.apply("6-demo-5-input.txt")),
      () -> assertEquals(3217, solution.apply("6-input.txt"))
    );
  }
}
