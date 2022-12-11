package com.clooker.aoc2022.solution.five;

public record UpdateCommand(int sourceStackIdx, int targetStackIdx, int updateCount) {}
