import java.util.Scanner;

public class PasswordComplexityChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();
        
        String feedback = checkPasswordStrength(password);
        System.out.println(feedback);
    }

    public static String checkPasswordStrength(String password) {
        int lengthCriteria = 8;
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        if (password.length() < lengthCriteria) {
            return "Password is too short. It should be at least " + lengthCriteria + " characters long.";
        }
        
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (isSpecialCharacter(ch)) {
                hasSpecialChar = true;
            }
        }
        
        int criteriaMet = 0;
        criteriaMet += hasLowercase ? 1 : 0;
        criteriaMet += hasUppercase ? 1 : 0;
        criteriaMet += hasDigit ? 1 : 0;
        criteriaMet += hasSpecialChar ? 1 : 0;
        
        if (criteriaMet < 3) {
            return "Password is weak. Try including uppercase letters, numbers, and special characters.";
        } else if (criteriaMet == 3) {
            return "Password is moderate. Consider adding more variety for a stronger password.";
        } else {
            return "Password is strong.";
        }
    }

    private static boolean isSpecialCharacter(char ch) {
        String specialCharacters = "!@#$%^&*()-+";
        return specialCharacters.contains(String.valueOf(ch));
    }
}
