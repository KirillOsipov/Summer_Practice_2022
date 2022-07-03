import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private static final Map<String, String> credentials = new HashMap<>(){
        {
            put("admin", "12345");
            put("test", "67890");
            put("some_login", "some_password");
        }
    };


    public static boolean login(String log, String pass) {
        if (credentials.containsKey(log) && credentials.get(log).equals(pass)) {
            System.out.println("Вход выполнен!");
            return true;
        }
        else {
            System.out.println("Не удалось войти!");
            return false;
        }
    }

}
