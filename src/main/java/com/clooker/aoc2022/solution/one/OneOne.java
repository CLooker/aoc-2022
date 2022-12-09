package com.clooker.aoc2022.solution.one;

import com.clooker.aoc2022.solution.Solution;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OneOne extends Solution<Integer> {

  @Override
  protected Integer apply(List<String> lines) {
    List<List<Integer>> calorieCountLists = new ArrayList<>();
    calorieCountLists.add(new ArrayList<>());

    for (String line : lines) {
      if (line.isEmpty()) {
        calorieCountLists.add(new ArrayList<>());

        continue;
      }

      List<Integer> calorieCounts = calorieCountLists.get(calorieCountLists.size() - 1);
      Integer calorieCount = Integer.parseInt(line);
      calorieCounts.add(calorieCount);
    }

    return calorieCountLists
      .stream()
      .map(calorieCounts -> calorieCounts.stream().reduce(0, Integer::sum))
      .max(Comparator.comparing(Integer::valueOf))
      .orElse(-1);
  }
}
