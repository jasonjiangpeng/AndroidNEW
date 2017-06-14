package com.jh.rental.user.other.apputilss.utilcode.utils;/*
package com.aotome202.lostjason.e202project.apputils.utilcode.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.aotome202.lostjason.e202project.apputils.utilcode.utils.ConstUtils.REGEX_ID_CARD15;
import static com.aotome202.lostjason.e202project.apputils.utilcode.utils.ConstUtils.REGEX_TEL;


*/
/*

public class RegexUtils {

    private RegexUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    */
/*


    */
/*

    public static boolean isMobileSimple(CharSequence input) {
        return isMatch(REGEX_MOBILE_SIMPLE, input);
    }

    */
/*

    public static boolean isMobileExact(CharSequence input) {
        return isMatch(REGEX_MOBILE_EXACT, input);
    }

    */
/*

    public static boolean isTel(CharSequence input) {
        return isMatch(REGEX_TEL, input);
    }

    */
/*

    public static boolean isIDCard15(CharSequence input) {
        return isMatch(REGEX_ID_CARD15, input);
    }

    */
/*

    public static boolean isIDCard18(CharSequence input) {
        return isMatch(REGEX_ID_CARD18, input);
    }

    */
/*

    public static boolean isEmail(CharSequence input) {
        return isMatch(REGEX_EMAIL, input);
    }

    */
/*

    public static boolean isURL(CharSequence input) {
        return isMatch(REGEX_URL, input);
    }

    */
/*

    public static boolean isZh(CharSequence input) {
        return isMatch(REGEX_ZH, input);
    }

    */
/*

    public static boolean isUsername(CharSequence input) {
        return isMatch(REGEX_USERNAME, input);
    }

    */
/*

    public static boolean isDate(CharSequence input) {
        return isMatch(REGEX_DATE, input);
    }

    */
/*

    public static boolean isIP(CharSequence input) {
        return isMatch(REGEX_IP, input);
    }

    */
/*

    public static boolean isMatch(String regex, CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

    */
/*

    public static List<String> getMatches(String regex, CharSequence input) {
        if (input == null) return null;
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    */
/*

    public static String[] getSplits(String input, String regex) {
        if (input == null) return null;
        return input.split(regex);
    }

    */
/*

    public static String getReplaceFirst(String input, String regex, String replacement) {
        if (input == null) return null;
        return Pattern.compile(regex).matcher(input).replaceFirst(replacement);
    }

    */
/*

    public static String getReplaceAll(String input, String regex, String replacement) {
        if (input == null) return null;
        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
    }
}*/
