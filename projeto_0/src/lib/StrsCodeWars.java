package lib;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * A utility class containing various string manipulation methods.
 */
public class StrsCodeWars {

    /**
     * Converts DNA to RNA by replacing each 'T' with 'U'.
     *
     * @param dna The input DNA string.
     * @return The RNA string obtained by replacing 'T' with 'U'.
     */
    public String dnaToRna(String dna) {
        return dna.replace("T", "U");
    }

    /**
     * Removes all exclamation marks from the input string.
     *
     * @param s The input string.
     * @return The string with all exclamation marks removed.
     */
    static String removeExclamationMarks(String s) {
        return s.replaceAll("!", "");
    }

    /**
     * Generates a greeting based on the provided name and owner.
     *
     * @param name  The name of the person.
     * @param owner The owner's name.
     * @return A greeting based on whether the name matches the owner or not.
     */
    static String greet(String name, String owner) {
        return name.equals(owner) ? "Hello boss" : "Hello guest";
    }

    /**
     * Checks if the input string is an isogram, which means it has no repeating
     * characters.
     *
     * @param str The input string.
     * @return true if the string is an isogram, false otherwise.
     */
    public static boolean isIsogram(String str) {
        String lower = str.toLowerCase();

        Set<Character> chr = new HashSet<>();
        for (var c : lower.toCharArray()) {
            if (chr.contains(c))
                return false;

            chr.add(c);
        }
        return true;
    }

    /**
     * Finds the longest distinct sorted string from two input strings.
     *
     * @param s1 The first input string.
     * @param s2 The second input string.
     * @return The longest distinct sorted string formed by combining the two input
     *         strings.
     */
    public static String longest(String s1, String s2) {
        String concatStr = s1 + s2;
        char[] longestArray = concatStr.toCharArray();
        Arrays.sort(longestArray);

        StringBuilder distinctString = new StringBuilder();
        char previousChar = '\0';

        for (var c : longestArray) {
            if (c != previousChar) {
                distinctString.append(c);
                previousChar = c;
            }
        }
        return distinctString.toString();
    }

    /**
     * Validates a PIN number by checking if it consists of either 4 or 6 digits.
     *
     * @param pin The input PIN number as a string.
     * @return true if the PIN is valid (4 or 6 digits), false otherwise.
     */
    public static boolean validatePin(String pin) {
        return pin.matches("\\d{4}|\\d{6}") && pin.matches("\\d+");
    }

    /**
     * Reverses the order of characters in the input string.
     *
     * @param original The original input string.
     * @return The reversed string.
     */
    public static String reverseWords(final String original) {
        char[] charArray = original.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    /**
     * Checks if a given string ends with a specified ending string.
     *
     * @param str    The input string.
     * @param ending The ending string to check for.
     * @return true if the input string ends with the specified ending, false
     *         otherwise.
     */
    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    /**
     * Filters a list to contain only the Integer elements and returns the filtered
     * list.
     *
     * @param list The input list containing elements of various types.
     * @return A new list containing only the Integer elements from the input list.
     */
    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(element -> element instanceof Integer)
                .collect(Collectors.toList());
    }

    /**
     * Converts a numeric string to an integer.
     *
     * @param str The input string representing a number.
     * @return The integer value of the input string.
     */
    public static int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    /**
     * Converts an integer to its string representation.
     *
     * @param num The input integer to be converted to a string.
     * @return The string representation of the input integer.
     */
    public static String numberToString(int num) {
        return String.valueOf(num);
    }

    /**
     * Converts a boolean value to its string representation.
     *
     * @param b The boolean value to be converted.
     * @return The string representation of the boolean value ("true" or "false").
     */
    public static String convert(boolean b) {
        return Boolean.toString(b);
    }

    /**
     * Determines whether a person's name indicates if they are playing the banjo or
     * not.
     * If the first character of the name is 'R' or 'r', it suggests the person
     * plays the banjo.
     * Otherwise, it indicates that the person does not play the banjo.
     *
     * @param name The name of the person to check.
     * @return A message indicating whether the person plays the banjo or not.
     */
    public static String areYouPlayingBanjo(String name) {
        char firstChar = name.charAt(0);

        return (firstChar == 'r' || firstChar == 'R') ? name + " plays banjo" : name + " does not play banjo";
    }

    /**
     * Counts the number of unique duplicate characters in the input string,
     * is case sensitivity.
     *
     * The method takes a string as input and iterates through each character to
     * count the unique duplicates.
     * It considers the characters as duplicates regardless of case, i.e., 'a' and
     * 'A' will be counted as duplicates.
     *
     * @param text The input string in which to count the unique duplicate
     *             characters.
     * @return The number of unique duplicate characters in the input string,
     *         with case sensitivity.
     */
    public static int duplicateCount(String text) {
        char[] charArray = text.toCharArray();
        Set<Character> duplicates = new HashSet<>();
        Set<Character> markedCharacters = new HashSet<>();

        for (char currentChar : charArray) {
            char lowerCaseChar = Character.toLowerCase(currentChar);

            if (markedCharacters.contains(lowerCaseChar)) {
                duplicates.add(lowerCaseChar);
            } else {
                markedCharacters.add(lowerCaseChar);
            }

        }
        return duplicates.size();
    }

    /**
     * Counts the number of vowels (i.e., lowercase 'a', 'e', 'i', 'o', 'u') in the
     * given string.
     * This method uses regular expression matching to find all occurrences of
     * vowels in the input string.
     *
     * @param str The input string in which vowels need to be counted.
     * @return The number of vowels (i.e., lowercase 'a', 'e', 'i', 'o', 'u') found
     *         in the input string.
     * @throws NullPointerException If the input string 'str' is null.
     *
     * @implNote This method uses a regular expression pattern to match each vowel
     *           in the input string.
     *           The pattern "[aeiou]" is used to find any character in the string
     *           that is a vowel (i.e., 'a', 'e', 'i', 'o', 'u').
     *           The Matcher class is then used to find all occurrences of the
     *           pattern in the string.
     *           The count of occurrences is incremented for each match found, and
     *           the final count is returned as the result.
     *
     * @implSpec This method assumes that the input string contains only lowercase
     *           characters.
     *           Any uppercase vowels or non-alphabetic characters will not be
     *           considered as vowels in the count.
     *           For example, 'A' or 'E' will not be counted as vowels, and
     *           punctuation marks will be ignored.
     *
     * @example
     *          {@code
     * String input = "Hello, how are you today?";
     * int result = getCount(input);
     * // The result will be 7, as there are 7 vowels ('e', 'o', 'o', 'a', 'e', 'o', 'a') in the input string.
     * }
     *
     * @see Matcher
     * @see Pattern
     */
    public static int getCount(String str) {
        Matcher matcher = Pattern.compile("[aeiou]").matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

}