package com.sagnik;

import java.util.Arrays;

public class EmailValidation {

    private static final String[] SPECIAL_CHARACTERS_FOR_USERNAME = new String[]{
            "..", "__", ",", "/", "<", ">", "?", ";", ":", "\"", "\"",
            "{", "}", "[", "]", "|", "\\", "!", "@", "#", "$", "%", "^",
            "&", "*", "(", ")", "+", "=", "~", "`"};

    private static final char[] SPECIAL_CHARACTERS_WITH_NUMBERS = new char[]{
            '.', ',', '/', '<', '>', '?', ';', ':', '\'', '\"', '{',
            '}', '[', ']', '|', '\\', '!', '@', '#', '$', '%', '^', '&',
            '*', '(', ')', '-', '_', '+', '=', '~', '`', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '0'};

    public static boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        String[] emailChunks = email.split("@");

        if (emailChunks.length != 2 || isEmailUserNameInvalid(emailChunks[0]) || emailChunks[1].isEmpty()) {
            return false;
        }

        String[] domainNames = emailChunks[1].split("\\.");
        if (domainNames.length < 2) {
            return false;
        }

        int topLevelDomainNameIndex = domainNames.length - 1;
        if (isTopLevelDomainNameInvalid(domainNames[topLevelDomainNameIndex])) {
            return false;
        }

        String[] subDomainNames = Arrays.copyOf(domainNames, topLevelDomainNameIndex);

        return isDomainNameValid(subDomainNames);
    }

    private static boolean isEmailUserNameInvalid(String emailUserName) {
        return emailUserName.isEmpty() || containsAny(emailUserName, SPECIAL_CHARACTERS_FOR_USERNAME);
    }

    private static boolean isTopLevelDomainNameInvalid(String topLevelDomain) {
        return topLevelDomain.isEmpty() || containsAny(topLevelDomain, SPECIAL_CHARACTERS_WITH_NUMBERS);
    }

    private static boolean isDomainNameValid(String[] domainNames) {
        for (String domainName : domainNames) {
            if (domainName.isEmpty() || containsAny(domainName, SPECIAL_CHARACTERS_WITH_NUMBERS)) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsAny(String str, String[] searchStrings) {
        for (String searchString : searchStrings) {
            if (str.contains(searchString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsAny(String str, char[] searchChars) {
        for (char searchChar : searchChars) {
            if (str.indexOf(searchChar) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        String[] emails = {
                "example@domain.com",          // valid
                "invalid_email@domain..com",   // invalid (double dots in domain)
                "user@domain",                 // invalid (no TLD)
                "user..name@domain.com",       // invalid (double dots in username)
                "username@domain.com",         // valid
                "username@domain.co.in" ,
                "sagnikb5223@gmail.com"// valid
        };

        for (String email : emails) {
            System.out.println("Is '" + email + "' valid? " + isEmailValid(email));
        }
    }
}
