package com.fengtin.LeetCode;

public class Robot {
    int[][] grid ;
    String direction = "East";
    final String[] directions = new String[]{"East","North","West","South"};
    int curPosI ,curPosJ,x,y,circular;

    /**
     * circular方向会变化。
     * @param width
     * @param height
     */
    public Robot(int width, int height) {
        grid = new int[width][height];
        curPosI = 0;
        curPosJ = 0;
        x = width;
        y = height;
        circular = 2 * ( x + y - 2);
    }

    public void move(int num) {
        num %= circular;
        if(num == 0){
            num = circular;
        }
        while (num > 0){
            int reduce = moveToEnd();
            if(reduce >= num){
                traceBack(reduce - num);
                break;
            }
            else{
                num -= reduce;
            }
            changeDirection();
        }
    }

    private void traceBack(int steps) {
        if(direction.equals(directions[0])){
            curPosI -= steps;
        }
        if(direction.equals(directions[2])){
            curPosI += steps;
        }
        if(direction.equals(directions[1])){
            curPosJ -= steps;
        }
        if(direction.equals(directions[3])){
            curPosJ += steps;
        }
    }

    private int moveToEnd() {
        int count = 0;
        if(direction.equals("East")){
            if(curPosI == x-1){
                return 0;
            }
            count += (x - 1) - curPosI;
            curPosI = x - 1;
        }
        if(direction.equals("West")){
            if(curPosI == 0){
                return 0;
            }
            count += curPosI;
            curPosI = 0;
        }
        if(direction.equals("North")){
            if(curPosJ == y-1){
                return 0;
            }
            count += (y - 1) - curPosJ;
            curPosJ = y - 1;
        }
        if(direction.equals("South")){
            if(curPosJ == 0){
                return 0;
            }
            count += curPosJ;
            curPosJ = 0;
        }
        return count;
    }

    private void changeDirection() {
        if(direction.equals(directions[0])){
            direction = directions[1];
        }
        else if(direction.equals(directions[1])){
            direction = directions[2];
        }
        else if(direction.equals(directions[2])){
            direction = directions[3];
        }
        else if(direction.equals(directions[3])){
            direction = directions[0];
        }
    }


    public int[] getPos() {
        return new int[]{curPosI,curPosJ};
    }

    public String getDir() {
        return direction;
    }

    public static void main(String[] args){
        Robot robot = new Robot(6, 3); // 初始化网格图，机器人在 (0, 0) ，朝东。
        robot.move(14);  // 机器人朝东移动 2 步，到达 (2, 0) ，并朝东。
        robot.move(18);  // 机器人朝东移动 2 步，到达 (4, 0) ，并朝东。
        robot.move(18);
        robot.getPos(); // 返回 [4, 0]
        robot.getDir(); // 返回 "East"
        robot.move(2);  // 朝东移动 1 步到达 (5, 0) ，并朝东。
        // 下一步继续往东移动将出界，所以逆时针转变方向朝北。
        // 然后，往北移动 1 步到达 (5, 1) ，并朝北。
        robot.move(1);  // 朝北移动 1 步到达 (5, 2) ，并朝 北 （不是朝西）。
        robot.move(4);  // 下一步继续往北移动将出界，所以逆时针转变方向朝西。
        // 然后，移动 4 步到 (1, 2) ，并朝西。
        robot.getPos(); // 返回 [1, 2]
        robot.getDir(); // 返回 "West"
    }
}
