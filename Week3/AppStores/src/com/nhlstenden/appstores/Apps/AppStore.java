package com.nhlstenden.appstores.Apps;

import com.nhlstenden.appstores.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class AppStore {
    private HashMap<User, Set<App>> purchasesMap;
    private Set<App> apps;
    private Currency currency;

    public AppStore(Currency currency) {
        this.purchasesMap = new HashMap<>();
        this.apps = new HashSet<>();
        this.currency = currency;
    }

    public HashMap<User, Set<App>> getPurchasesMap() {
        return purchasesMap;
    }

    public void setPurchasesMap(HashMap<User, Set<App>> purchasesMap) {
        this.purchasesMap = purchasesMap;
    }

    public Set<App> getApps() {
        return apps;
    }

    public void setApps(Set<App> apps) {
        this.apps = apps;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void createAndUploadGame(String name, double price, boolean containsViolence, boolean containsNudity){
        this.apps.add(new App(name, price, containsViolence, containsNudity));
    }

    public void createAndUploadGame(App app){
        this.apps.add(app);
    }

    public double calculateTotalRevenueOfApp(App app){
        if (app == null || !this.apps.contains(app)){
            throw new IllegalArgumentException("this app null or does not exists");
        }

        double total = 0;

        for (Set<App> apps: this.purchasesMap.values()){
            for (App appInSet: apps){
                if (appInSet.equals(app)){
                    total += app.getPrice();
                }
            }
        }

        return total;
    }

    public double calculateTotalRevenueOfAllApps(){
        double total = 0;

        for (Set<App> apps: this.purchasesMap.values()){
            for (App appInSet: apps){
                total += appInSet.getPrice();
            }
        }

        return total;
    }

    public void makePurchase(User user, App app){

        if (app.isContainsViolence() && user.getAge() < 16)
        {
            throw new DownloadNotAllowedException();
        }

        if (app.isContainsNudity() && user.getAge() < 18)
        {
            throw new DownloadNotAllowedException();
        }

        if (!this.purchasesMap.containsKey(user)){
            this.purchasesMap.put(user, new HashSet<>());
        }

        this.purchasesMap.get(user).add(app);
    }
}
