package com.popova.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоматически генерируется
    private Long id;

    private String header;
    private String author;
    private LocalDate date; //пока что стринг
    private LocalDate updatedDate; //пока что стринг
    private String test;
    private String category;

    public void setTest(String test) {
        this.test = test;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getTest() {
        return test;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", updatedDate=" + updatedDate +
                ", test='" + test + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
