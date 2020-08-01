
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Harsh
 */
public class Swaymavar {

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            int N = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();

            LinkedList<Character> brides = new LinkedList<>();
            LinkedList<Character> grooms = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                brides.add(s1.charAt(i));
                grooms.add(s2.charAt(i));
            }

            while (!brides.isEmpty()) {
                if(Objects.equals(brides.getFirst(), grooms.getFirst())){
                    brides.removeFirst();
                    grooms.removeFirst();
                }
                else{
                    if(grooms.contains(brides.getFirst())){
                        char temp=grooms.getFirst();
                        grooms.removeFirst();
                        LinkedList<Character> templist=new LinkedList<>();
                        templist=grooms;
                        templist.addLast(temp);
                    }
                    else{
                        break;
                    }
                }
            }
            
            System.out.println(brides.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
