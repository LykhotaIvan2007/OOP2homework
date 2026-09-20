package com.nhlstenden.appstores.Apps;

public class AppleAppStore extends AppStore {
    public AppleAppStore(Currency currency) {
        super(currency);
    }

    @Override
    public double calculateTotalRevenueOfApp(App app) {
        return super.calculateTotalRevenueOfApp(app) * 0.7;
    }

    @Override
    public double calculateTotalRevenueOfAllApps() {
        return super.calculateTotalRevenueOfAllApps() * 0.7;
    }

    @Override
    public void createAndUploadGame(String name, double price, boolean containsViolence, boolean containsNudity) {
        if (containsNudity){
            throw new IllegalArgumentException("In Apple App Store it is forbidden to uload games with nudity");
        }
        super.createAndUploadGame(name, price, containsViolence, containsNudity);
    }
}
