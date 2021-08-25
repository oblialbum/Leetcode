package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_207 {
    /**
     * 即判断有向图中是否存在环。
     * numCourse:节点数
     * prerequisites:a,b,其中b是a的前驱。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    boolean[] path;
    Set<Integer> set = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        path = new boolean[numCourses];
        for(int i = 0 ;i < prerequisites.length;i++){
                set.add(prerequisites[i][0]);
        }
        for(int i = 0;i < prerequisites.length;i++){
                if(!dfs(prerequisites[i][0],prerequisites)){
                    return false;
                }
        }
        return true;
    }

    /**
     * @param prerequisites
     */
    private boolean dfs(int course,int[][] prerequisites){
        if(path[course]){
            return false;
        }
        path[course] = true;
        for(int i = 0;i < prerequisites.length;i++) {
            if(prerequisites[i][0] == course) {
                if (set.contains(prerequisites[i][1])) {
                    if (!dfs(prerequisites[i][1], prerequisites)) {
                        return false;
                    }
                }
            }
        }
        path[course] = false;
        return true;
    }
}
