package com.clooker.aoc2022.solution.five;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.clooker.aoc2022.solution.Solution;
import org.junit.jupiter.api.Test;

class FiveOneSolutionTest {

  private final Solution<String> solution = new FiveOneSolution();

  @Test
  void apply() {
    assertAll(
      () -> assertEquals("CMZ", solution.apply("5-demo-input.txt")),
      () -> assertEquals("GFTNRBZPF", solution.apply("5-input.txt"))
    );
  }
}
