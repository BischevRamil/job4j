package ru.job4j.school;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    Map<String, Student> convertInMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(e -> e.secondName, e -> e));
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students
                .stream()
                .flatMap(Stream::ofNullable)
                .sorted((o1, o2) -> o2.getScore() - o1.getScore())
                .takeWhile(a -> a.getScore() > bound)
                .collect(Collectors.toList());
    }
}
