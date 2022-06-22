package com.fengtin.LeetCode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator ;
    Integer nextInt;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        nextInt = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
       return nextInt;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
        public Integer next() {
            int res = nextInt;
            if(iterator.hasNext()){
                nextInt = iterator.next();
            }
            else{
                nextInt = null;
            }
            return res;
        }

        @Override
        public boolean hasNext() {
            return nextInt == null;
        }
}
