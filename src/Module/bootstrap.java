package Module;

import Development.Commands;
import Development.Database.DBAccounts;
import Development.Database.DBItems;
import Development.LogIn;
import Development.SignIn;

import java.util.Scanner;

/*******************************************************************************************
 *                                                                                         *
 *                                   My graduation app                                     *
 *                                                                                         *
 *  The primary purpose of the project was to simulate a Linux distro terminal at specific *
 *  commands. As it is the final release for deadlines, but it was not optimized before.   *
 *                                                                                         *
 *                                                                                         *
 *******************************************************************************************/

@SuppressWarnings("ALL")

public class bootstrap {
    public static void main(String[] args) {
        DBAccounts accounts = new DBAccounts();
        DBItems items = new DBItems();
        SignIn SignIn = new SignIn();
        LogIn LogIn = new LogIn();
        Commands c = new Commands();
        int commandCount = 50;

        System.out.println(accounts.getAccounts());
        System.out.println(accounts.getPasswords());
        System.out.println(accounts.getEmail());
        System.out.println();

        items.showItems();

        Scanner inp = new Scanner(System.in);
        System.out.println('\n');
        System.out.print("Doresti sa iti creezi cont?: Y/N ");
        String an = inp.next();

        if(an.equals("Y") || an.equals("y")){
            signInPath(SignIn,LogIn,c,commandCount);
        } else if(an.equals("N") || an.equals("n")) {
            logInPath(LogIn,c,commandCount);
        } else {
            throw new RuntimeException("Raspunsul nu este valid");
        }
    }
    private static void logInPath(LogIn LogIn,Commands c,int commandCount) {
        Scanner in = new Scanner(System.in);
        boolean acc = false;
        System.out.print("Username: ");
        String user3 = in.next();
        System.out.print("Password: ");
        String pass3 = in.next();
        LogIn.logIn(user3, pass3);
        if (user3.equals("Admin")){
            acc = true;
            c.showAdminCommands();
        }
        c.showCommands();
        while(commandCount!= 0){
            System.out.println();
            String com = in.next();
            switch (com) {
                case "-help" -> {
                    if (acc){
                        c.showAdminCommands();
                    }
                    c.showCommands();
                }
                case "-items" -> c.showItems();
                case "-add_item" -> {
                    System.out.print("Id: ");
                    int iD = in.nextInt();
                    System.out.print("Tip: ");
                    String type = in.next();
                    System.out.print("Nume: ");
                    String name = in.next();
                    System.out.print("Detalii:");
                    String det = in.next();
                    System.out.println();
                    System.out.print("Pret: ");
                    double pret = in.nextDouble();
                    c.addItem(iD,type,name,det,pret,acc);
                }
                case "-rmv_item" -> {
                    System.out.print("Confirm action: Y/N");
                    String ns = in.next();
                    System.out.print("ID: ");
                    int iD = in.nextInt();
                    if (ns.equals("N") || ns.equals("n")) {
                        continue;
                    } else {
                        c.removeItem(iD,acc);
                    }
                }
                case "-ch_price" -> {
                    System.out.print("ID:");
                    int id = in.nextInt();
                    System.out.print("Noul pret:");
                    double newPrice = in.nextDouble();
                    c.chPrice(id,newPrice,acc);
                }
                case "-add_account" -> c.addAccount(acc);
                case "-show_accs" -> c.showAllAccounts(acc);
                case "-show_my_acc" -> c.showMyAcc(user3);
            }
            commandCount--;
        }
    }
    private static void signInPath(SignIn SignIn,LogIn LogIn,Commands c,int commandCount) {
        Scanner in = new Scanner(System.in);
        System.out.print("Username: ");
        String user = in.next();
        System.out.print("Password: ");
        String pass = in.next();
        System.out.print("Email: ");
        String email = in.next();
        SignIn.signIn(user, pass, email);
        System.out.println();
        System.out.print("Username: ");
        String user2 = in.next();
        System.out.print("Password: ");
        String pass2 = in.next();
        LogIn.logIn(user2, pass2);
        System.out.println();
        c.showCommands();
        while(commandCount!= 0){
            String com = in.next();
            switch (com) {
                case "-help" -> c.showCommands();
                case "-items" -> c.showItems();
            }
            commandCount--;
        }
    }
}