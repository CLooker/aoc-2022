package com.clooker.aoc2022.solution.nine;

import static com.clooker.aoc2022.solution.nine.Direction.DOWN;
import static com.clooker.aoc2022.solution.nine.Direction.LEFT;
import static com.clooker.aoc2022.solution.nine.Direction.RIGHT;
import static com.clooker.aoc2022.solution.nine.Direction.UP;

import java.util.List;

public class InputService {

  public Input parse(List<String> lines) {
    List<MotionInfo> motionInfos = lines
      .stream()
      .map(line -> {
        String[] split = line.split((" "));

        Direction direction = switch (split[0]) {
          case "U" -> UP;
          case "L" -> LEFT;
          case "R" -> RIGHT;
          case "D" -> DOWN;
          default -> throw new IllegalArgumentException(
              "failed handling direction " + split[0]
          );
        };

        int count = Integer.parseInt(split[1]);

        return new MotionInfo(direction, count);
      })
      .toList();

    return new Input(motionInfos);
  }

}
