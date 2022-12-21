package com.clooker.aoc2022.solution.eight;

import com.clooker.aoc2022.solution.Solution;
import java.util.ArrayList;
import java.util.List;

public abstract class EightSolution extends Solution<Integer> {

  @Override
  protected Integer apply(List<String> lines) {
    List<List<Integer>> treeGrid = parseTreeGrid(lines);
    int accumulator = initAccumulator(treeGrid);

    for (int rowI = 1; rowI < treeGrid.size() - 1; rowI++) {
      List<Integer> heights = treeGrid.get(rowI);

      for (int colI = 1; colI < heights.size() - 1; colI++) {
        int height = heights.get(colI);

        List<Integer> up = new ArrayList<>();
        for (int rI = rowI - 1; rI >= 0; rI--) {
          up.add(treeGrid.get(rI).get(colI));
        }

        List<Integer> down = new ArrayList<>();
        for (int rI = rowI + 1; rI < treeGrid.size(); rI++) {
          down.add(treeGrid.get(rI).get(colI));
        }

        List<Integer> left = new ArrayList<>();
        for (int cI = colI - 1; cI >= 0; cI--) {
          left.add(treeGrid.get(rowI).get(cI));
        }

        List<Integer> right = new ArrayList<>();
        for (int cI = colI + 1; cI < treeGrid.size(); cI++) {
          right.add(treeGrid.get(rowI).get(cI));
        }

        accumulator = reduce(accumulator, new TreeInfo(height, List.of(up, right, left, down)));
      }
    }

    return accumulator;
  }

  protected abstract int initAccumulator(List<List<Integer>> treeGrid);

  protected abstract int reduce(int accumulator, TreeInfo treeInfo);

  private List<List<Integer>> parseTreeGrid(List<String> lines) {
    return lines
      .stream()
      .map(line -> {
        List<Integer> heights = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
          int height = Integer.parseInt(String.valueOf(line.charAt(i)));

          heights.add(height);
        }

        return heights;
      })
      .toList();
  }
}
