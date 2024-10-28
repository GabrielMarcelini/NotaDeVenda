package model;

public interface ISaleFactory {
    ISale createSale();
    ISaleItem createSaleItem(IProduct product, int quantity);
}
