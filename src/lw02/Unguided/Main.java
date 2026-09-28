import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;  

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> stack = new Stack<>();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] req = line.split(" ");
            requests.add(req);

            boolean exist = false;
            for(String[] member : members){
                if(req[0].equals(member[0])){
                    exist = true;
                    break;
                }
            }
            if(exist == false){
                members.add(new String[]{req[0], "0"});
            }
        }

        queue.addAll(requests);

        System.out.println("=== Successfully Processed Requests ===");

        while(!queue.isEmpty()){
            boolean success = false;
            String[] current = queue.poll();

            for(String[] book : books){
                if(current[1].equals(book[0])){
                    if(Integer.parseInt(book[1]) > 0){
                        for(String[] member : members){
                            if(current[0].equals(member[0])){
                                if(Integer.parseInt(member[1]) < 2){
                                    book[1] = String.valueOf(Integer.parseInt(book[1]) - 1);
                                    member[1] = String.valueOf(Integer.parseInt(member[1]) + 1);
                                    System.out.println(current[0] + " " + current[1]);
                                    success = true;
                                } 
                            }
                        }
                    } 
                }
            }
            if(!success){
                stack.push(current);
            }
        }
        System.out.println("\n=== Remaining Books Stock ===");
        for(String[] book : books){
            System.out.println(book[0] + ":" + book[1]);
        }

        System.out.println("\n=== Failed Requests ===");
        while(!stack.isEmpty()){
            String[] failed = stack.pop();
            System.out.println(failed[0] + " " + failed[1]);
        }

    }
}
