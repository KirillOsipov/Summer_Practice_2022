package Repositories;

import Models.Patient;

import java.util.HashSet;
import java.util.Set;

public class PatientRepository {
    private static final Set<Patient> PATIENTS = new HashSet<>();
    private static final PatientRepository SINGLETON = new PatientRepository();
    private PatientRepository() {}

    public static PatientRepository getSingleton() {
        return SINGLETON;
    }

    public Set<Patient> findAll() {
        return PATIENTS;
    }

    public void save(Patient patient) {
        PATIENTS.add(patient);
    }

    public void remove(Patient patient) {
        PATIENTS.remove(patient);
    }
}
