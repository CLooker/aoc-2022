package com.clooker.aoc2022.solution.nine;

import com.clooker.aoc2022.solution.Solution;
import java.util.ArrayList;
import java.util.List;

public abstract class NineSolution extends Solution<Long> {

  private final int knotCount;
  private final InputService inputService = new InputService();

  public NineSolution(int knotCount) {
    if (knotCount < 2) {
      throw new IllegalArgumentException(
          String.format("knotCount %s mut be greater than or equal to 2", knotCount)
      );
    }

    this.knotCount = knotCount;
  }

  @Override
  protected Long apply(List<String> lines) {
    List<List<Point>> paths = new ArrayList<>();
    paths.add(
        findFirstPath(
            inputService.parse(lines).motionInfos()
        )
    );

    for (int i = 2; i <= knotCount; i++) {
      paths.add(
          findNextPath(
              paths.get(
                  paths.size() - 1
              )
          )
      );
    }

    return paths
        .get(paths.size() - 1)
        .stream()
        .distinct()
        .count();
  }

  private List<Point> findFirstPath(List<MotionInfo> motionInfos) {
    List<Point> path = new ArrayList<>();
    path.add(Point.origin());

    for (MotionInfo motionInfo : motionInfos) {
      for (int c = 1; c <= motionInfo.count(); c++) {
        Point prev = path.get(path.size() - 1);
        Point next = new Point(prev.getX(), prev.getY());

        switch (motionInfo.direction()) {
          case UP -> next.incY();
          case DOWN -> next.decY();
          case LEFT -> next.decX();
          case RIGHT -> next.incX();
        }

        path.add(next);
      }
    }

    return path;
  }

  private List<Point> findNextPath(List<Point> prevPath) {
    List<Point> nextPath = new ArrayList<>();

    prevPath.forEach(head -> {
      Point tail = Point.from(
          nextPath.isEmpty()
              ? head
              : nextPath.get(nextPath.size() - 1)
      );

      Point nextTail = findNextTail(head, tail);

      nextPath.add(nextTail);
    });

    return nextPath;
  }

  private Point findNextTail(Point head, Point tail) {
    Point nextTail = Point.from(tail);

    boolean touching =
        Math.abs(head.getY() - tail.getY()) <= 1 && Math.abs(head.getX() - tail.getX()) <= 1;

    if (touching) {
      return nextTail;
    }

    int xDiff = head.getX() - tail.getX();
    int yDiff = head.getY() - tail.getY();

    if (Math.abs(xDiff) + Math.abs(yDiff) > 2) {
      if (xDiff < 0) {
        nextTail.decX();
      } else {
        nextTail.incX();
      }

      if (yDiff < 0) {
        nextTail.decY();
      } else {
        nextTail.incY();
      }
    } else {
      if (Math.abs(xDiff) > 1) {
        if (xDiff < 0) {
          nextTail.decX();
        } else {
          nextTail.incX();
        }
      }

      if (Math.abs(yDiff) > 1) {
        if (yDiff < 0) {
          nextTail.decY();
        } else {
          nextTail.incY();
        }
      }
    }

    return nextTail;
  }
}
