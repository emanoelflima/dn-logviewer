package com.dn.logviewer.common;

public class Constants {
    public static String REGEX_START_RENDERING = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) \\[(.+)\\].+: Executing request startRendering with arguments \\[(\\d+), (\\d+)\\]";
    public static String REGEX_FINISH_RENDERING = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3} \\[(.+)\\].+: Service startRendering returned (.+)";
    public static String REGEX_GET_RENDERING = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}) \\[.+\\].+: Executing request getRendering with arguments \\[(.+)\\]";
    public static String EXTENSION_TXT = ".txt";
    public static String EXTENSION_LOG = ".log";
}
