package com.clooker.aoc2022.solution.five;

import com.clooker.aoc2022.solution.Solution;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public abstract class FiveSolution extends Solution<String> {

  @Override
  protected String apply(List<String> lines) {
    ParsedInput parsedInput = parseInput(lines);

    List<Stack<String>> stacks = parsedInput.stacks();

    parsedInput.updateCommands().forEach(uc -> handleUpdate(stacks, uc));

    return stacks.stream().map(Stack::peek).collect(Collectors.joining());
  }

  protected abstract void handleUpdate(List<Stack<String>> stacks, UpdateCommand updateCommand);

  private ParsedInput parseInput(List<String> lines) {
    int stackIdLineIdx = -1;
    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);

      if (line.trim().startsWith("1")) {
        stackIdLineIdx = i;

        break;
      }
    }

    if (stackIdLineIdx == -1) {
      throw new RuntimeException("failed finding index of line containing stack IDs");
    }

    List<Stack<String>> stacks = new ArrayList<>();
    for (int i = stackIdLineIdx - 1; i >= 0; i--) {
      String stackLine = lines.get(i);

      for (int j = 0; j < stackLine.length(); j += 4) {
        int stackIdx = j / 4;

        if (stacks.size() - 1 < stackIdx) {
          stacks.add(new Stack<>());
        }

        Stack<String> stack = stacks.get(stackIdx);

        String stackItem = stackLine
          .substring(j, j + 4 > stackLine.length() ? j + 3 : j + 4)
          .replace("[", "")
          .replace("]", "")
          .trim();

        if (!stackItem.isBlank()) {
          stack.add(stackItem);
        }
      }
    }

    List<UpdateCommand> updateCommands = lines
      .stream()
      .skip(stackIdLineIdx + 2)
      .map(line -> {
        int sourceStackIdx =
          Integer.parseInt(
            line.substring(line.indexOf("from"), line.indexOf("to")).replace("from", "").trim()
          ) -
          1;

        int targetStackIdx =
          Integer.parseInt(line.substring(line.indexOf("to")).replace("to", "").trim()) - 1;

        int updateCount = Integer.parseInt(
          line.substring(0, line.indexOf("from")).replace("move ", "").trim()
        );

        return new UpdateCommand(sourceStackIdx, targetStackIdx, updateCount);
      })
      .toList();

    return new ParsedInput(stacks, updateCommands);
  }
}
