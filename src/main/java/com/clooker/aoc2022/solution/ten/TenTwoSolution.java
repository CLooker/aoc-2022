package com.clooker.aoc2022.solution.ten;

import java.util.ArrayList;
import java.util.List;

public class TenTwoSolution extends TenSolution<Void> {

  private final List<List<String>> screen;

  public TenTwoSolution() {
    List<List<String>> screen = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      List<String> row = new ArrayList<>();
      for (int j = 0; j < 40; j++) {
        row.add(" ");
      }
      screen.add(row);
    }

    this.screen = screen;
  }

  @Override
  protected void processState(int cycle, int register) {
    int rowIdx = (cycle - 1) / 40;
    int colIdx = (cycle - 1) % 40;
    screen
        .get(rowIdx)
        .add(
            colIdx,
            List.of(register - 1, register, register + 1).contains(colIdx)
                ? "#"
                : "."
        );
  }

  @Override
  protected Void getResult() {
    screen.forEach(row -> System.out.println(String.join("", row)));
    return null;
  }

}
