package com.clooker.aoc2022.solution.four;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourTwoSolution extends FourSolution {

  @Override
  protected boolean isAssignmentReplanningRequired(
    Set<Long> assignmentRange1,
    Set<Long> assignmentRange2
  ) {
    return (
      Stream
        .concat(assignmentRange1.stream(), assignmentRange2.stream())
        .collect(Collectors.toSet())
        .size() !=
      (assignmentRange1.size() + assignmentRange2.size())
    );
  }
}
