package com.clooker.aoc2022.solution.four;

import com.clooker.aoc2022.solution.Solution;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public abstract class FourSolution extends Solution<Long> {

  @Override
  protected Long apply(List<String> lines) {
    return lines
      .stream()
      .filter(line -> {
        String[] assignments = line.split(",");
        Set<Long> assignmentRange1 = getAssignmentRange(assignments[0]);
        Set<Long> assignmentRange2 = getAssignmentRange(assignments[1]);

        return isAssignmentReplanningRequired(assignmentRange1, assignmentRange2);
      })
      .count();
  }

  protected abstract boolean isAssignmentReplanningRequired(
    Set<Long> assignmentRange1,
    Set<Long> assignmentRange2
  );

  private Set<Long> getAssignmentRange(String assignment) {
    String[] minAndMax = assignment.split("-");
    long min = Long.parseLong(minAndMax[0]);
    long max = Long.parseLong(minAndMax[1]);
    return LongStream.rangeClosed(min, max).boxed().collect(Collectors.toSet());
  }
}
