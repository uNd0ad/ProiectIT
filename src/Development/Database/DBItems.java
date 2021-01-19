package Development.Database;

import Interface.itemList;

import java.util.ArrayList;

@SuppressWarnings("ALL")

public class DBItems extends DBAccounts implements itemList {
    protected ArrayList<Integer> id = new ArrayList<>();
    protected ArrayList<String> type = new ArrayList<>();
    protected ArrayList<String> name = new ArrayList<>();
    protected ArrayList<String> details = new ArrayList<>();
    protected ArrayList<Double> price = new ArrayList<>();

    public DBItems() {
        id.add(0);
        type.add("-tip-");
        name.add("-nume-");
        details.add("-model-");
        price.add(0.0);
        id.add(1);
        type.add("Fructe");
        name.add("Mar");
        details.add("Proaspete");
        price.add(1.20);
        id.add(2);
        type.add("Lactate");
        name.add("Lapte");
        details.add("Provenieta: Bovine");
        price.add(12.3);
    }

    //Getters
    public ArrayList<Integer> getId() {
        return id;
    }

    //Setters
    public void setItm(int id,String type, String name, String description, double price) {
        this.id.add(id);
        this.type.add(type);
        this.name.add(name);
        this.details.add(description);
        this.price.add(price);
        System.out.println("Ai adaugat un produs cu succes");
    }
    @Override
    public void removeItm(int id) {
        System.out.println("Produsul "+id+" "+name.get(id)+" a fost eliminat.");
        this.id.remove(id);
        this.type.remove(id);
        this.name.remove(id);
        this.details.remove(id);
        this.price.remove(id);
    }
    public void changePrice(int id, double newPrice){
        double oldPrice;

        for (int i = 0; i < price.size(); i++) {
            if (price.indexOf(id) == price.indexOf(i)) {
                oldPrice = price.get(id);
                price.set(id,newPrice);
                System.out.println("Pretul la " + getIdElem(id) + " - " + getNameElem(id) + " a fost modificat din " + oldPrice + " in " + price.get(id));
                break;
            } else {
                System.out.println("Produsul cu id-ul " + id + " nu exista.");
            }
        }
    }

    //Getter of element
    int getIdElem(int i) {
        return (id.get(i));
    }
    String getTypeElem(int i) {
        return (type.get(i));
    }
    String getNameElem(int i) {
        return(name.get(i));
    }
    String getDetailsElem(int i) {
        return details.get(i);
    }
    double getPriceElem(int i) {
        return(price.get(i));
    }

    //StringBuilder for item list
    StringBuilder stringBuilder(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getId().size(); i++) {
            sb.append(getIdElem(i));
            sb.append(" - ");
            sb.append(getTypeElem(i));
            sb.append(": ");
            sb.append(getNameElem(i));
            sb.append(" Pret: ");
            sb.append(getPriceElem(i));
            sb.append("$ ");
            sb.append(" Detalii: ");
            sb.append(getDetailsElem(i));
            System.out.println(sb);
            sb = new StringBuilder();
        }
        return null;
    }

    @Override
    public void showItems() {
        stringBuilder();
    }
}


