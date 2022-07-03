package ConsoleCommands.DoctorController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Doctor;
import Models.Patient;

import java.time.Instant;
import java.util.Optional;

public class DoctorChanger extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return changeDoctor(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.CHANGE_DOCTOR;
    }

    private int changeDoctor(String command) {
        String[] wordsArray = command.split(" ");
        int doctorId = Integer.parseInt(wordsArray[2]);
        Optional<Doctor> doctorToChange = findDoctor(doctorId);

        if (doctorToChange.isPresent()) {
            switch (wordsArray[3]) {
                case "set_name":
                    doctorToChange.get().setName(new String[]{ wordsArray[4], wordsArray[5], wordsArray[6] });
                case "set_specialization":
                    doctorToChange.get().setSpecialization(wordsArray[4]);
                case "set_work_experience":
                    doctorToChange.get().setWorkExperience(Integer.parseInt(wordsArray[4]));
                default:
                    System.out.println("Неверная команда!");
            }
            System.out.println("Данные врача изменены");
        }
        else {
            System.out.println("Врач не найден");
            return -1;
        }
        return 1;
    }
}
