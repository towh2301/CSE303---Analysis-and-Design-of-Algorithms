package Learning;

import java.util.Scanner;
import java.util.TreeSet;

class EIUQBHVLearning {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String letter = sc.next();

        TreeSet<String> passwords = new TreeSet<>();
        passwords.add(String.valueOf(letter.charAt(0)));

        for (int i = 1; i < letter.length(); i++) {
            TreeSet<String> subPasswords = new TreeSet<>();

            for (String password : passwords) {
                for (int j = 0; j <= password.length(); j++) {
                    String newSubPass = password.substring(0, j) + letter.charAt(i) + password.substring(j);
                    subPasswords.add(newSubPass);
                }
            }
            passwords = subPasswords;
        }
    }
}
