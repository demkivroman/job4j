package ru.job4j.pojo;

public class Shop {
    public Product[] delete(Product[] products, int index) {
        if (index >= 0 && index < products.length) {
            products[index] = null;
            for (int i = index; i < products.length; i++) {
                if (i == products.length - 1) {
                    products[i] = null;
                    break;
                }
                products[i] = products[i + 1];
            }
        }
        return products;
    }
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Butter", 21);
        products[4] = new Product("Carrot", 55);

        for (Product pr : products) {
            if (pr != null) {
                System.out.println(pr.getName());
            } else {
                System.out.println("null");
            }
        }
        Product[] delProduct = new Shop().delete(products, 2);
        System.out.println("Delete element with index 2");
        for (Product pr : delProduct) {
            if (pr != null) {
                System.out.println(pr.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
