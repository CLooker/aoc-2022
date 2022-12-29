package com.clooker.aoc2022.solution.ten;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class TenOneSolutionTest {

  private final Solution<Integer> solution = new TenOneSolution();

  @Test
  void demoApply() {
    assertEquals(13140, solution.apply("10-demo-input.txt"));
  }

  @Test
  void apply() {
    assertEquals(17940, solution.apply("10-input.txt"));
  }

}
