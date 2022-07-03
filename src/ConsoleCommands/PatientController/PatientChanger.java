package ConsoleCommands.PatientController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Patient;

import java.time.Instant;
import java.util.Optional;

public class PatientChanger extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return changePatient(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.CHANGE_PATIENT;
    }

    private int changePatient(String command) {
        String[] wordsArray = command.split(" ");
        int patientId = Integer.parseInt(wordsArray[2]);
        Optional<Patient> patientToChange = findPatient(patientId);

        if (patientToChange.isPresent()) {
            switch (wordsArray[3]) {
                case "set_name":
                    patientToChange.get().setName(new String[]{ wordsArray[4], wordsArray[5], wordsArray[6] });
                case "set_animal":
                    patientToChange.get().setAnimal(wordsArray[4]);
                case "set_registration_date":
                    patientToChange.get().setRegistrationDate(Instant.parse(wordsArray[4]));
                default:
                    System.out.println("Неверная команда!");
            }
            System.out.println("Данные пациента изменены");
        }
        else {
            System.out.println("Пациент не найден");
            return -1;
        }
        return 1;
    }
}
