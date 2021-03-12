package uz.itjunior.store;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static ArrayList<String> soldProducts;
    static ArrayList<Product> products;
    static Product redWaterMelon;
    static Product bosvoldi;
    static Product melon;
    static long budged;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        soldProducts = new ArrayList<>();
        products = new ArrayList<>();
        budged = 0;

        redWaterMelon = new WaterMelon("Qizil tarvuz", 54, 12000);
        bosvoldi = new Melon("Bosvoldi", 120, 15000);
        melon = new Melon("Melon", 45, 5600);

        products.add(redWaterMelon);
        products.add(bosvoldi);
        products.add(melon);

        init();

    }

    static void init() {
        printDash("Bo'limlardan birini tanlang");
        System.out.println("1. Mahsulotlar ro'yxati");
        System.out.println("2. Sotilgan Mahsulotlar");
        System.out.println("3. Budjet");

        int choose = scanner.nextInt();

        switch (choose) {

            case 1:
                showProduct();
                break;
            case 2:
                soldProduct();
                break;
            case 3:
                budged();
                break;
            default:
                System.out.println("Bunday bo'lim yo'q");
        }


    }

    private static void budged() {
        System.out.print("Sizning mablagingiz: " + budged + " so'm");
        System.out.println();
        init();
    }

    private static void soldProduct() {

        for (String soldProduct : soldProducts) {
            System.out.println(soldProduct);
        }
        init();

    }

    static void showProduct() {
        for (Product product : products) {
            System.out.printf("Mahsulot nomi: %s - miqdori: %d ta - narxi: %d so'mdan \n",
                    product.getName(),
                    product.getQuantity(),
                    product.getPrice());
        }

        System.out.println("Sotish");
        int choose = scanner.nextInt();

        for (int i = 0; i < products.size(); i++) {

            if (choose - 1 == i) {
                System.out.println("Nechta " + products.get(i).getName() + " Sotmoqchisiz?");
                int quantity = scanner.nextInt();
                budged += (long) products.get(i).getPrice() * quantity;
                soldProducts.add(products.get(i).getName() + " " + quantity + " ta sotildi");
                products.get(i).setQuantity(products.get(i).getQuantity() - quantity);
                init();
                break;
            } else {
                System.out.println("Bunday mahsulot yo'q");
                init();
            }
        }
    }

    static void printDash(String str) {

        for (int i = 0; i < str.length() + 2; i++) {
            System.out.print("-");
        }

        System.out.println();
        System.out.println(" " + str);

        for (int i = 0; i < str.length() + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
