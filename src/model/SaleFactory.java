package model;

public class SaleFactory implements ISaleFactory {
    @Override
    public ISale createSale() {
        return new Sale();
    }

    @Override
    public ISaleItem createSaleItem(IProduct product, int quantity) {
        return new SaleItem(product, quantity);
    }
}