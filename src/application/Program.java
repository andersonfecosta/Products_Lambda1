package application;

import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter file full path: ");
        String txt = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(txt))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                products.add(new Product(fields[0],Double.parseDouble(fields[1])));
                line = br.readLine();
            }
            double sum = 0.0;
            for (Product p: products) {
                sum += p.getPrice();
            }
            double average = sum/ products.size();
            System.out.printf("Average price: %.2f",average);
            System.out.println();
            for (Product p: products) {
                if (p.getPrice() < average) {
                    System.out.println(p.getName());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());;
        }


    }
}
