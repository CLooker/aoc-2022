package com.clooker.aoc2022.solution.one;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import com.clooker.aoc2022.solution.two.TwoTwoSolution;
import org.junit.jupiter.api.Test;

class TwoTwoSolutionTest {

  private final Solution<Integer> solution = new TwoTwoSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(12, solution.apply("2-demo-input.txt")),
      () -> assertEquals(14652, solution.apply("2-input.txt"))
    );
  }
}
