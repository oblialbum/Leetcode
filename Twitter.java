package com.fengtin.LeetCode;

import java.util.*;

public class Twitter {
    private class Node {
        // 哈希表存储关注人的 Id
        Set<Integer> followee;
        // 用链表存储 tweetId
        LinkedList<Integer> tweet;

        Node() {
            followee = new HashSet<Integer>();
            tweet = new LinkedList<Integer>();
        }
    }

    private int recentMax,time;

    private Map<Integer,Integer> tweetTime;

    private Map<Integer,Node> user;
    /** Initialize your data structure here. */
    public Twitter() {
        time = 0;
        recentMax = 10;
        tweetTime = new HashMap<>();
        user = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!user.containsKey(userId)){
            init(userId);
        }
        if(user.get(userId).tweet.size() == recentMax){
            user.get(userId).tweet.remove(recentMax - 1);
        }
        user.get(userId).tweet.addFirst(tweetId);
        tweetTime.put(tweetId,time++);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> ans = new LinkedList<>();
        /**
         * 将自己发的twitter添加到结果中。
         */
        for (int it: user.getOrDefault(userId,new Node()).tweet
             ) {
            ans.add(it);
        }

        for(int followeeID:user.getOrDefault(userId,new Node()).followee
            ){
            if(followeeID == userId){
                continue;
            }
            LinkedList<Integer> res = new LinkedList<>();
            int tweetSize = user.get(followeeID).tweet.size();
            Iterator<Integer> it = user.get(followeeID).tweet.iterator();
            int i = 0, j = 0, cur = -1;
            /**
             * 对ans,当前待处理的linkList进行归并排序。
             */
            if(j < tweetSize){
                cur = it.next();
                while (i < ans.size() && j < tweetSize) {
                    if (tweetTime.get(cur) > tweetTime.get(ans.get(i))) {
                        res.addLast(cur);
                        ++j;
                        if (it.hasNext()) {
                            cur = it.next();
                        }
                    } else {
                        res.addLast(ans.get(i));
                        ++i;
                    }
                    // 已经找到这两个链表合起来后最近的 recentMax 条推文
                    if (res.size() == recentMax) {
                        break;
                    }
                }
            }
            for (; i < ans.size() && res.size() < recentMax; ++i) {
                res.addLast(ans.get(i));
            }
            if (j < tweetSize && res.size() < recentMax) {
                res.addLast(cur);
                for (; it.hasNext() && res.size() < recentMax;) {
                    res.addLast(it.next());
                }
            }
            ans = new LinkedList<Integer>(res);
            /**
             * 本次排序完成。
             */
        }

        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!user.containsKey(followerId)){
            init(followerId);
        }
        if(!user.containsKey(followeeId)){
            init(followeeId);
        }
        user.get(followerId).followee.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(user.containsKey(followerId)){
            if(user.get(followerId).followee.contains(followeeId)){
                user.get(followerId).followee.remove(followeeId);
            }
        }
    }

    private void init(int id){
        user.put(id,new Node());
    }
}
