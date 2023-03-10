package it.italiandudes.easy_sheet.common.sheet;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.common.sheet.inventory.Wallet;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class Inventory implements SheetComponent {

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
    public Inventory(@NotNull Element dndSheet) throws RuntimeException {
        wallet = new Wallet(dndSheet);
        items = new ArrayList<>();
        NodeList itemList = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Inventory.Item.ITEM);
        for(int i=0;i<itemList.getLength();i++){
            items.add(itemList.item(i).getTextContent());
        }
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
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        Element inventoryElement = dndSheet.createElement(EasySheet.Defs.XMLElementNames.Inventory.INVENTORY);
        Element itemElement;
        for(String item : items){
            itemElement = dndSheet.createElement(EasySheet.Defs.XMLElementNames.Inventory.Item.ITEM);
            itemElement.setTextContent(item);
            inventoryElement.appendChild(itemElement);
        }
        wallet.writeComponent(dndSheet, inventoryElement);
        parent.appendChild(inventoryElement);
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
