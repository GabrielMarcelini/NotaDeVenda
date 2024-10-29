package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SaleItem> items;

    public Sale() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        this.items.add(new SaleItem(product, quantity));
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(SaleItem::getSubtotal).sum();
    }

    public List<SaleItem> getItems() {
        return items;
    }
}
