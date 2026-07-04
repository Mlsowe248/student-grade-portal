package com.school.studentportal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private String matNo;

    private String name;

    private int physics;
    private int french;
    private int programming;
    private int computerArchitecture;
    private int database;
    private int networking;

    public Student() {
    }

    public Student(String matNo, String name, int physics, int french, int programming,
                   int computerArchitecture, int database, int networking) {
        this.matNo = matNo;
        this.name = name;
        this.physics = physics;
        this.french = french;
        this.programming = programming;
        this.computerArchitecture = computerArchitecture;
        this.database = database;
        this.networking = networking;
    }

    public String getMatNo() {
        return matNo;
    }
    public void setMatNo(String matNo) {
        this.matNo = matNo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPhysics() {
        return physics;
    }
    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getFrench() {
        return french;
    }
    public void setFrench(int french) {
        this.french = french;
    }

    public int getProgramming() {
        return programming;
    }
    public void setProgramming(int programming) {
        this.programming = programming;
    }

    public int getComputerArchitecture() {
        return computerArchitecture;
    }
    public void setComputerArchitecture(int computerArchitecture) {
        this.computerArchitecture = computerArchitecture;
    }

    public int getDatabase() {
        return database;
    }
    public void setDatabase(int database) {
        this.database = database;
    }

    public int getNetworking() {
        return networking;
    }
    public void setNetworking(int networking) {
        this.networking = networking;
    }

    public String getLetterGrade(int score){
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if(score >= 70) return "C";
        else if(score >= 60) return "D";
        else return "F";
    }
    public String getGradeColor(int score){
        if (score >= 80) return  "#27ae60";
        else if (score >= 60) return "#f39c12";
        else return "#e74c3c";
    }

    public double getGpa() {
        int[] grades = { physics, french, programming, computerArchitecture, database, networking };

        double total = 0;
        for (int grade : grades) {
            total += grade;
        }
        double average = total / grades.length;

        if (average >= 90) {
            return 4.0;
        } else if (average >= 80) {
            return 3.0;
        } else if (average >= 70) {
            return 2.0;
        } else if (average >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}