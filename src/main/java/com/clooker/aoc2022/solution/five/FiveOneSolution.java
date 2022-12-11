package com.clooker.aoc2022.solution.five;

import java.util.List;
import java.util.Stack;

public class FiveOneSolution extends FiveSolution {

  @Override
  protected void handleUpdate(List<Stack<String>> stacks, UpdateCommand updateCommand) {
    for (int updateCount = 1; updateCount <= updateCommand.updateCount(); updateCount++) {
      stacks
        .get(updateCommand.targetStackIdx())
        .add(stacks.get(updateCommand.sourceStackIdx()).pop());
    }
  }
}
