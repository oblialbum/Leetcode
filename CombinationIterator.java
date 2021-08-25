package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class CombinationIterator {
    /**
     * Your CombinationIterator object will be instantiated and called as such:
     * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
     * String param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    private HashSet<Character> hashSet = new HashSet<Character>();
    private char[] c ;
    private ArrayList<String> answer = new ArrayList();
    private int index = 0;
    public CombinationIterator(String characters, int combinationLength) {
        for(int i = 0; i < characters.length();i++){
            if(!hashSet.contains(characters.charAt(i))){
                hashSet.add(characters.charAt(i));
            }
        }
        c = new char[hashSet.size()];
        int i = 0;
        for (Iterator<Character> it = hashSet.iterator(); it.hasNext(); ) {
            c[i++] = it.next();
        }
        Arrays.sort(c);
        dfs(0,combinationLength,new StringBuilder());
    }
    private void dfs(int pos,int length,StringBuilder sb){
        if(length == 0){
            answer.add(sb.toString());
        }
        for(int i = pos;i < c.length; i++){
            sb.append(c[i]);
            dfs(i+1, length-1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public String next() {
        if (this.hasNext()) {
            return answer.get(index++);
        }
        return null;
    }

    public boolean hasNext() {
        return index < answer.size();
    }
    public static void main(String[] args){
        CombinationIterator obj = new CombinationIterator("chp",1);
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
    }
}
