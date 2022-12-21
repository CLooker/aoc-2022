package com.clooker.aoc2022.solution.eight;

import java.util.List;

public class EightOneSolution extends EightSolution {

  @Override
  protected int initAccumulator(List<List<Integer>> treeGrid) {
    return (treeGrid.size() * 2) + ((treeGrid.size() * 2) - 4);
  }

  @Override
  protected int reduce(int accumulator, TreeInfo treeInfo) {
    boolean visible = treeInfo
      .edgePaths()
      .stream()
      .filter(edgePath -> !edgePath.isEmpty())
      .anyMatch(edgePath -> edgePath.stream().allMatch(h -> treeInfo.height() > h));

    return visible ? accumulator + 1 : accumulator;
  }
}
