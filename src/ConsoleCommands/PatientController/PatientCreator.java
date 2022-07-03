package ConsoleCommands.PatientController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Patient;

import java.time.Instant;

public class PatientCreator extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return createPatient(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.ADD_PATIENT;
    }

    private int createPatient(String command) {
        String[] wordsArray = command.split(" ");
        String[] patientName = { wordsArray[2], wordsArray[3], wordsArray[4] };
        String animal = wordsArray[5];
        Instant registrationDate = Instant.parse(wordsArray[6]);

        Patient newPatient = new Patient(patientName, animal, registrationDate);
        patientRepository.save(newPatient);
        System.out.println("Пациент создан");

        return 1;
    }
}