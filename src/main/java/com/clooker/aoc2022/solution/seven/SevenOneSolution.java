package com.clooker.aoc2022.solution.seven;

import java.util.Map;

public class SevenOneSolution extends SevenSolution {

  @Override
  protected Long apply(Map<String, Long> sizeByPath) {
    return sizeByPath.values().stream().filter(size -> size <= 100_000).reduce(0L, Long::sum);
  }
}
