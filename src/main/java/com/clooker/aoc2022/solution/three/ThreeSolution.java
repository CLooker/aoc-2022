package com.clooker.aoc2022.solution.three;

import static java.util.Objects.requireNonNull;

import com.clooker.aoc2022.solution.Solution;
import java.util.Arrays;
import java.util.List;

public abstract class ThreeSolution extends Solution<Integer> {

  @Override
  protected Integer apply(List<String> lines) {
    return compartmentize(lines)
      .stream()
      .map(this::getDuplicatedItemType)
      .map(this::getPriority)
      .reduce(0, Integer::sum);
  }

  protected abstract List<String[]> compartmentize(List<String> lines);

  private String getDuplicatedItemType(String[] compartments) {
    String itemTypes = compartments[0];

    String duplicatedItemType = null;
    for (int i = 0; i < itemTypes.length(); i++) {
      String itemType = String.valueOf(itemTypes.charAt(i));

      boolean duplicated = Arrays
        .stream(compartments)
        .skip(1)
        .allMatch(iTypes -> iTypes.contains(itemType));

      if (duplicated) {
        duplicatedItemType = itemType;

        break;
      }
    }

    return requireNonNull(duplicatedItemType);
  }

  private Integer getPriority(String itemType) {
    return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(itemType) + 1;
  }
}
