package com.clooker.aoc2022.solution.eight;

import java.util.List;

public class EightTwoSolution extends EightSolution {

  @Override
  protected int initAccumulator(List<List<Integer>> treeGrid) {
    return 0;
  }

  @Override
  protected int reduce(int accumulator, TreeInfo treeInfo) {
    int scenicScore = treeInfo
      .edgePaths()
      .stream()
      .filter(edgePath -> !edgePath.isEmpty())
      .map(edgePath -> {
        int viewingDistance = 0;

        for (int h : edgePath) {
          viewingDistance++;

          if (treeInfo.height() <= h) {
            break;
          }
        }

        return viewingDistance;
      })
      .reduce(1, (i1, i2) -> i1 * i2);

    return Math.max(accumulator, scenicScore);
  }
}
