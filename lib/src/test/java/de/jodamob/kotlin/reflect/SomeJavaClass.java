package de.jodamob.kotlin.reflect;


public class SomeJavaClass {

    private String variable1 = "preset";
    private static String variable2 = "preset";

    public String getOne() {
        return variable1;
    }

    public static String getTwo() {
        return variable2;
    }

}
