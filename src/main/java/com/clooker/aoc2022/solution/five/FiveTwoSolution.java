package com.clooker.aoc2022.solution.five;

import java.util.List;
import java.util.Stack;

public class FiveTwoSolution extends FiveSolution {

  @Override
  protected void handleUpdate(List<Stack<String>> stacks, UpdateCommand updateCommand) {
    String[] stackItems = new String[updateCommand.updateCount()];
    for (int updateCount = 1; updateCount <= updateCommand.updateCount(); updateCount++) {
      stackItems[updateCount - 1] = stacks.get(updateCommand.sourceStackIdx()).pop();
    }

    for (int i = stackItems.length - 1; i >= 0; i--) {
      stacks.get(updateCommand.targetStackIdx()).add(stackItems[i]);
    }
  }
}
