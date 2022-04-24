package com.gustavosiqueira.camelcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCase {

    private static boolean isEmptyOrNull(String str)
    {
        return str != null && !str.trim().isEmpty();
    }

    private static boolean isStartsNumbers(String str)
    {
        return Character.isDigit(str.charAt(0));
    }

    private static boolean isCharacterSpecial(String str)
    {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private static List<String> convertToLowerCase(String[] str)
    {
        List<String> values = new ArrayList<String>();

        for(var i = 0; i < str.length; i++) {
            if(str[i].chars().allMatch(Character :: isDigit)) {
                values.add((str[i]));
            } else {
                if(str[i].equals(str[i].toUpperCase()))
                    values.add(str[i]);
                else
                    values.add(str[i].toLowerCase());
            }
        }

        return values;
    }

    public static List<String> convertCamelCase(String text) throws CamelCaseException {

        if(!isEmptyOrNull(text)) {
            throw new CamelCaseException("String can't be empty or null.");
        } else if(isStartsNumbers(text)) {
            throw new CamelCaseException("String can't starts with numbers.");
        } else if(isCharacterSpecial(text)) {
            throw new CamelCaseException(("String can't have special character"));
        } else {
            String[] splits = text.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])");
            return convertToLowerCase(splits);

        }
    }



}
