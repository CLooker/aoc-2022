package com.clooker.aoc2022.solution.six;

import com.clooker.aoc2022.solution.Solution;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class SixSolution extends Solution<Integer> {

  private final int uniqueCharsLength;

  @Override
  protected Integer apply(List<String> lines) {
    String signal = lines.get(0);

    for (int i = uniqueCharsLength; i < signal.length(); i++) {
      boolean packetStartIdentified =
        signal
          .substring(i - uniqueCharsLength, i)
          .chars()
          .mapToObj(it -> (char) it)
          .collect(Collectors.toSet())
          .size() ==
        uniqueCharsLength;

      if (packetStartIdentified) {
        return i;
      }
    }

    throw new RuntimeException("failed to find solution");
  }
}
