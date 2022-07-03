package ConsoleCommands.DoctorController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Doctor;

import java.util.Optional;

public class DoctorDeleter extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return deleteDoctor(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.DELETE_DOCTOR;
    }

    private int deleteDoctor(String command) {
        String[] wordsArray = command.split(" ");
        int doctorId = Integer.parseInt(wordsArray[2]);
        Optional<Doctor> doctorToRemove = findDoctor(doctorId);

        if (doctorToRemove.isPresent()) {
            doctorRepository.remove(doctorToRemove.get());
            System.out.println("Врач удален");
        }
        else {
            System.out.println("Врач не найден");
        }

        return 1;
    }
}