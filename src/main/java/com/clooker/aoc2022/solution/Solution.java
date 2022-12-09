package com.clooker.aoc2022.solution;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class Solution<T> {

  public final T apply(String inputLocation) {
    return apply(findLines(inputLocation));
  }

  protected List<String> findLines(String inputLocation) {
    try {
      Path inputPath = Stream
        .of(
          inputLocation,
          Optional
            .ofNullable(getClass().getClassLoader().getResource(inputLocation))
            .map(URL::getFile)
            .orElse(null)
        )
        .filter(Objects::nonNull)
        .map(Path::of)
        .filter(Files::exists)
        .findAny()
        .orElseThrow(
          () ->
            new IllegalArgumentException("failed finding file at input location " + inputLocation)
        );

      return Files.readAllLines(inputPath);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  protected abstract T apply(List<String> lines);
}
