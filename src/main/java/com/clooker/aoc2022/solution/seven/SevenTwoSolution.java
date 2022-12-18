package com.clooker.aoc2022.solution.seven;

import java.util.Map;

public class SevenTwoSolution extends SevenSolution {

  @Override
  protected Long apply(Map<String, Long> sizeByPath) {
    long sizeFree =
      70_000_000 - sizeByPath.values().stream().sorted().toList().get(sizeByPath.size() - 1);

    return sizeByPath
      .values()
      .stream()
      .sorted()
      .filter(size -> sizeFree + size >= 30_000_000)
      .findFirst()
      .orElseThrow(() -> new RuntimeException("failed finding solution"));
  }
}
