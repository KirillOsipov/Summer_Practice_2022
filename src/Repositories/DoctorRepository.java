package Repositories;

import Models.Doctor;
import Models.Patient;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepository {
    private static final Set<Doctor> DOCTORS = new HashSet<>();
    private static final DoctorRepository SINGLETON = new DoctorRepository();
    private DoctorRepository() {}

    public static DoctorRepository getSingleton() {
        return SINGLETON;
    }

    public Set<Doctor> findAll() {
        return DOCTORS;
    }

    public void save(Doctor doctor) {
        DOCTORS.add(doctor);
    }

    public void remove(Doctor doctor) {
        DOCTORS.remove(doctor);
    }
}
