package ConsoleCommands;

import Models.Appointment;
import Models.Doctor;
import Models.Patient;
import Repositories.AppointmentRepository;
import Repositories.DoctorRepository;
import Repositories.PatientRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCommandExecutor implements ICommandExecutor {

    protected final PatientRepository patientRepository = PatientRepository.getSingleton();
    protected final DoctorRepository doctorRepository = DoctorRepository.getSingleton();
    protected final AppointmentRepository appointmentRepository = AppointmentRepository.getSingleton();

    protected Optional<Patient> findPatient(int patientId) {
        for (Patient patient : patientRepository.findAll()) {
            if (patient.getId() == patientId) {
                return Optional.of(patient);
            }
        }

        return Optional.empty();
    }

    protected Optional<Doctor> findDoctor(int doctorId) {
        for (var doctor : doctorRepository.findAll()) {
            if (doctor.getId() == doctorId) {
                return Optional.of(doctor);
            }
        }

        return Optional.empty();
    }

    protected Optional<Appointment> findAppointment(int appointmentId) {
        for (var appointment : appointmentRepository.findAll()) {
            if (appointment.getId() == appointmentId) {
                return Optional.of(appointment);
            }
        }

        return Optional.empty();
    }
}