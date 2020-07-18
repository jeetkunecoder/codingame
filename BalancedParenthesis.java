import java.io.*;
import java.util.*;

/**
 * Solution:
 * 1) Create a Map with the brackets Characters
 * 2) Create a boolean variable to check if the brackets are balanced
 * 3) Convert the string to an array of chars
 * 4) Create a Stack
 * 5) Loop through the characters of the string:
 *    if the character is a closing bracket, push it to the stack
 *    else (if it's a key) -> if the stack is empty return false
 *    otherwise pop a value balanced = st.pop().equals(m.get(key));
 */

public class BalancedParenthesis {

    public static boolean isBalanced(String s){
        HashMap<Character, Character> m = new HashMap<>();
        m.put('}', '{');
        m.put(')', '(');
        m.put(']', '[');
        boolean balanced = true;
        char c[] = s.toCharArray();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < c.length && balanced; i++) {
            if(m.containsValue(c[i])) st.push(c[i]);
            if(m.containsKey(c[i])){
                if(st.empty()) return false;
                balanced = st.pop().equals(m.get(c[i]));
            }
        }
        if(!st.empty()) return false;
        return balanced;
    }

    public static void main(String args[]){
        long start = System.nanoTime();
        try{
            File inFile = new File("input.txt");
            Scanner sc = new Scanner(inFile);

            while(sc.hasNext()){
                String s = sc.next();
                System.out.println(isBalanced(s));
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds = (double)elapsedTime / 1000000000.0;
        System.out.println(seconds + " s");
    }
}