package com.almaz.crud.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "students2")//привязка к таблице, если названия совпадают то не обяз-на, но лучше
public class Student {

    @Id// показывает какой столбец яв-ся primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//если назв-я в таблице совп-т, то это аннотация не обяз-на, но лучше
    private Long id;

    @Column(name = "first_name", unique = true)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "avg_grade", nullable = false)
    private Double avgGrade;

    @Transient
    private LocalDateTime createDate;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Student() {
    }

    public Student(String name, String surname, Double avgGrade) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = avgGrade;
        this.createDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                ", createDate=" + createDate +
                '}';
    }
}
