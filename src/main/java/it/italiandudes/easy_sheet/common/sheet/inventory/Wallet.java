package it.italiandudes.easy_sheet.common.sheet.inventory;

import it.italiandudes.easy_sheet.EasySheet;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
public final class Wallet {

    //Attributes
    private int copperCoins;
    private int silverCoins;
    private int electrumCoins;
    private int goldCoins;
    private int platinumCoins;

    //Constructors
    public Wallet() {
        copperCoins = 0;
        silverCoins = 0;
        electrumCoins = 0;
        goldCoins = 0;
        platinumCoins = 0;
    }

    public Wallet(int copperCoins, int silverCoins, int electrumCoins, int goldCoins, int platinumCoins) {
        this.copperCoins = copperCoins;
        this.silverCoins = silverCoins;
        this.electrumCoins = electrumCoins;
        this.goldCoins = goldCoins;
        this.platinumCoins = platinumCoins;
    }

    public Wallet(@NotNull Element dndSheet) {
        Element walletElement = (Element) dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Inventory.Wallet.WALLET).item(0);
        copperCoins = Integer.parseInt(walletElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Inventory.Wallet.COPPER_COINS).item(0).getTextContent());
        silverCoins = Integer.parseInt(walletElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Inventory.Wallet.SILVER_COINS).item(0).getTextContent());
        electrumCoins = Integer.parseInt(walletElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Inventory.Wallet.ELECTRUM_COINS).item(0).getTextContent());
        goldCoins = Integer.parseInt(walletElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Inventory.Wallet.GOLD_COINS).item(0).getTextContent());
        platinumCoins = Integer.parseInt(walletElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Inventory.Wallet.PLATINUM_COINS).item(0).getTextContent());
    }

    //Methods
    public int getCopperCoins() {
        return copperCoins;
    }

    public void setCopperCoins(int copperCoins) {
        this.copperCoins = copperCoins;
    }

    public int getSilverCoins() {
        return silverCoins;
    }

    public void setSilverCoins(int silverCoins) {
        this.silverCoins = silverCoins;
    }

    public int getElectrumCoins() {
        return electrumCoins;
    }

    public void setElectrumCoins(int electrumCoins) {
        this.electrumCoins = electrumCoins;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getPlatinumCoins() {
        return platinumCoins;
    }

    public void setPlatinumCoins(int platinumCoins) {
        this.platinumCoins = platinumCoins;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (getCopperCoins() != wallet.getCopperCoins()) return false;
        if (getSilverCoins() != wallet.getSilverCoins()) return false;
        if (getElectrumCoins() != wallet.getElectrumCoins()) return false;
        if (getGoldCoins() != wallet.getGoldCoins()) return false;
        return getPlatinumCoins() == wallet.getPlatinumCoins();
    }
    @Override
    public int hashCode() {
        int result = getCopperCoins();
        result = 31 * result + getSilverCoins();
        result = 31 * result + getElectrumCoins();
        result = 31 * result + getGoldCoins();
        result = 31 * result + getPlatinumCoins();
        return result;
    }
    @Override
    public String toString() {
        return "Wallet{" +
                "copperCoins=" + copperCoins +
                ", silverCoins=" + silverCoins +
                ", electrumCoins=" + electrumCoins +
                ", goldCoins=" + goldCoins +
                ", platinumCoins=" + platinumCoins +
                '}';
    }
}
