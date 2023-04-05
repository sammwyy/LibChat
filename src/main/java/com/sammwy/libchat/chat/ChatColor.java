package com.sammwy.libchat.chat;

import com.google.common.base.Preconditions;

public enum ChatColor {
    BLACK,
    DARK_BLUE,
    DARK_GREEN,
    DARK_AQUA,
    DARK_RED,
    DARK_PURPLE,
    GOLD,
    GRAY,
    DARK_GRAY,
    BLUE,
    GREEN,
    AQUA,
    RED,
    LIGHT_PURPLE,
    YELLOW,
    WHITE;

    public static char COLOR_CHAR = '§';

    public static ChatColor getByChar(String chr) {
        switch (chr) {
            case "0":
                return BLACK;
            case "1":
                return DARK_BLUE;
            case "2":
                return DARK_GREEN;
            case "3":
                return DARK_AQUA;
            case "4":
                return DARK_RED;
            case "5":
                return DARK_PURPLE;
            case "6":
                return GOLD;
            case "7":
                return GRAY;
            case "8":
                return DARK_GRAY;
            case "9":
                return BLUE;
            case "a":
                return GREEN;
            case "b":
                return AQUA;
            case "c":
                return RED;
            case "d":
                return LIGHT_PURPLE;
            case "e":
                return YELLOW;
            case "f":
            default:
                return WHITE;
        }
    }

    public static final String COLORS = "0123456789AaBbCcDdEeFfXx";
    public static final String SPECIALS = "KkLlMmNnOoRr";
    public static final String ALL = COLORS + SPECIALS;

    public static String translateAlternateColorCodes(char altColorChar, String textToTranslate,
            boolean allowSpecials) {
        Preconditions.checkArgument(textToTranslate != null, "Cannot translate null text");

        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == altColorChar && (allowSpecials ? ALL : COLORS).indexOf(b[i + 1]) > -1) {
                b[i] = ChatColor.COLOR_CHAR;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }
        return new String(b);
    }

    public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
        return translateAlternateColorCodes(altColorChar, textToTranslate, true);
    }
}
