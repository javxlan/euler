package test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class AmazonProduct {


    public static void main(String[] args) {

        int numProducts = 5;
        String query = "ball";
        List<String> products = Arrays.asList("bag", "ball", "banner", "baggage", "bags");

        AmazonProduct m = new AmazonProduct();
        m.threeProductSuggestions(numProducts, products, query);

    }


    public List<List<String>> threeProductSuggestions(int numProducts,
                                                      List<String> repository,
                                                      String customerQuery) {
        int minChar = 2;
        int maxResults = 3;

        List<List<String>> result = new ArrayList<List<String>>();

        if (customerQuery.length() < minChar) return result;

        Collections.sort(repository);

        for (var i = 0; i <= customerQuery.length() - minChar; i++) {

            var q = customerQuery.substring(0, minChar + i);

            var l = getProducts(numProducts, repository, q, maxResults);
            System.out.println(q + " => " + l);
            result.add(l);
        }
        return result;
    }


    private List<String> getProducts(int numProducts, List<String> repository, String query, int maxResults) {

        List<String> list = new ArrayList<>();

        for (var i = 0; i < numProducts; i++) {
            String s = repository.get(i);

            if (s.startsWith(query)) {
                list.add(s);
            }
            if (list.size() == maxResults)
                break;
        }
        return list;
    }
}