import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        int failed = 0;
        Map<String, Integer> courses = new LinkedHashMap<>();

        System.out.println("==== Enrollment Checks ====");
        while(input.hasNext()){
            String operation = input.next();

            if(operation.equals("REGISTER")){
                String course = input.next();
                int num = input.nextInt();
                if(courses.containsKey(course)){
                    if(num > 0){
                        courses.put(course, courses.get(course) + num);
                    }
                    else{
                        failed++;
                    }
                }
                else{
                    if(num > 0){
                        courses.put(course, num);
                    }
                    else{
                        failed++;
                    }
                }
            }
            else if(operation.equals("WITHDRAW")){
                String course = input.next();
                int num = input.nextInt();
                if(courses.containsKey(course) && courses.get(course) >= num && num > 0){
                    courses.put(course, courses.get(course) - num);
                }
                else{
                    failed++;
                }
            }
            else if(operation.equals("CHECK")){
                String course = input.next();
                if(courses.containsKey(course)){
                    System.out.println(course + ": " + courses.get(course) + " Students");
                }
                else{
                    System.out.println(course + ": Not Found");  
                }
            }
        }
       System.out.println("\n==== Final Enrollment ====");
       for(String key : courses.keySet()){
            System.out.println(key + ": " + courses.get(key) + " Students");
        }
        System.out.println("\nRejected operations: " + failed);
    }
}
