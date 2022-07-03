package ConsoleCommands;

import ConsoleCommands.AppointmentController.AppointmentChanger;
import ConsoleCommands.AppointmentController.AppointmentCreator;
import ConsoleCommands.AppointmentController.AppointmentDeleter;
import ConsoleCommands.AppointmentController.AppointmentDisplayer;
import ConsoleCommands.DoctorController.DoctorChanger;
import ConsoleCommands.DoctorController.DoctorCreator;
import ConsoleCommands.DoctorController.DoctorDeleter;
import ConsoleCommands.DoctorController.DoctorDisplayer;
import ConsoleCommands.PatientController.PatientChanger;
import ConsoleCommands.PatientController.PatientCreator;
import ConsoleCommands.PatientController.PatientDeleter;
import ConsoleCommands.PatientController.PatientDisplayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandReader {
    private static final Map<CommandList, ICommandExecutor> COMMAND_EXECUTORS = new HashMap<>() {
        {
            //put(CommandList.LOGIN, new );
            //put(CommandList.LOGOUT, new );
            put(CommandList.ADD_PATIENT, new PatientCreator());
            put(CommandList.CHANGE_PATIENT, new PatientChanger());
            put(CommandList.DELETE_PATIENT, new PatientDeleter());
            put(CommandList.DISPLAY_PATIENTS, new PatientDisplayer());

            put(CommandList.ADD_DOCTOR, new DoctorCreator());
            put(CommandList.CHANGE_DOCTOR, new DoctorChanger());
            put(CommandList.DELETE_DOCTOR, new DoctorDeleter());
            put(CommandList.DISPLAY_DOCTORS, new DoctorDisplayer());

            put(CommandList.ADD_APPOINTMENT, new AppointmentCreator());
            put(CommandList.CHANGE_APPOINTMENT_STATUS, new AppointmentChanger());
            put(CommandList.DELETE_APPOINTMENT, new AppointmentDeleter());
            put(CommandList.DISPLAY_APPOINTMENTS, new AppointmentDisplayer());
        }
    };

    public static void startReading() {
        Scanner sc = new Scanner(System.in);

        int i = 1;
        while (i != 0) {
            i = readCommand(sc);
        }

        sc.close();
    }

    private static int readCommand(Scanner sc) {
        String commandString = sc.nextLine();

        CommandList command = getCommand(commandString);

        if (COMMAND_EXECUTORS.containsKey(command)) {
            ICommandExecutor commandExecutor = COMMAND_EXECUTORS.get(command);
            return commandExecutor.execute(commandString);
        }

        if (command == CommandList.EXIT) {
            return 0;
        }

        System.out.println("Неправильная команда");
        return -1;
    }

    private static CommandList getCommand(String commandString) {
        if (commandString.startsWith("add patient")) {
            return CommandList.ADD_PATIENT;
        }

        if (commandString.startsWith("delete patient")) {
            return CommandList.DELETE_PATIENT;
        }

        if (commandString.startsWith("change patient")) {
            return CommandList.CHANGE_PATIENT;
        }

        if (commandString.startsWith("display patients")) {
            return CommandList.DISPLAY_PATIENTS;
        }

        if (commandString.startsWith("add doctor")) {
            return CommandList.ADD_DOCTOR;
        }

        if (commandString.startsWith("delete doctor")) {
            return CommandList.DELETE_DOCTOR;
        }

        if (commandString.startsWith("change doctor")) {
            return CommandList.CHANGE_DOCTOR;
        }

        if (commandString.startsWith("display doctors")) {
            return CommandList.DISPLAY_DOCTORS;
        }

        if (commandString.startsWith("add appointment")) {
            return CommandList.ADD_APPOINTMENT;
        }

        if (commandString.startsWith("delete appointment")) {
            return CommandList.DELETE_APPOINTMENT;
        }

        if (commandString.startsWith("change appointment_status")) {
            return CommandList.CHANGE_APPOINTMENT_STATUS;
        }

        if (commandString.startsWith("display appointments")) {
            return CommandList.DISPLAY_APPOINTMENTS;
        }

        if (commandString.startsWith("exit")) {
            return CommandList.EXIT;
        }

        return CommandList.UNDEFINED;
    }
}
