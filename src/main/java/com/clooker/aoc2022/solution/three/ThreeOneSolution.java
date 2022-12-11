package com.clooker.aoc2022.solution.three;

import java.util.List;

public class ThreeOneSolution extends ThreeSolution {

  @Override
  protected List<String[]> compartmentize(List<String> lines) {
    return lines
      .stream()
      .map(line -> {
        int length = line.length();
        return new String[] { line.substring(0, length / 2), line.substring(length / 2) };
      })
      .toList();
  }
}
