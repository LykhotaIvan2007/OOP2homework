package com.nhlstenden.appstores.Apps;

import com.nhlstenden.appstores.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.nhlstenden.appstores.Apps.Currency.DOLLAR;
import static org.junit.jupiter.api.Assertions.*;

class PlayMarketTest {
    @Test
    void certainGame() {
        AppStore playMarket = new PlayMarket(DOLLAR);
        App app1 = new App("asd",60,false,false);
        App app = new App("zxc",40,false,false);
        playMarket.createAndUploadGame(app);
        playMarket.createAndUploadGame(app1);
        User user = new User("zxc", "user@gmail.com", LocalDate.of(2000, 12,12));
        playMarket.makePurchase(user, app);
        playMarket.makePurchase(user, app1);
        assertEquals(60, playMarket.calculateTotalRevenueOfApp(app1));
    }
}