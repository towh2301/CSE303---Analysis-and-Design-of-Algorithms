package Lab3;

import java.util.Scanner;
import java.util.TreeSet;

 class LAB3_EIUQBHV {
    private static final Scanner sc = new Scanner(System.in);
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String pass = sc.nextLine();
        TreeSet<String> treeSetPasswords = new TreeSet<>();
        treeSetPasswords.add(String.valueOf(pass.charAt(0))); // The first character

        for (int i = 1; i < pass.length(); i++) {
            TreeSet<String> subPassword = new TreeSet<>();

            for (String password : treeSetPasswords) {
                for (int j = 0; j <= password.length(); j++) {
                    var passwordSub = password.substring(0, j) + pass.charAt(i) + password.substring(j);
                    subPassword.add(passwordSub);
                }
            }
            treeSetPasswords = subPassword;
        }

        sb.append(treeSetPasswords.size()).append("\n");
        for (String subPass : treeSetPasswords) {
            sb.append(subPass).append("\n");
        }

        System.out.println(sb);
    }
}
