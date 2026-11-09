import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int N = input.nextInt();
        int[] cards = new int[N];
        for(int i = 0; i < N; i++){
            cards[i] = input.nextInt();
        } 
        int M = input.nextInt();
        int[] find = new int[M];
        for(int i = 0; i < M; i++){
            find[i] = input.nextInt();
        }

        for(int i = 0; i < 2; i++){
            int least = 21;
            int leastIndex = 0;
            for(int j = 1; j < cards.length; j++){
                if(cards[j] < least){
                    least = cards[j];
                    leastIndex = j;
                }
            }
            int placeholder = cards[i];
            cards[i] = least;
            cards[leastIndex] = placeholder;
        }

        for(int x : cards){
            System.out.print(x + " ");
        }
        System.out.println();

        for(int i = 0; i < M; i++){
            boolean found = false;
            for(int j = 0; j < cards.length; j++){
                if(find[i] == cards[j]){
                    System.out.println(find[i] + ": FOUND at index " + j);
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println(find[i] + ": NOT FOUND");
            }
        }
    }
}
