import ConsoleCommands.CommandReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String log = sc.nextLine();
        String pass = sc.nextLine();
        if(Authentication.login(log, pass)) {
            CommandReader.startReading();
        }
    }
}