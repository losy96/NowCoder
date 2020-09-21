package duxiaoman;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Search {
    //记录已经走过的路径

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        Integer numData = cin.nextInt();
        int[] nowPosition = new int[2];
        for (int i=0;i<numData;i++){
            Integer x = cin.nextInt();
            Integer y = cin.nextInt();
            //记录迷宫
            char[][] home = new char[x][y];
            //记录已经走过的路径
            int[][] hasMoveHome = new int[x][y];
            for (int j=0;j<x;j++){
                String line = cin.next();
                for (int k=0;k<y;k++){
                    if (line.charAt(k) == '@'){
                        //找出当前所在位置
                        nowPosition[0] = j;
                        nowPosition[1] = k;
                    }
                    home[j][k] = line.charAt(k);
                }
            }
            //搜索入口
            System.out.println(search(nowPosition,home,hasMoveHome));
        }
    }

    /**
     * 搜索主程序
     * @param nowPosition
     * @param home
     * @param hasMoveHome
     * @return
     */
    public static int search(int[] nowPosition,char[][] home,int[][] hasMoveHome){
        //如果当前位置为之前已经走过的路径，则不再走了，直接返回走不通。
        showHomeHasMove(hasMoveHome,nowPosition);
        if (hasMoveHome[nowPosition[0]][nowPosition[1]] == -1){
            //如果已经走过了，停掉
            return -1;
        }
        //设置当前位置为-1，标志为已经走过的格子
        hasMoveHome[nowPosition[0]][nowPosition[1]] = -1;
        //查找是否为走出迷宫，活着找到公主等条件
        if (nowPosition[0] == 0||nowPosition[0] == home.length-1){
            hasMoveHome[nowPosition[0]][nowPosition[1]] = 0;
            return 0;
        }
        if (nowPosition[1] == 0||nowPosition[1] == home[0].length-1){
            hasMoveHome[nowPosition[0]][nowPosition[1]] = 0;
            return 0;
        }

        //查探周围
        //向左边
        int left = -1;
        /**
         * 判断路径是否能继续往下走，如果只是简单的走迷宫，并且计算路径，则修改条件为只保留下一个else if
         * 如果下面if条件无法满足，则证明该路不通，up值为-1，在下面会判断该方向能否走通
         */
//        System.out.println("@"+nowPosition[0]+":"+(nowPosition[1]-1));
        if (home[nowPosition[0]][nowPosition[1] - 1] == '.'){//查看是否为可走路径
            left = search(new int[]{nowPosition[0], nowPosition[1] - 1},home,hasMoveHome);
        }else if (home[nowPosition[0]][nowPosition[1] - 1] == '*'){//查看是否为可撞击的墙
            left = search(new int[]{nowPosition[0], nowPosition[1] - 1},home,hasMoveHome);
            if (left != -1){
                left++;
            }
        }
        //向右边
        int right = -1;
        if (home[nowPosition[0]][nowPosition[1] + 1] == '.'){
            right = search(new int[]{nowPosition[0], nowPosition[1] + 1},home,hasMoveHome);
        }else if (home[nowPosition[0]][nowPosition[1] + 1] == '*'){
            right = search(new int[]{nowPosition[0], nowPosition[1] + 1},home,hasMoveHome);
            if (right != -1){
                right++;
            }
        }
        //向上面
        int up = -1;
        if (home[nowPosition[0] - 1][nowPosition[1]] == '.'){
            up= search(new int[]{nowPosition[0] - 1, nowPosition[1]},home,hasMoveHome);
        }else if (home[nowPosition[0] - 1][nowPosition[1]] == '*'){
            up = search(new int[]{nowPosition[0] - 1, nowPosition[1]},home,hasMoveHome);
            if (up != -1){
                up++;
            }
        }
        //向下面
        int down = -1;
        if (home[nowPosition[0] + 1][nowPosition[1]] == '.'){
            down = search(new int[]{nowPosition[0] + 1, nowPosition[1]},home,hasMoveHome);
        }else if (home[nowPosition[0] + 1][nowPosition[1]] == '*'){
            down = search(new int[]{nowPosition[0] + 1, nowPosition[1]},home,hasMoveHome);
            if (down != -1){
                down++;
            }
        }

        //如果所有路都是-1，则证明该空格走不通，直接返回-1，由上一层进行处理
        if (up == -1 && down == -1 && right == -1 && left == -1){
            return -1;

        }
        //到这里证明至少有一个方向是走通了，选择走通的方向撞墙次数最少
        int[] answers = new int[4];
        answers[0] = up;
        answers[1] = down;
        answers[2] = right;
        answers[3] = left;
        int min = -1;
        for (int i:answers){
            if (i != -1){
                if (min == -1){
                    min = i;
                }else {
                    min = min > i ? i : min;
                }
            }
        }
        /**
         * 搜索过的位置应该不需要归0，因为曾经从这走过，再走一遍结果应该也是一致的。
         */
//        System.out.println(up+" "+down+" "+right+" "+left);
//        System.out.println("!"+min);
        hasMoveHome[nowPosition[0]][nowPosition[1]] = 0;
        return min;//返回当前格子撞墙次数最少的路径一共撞墙多少次。
    }
    public static void showHomeHasMove(int[][] hasMoveHome,int[] nowPosition){
        System.out.println("-------------");
        System.out.println("now position:"+nowPosition[0]+":"+nowPosition[1]);
        for (int i=0;i<hasMoveHome.length;i++){
            for (int j=0;j<hasMoveHome[i].length;j++){
                if (i == nowPosition[0] && j == nowPosition[1]){
                    System.out.print("*\t");
                }else {
                    System.out.print(hasMoveHome[i][j]+"\t");
                }
            }
            System.out.println();

        }
    }
}
