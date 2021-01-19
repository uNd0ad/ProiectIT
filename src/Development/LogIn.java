package Development;

public class LogIn extends Commands {
    private int countKey = 0;
    public void logIn(String name,String pass) {
        for (int i = 0; i < getAccounts().size() ; i++) {
            if (getAccounts().get(i).equals(name) && getPasswords().get(i).equals(pass)) {
                System.out.println();
                System.out.println("Te-ai logat cu succes " + name +'\n');
                countKey--;
                break;
            }
            countKey++;
        }
        if (countKey == getAccounts().size()+1){
            System.out.println("Mai incearca o data");
        }
    }
}
