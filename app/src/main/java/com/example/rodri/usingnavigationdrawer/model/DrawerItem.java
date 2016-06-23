package com.example.rodri.usingnavigationdrawer.model;

/**
 * Created by rodri on 6/23/2016.
 */
public class DrawerItem {

    private String title;
    private int icon;
    private String count = "0";
    private boolean isCounterVisible = false;

    public DrawerItem() {}

    public DrawerItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public DrawerItem(String title, int icon, String count, boolean isCounterVisible) {
        this.title = title;
        this.icon = icon;
        this.count = count;
        this.isCounterVisible = isCounterVisible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public boolean getCounterVisibility() {
        return isCounterVisible;
    }

    public void setCounterVisibility(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }
    
}
