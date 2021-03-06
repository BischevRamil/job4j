package ru.job4j.school;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    private School school = new School();
    Student st1 = new Student("st1", 10);
    Student st2 = new Student("st2", 20);
    Student st3 = new Student("st3", 30);
    Student st4 = new Student("st4", 40);
    Student st5 = new Student("st5", 50);
    Student st6 = new Student("st6", 60);
    Student st7 = new Student("st7", 70);
    Student st8 = new Student("st8", 80);
    Student st9 = new Student("st9", 90);
    private List<Student> studentList = List.of(st1, st2, st3, st4, st5, st6, st7, st8, st9);

    @Test
    public void makeATest() {
        List<Student> expected = List.of(st7, st8, st9);
        assertThat(expected, is(this.school.collect(studentList, student -> student.getScore() >= 70)));
    }

    @Test
    public void makeBTest() {
        List<Student> expected = List.of(st5, st6);
        assertThat(expected, is(this.school.collect(studentList, student -> {
            int score = student.getScore();
            return score < 70 && score >= 50;
        })));
    }

    @Test
    public void makeVTest() {
        List<Student> expected = List.of(st1, st2, st3, st4);
        assertThat(expected, is(this.school.collect(studentList, student -> student.getScore() < 50)));
    }

    @Test
    public void convertToMapTest() {
        Map<String, Student> expected = Map.of(
                st1.getSecondName(), st1,
                st2.getSecondName(), st2,
                st3.getSecondName(), st3,
                st4.getSecondName(), st4,
                st5.getSecondName(), st5,
                st6.getSecondName(), st6,
                st7.getSecondName(), st7,
                st8.getSecondName(), st8,
                st9.getSecondName(), st9);
        assertThat(expected, is(this.school.convertInMap(studentList)));
    }

    @Test
    public void levelOfTest() {
        List<Student> actual = new ArrayList<>(studentList);
        actual.add(1, null);
        actual.add(8, null);
        List<Student> expected = List.of(st9, st8, st7, st6);
        assertThat(expected, is(this.school.levelOf(actual, 50)));
    }
}
