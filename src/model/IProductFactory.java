package model;

public interface IProductFactory {
    IProduct createProduct(String name, double price);
}
