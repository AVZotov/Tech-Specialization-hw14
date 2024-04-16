package ru.gb.task01;

import ru.gb.task01.controls.SqlControls;
import ru.gb.task01.models.Course;

import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        SqlControls sqlControls = new SqlControls();
        //fill table with initial data
        //sqlControls.fillTable(20);

        //Get all records from DB
        List<Course> courses = sqlControls.getAllData();
        System.out.println(courses);

        //Get course by ID
        Course course = sqlControls.getCourseById(4);
        System.out.println(course);

        //Update course
        course.updateDuration();
        course.updateTitle();
        System.out.println(course);
        sqlControls.updateCourse(course);

        //Delete course by ID
        Course course1 = courses.get(new Random().nextInt(courses.size()));
        System.out.println("Candidate for removal: " + course1);
        sqlControls.deleteCourse(course1);
    }
}
