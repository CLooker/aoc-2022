package com.clooker.aoc2022.solution.three;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class ThreeOneSolutionTest {

  private final Solution<Integer> solution = new ThreeOneSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(157, solution.apply("3-demo-input.txt")),
      () -> assertEquals(7811, solution.apply("3-input.txt"))
    );
  }
}
