package Repositories;

import Models.Appointment;
import Models.Doctor;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepository {
    private static final Set<Appointment> APPOINTMENTS = new HashSet<>();
    private static final AppointmentRepository SINGLETON = new AppointmentRepository();
    private AppointmentRepository() {}

    public static AppointmentRepository getSingleton() {
        return SINGLETON;
    }

    public Set<Appointment> findAll() {
        return APPOINTMENTS;
    }

    public void save(Appointment appointment) {
        APPOINTMENTS.add(appointment);
    }

    public void remove(Appointment appointment) {
        APPOINTMENTS.remove(appointment);
    }
}
