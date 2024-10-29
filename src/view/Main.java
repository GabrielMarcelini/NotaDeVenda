package view;

import model.Product;
import model.Sale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sale sale = new Sale();
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.println("Enter the product name:");
            String name = scanner.nextLine();

            System.out.println("Enter the product price:");
            double price = scanner.nextDouble();

            System.out.println("Enter the quantity purchased:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            Product product = new Product(name, price);
            sale.addItem(product, quantity);

            System.out.println("Do you want to add another product? (y/n)");
            String response = scanner.nextLine();
            continueAdding = response.equalsIgnoreCase("y");
        }

        displayReceipt(sale);
    }

    private static void displayReceipt(Sale sale) {
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