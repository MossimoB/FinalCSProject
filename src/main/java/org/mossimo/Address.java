package org.mossimo;

import java.util.Scanner;

import lombok.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {

    // USED TO TEST THE  isPostalCodeValid  METHOD
    /*

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

     */

    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        AB, BC, MB, NB ,NL, NT, NU, ON, PE, QC, SK, YT
    }

    /**
     * Constructor that sets all fields. Validates postal code before assigning
     * If postal code is invalid, all fields are set to null (0)
     * @param streetNo is the number of student's street
     * @param street is the student's street name
     * @param city is where the student resides
     * @param province is where the city is located
     * @param postalCode is the area of the city where the street is located
     */
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

    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        } else {
            System.out.println("Invalid postal code. Not set.");
        }
    }


    /**
     * Validates a postal code string in CDCDCD format
     * @param postalCode the postal code string
     * @return true if valid, otherwise false 
     */
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
