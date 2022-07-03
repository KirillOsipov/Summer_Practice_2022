package Models;

import java.time.Instant;
import java.util.Objects;

public class Patient {
    private static int idCount = 0;
    private final int id;
    private String[] name;
    private String animal;
    private Instant registrationDate;

    public Patient(String[] name, String animal, Instant registrationDate) {
        this.id = ++idCount;
        this.name = name;
        this.animal = animal;
        this.registrationDate = registrationDate;
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

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
