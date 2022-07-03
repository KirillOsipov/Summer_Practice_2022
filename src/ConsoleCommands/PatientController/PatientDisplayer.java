package ConsoleCommands.PatientController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Patient;

public class PatientDisplayer extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return displayPatients(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.DISPLAY_PATIENTS;
    }

    private int displayPatients(String command) {
        for (Patient patient : patientRepository.findAll()) {

            System.out.printf("ИД: %d. Фамилия: %s. Имя: %s. Отчество: %s. Животное: %s. Дата регистрации: %s \n",
                    patient.getId(),
                    patient.getName()[0],
                    patient.getName()[1],
                    patient.getName()[2],
                    patient.getAnimal(),
                    patient.getRegistrationDate()
            );
        }

        return 1;
    }
}
