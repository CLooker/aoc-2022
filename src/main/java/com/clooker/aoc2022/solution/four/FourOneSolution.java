package com.clooker.aoc2022.solution.four;

import java.util.Set;

public class FourOneSolution extends FourSolution {

  @Override
  protected boolean isAssignmentReplanningRequired(
    Set<Long> assignmentRange1,
    Set<Long> assignmentRange2
  ) {
    return (
      assignmentRange1.containsAll(assignmentRange2) ||
      assignmentRange2.containsAll(assignmentRange1)
    );
  }
}
