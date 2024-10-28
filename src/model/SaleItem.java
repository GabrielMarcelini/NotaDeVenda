package model;

public class SaleItem implements ISaleItem {
    private IProduct product;
    private int quantity;

    public SaleItem(IProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public IProduct getProduct() {
        return product;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}