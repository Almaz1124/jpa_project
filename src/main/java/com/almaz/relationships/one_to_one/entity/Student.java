package com.almaz.relationships.one_to_one.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "students")//привязка к таблице, если названия совпадают то не обяз-на, но лучше
public class Student {

    @Id// показывает какой столбец яв-ся primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//если назв-я в таблице совп-т, то это аннотация не обяз-на, но лучше
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "avg_grade")
    private Double avgGrade;

    @OneToOne(cascade = CascadeType.ALL)//синхронизация всех действий
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @Column(name = "university_id")
    private Long universityId;

    public Student() {
    }

    public Student(String name, String surname, Double avgGrade) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = avgGrade;
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                ", universityId=" + universityId +
                '}';
    }
}
