package model;

import java.util.ArrayList;
import java.util.List;

public class Sale implements ISale {
    private List<ISaleItem> items;

    public Sale() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(ISaleItem item) {
        this.items.add(item);
    }

    @Override
    public double calculateTotal() {
        return items.stream().mapToDouble(ISaleItem::getSubtotal).sum();
    }

    @Override
    public List<ISaleItem> getItems() {
        return items;
    }
}