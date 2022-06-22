package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_166 {
    /**
     * map记录余数出现的位置（第几位小数字）。
     * @param numator
     * @param denom
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb = new StringBuffer();
        Map<Long,Integer> map = new HashMap<>();
        int symbol = 1;
        if(numerator < 0 && denominator > 0){
            symbol = -1;
        }
        if(numerator > 0 && denominator < 0){
            symbol = -1;
        }
        if(symbol == -1){
            sb.append('-');
        }
        long numator = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        sb.append(numator / denom);
        long remaining = numator % denom;
        if(remaining == 0){
            return sb.toString();
        }
        sb.append('.');
        remaining *= 10;
        int pos = 1;
        int offset = sb.length() - 1;
        while (remaining != 0){
            sb.append( remaining / denom);
            if(!map.containsKey(remaining)) {
                map.put(remaining, pos);
            }
            else{
                sb.deleteCharAt(sb.length() - 1);
                sb.append(')');
                /**
                 * 在该位置上插入'(',开始有俩个字符。
                 */
                sb.insert(map.get(remaining) + offset,'(');
                break;
            }
            remaining %= denom;
            pos++;
            remaining *= 10;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        new D_166().fractionToDecimal(-1, -2147483648);
    }
}
