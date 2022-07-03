package ConsoleCommands.PatientController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

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
        String[] patientName = {wordsArray[2], wordsArray[3], wordsArray[4]};
        String animal = wordsArray[5];
        //Instant registrationDate = Instant.parse(wordsArray[6]);

        Date registrationDate = null;
        try {
            registrationDate = new SimpleDateFormat("yyyy-MM-dd").parse(wordsArray[6]);
        }
        catch (ParseException pe) {
            System.out.println(pe);
        }

        assert registrationDate != null;
        Patient newPatient = new Patient(patientName, animal, registrationDate.toInstant());
        patientRepository.save(newPatient);
        System.out.println("Пациент создан");

        return 1;
    }
}