package com.clooker.aoc2022.solution.ten;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TenOneSolution extends TenSolution<Integer> {

  private final List<Integer> measurements = new ArrayList<>();
  private final LinkedList<Integer> measurableCycles = new LinkedList<>(
      List.of(
          20, 60, 100, 140, 180, 220
      )
  );

  @Override
  protected void processState(int cycle, int register) {
    if (Objects.equals(measurableCycles.peek(), cycle)) {
      measurements.add(
          cycle * register
      );

      measurableCycles.removeFirst();
    }
  }

  @Override
  protected Integer getResult() {
    return measurements.stream().reduce(0, Integer::sum);
  }

}
