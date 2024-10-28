package model;

import java.util.List;

public interface ISale {
    void addItem(ISaleItem item);
    double calculateTotal();
    List<ISaleItem> getItems();
}