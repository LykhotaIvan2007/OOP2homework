package com.nhlstenden.vegetablegarden.exceptions;

public class TooManyVegetablesException extends RuntimeException {
    public TooManyVegetablesException() {
        super("It is impossible to plant new vegetable because garden is full");
    }
}
