package com.Practise.BeanValidation.Services;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "ValidationPractise")
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name Cannot Be Blank")
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @NotNull(message = "Enter a Valid RollNo")
    @Column(name = "RollNo", unique = true)
    @Min(1)
    @Max(100)
    @Digits(fraction = 0, integer = 2)
    private int rollno;

    @Column(name = "Class")
    @Max(12)
    private int std;

    @Column(name = "Admission_Date", nullable = false, updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate adddate;

    @Column(name = "DateOfBirth")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate DOB;

    // Default constructor for JPA
    public Validation() {}

    // Constructor with parameters

    public Validation(int id, String name, int rollno, int std, LocalDate adddate, LocalDate DOB) {
        this.id = id;
        this.name = name;
        this.rollno = rollno;
        this.std = std;
        this.adddate = adddate;
        this.DOB = DOB;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public LocalDate getAdddate() {
        return adddate;
    }

    public void setAdddate(LocalDate adddate) {
        this.adddate = adddate;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
}
