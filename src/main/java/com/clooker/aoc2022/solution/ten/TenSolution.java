package com.clooker.aoc2022.solution.ten;

import com.clooker.aoc2022.solution.Solution;
import java.util.List;

public abstract class TenSolution<T> extends Solution<T> {

  @Override
  protected T apply(List<String> lines) {
    int cycle = 1;
    int register = 1;

    for (String line : lines) {
      String[] split = line.split(" ");
      String instruction = split[0];
      int cycleInc = switch (instruction) {
        case "noop" -> 1;
        case "addx" -> 2;
        default -> throw new IllegalArgumentException();
      };

      for (int i = 1; i <= cycleInc; i++) {
        processState(cycle, register);
        cycle++;
      }

      if (instruction.equals("addx")) {
        register += Integer.parseInt(split[1]);
      }
    }

    return getResult();
  }

  protected abstract void processState(int cycle, int register);

  protected abstract T getResult();

}
