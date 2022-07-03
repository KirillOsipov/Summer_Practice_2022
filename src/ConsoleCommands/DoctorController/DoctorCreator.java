package ConsoleCommands.DoctorController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Doctor;

public class DoctorCreator extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return createDoctor(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.ADD_DOCTOR;
    }

    private int createDoctor(String command) {
        String[] wordsArray = command.split(" ");
        String[] doctorName = { wordsArray[2], wordsArray[3], wordsArray[4] };
        String specialization = wordsArray[5];
        int workExperience = Integer.parseInt(wordsArray[6]);

        Doctor newDoctor = new Doctor(doctorName, specialization, workExperience);
        doctorRepository.save(newDoctor);
        System.out.println("Врач создан");

        return 1;
    }
}
