package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HMap {
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
       // order HashMap to TreeMap
       // get Value and key
        Map<String, String> treeMap = new TreeMap<>(capitalCities);
        for (String str : treeMap.keySet()) {
            System.out.println(treeMap.get(str));
        }
    }
}
