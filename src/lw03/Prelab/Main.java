import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args){
        //problem 1
        Scanner in = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new ArrayList<>();
        while (in.hasNext()){
            String cmd = in.next();
            if(cmd.equals("ADD")){
                String song = in.nextLine();
                playlist.add(song);
            }
            else if(cmd.equals("REMOVE")){
                String song = in.nextLine();
                playlist.remove(playlist.indexOf(song));
            }
            else if(cmd.equals("INSERT")){
                int index = in.nextInt();
                String song = in.nextLine();
                playlist.add(index, song);
            }
        }
        System.out.println("==== Problem 1 ====\nTotal songs: " + playlist.size());
        for(int i = 0; i < playlist.size(); i++){
            System.out.println(i + 1 + ": " + playlist.get(i));
        }
        in.close();

        //problem 2
        Set<String> participants = new LinkedHashSet<>();
        Scanner in1 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        int duplicate = 0;
        while(in1.hasNextLine()){
            String name = in1.nextLine();
            if(participants.contains(name)){
                duplicate++;
            }
            else {
                participants.add(name);
            }
        }
        System.out.println("===== Problem 2 =====\nUnique participants: " + participants.size());
        int count = 1;
        for(String name : participants){
            System.out.println(count++ + ". " + name);
        }
        System.out.println("Duplicate registrations: " + duplicate);
        in1.close();

        //problem 3
        Scanner sc = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> stock = new LinkedHashMap<>();
        int failed = 0;
        while(sc.hasNext()){
            String type = sc.next();
            String product = sc.next();
            int quantity = sc.nextInt();

            if(type.equals("ADD")){
                if(stock.containsKey(product)){
                    //int currentStock = stock.get(product);
                    stock.put(product, stock.get(product) + quantity);
                }
                else{
                    stock.put(product, quantity);
                }
            } 
            else if(type.equals("SELL")){
                if(stock.containsKey(product) && stock.get(product) > quantity){
                    stock.put(product, stock.get(product) - quantity);
                }
                else {
                    failed++;
                }
            }
        }

        System.out.println("==== Problem 3 ====");
        for(String key : stock.keySet()){
            System.out.println(key + ": " + stock.get(key));
        }
        System.out.println("Failed sales: " + failed);
    }
}
