package com.clooker.aoc2022.solution.seven;

import com.clooker.aoc2022.solution.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class SevenSolution extends Solution<Long> {

  @Override
  protected Long apply(List<String> lines) {
    return apply(parseSizeByPath(lines));
  }

  protected abstract Long apply(Map<String, Long> sizeByPath);

  private Map<String, Long> parseSizeByPath(List<String> lines) {
    Map<String, Long> sizeByPath = new HashMap<>();
    Stack<String> cwd = new Stack<>();

    lines
      .stream()
      .map(line -> line.replace("$ ", ""))
      .forEach(line -> {
        boolean isCdToParent = line.equals("cd ..");
        if (isCdToParent) {
          cwd.pop();

          return;
        }

        boolean isCdToChild = line.startsWith("cd");
        if (isCdToChild) {
          String dirName = line.replace("cd ", "");
          cwd.push(dirName);

          String path = String.join("/", cwd).replace("//", "/");

          if (!sizeByPath.containsKey(path)) {
            sizeByPath.put(path, 0L);
          }

          return;
        }

        boolean isFileInfo = !(line.startsWith("ls") || line.startsWith("dir"));
        if (isFileInfo) {
          long size = Long.parseLong(line.split(" ")[0]);

          for (int i = 0; i < cwd.size(); i++) {
            String path = cwd
              .stream()
              .limit(i + 1)
              .collect(Collectors.joining("/"))
              .replace("//", "/");

            sizeByPath.merge(path, size, Long::sum);
          }
        }
      });

    return sizeByPath;
  }
}
