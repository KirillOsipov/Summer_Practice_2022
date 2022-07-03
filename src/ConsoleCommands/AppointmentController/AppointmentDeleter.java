package ConsoleCommands.AppointmentController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Appointment;

import java.util.Optional;

public class AppointmentDeleter extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return deleteAppointment(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.DELETE_APPOINTMENT;
    }

    private int deleteAppointment(String command) {
        String[] wordsArray = command.split(" ");
        int appointmentId = Integer.parseInt(wordsArray[2]);
        Optional<Appointment> appointmentToRemove = findAppointment(appointmentId);

        if (appointmentToRemove.isPresent()) {
            appointmentRepository.remove(appointmentToRemove.get());
            System.out.println("Прием удален");
        }
        else {
            System.out.println("Прием не найден");
        }

        return 1;
    }
}
