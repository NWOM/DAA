import java.util.Scanner;
import java.util.regex.Pattern;

//VALID MOBILE NUMBER
class GFG {
    public static boolean isValid(String s) {
        // Check if the string starts with "0" or "91"
        if (s.startsWith("0")) {
            s = s.substring(1);
        } else if (s.startsWith("91")) {
            s = s.substring(2);
        }

        // Check if the string length is 10
        if (s.length() != 10) {
            return false;
        }

        // Check if the first character is 6, 7, 8, or 9
        if (s.charAt(0) < '6' || s.charAt(0) > '9') {
            return false;
        }

        // Check if all characters are digits
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
    public static boolean isValidPhone(String phoneNumber){
        String regex="^(\\+91|0)?[1-9][0-9]{9}$";
        return Pattern.matches(regex,phoneNumber);
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mobile number:");
        String s = scanner.nextLine();

        if (isValid(s))
            System.out.println("Valid Number");
        else
            System.out.println("Invalid Number");

        scanner.close();
    }
}
