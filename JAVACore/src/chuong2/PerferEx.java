package chuong2;

import java.util.prefs.Preferences;

public class PerferEx {
    public static void main(String[] args) {
        Preferences preferences = Preferences.userNodeForPackage(PerferEx.class);
        System.out.println("Old Value = " + preferences.get("data1","No value"));
        preferences.put("data","value" + System.currentTimeMillis());
        System.out.println("new Value = " + preferences.get("data1","No value"));
        
    }
}
