package Models;

import java.util.Objects;

public class Doctor {
    private static int idCount = 0;
    private final int id;
    private String[] name;
    private String specialization;
    private int workExperience;

    public Doctor(String[] name, String specialization, int workExperience) {
        this.id = ++idCount;
        this.name = name;
        this.specialization = specialization;
        this.workExperience = workExperience;
    }

    public int getId() {
        return id;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
