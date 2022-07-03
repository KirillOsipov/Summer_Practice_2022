package ConsoleCommands.PatientController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Patient;

import java.util.Optional;

public class PatientDeleter extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return deletePatient(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.DELETE_PATIENT;
    }

    private int deletePatient(String command) {
        String[] wordsArray = command.split(" ");
        int patientId = Integer.parseInt(wordsArray[2]);
        Optional<Patient> patientToRemove = findPatient(patientId);

        if (patientToRemove.isPresent()) {
            patientRepository.remove(patientToRemove.get());
            System.out.println("Пациент удален");
        }
        else {
            System.out.println("Пациент не найден");
        }

        return 1;
    }
}
