package com.Nephty.body;

public class FileMatcher {
    private static final JSONReader jsonReader = new JSONReader("file matcher.json");

    public static String getFileName(String key) {
        return jsonReader.getString(key);
    }
}
