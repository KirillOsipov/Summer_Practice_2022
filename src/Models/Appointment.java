package Models;

import java.time.Instant;
import java.util.Objects;

public class Appointment {
    private static int idCount = 0;
    private final int id;
    private Doctor doctor;
    private Patient patient;
    private Instant dateOfAppointment;
    private AppointmentStatus status;

    public Appointment(Doctor doctor, Patient patient, Instant dateOfAppointment) {
        this.id = ++idCount;
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfAppointment = dateOfAppointment;
        this.status = AppointmentStatus.NEW;
    }

    public int getId() { return id; }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Instant getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Instant dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
    public void setStatus(String appointmentStatus) {
        for (AppointmentStatus as : AppointmentStatus.values()) {
            String currentAppointmentStatus = as.getAppointmentStatus();
            if(appointmentStatus.equals(currentAppointmentStatus)) {
                this.status = as;
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
