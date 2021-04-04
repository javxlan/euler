package dome;

import java.util.*;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {

        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<products.length;i++){
            map.put(products[i],map.getOrDefault(products[i],0)+1);
        }
        for(int i=0;i<products.length;i++){
            if(map.get(products[i])==1){
                return products[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}