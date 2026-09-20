import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(Main.class.getResourceAsStream("Jobs.txt"));
        ArrayList<PrintJob> prints = new ArrayList<>();
        while (input.hasNext()){
            String jobType = input.next();
            if(jobType.equals("MONO")){
                String id = input.next();
                int pages = input.nextInt();
                PrintJob print = new MonoPrint(id, pages);
                prints.add(print);
            } 
            else if(jobType.equals("COLOUR")){
                String id = input.next();
                int pages = input.nextInt();
                PrintJob print = new ColourPrint(id, pages);
                prints.add(print);
            }
        }

        for (int i = 0; i < prints.size(); i++){
            System.out.println(prints.get(i).summary());
        }
        input.close();
    }
}

