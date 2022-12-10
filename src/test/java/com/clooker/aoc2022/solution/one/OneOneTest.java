package com.clooker.aoc2022.solution.one;

import static org.junit.jupiter.api.Assertions.*;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class OneOneTest {

  private final Solution<Integer> solution = new OneOne();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(24000, solution.apply("1-demo-input.txt")),
      () -> assertEquals(67633, solution.apply("1-input.txt"))
    );
  }
}
