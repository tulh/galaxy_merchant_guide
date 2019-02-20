package com.tulh.galaxy;

import java.util.Scanner;

public class GalaxyMerchantApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to galaxy conversion application! Please input and press Enter to finish input.\n" +
                "Press Ctrl+C to finish application. Enter \"list\" for show all assignment and conversion rate");
        Scanner scanner = new Scanner(System.in);
        GalaxyMerchantHandler galaxyMerchantHandler = new GalaxyMerchantHandler();
        while (scanner.hasNextLine()) {
            galaxyMerchantHandler.processing(scanner.nextLine());
        }
    }
}
