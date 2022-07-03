package ConsoleCommands.AppointmentController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Appointment;
import Models.Doctor;
import Models.Patient;

import java.time.Instant;
import java.util.Optional;

public class AppointmentCreator extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return createAppointment(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.ADD_APPOINTMENT;
    }

    private int createAppointment(String command) {
        String[] wordsArray = command.split(" ");
        int doctorId = Integer.parseInt(wordsArray[2]);
        int patientId = Integer.parseInt(wordsArray[3]);
        Instant dateOfAppointment = Instant.parse(wordsArray[4]);

        Optional<Doctor> doctor = findDoctor(doctorId);
        Optional<Patient> patient = findPatient(patientId);
        if(doctor.isEmpty() || patient.isEmpty()) {
            System.out.println("Врач или пациент с таким ID не найден");
            return -1;
        }

        Appointment newAppointment = new Appointment(doctor.get(), patient.get(), dateOfAppointment);
        appointmentRepository.save(newAppointment);
        System.out.println("Прием создан");

        return 1;
    }
}
