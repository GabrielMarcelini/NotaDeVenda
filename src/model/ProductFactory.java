package model;

public class ProductFactory implements IProductFactory {
    @Override
    public IProduct createProduct(String name, double price) {
        return new Product(name, price);
    }
}
