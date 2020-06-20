/**
 *
 * Object Oriented Scraper
 *
 * jsoup: Java HTML Parser
 * jsoup is a Java library for working with real-world HTML.
 * It provides a very convenient API for fetching URLs and extracting and manipulating data,
 * using the best of HTML5 DOM methods and CSS selectors.
 *
 * https://jsoup.org
 *
 * @author Norman Mikhail <normanmkhl@gmail.com>
 *                        <github.com/normanmkhl>
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ScraperIMDB{
    public static void main(String[] args) {
        final String url = "https://www.imdb.com/chart/top/";
        LinkedList<Integer> list = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        try {
            final Document document = Jsoup.connect(url).get();

            for (Element e : document.select("tbody.lister-list tr")) {
                if (e.select("td.titleColumn").text().equals("")) {
                    continue;
                } else {
                    final String name = e.select("td.titleColumn a").text();
                    final String rating = e.select("td.ratingColumn.imdbRating").text();
                    final String rating1 = rating.replace(".", "");
                    final int ratingFix = Integer.parseInt(rating1);
                    list.add(ratingFix);
                    map.put(name, ratingFix);
                    System.out.println(name + " " + " -----> Rating :  " + ratingFix);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < list.size(); i++) {
            bt.binarySearchTreeInsert(list.get(i));
        }
        System.out.println("-----------------------------------------------");
        System.out.print("Biggest Score on IMDB 250 : ");
        bt.BSTbiggest();
        System.out.print("Lowest Score on IMDB 250 : ");
        bt.BSTsmallest();
        //System.out.println("Rating from lowest to biggest : ");
        //System.out.println(bt.SmallestToBig());
        //System.out.println("Rating from biggest to lowest : ");
        //System.out.println(bt.BiggestToSmallest());
        ArrayList<Object> listRand = new ArrayList<Object>(map.keySet());
        Collections.shuffle(listRand);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Create a new watch list! (auto-generated)");
        System.out.println("Enter how many movies you want on the list : ");
        int s = Integer.parseInt(sc.nextLine()); int x =0;
        for(Object obj : listRand){
            if(x < s){
                System.out.println(obj);
            }
            else{
                break;
            }
            x++;
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Check a movie rating (example input = Rocky) : ");
        String z = sc.nextLine();
        System.out.println(map.get(z));
    }
}
