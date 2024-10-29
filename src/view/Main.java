package view;

import java.util.Scanner;

import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ISaleFactory saleFactory = new SaleFactory();
        IProductFactory productFactory = new ProductFactory();
        ISale sale = saleFactory.createSale();
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.println("Enter the product name:");
            String name = scanner.nextLine();

            System.out.println("Enter the product price:");
            double price = scanner.nextDouble();

            System.out.println("Enter the quantity purchased:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 

            IProduct product = productFactory.createProduct(name, price);
            ISaleItem saleItem = saleFactory.createSaleItem(product, quantity);
            sale.addItem(saleItem);

            System.out.println("Do you want to add another product? (y/n)");
            String response = scanner.nextLine();
            continueAdding = response.equalsIgnoreCase("y");
        }

        displayReceipt(sale);
    }

    private static void displayReceipt(ISale sale) {
        System.out.println("********* RECEIPT *********");
        System.out.println("Product\tQty\tPrice\tSubtotal");
        sale.getItems().forEach(item -> {
            System.out.println(item.getProduct().getName() + "\t" +
                               item.getQuantity() + "\t" +
                               item.getProduct().getPrice() + "\t" +
                               item.getSubtotal());
        });
        System.out.println("*****************************");
        System.out.println("Total Amount: " + sale.calculateTotal());
    }
}