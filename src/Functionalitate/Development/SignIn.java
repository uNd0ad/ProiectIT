package Functionalitate.Development;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

@SuppressWarnings("ALL")

public class SignIn extends Commands {
    public void signIn(@NotNull String account, @NotNull String pass, @NotNull String email) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        for (int i = 0; i < getAccounts().size(); i++) {
            if (getAccounts().get(i).equals(account)) {
                System.out.println("Username-ul exista deja, alege altul");
                account = in.next();
                counter++;

            } else if (counter==5) {
                throw new RuntimeException("Imi pare rau, incearca mai tarziu");
            } else {
                break;
            }
        }
        counter = 0;
        for (int i = 0; i < getEmail().size(); i++) {
            if (getAccounts().get(i).equals(email)) {
                System.out.println("Username-ul exista deja, alege altul");
                email = in.next();
                counter++;
            } else if (counter==5) {
                throw new RuntimeException("Imi pare rau, incearca mai tarziu");
            } else {
                break;
            }
        }
        setAccountCmd(account, pass, email, false);
    }
}
