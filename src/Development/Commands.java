package Development;

import Development.Database.DBItems;

import java.util.Scanner;

@SuppressWarnings("ALL")

public class Commands extends DBItems {
    Scanner in = new Scanner(System.in);

    public void showCommands(){
        //Basic users commands
        System.out.println("'-items' //Pentru a vedea produsele existente in stoc.");
        System.out.println("'-help' //Pentru a vedea comenzile din nou.");
    }
    public void showAdminCommands(){
        //Privileged users commands
        System.out.println("'-add_account' //Pentru a adauga alte conturi fara inregistrare.");
        System.out.println("'-add_item' id //Pentru a adauga un produs in lista.");
        System.out.println("'-rmv_item' id //Pentru a scoate un produs din lista.");
        System.out.println("'-ch_price' id //Pentru a modifica pretul actual al produselor.");
        System.out.println("'-show_accs' //Pentru a vedea cate conturi exista in baza de date.");
        System.out.println("'-show_my_acc' // Pentru a vedea detalii despre contul curent.");
    }
    public void addItem(int id, String type, String name, String details, double price, boolean acc){
            if (acc) {
                for (int i = 0; i < getId().size(); i++) {
                    if (getId().get(i)==id) {
                        System.out.println("Exista deja un produs cu id-ul respectiv!");
                    } else {
                        setItm(id,type,name,details,price);
                        break;
                    }
                }
            } else {
                System.out.println("Nu ai acces - Admin command.");
            }
    }
    public void removeItem(int id, boolean acc){
        int counter = 0;
        if (acc) {
            for (int i = 0; i < getId().size(); i++) {
                if (getId().get(i)==id) {
                    removeItm(id);
                    counter--;
                    break;
                }
                counter++;
            }
            if (counter == getId().size()){
                System.out.println("Produsul nu exista.");
            }
        } else {
            System.out.println("Nu ai acces - Admin command.");
        }
    }
    public void showItems() {
        super.showItems();
    }
    public void chPrice(int id, double newPrice, boolean acc){
        if(acc) {
            changePrice(id,newPrice);
        } else {
            System.out.println("Nu ai acces - Admin command.");
        }
    }
    public void addAccount(boolean acc){
        if (acc){
            boolean isAdmin;
            System.out.println("Username: ");
            String u = in.next();
            System.out.println("Password: ");
            String p = in.next();
            System.out.println("Email: ");
            String e = in.next();
            System.out.println("Acces Admin?: Y/N");
            String ans = in.next();
            isAdmin = ans.equals("Y") || ans.equals("y");
            setAccountCmd(u, p, e, isAdmin);
        } else {
            System.out.println("Nu ai acces - Admin command.");
        }
    }
    public void showAllAccounts(boolean acc){
        showAccounts(acc);
    }
    public void showMyAcc(String name){
        for (int i = 0; i < getAccounts().size(); i++) {
            if (getAccounts().get(i).equals(name)){
                System.out.println("name: " + getAccounts().get(i));
                System.out.println("password: " + getPasswords().get(i));
                System.out.println("email: " + getEmail().get(i));
                System.out.println("access: "+ getPrivileges().get(i));
            }
        }
    }
}
