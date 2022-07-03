package ConsoleCommands.AppointmentController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Appointment;
import Models.AppointmentStatus;

import java.util.Optional;

public class AppointmentChanger extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return changeAppointmentStatus(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.CHANGE_APPOINTMENT_STATUS;
    }

    private int changeAppointmentStatus(String command) {
        String[] wordsArray = command.split(" ");
        int appointmentId = Integer.parseInt(wordsArray[2]);

        Optional<Appointment> appointment = findAppointment(appointmentId);
        if(appointment.isEmpty()) {
            System.out.println("Прием с таким ID не найден");
            return -1;
        }
        appointment.get().setStatus(wordsArray[3]);
        return 1;
    }
}