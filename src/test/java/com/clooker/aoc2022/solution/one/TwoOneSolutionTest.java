package com.clooker.aoc2022.solution.one;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import com.clooker.aoc2022.solution.two.TwoOneSolution;
import org.junit.jupiter.api.Test;

class TwoOneSolutionTest {

  private final Solution<Integer> solution = new TwoOneSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(15, solution.apply("2-demo-input.txt")),
      () -> assertEquals(10718, solution.apply("2-input.txt"))
    );
  }
}
