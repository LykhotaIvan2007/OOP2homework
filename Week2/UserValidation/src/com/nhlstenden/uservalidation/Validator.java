package com.nhlstenden.uservalidation;

import static com.nhlstenden.uservalidation.Validation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static List<Validation> validations = new ArrayList<>();
    private static int minAge;

    public static void setUpValidations(int age, Validation... validationList) {
        for (Validation validation : validationList) {
            validations.add(validation);
        }
        minAge = age;
    }

    public static void setUpValidations(Validation... validationList) {
        for (Validation validation : validationList) {
            validations.add(validation);
        }
    }

    public static void validate(LocalDate localDate, String... values){
        String password = null;
        String email = null;
        String username = null;
        if (values.length >= 1) {
            password = values[0];
        }
        if (values.length >= 2){
            email = values[1];
        }
        if (values.length >= 3){
            username = values[2];
        }
        if (password.contains(" ")){
            throw new IllegalArgumentException("spaces are not allowed");
        }
        if (validations.contains(PASSWORD))
        {
            hasSpecialCharacter(password);
            hasLower(password);
            hasUpper(password);
        }
        if (validations.contains(EMAIL))
        {
            validateEmail(email);
        }
        if (validations.contains(USERNAME))
        {
            validateUsername(username);
        }
        if (validations.contains(MINIMUM_AGE)){
            validateAge(localDate);
        }
    }

    public static void validateAge(LocalDate dateOfBirth){
        if (Period.between(dateOfBirth, LocalDate.now()).getYears() < minAge){
            throw new IllegalArgumentException("you are too young");
        }
    }

    public static void validateUsername(String s){
        for (User user: Storage.getUsers()){
            if (user.getName().equals(s)){
                throw new IllegalArgumentException("User with this uthername already exists");
            }
        }

    }

    public static void validateEmail(String s){
        if (s.contains(" ")){
            throw new IllegalArgumentException("email can not contain spaces");
        }
        int aIndex = s.indexOf("@");
        if (aIndex <= 0)
        {
            throw new IllegalArgumentException("email needs to contain @");
        }
        if (aIndex != s.lastIndexOf('@')) {
            throw new IllegalArgumentException("Email cannot contain more than one @");
        }
        int dotIndex = s.lastIndexOf(".");
        if (dotIndex < aIndex + 2){
            throw new IllegalArgumentException("after @ needs to be domain");
        }
        if (dotIndex == s.length() - 1){
            throw new IllegalArgumentException("domain incorrect");
        }
    }

    public static void hasSpecialCharacter(String s)
    {
        String specialCharacters = "!@#$%^&*()_+-=";
        boolean hasSpecialCharacter = false;
        for (int i =0; i < s.length(); i++){
            if (specialCharacters.contains(String.valueOf(s.charAt(i)))){
                hasSpecialCharacter = true;
                break;
            }
        }
        if (!hasSpecialCharacter){
            throw new IllegalArgumentException("special character is not here");
        }
    }

    public static void hasNumber(String s)
    {
        String numbers = "1234567890";
        boolean hasNumber = false;
        for (int i = 0; i < s.length(); i++){
            if (numbers.contains(String.valueOf(s.charAt(i)))){
                hasNumber = true;
                break;
            }
        }
        if (!hasNumber){
            throw new IllegalArgumentException("Number is not here");
        }
    }

    public static void hasLower(String s){
        boolean hasLower = false;
        for (int i = 0; i < s.length(); i++){
            if (Character.isLowerCase(s.charAt(i))){
                hasLower = true;
                break;
            }
        }
        if (!hasLower){
            throw new IllegalArgumentException("lowercase letter is not here");
        }
    }

    public static void hasUpper(String s){
        boolean hasUpper = false;
        for (int i = 0; i < s.length(); i++){
            if (Character.isUpperCase(s.charAt(i))){
                hasUpper = true;
                break;
            }
        }
        if (!hasUpper){
            throw new IllegalArgumentException("uppercase letter is not here");
        }
    }

    public static int getLenghtOfValidations(){
        return validations.size();
    }
}
