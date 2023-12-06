package com.ku.quizzical.common.helper.string;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import com.ku.quizzical.common.helper.ConditionalHelper;
import com.ku.quizzical.common.helper.FunctionHelper;
import com.ku.quizzical.common.helper.IterationHelper;
import com.ku.quizzical.common.helper.ListHelper;
import com.ku.quizzical.common.util.string.StringList;
import com.ku.quizzical.common.util.string.StringMap;

/**
 * Helper class for String Operations
 */
public final class StringHelper {
    /**
     * Capitalizes the first letter of a String
     */
    public static String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    /**
     * Creates a new String Builder
     */
    public static StringBuilder newBuilder() {
        return new StringBuilder();
    }

    /**
     * Checks if a string contains a substring
     */
    public static boolean contains(String text, CharSequence target) {
        return text.contains(target);
    }

    /**
     * Copies a String List
     */
    public static StringList copyStringList(StringList list) {
        return list.copy();
    }

    /**
     * Checks if a string ends with a given target
     */
    public static boolean endsWith(String text, String target) {
        return StringHelper.substringEquals(text, target, text.length() - target.length());
    }

    /**
     * Iterates through a String
     */
    public static void forEach(String text, Consumer<Character> action) {
        StringHelper.forEach(text, FunctionHelper.newPredicateFromConsumer(action));
    }

    /**
     * Iterates through a String and stops if a breaking point is reached
     */
    public static boolean forEach(String text, Predicate<Character> action) {
        return StringHelper.forEach(text, (Integer i, Character ch) -> action.test(ch));
    }

    /**
     * Iterates through a String
     */
    public static void forEach(String text, BiConsumer<Integer, Character> action) {
        StringHelper.forEach(text, FunctionHelper.newBiPredicateFromBiConsumer(action));
    }

    /**
     * Iterates through a String and stops if a breaking point is reached
     */
    public static boolean forEach(String text, BiPredicate<Integer, Character> action) {
        for (int i = 0; i < text.length(); i++) {
            if (!action.test(i, text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the first found index of a character
     */
    public static int indexOf(String text, char target) {
        return StringHelper.indexOf(text, (Character ch) -> ch == target);
    }

    /**
     * Returns the first found index of a query
     */
    public static int indexOf(String text, Predicate<Character> query) {
        for (int i = 0; i < text.length(); i++) {
            if (query.test(text.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if a String is empty
     */
    public static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    /**
     * Checks if a String is not empty
     */
    public static boolean isNotEmpty(String text) {
        return !StringHelper.isEmpty(text);
    }

    /**
     * Returns the last found index of a character
     */
    public static int lastIndexOf(String text, char target) {
        return StringHelper.lastIndexOf(text, (Character ch) -> ch == target);
    }

    /**
     * Returns the last found index of a query
     */
    public static int lastIndexOf(String text, Predicate<Character> query) {
        for (int i = text.length() - 1; i > -1; i--) {
            if (query.test(text.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Creates a new String List
     */
    public static StringList newStringList() {
        return StringList.newInstance();
    }

    /**
     * Creates a new String Map
     */
    public static StringMap newStringMap() {
        return StringMap.newInstance();
    }

    /**
     * Concatenates Strings together from a List
     */
    public static String join(List<String> list, String delimiterText) {
        return StringHelper.join(list, delimiterText, false, false);
    }

    /**
     * Concatenates Strings together from a List
     */
    public static String join(List<String> list, String delimiterText,
            boolean willIncludeDelimiterAtStart, boolean willIncludeDelimiterAtEnd) {
        StringBuilder joined = StringHelper.newBuilder();
        ConditionalHelper.ifThen(willIncludeDelimiterAtStart, () -> joined.append(delimiterText));
        ListHelper.forEach(list, (String string) -> joined.append(string + delimiterText));
        ConditionalHelper.ifThen(!willIncludeDelimiterAtEnd,
                () -> joined.delete(joined.length() - delimiterText.length(), joined.length()));
        return joined.toString();
    }

    /**
     * Repeats text for a given number of times
     */
    public static String repeatText(String text, int times) {
        StringBuilder repeatedText = StringHelper.newBuilder();
        IterationHelper.forEach(times, () -> repeatedText.append(text));
        return repeatedText.toString();
    }

    /**
     * Splits a String into parts
     */
    public static StringList split(String text, String regex) {
        return StringList.newInstance(text.split(regex));
    }

    /**
     * Checks if a string starts with a given target
     */
    public static boolean startsWith(String text, String target) {
        return StringHelper.substringEquals(text, target, 0);
    }

    /**
     * Returns a substring of a text
     */
    public static String substring(String text, int start) {
        return StringHelper.substring(text, start, text.length());
    }

    /**
     * Returns a substring of a text
     */
    public static String substring(String text, int start, int upTo) {
        return text.substring(start, upTo);
    }

    /**
     * Returns a substring of a text from the lengths of target texts depicting the last from the
     * endpoints to be removed.
     */
    public static String substringFromEndpointTexts(String text, String startText,
            String upToText) {
        return StringHelper.substring(text, startText.length(), text.length() - upToText.length());
    }

    /**
     * Returns a substring of a text removing characters from the start of the string, the amount to
     * be removed depicted by the length of a specified string
     */
    public static String substringFromStartText(String text, String startText) {
        return StringHelper.substringFromEndpointTexts(text, startText, "");
    }

    /**
     * Returns a substring of a text removing characters from the end of the string, the amount to
     * be removed depicted by the length of a specified string
     */
    public static String substringFromUpToText(String text, String upToText) {
        return StringHelper.substringFromEndpointTexts(text, "", upToText);
    }

    /**
     * Returns a substring of a text removing characters from the end of the string, the amount to
     * be removed depicted by a specified length
     */
    public static String substringFromUpToTextLength(String text, int upToTextLength) {
        return text.substring(0, text.length() - upToTextLength);
    }

    /**
     * Checks if a substring is present at a given index
     */
    public static boolean substringEquals(String text, String target, int index) {
        if (index < 0 || index + target.length() > text.length()) {
            return false;
        }
        return text.substring(index, index + target.length()).equals(target);
    }

    /**
     * Converts an object to String even if null
     */
    public static String toString(Object item) {
        return item + "";
    }

    /**
     * Private Constructor to prevent instantiation
     */
    private StringHelper() {
        super();
    }
}
