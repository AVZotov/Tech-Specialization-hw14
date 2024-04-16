package ru.gb.task01.models;

import net.datafaker.Faker;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public Course() {
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Course generate(){
        Faker faker = new Faker();
        return new Course(faker.lorem().word(), new Random().nextInt(10));
    }

    public void updateDuration(){
        duration = new Random().nextInt(1, 11);
    }

    public void updateTitle(){
        Faker faker = new Faker();
        title = faker.lorem().word();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
