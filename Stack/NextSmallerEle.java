import java.util.*;
import java.io.*;

public class NextSmallerEle{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i = arr.size() - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() >= arr.get(i)) s.pop();
            if(s.isEmpty()) res.add(-1);
            else res.add(s.peek());
            s.push(arr.get(i));
        }
        Collections.reverse(res);
        return res;
    }
}