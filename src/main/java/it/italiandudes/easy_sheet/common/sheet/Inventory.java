package it.italiandudes.easy_sheet.common.sheet;

import it.italiandudes.easy_sheet.common.sheet.inventory.Wallet;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class Inventory {

    //Attributes
    @NotNull private final Wallet wallet;
    @NotNull private final ArrayList<String> items;

    //Constructors
    public Inventory(@NotNull Wallet wallet, @NotNull ArrayList<String> items) {
        this.wallet = wallet;
        this.items = items;
    }
    public Inventory(){
        wallet = new Wallet();
        items = new ArrayList<>();
    }
    public Inventory(@NotNull Document dndSheet){
        wallet = new Wallet(dndSheet);
        items = new ArrayList<>(); //TODO: read items from xml
    }

    //Methods
    @NotNull
    public Wallet getWallet() {
        return wallet;
    }
    @NotNull
    public ArrayList<String> getItems() {
        return items;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (!getWallet().equals(inventory.getWallet())) return false;
        return getItems().equals(inventory.getItems());
    }
    @Override
    public int hashCode() {
        int result = getWallet().hashCode();
        result = 31 * result + getItems().hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Inventory{" +
                "wallet=" + wallet +
                ", items=" + items +
                '}';
    }
}
