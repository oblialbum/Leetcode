package com.fengtin.LeetCode;

public class D_1105 {
    /**
     * DP[i]:将第i本数作为一层的开始能够得到的最小高度。
     * @param books
     * @param shelfWidth
     * @return
     */
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] DP = new int[n + 1];
        DP[n] = 0 ;
        DP[n - 1] = books[n - 1][1];
        for (int i = n - 2; i >= 0 ; i--) {
            DP[i] = DP[i + 1] + books[i][1];
            int curWidth = books[i][0],curHeight = books[i][1];
            /**
             * 当前层数能够放下几本书，根据各种情况取最小高度。
             */
            for (int j = i + 1; j < n; j++) {
                curWidth += books[j][0];
                curHeight = Math.max(curHeight,books[j][1]);
                if(curWidth > shelfWidth){
                    break;
                }
                else{
                    DP[i] = Math.min(DP[i],DP[j + 1]+curHeight);
                }
            }
        }
        return DP[0];
    }
}
