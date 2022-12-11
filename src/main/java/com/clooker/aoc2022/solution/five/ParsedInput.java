package com.clooker.aoc2022.solution.five;

import java.util.List;
import java.util.Stack;

public record ParsedInput(List<Stack<String>> stacks, List<UpdateCommand> updateCommands) {}
