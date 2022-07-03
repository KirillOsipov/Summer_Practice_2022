package ConsoleCommands.DoctorController;

import ConsoleCommands.AbstractCommandExecutor;
import ConsoleCommands.CommandList;
import Models.Doctor;

public class DoctorDisplayer extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return displayDoctors(command);
    }

    @Override
    public CommandList getCommand() {
        return CommandList.DISPLAY_DOCTORS;
    }

    private int displayDoctors(String command) {
        for (Doctor doctor : doctorRepository.findAll()) {

            System.out.printf("ИД: %d. Фамилия: %s. Имя: %s. Отчество: %s. Специализация: %s. Опыт работы: %d \n",
                    doctor.getId(),
                    doctor.getName()[0],
                    doctor.getName()[1],
                    doctor.getName()[2],
                    doctor.getSpecialization(),
                    doctor.getWorkExperience()
            );
        }

        return 1;
    }
}