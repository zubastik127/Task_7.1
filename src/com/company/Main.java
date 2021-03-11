package com.company;

import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {

        for (Country s : Country.values()) {
            System.out.println(s);
        }

        System.out.println();

        Scanner str = new Scanner(System.in);
        System.out.print("Введите название страны: ");
        String input = str.nextLine();

        Country country;

        try {
            country = Country.valueOf(input.toUpperCase());
            System.out.println(country + country.getIsOpen());
            System.exit(0);
        } catch (NullPointerException a) {
            System.out.println("Пустое значение");
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
        }

        try {
            country = Country.getByRuName(input);
            System.out.println(country + country.getIsOpen());
        } catch (NoSuchCountryException e) {
            System.out.println(e.getMessage());
        }
    }
}
