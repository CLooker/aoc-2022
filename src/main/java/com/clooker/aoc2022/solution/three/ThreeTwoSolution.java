package com.clooker.aoc2022.solution.three;

import java.util.ArrayList;
import java.util.List;

public class ThreeTwoSolution extends ThreeSolution {

  @Override
  protected List<String[]> compartmentize(List<String> lines) {
    List<String[]> result = new ArrayList<>();
    int partitionSize = 3;

    for (int i = 0; i < lines.size(); i += partitionSize) {
      String[] compartments = new String[partitionSize];

      for (int j = i; j < i + partitionSize; j++) {
        String line = lines.get(j);
        compartments[j - i] = line;
      }

      result.add(compartments);
    }

    return result;
  }
}
