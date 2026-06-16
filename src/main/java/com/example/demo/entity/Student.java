package com.example.demo.entity; // Make sure this matches your package name!

import jakarta.persistence.*; // Uses Jakarta Persistence API (JPA)

@Entity // Tells Spring this class represents a database table
@Table(name = "students") // Names the table 'students' in MySQL
public class Student {

    @Id // Specifies that this is the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells MySQL to Auto-Increment this ID
    private Long id;

    @Column(name = "name", nullable = false) // Maps to a column, cannot be null
    private String name;

    @Column(name = "roll_number", unique = true, nullable = false)
    private Integer rollNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "section")
    private String section;

    // --- CONSTRUCTORS ---
    
    // JPA requires a default, no-argument constructor to work under the hood!
    public Student() {
    }

    public Student(String name, Integer rollNumber, String gender, String section) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.gender = gender;
        this.section = section;
    }

    // --- GETTERS AND SETTERS ---
    // (Spring uses these to read and write data to the object)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getRollNumber() { return rollNumber; }
    public void setRollNumber(Integer rollNumber) { this.rollNumber = rollNumber; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
}