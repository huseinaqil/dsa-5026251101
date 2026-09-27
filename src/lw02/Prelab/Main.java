import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("transaction.txt"));

        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> record = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>(); 
        Stack<String[]> stack = new Stack<>(); 

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] trans = line.split(" ");
            transactions.add(trans);
            
            boolean exists = false;
            for(String[] i : record){
                if(i[0].equals(trans[0])){
                    exists = true;
                    break;
                }
            }
            if(!exists){
                record.add(new String[]{trans[0], "0"});
            }
        }

        for(String[] i :transactions){
           queue.offer(i);
        }

        while(!queue.isEmpty()){
            String[] current = queue.poll();

            if(current[1].equals("DEPOSIT")){
                for(String[] j : record){
                    if(j[0].equals(current[0])){
                        j[1] = String.valueOf(Integer.parseInt(j[1]) + Integer.parseInt(current[2]));
                    }
                }
            }
            else if(current[1].equals("WITHDRAW")){
                for(String[] j : record){
                    if(j[0].equals(current[0])){
                        if(Integer.parseInt(j[1]) < Integer.parseInt(current[2])){
                            stack.push(current);
                        } else {
                            j[1] = String.valueOf(Integer.parseInt(j[1]) - Integer.parseInt(current[2]));
                        }
                    }
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for(String[] i : record){
            System.out.println(i[0] + " : " + i[1]);
        }
        System.out.println("\n=== Failed Transactions ===");

        while(!stack.isEmpty()){
            String[] failed = stack.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }

        scanner.close();
    }
}
