package org.mossimo;

import lombok.*;
import java.util.Scanner;

public class Address {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a postal code to test: ");
        String postalCode = scanner.nextLine();

        if (Address.isPostalCodeValid((postalCode))) {
            System.out.println("Postal code " + postalCode.toUpperCase() + " is valid.");
        } else {
            System.out.println("Postal code " + postalCode + " is invalid.");
        }
    }

    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        AB, BC, MB, NB ,NL, NT, NU, ON, PE, QC, SK, YT
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < 6; i++) {
            char c = postalCode.charAt(i);

            if (i % 2 == 0) {
                if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                    return false;
                }
            } else {
                if (!(c >= '0' && c <= '9')) {
                    return false;
                }
            }
        }

        return true;
    }
}
