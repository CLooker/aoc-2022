package com.clooker.aoc2022.solution.nine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

  private Integer x;
  private Integer y;

  public static Point from(Point point) {
    return new Point(point.getX(), point.getY());
  }

  public static Point origin() {
    return new Point(0, 0);
  }

  public void decX() {
    x--;
  }

  public void decY() {
    y--;
  }

  public void incX() {
    x++;
  }

  public void incY() {
    y++;
  }
}
