package com.almaz.relationships.one_to_one.entity;


import com.almaz.relationships.one_to_one.EyeColor;
import jakarta.persistence.*;

@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "height")
    private int height;

    //@Enumerated(EnumType.STRING)
    @Column(name = "eye_color")
    //private EyeColor eyeColor;
    private String eyeColor;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Student student;

    public Passport() {}

    public Passport(String email, int height, String eyeColor) {
        this.email = email;
        this.height = height;
        this.eyeColor = eyeColor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", eyeColor='" + eyeColor + '\'' +
                ", student=" + student +
                '}';
    }
}
