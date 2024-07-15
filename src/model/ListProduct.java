package model;

import java.util.Arrays;
import java.util.List;

public class ListProduct {
    public static final List<Product> PRODUCTS = Arrays.asList(
            new Product("Coke", 10000),
            new Product("Pepsi", 10000),
            new Product("Soda", 20000)
    );
}