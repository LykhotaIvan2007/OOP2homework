package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static com.nhlstenden.uservalidation.Validation.*;
import static org.junit.jupiter.api.Assertions.*;

class StorageTest {


    @BeforeEach
    void setUp() {

    }

    @Test
    void createUser() {
        Validator.setUpValidations(PASSWORD, EMAIL);
        assertThrows(IllegalArgumentException.class,() -> Storage.createUser("Ivan","1234qQ!", "ivangmail.com", LocalDate.of(2000,10,10)));
    }

    @Test
    void v(){
        Validator.setUpValidations(PASSWORD);
        assertDoesNotThrow(() -> {
            Storage.createUser("Ivan","1234qQ!", "ivan@g  mail.com", LocalDate.of(2000,10,10));
        });
    }

    @Test
    void v1(){
        Validator.setUpValidations(10,MINIMUM_AGE, PASSWORD, USERNAME);
        assertDoesNotThrow(() -> {
            Storage.createUser("Ivan","1234qQ!", "ivan@g  mail.com", LocalDate.of(2000,10,10));
        });
        assertThrows(IllegalArgumentException.class, ()->
                Storage.createUser("Ivan","1234qQ!", "ivan@g  mail.com", LocalDate.of(2000,10,10))

                );
    }

    @Test
    void v2(){
        Validator.setUpValidations(10,MINIMUM_AGE, PASSWORD);
        assertDoesNotThrow(() -> {
            Storage.createUser("Ivan","1234qQ!", "ivan@g  mail.com", LocalDate.of(2000,10,10));
        });
    }
}