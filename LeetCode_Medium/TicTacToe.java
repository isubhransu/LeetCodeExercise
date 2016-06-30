package LeetCode_Medium;

import AbstractClass_Challenge.Main;

/**
 * Created by subhransumishra on 6/29/16.
 *
 * Problem: Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 * Example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

 TicTacToe toe = new TicTacToe(3);

 toe.move(0, 0, 1); -> Returns 0 (no one wins)
 |X| | |
 | | | |    // Player 1 makes a move at (0, 0).
 | | | |

 toe.move(0, 2, 2); -> Returns 0 (no one wins)
 |X| |O|
 | | | |    // Player 2 makes a move at (0, 2).
 | | | |

 toe.move(2, 2, 1); -> Returns 0 (no one wins)
 |X| |O|
 | | | |    // Player 1 makes a move at (2, 2).
 | | |X|

 toe.move(1, 1, 2); -> Returns 0 (no one wins)
 |X| |O|
 | |O| |    // Player 2 makes a move at (1, 1).
 | | |X|

 toe.move(2, 0, 1); -> Returns 0 (no one wins)
 |X| |O|
 | |O| |    // Player 1 makes a move at (2, 0).
 |X| |X|

 toe.move(1, 0, 2); -> Returns 0 (no one wins)
 |X| |O|
 |O|O| |    // Player 2 makes a move at (1, 0).
 |X| |X|

 toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 |X| |O|
 |O|O| |    // Player 1 makes a move at (2, 1).
 |X|X|X|

 Could you do better than O(n2) per move() operation?

 * Solution: You have to be little creative to think for a solution to this problem. You need 2 1D arrays
 * one for colum and another for row and return 0 until one hit the length of row/col size. I have
 * explained it in detail in comments.
 * (Explanation: https://leetcode.com/discuss/101144/java-o-1-solution-easy-to-understand)
 *
 * Complexity:
 */

public class TicTacToe{
//TODO
    public static void main(String[] args){
        TicTacToeHelper ttt = new TicTacToeHelper(3);
        System.out.println(ttt.move(1, 2, -1));
        System.out.println(ttt.move(0, 1, 1));
        System.out.println(ttt.move(1, 1, -1));
        System.out.println(ttt.move(0, 2, 1));
        System.out.println(ttt.move(1, 0, -1));
    }
}

class TicTacToeHelper{
    int[] rows;
    int[] cols;
    int Diagonal;
    int XDiagonal;

    TicTacToeHelper(int n){
       rows = new int[n];
       cols = new int[n];
    }

    public int move(int row, int col, int player){
        int addPlayer = player == 1 ? 1 : -1;

        //Update index of row by adding player
        rows[row] += addPlayer;

        //Update index of col by adding player
        cols[col] += addPlayer;

        //Update diagonal by adding player
        if(row == col){
            Diagonal+=addPlayer;
        }

        //Update anti-diagonal by adding player
        if(col == rows.length - 1 - row){
            XDiagonal += addPlayer;
        }

        int size = rows.length;

        //Return current player if you have "size" number of current
        // player across diagonal or anti-diagonal or across a colom
        // or across a row.

        if(Math.abs(Diagonal) == size ||
                Math.abs(XDiagonal) == size ||
                Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size){
            return addPlayer;
        }
        return 0;
    }
}
