package com.clooker.aoc2022.solution.one;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class OneTwoTest {

  private final Solution<Integer> solution = new OneTwo();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals(45000, solution.apply("1-demo-input.txt")),
      () -> assertEquals(199628, solution.apply("1-input.txt"))
    );
  }
}
