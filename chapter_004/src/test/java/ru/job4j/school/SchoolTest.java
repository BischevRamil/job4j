package ru.job4j.school;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    private School school = new School();
    Student st1 = new Student(10);
    Student st2 = new Student(20);
    Student st3 = new Student(30);
    Student st4 = new Student(40);
    Student st5 = new Student(50);
    Student st6 = new Student(60);
    Student st7 = new Student(70);
    Student st8 = new Student(80);
    Student st9 = new Student(90);
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

}
