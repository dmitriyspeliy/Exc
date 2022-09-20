import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exc {

    public static void main(String[] args) {
        System.out.println(getVerification("java_skypro.go","1231w23","123123"));
    }


    public static boolean getVerification(String login,String password, String confirmPassword){
        String regex = "^[a-zA-Z0-9_.]+$";
        Pattern patternForLogin = Pattern.compile(regex);
        Matcher matcherForLogin = patternForLogin.matcher(login);
        Pattern patternForPassword = Pattern.compile(regex);
        Matcher matcherForPassword = patternForPassword.matcher(password);
        boolean result = true;
        try {
            if(!matcherForLogin.matches() || login.length() > 20)
                throw new WrongLoginException("Этот логин введен некоректно");
            if(!matcherForPassword.matches() || password.length() > 20 || !password.equals(confirmPassword))
                throw new WrongPasswordException("Этот пароль введен некоректно");
        }catch (WrongLoginException | WrongPasswordException e) {
            result = false;
            throw new RuntimeException(e);
        }finally {
            return result;
        }
    }
}

