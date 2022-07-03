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

            System.out.printf("ИД: %d. Статус приема: %s. ФИО врача: %s. ФИО пациента: %s. Дата приема: %s. \n",
                    appointment.getId(),
                    appointment.getStatus(),
                    Arrays.toString(appointment.getDoctor().getName()),
                    Arrays.toString(appointment.getPatient().getName()),
                    appointment.getDateOfAppointment()
            );
        }

        return 1;
    }
}
