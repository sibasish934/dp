import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> l = new ArrayList<>(n+1);

        for(int i = 0; i<=l.size(); i++){
            l.add(-1);
        }
        for(int i:l){
            System.out.println(i);
        }
        System.out.println(fibbo(n,l));
    }

    public static int fibbo(int n , List<Integer> l){
        if(n <=1 ){
            return n;
        }
        if(l.get(n) != -1){
            return l.get(n);
        }
        l.add((fibbo(n-1,l) + fibbo(n-2,l)),n);
        return l.get(n);
    }

}
