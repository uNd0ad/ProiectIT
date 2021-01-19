package Development.Database;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("ALL")

public class DBAccounts {

    // Account related
    private ArrayList<String> accounts = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();
    private ArrayList<Boolean> privileges = new ArrayList<>();

    public DBAccounts(){
        addDefaults();
    }
    //Getters
    public ArrayList<String> getAccounts() {
        return accounts;
    }
    public ArrayList<String> getPasswords() {
        return passwords;
    }
    public ArrayList<String> getEmail() {
        return emails;
    }
    public ArrayList<Boolean> getPrivileges() {
        return privileges;
    }
    //Setters
    public void setAccountCmd(String account,String password,String email,boolean isAdmin){
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
                this.accounts.add(account);
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
                this.emails.add(email);
                break;
            }
        }
        this.passwords.add(password);
        this.privileges.add(isAdmin);
        System.out.println("Te-ai inregistrat cu succes! :)");
    }

    // Showing accounts - only admins
    public void showAccounts(boolean acc){
        if (acc){
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println("name: " + accounts.get(i));
                System.out.println("password: " + passwords.get(i));
                System.out.println("email: " + emails.get(i));
                System.out.println("access: "+ privileges.get(i));
                System.out.println();
            }
        }
    }

    public void addDefaults(){
        accounts.add(0, "Admin");
        passwords.add(0, "1234");
        emails.add(0, "admin@domeniu.tld");
        privileges.add(0, true);
        accounts.add(1, "Costumer");
        passwords.add(1, "1212");
        emails.add(1, "cost@gmail.com");
        privileges.add(1, false);
    }
}
