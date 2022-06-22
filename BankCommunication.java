package com.fengtin.LeetCode;

import java.util.*;

public class BankCommunication {
    public boolean isPalindrome(ListNode head) {
        int[] nums = toArray(head);
        return removeLeft(nums) || removeRight(nums);
    }

    private boolean removeLeft(int[] nums){
        int left = 0,right = nums.length - 1;
        boolean removed = false;
        while (left < right){
            if (nums[left] == nums[right]){
                left++;
                right--;
            }else{
                if (removed){
                    return false;
                }else{
                    if (nums[left + 1] == nums[right]){
                        left += 2;
                        right--;
                        removed = true;
                    }else if(nums[left] == nums[right - 1]){
                        left++;
                        right -= 2;
                        removed = true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean removeRight(int[] nums){
        int left = 0,right = nums.length - 1;
        boolean removed = false;
        while (left < right){
            if (nums[left] == nums[right]){
                left++;
                right--;
            }else{
                if (removed){
                    return false;
                }else{
                    if (nums[left] == nums[right - 1]){
                        left++;
                        right -= 2;
                        removed = true;
                    }else if(nums[left + 1] == nums[right]){
                        left += 2;
                        right --;
                        removed = true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int maxInvestment(int[] product, int limit) {
        PriorityQueue<Double> pq = new PriorityQueue<>((x,y)->{
            if (x.equals(y)){
                return 0;
            }
            if (x < y){
                return 1;
            }
            return -1;
        });
        double res = 0,mod = 1e9 + 7;
        for (int num:product
             ) {
            pq.add((double) num);
        }
        while (limit > 0 && !pq.isEmpty()){
            double max = pq.poll();
                double nums = 1;
                while (pq.peek() != null && pq.peek() == max){
                    nums++;
                    pq.poll();
                }
                double floor;
                floor = pq.peek() == null ? 0.0 : pq.peek();
                double loop = (double)limit / nums;
                loop = (int)loop;
                //本次循环可以把所有limit耗尽
                if (max - loop >= floor){
                    res %= mod;
                    res += ((nums * loop) % mod * (max + max - loop + 1) % mod / 2) % mod;
                    max -= loop;
                    double left = limit - loop * nums;
                    res += left * max % mod;
                    break;
                }else{
                    limit -= (max - floor) * nums;
                    res += ((nums * (max - floor)) % mod * (max + floor + 1) % mod / 2) % mod;

                    res %= mod;
                    if (floor == 0){
                        break;
                    }
                    while (nums > 0){
                        nums--;
                        pq.add(floor);
                    }
                }
        }
        return (int)(res % mod);
    }

    public static void main(String[] args) {
        new BankCommunication().maxInvestment(new int[]{54184,77152,6790,25849,26072,99213,41828,2510},311619);
    }
}

class DiscountSystem{
    List<Activity> list;
    Map<Integer,Activity> map ;
    Map<Activity,Map<Integer,Integer>> usedMap;//已经使用的.
    public DiscountSystem() {
        list = new ArrayList<>();
        map = new HashMap<>();
        usedMap = new HashMap<>();
    }

    public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
        Activity activity = new Activity(actId, priceLimit, discount, number, userLimit);
        list.add(activity);
        map.put(actId,activity);
        usedMap.put(activity,new HashMap<>());
    }

    public void removeActivity(int actId) {
        list.remove(map.get(actId));
        map.remove(actId);
    }

    public int consume(int userId, int cost) {
        Collections.sort(list,(x,y)->{
            int res ;
            if (x.discount == y.discount){
                if (x.actId == y.actId){
                    res = x.priceLimit - y.priceLimit;
                }else{
                    res = y.actId - x.actId;
                }
            }else{
                res = x.discount - y.discount;
            }
            return res;
        });
        int discount = 0;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            Activity activity = list.get(i);
            if (activity.priceLimit > cost){
                continue;
            }
            //使用情况
            Map<Integer, Integer> map1 = usedMap.get(activity);
            int sum = 0;
            for (Map.Entry<Integer,Integer> entry:map1.entrySet()
                 ) {
                sum += entry.getValue();
            }
            if (sum == activity.number){
                continue;
            }
            if (map1.containsKey(userId)){
                if (map1.get(userId) == activity.userLimit) {
                    continue;
                }
                discount = activity.discount;
                map1.put(userId,map1.get(userId)+1);
                break;
            }else{
                map1.put(userId,1);
                discount = activity.discount;
                break;
            }
        }
        return cost - discount;
    }

    class Activity {
        int actId;
        int priceLimit;
        int discount;
        int number;
        int userLimit;

        public Activity(int actId, int priceLimit, int discount, int number, int userLimit) {
            this.actId = actId;
            this.number = number;
            this.userLimit = userLimit;
            this.priceLimit = priceLimit;
            this.discount = discount;
        }



    }
}
