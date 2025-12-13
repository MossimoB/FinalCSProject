package org.mossimo;

public class Util {

    /**
     * Converts a string to Title Case.
     * Each word's first character is uppercase, the rest lowercase.
     *
     * @param str the input string (words separated by spaces)
     * @return the string in title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) return str;

        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}
