package com.nhlstenden.appstores.Apps;

import com.nhlstenden.appstores.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.nhlstenden.appstores.Apps.Currency.DOLLAR;
import static org.junit.jupiter.api.Assertions.*;

class AppleAppStoreTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createGame() {
        assertThrows(IllegalArgumentException.class, () -> {
            AppStore appStore = new AppleAppStore(DOLLAR);
            appStore.createAndUploadGame("zxc",12,false,true);
        });
    }

    @Test
    void total() {
        AppStore appStore = new AppleAppStore(DOLLAR);
        App app = new App("zxc",40,false,false);
        appStore.createAndUploadGame("zxc",40,false,false);
        appStore.createAndUploadGame("asd",60,false,false);
        App app1 = new App("asd",60,false,false);
        User user = new User("zxc", "user@gmail.com", LocalDate.of(2000, 12,12));
        appStore.makePurchase(user, app);
        appStore.makePurchase(user, app1);
        assertEquals(70, appStore.calculateTotalRevenueOfAllApps());
    }
}