package ConsoleCommands.AppointmentController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Appointment;

import java.util.Arrays;

public class AppointmentDisplayer extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return displayAppointments(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.DISPLAY_APPOINTMENTS;
    }

    private int displayAppointments(String command) {
        for (Appointment appointment : appointmentRepository.findAll()) {

            System.out.printf("ИД: %d. Статус приема: %s. ФИО врача: %s %s %s. ФИО пациента: %s %s %s. Дата приема: %s. \n",
                    appointment.getId(),
                    appointment.getStatus().getAppointmentStatus(),
                    appointment.getDoctor().getName()[0],
                    appointment.getDoctor().getName()[1],
                    appointment.getDoctor().getName()[2],
                    appointment.getPatient().getName()[0],
                    appointment.getPatient().getName()[1],
                    appointment.getPatient().getName()[2],
                    appointment.getDateOfAppointment()
            );
        }

        return 1;
    }
}
