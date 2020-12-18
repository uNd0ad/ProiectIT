package Functionalitate.Interface;

public interface itemList {
    void setItm(int id, String type, String name, String details, double price);
    void removeItm(int id);
    void showItems();
}
