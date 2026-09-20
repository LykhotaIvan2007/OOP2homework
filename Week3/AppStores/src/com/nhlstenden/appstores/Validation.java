package com.nhlstenden.appstores;

import java.util.TreeMap;

public class Validation {
    public static boolean validateEmail(String email){
        if (email == null || email.isBlank()){
            return false;
        }

        int atIndex = email.indexOf("@");
        int dotIndex = email.lastIndexOf(".");

        if (dotIndex <= 0 || atIndex <= 0){
            return false;
        }

        if (atIndex != email.lastIndexOf("@")){
            return false;
        }

        if (dotIndex == email.length() - 1){
            return false;
        }

        if (dotIndex <= atIndex + 1){
            return false;
        }

        return true;
    }
}
