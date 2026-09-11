package com.nhlstenden.uservalidation;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Storage {
    private static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users1) {
        users = users1;
    }

    public static void addUsers(List<User> users1) {
        users.addAll(users1);
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static boolean isUserExists(User user)
    {
        if (!users.contains(user)){
            return false;
        }

        return true;
    }
    public static void createUser(String name, String password, String email, LocalDate dateOfBirth){
        Validator.validate(dateOfBirth, password, email, name);
        addUser(new User(email, name, password, dateOfBirth));
    }
}
