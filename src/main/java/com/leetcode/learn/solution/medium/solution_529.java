package com.leetcode.learn.solution.medium;

/**
 * 529. 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *
 *
 * 示例 1：
 *
 * 输入:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 * 示例 2：
 *
 * 输入:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 *
 *
 * 注意：
 *
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 */
public class solution_529 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                 {'M', 'E', 'E'},
                 {'E', 'E', 'M'},
                 {'E', 'E', 'E'}
        };
        System.out.println(new solution_529().updateBoard(board, new int[]{2, 0}));
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        char c = board[click[0]][click[1]];
        switch(c){
            case 'M':
                board[click[0]][click[1]] = 'X';
                break;
            case 'E':
                //判断是否相邻地雷
                dfs(board,click[0],click[1]);
                break;
            default:
                break;
        }
        return board;
    }

    public void dfs(char[][] board, int i, int j){
        int num = check(board,i,j);
        if(num > 0){
            board[i][j] = (char)(num + '0');
        }else{
            board[i][j] = 'B';
            for(int x = i - 1;x <= i + 1;x++){
                if(x < 0 || x >= board.length)
                    continue;
                for(int y = j - 1;y <= j + 1;y++){
                    if(y < 0 || y >= board[0].length || (x == i && y == j))
                        continue;
                    else if(board[x][y] != 'E')
                        continue;
                    dfs(board,x,y);
                }
            }
        }
    }

    public int check(char[][] board, int i,int j){
        int num = 0;
        for(int x = i - 1;x <= i + 1;x++){
            if(x < 0 || x >= board.length)
                continue;
            for(int y = j - 1;y <= j + 1;y++){
                if(y < 0 || y >= board[0].length || (x == i && y == j))
                    continue;
                if(board[x][y] == 'M')
                    num++;
            }
        }

        return num;
    }
}
