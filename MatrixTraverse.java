/**
 * Created by subhransumishra on 3/13/16.
 */
public class MatrixTraverse {


    /*
 * Complete the function below.
 */
    static int count = 0;
    static int totalCellsVisited(int n, int m) {
        int[][] matrix = new int[n][m];
        count++;
        visitMat(0, 0, matrix);
        matTraverse(0, 0, matrix, Direction.Right);
        return count;
    }

    static void matTraverse(int x, int y, int[][] Arr2D, Direction d) {
        if (areSurroundingsVisited(x, y, Arr2D)) {
            return;
        }
        if (d.equals(Direction.Right)) {
            if (isNotVisited(x + 1, y, Arr2D)) {
                count++;
                visitMat(x + 1, y, Arr2D);
                matTraverse(x + 1, y, Arr2D, Direction.Bottom);
            } else {
                matTraverse(x, y, Arr2D, Direction.Bottom);
            }
        } else if (d.equals(Direction.Left)) {
            if (isNotVisited(x - 1, y, Arr2D)) {
                count++;
                visitMat(x - 1, y, Arr2D);
                matTraverse(x - 1, y, Arr2D, Direction.Top);
            } else {
                matTraverse(x, y, Arr2D, Direction.Top);
            }
        } else if (d.equals(Direction.Bottom)) {
            if (isNotVisited(x, y + 1, Arr2D)) {
                count++;
                visitMat(x, y + 1, Arr2D);
                matTraverse(x, y + 1, Arr2D, Direction.Left);
            } else {
                matTraverse(x, y, Arr2D, Direction.Left);
            }
        } else {
            if (isNotVisited(x, y - 1, Arr2D)) {
                count++;
                visitMat(x, y - 1, Arr2D);
                matTraverse(x, y - 1, Arr2D, Direction.Right);
            } else {
                matTraverse(x, y, Arr2D, Direction.Right);
            }
        }
    }

    static boolean isNotVisited(int x, int y, int[][] Arr2D) {
        if (x < 0 || x > Arr2D.length - 1) {
            return false;
        }
        if (y < 0 || y > Arr2D[x].length - 1) {
            return false;
        }
        return (Arr2D[x][y] == 0) ? true : false;
    }

    static boolean areSurroundingsVisited(int x, int y, int[][] Arr2D) {
        if (y == 0) {
            if (x == 0) {
                boolean right = Arr2D[x + 1][y] != 0;
                boolean bottom = Arr2D[x][y + 1] != 0;
                return (right && bottom);
            } else if (x == Arr2D.length - 1) {
                boolean left = Arr2D[x - 1][y] != 0;
                boolean bottom = Arr2D[x][y + 1] != 0;
                return (left && bottom);
            } else {
                boolean bottom = Arr2D[x][y + 1] != 0;
                boolean left = Arr2D[x - 1][y] != 0;
                boolean right = Arr2D[x + 1][y] != 0;
                return (bottom && left && right);
            }
        } else if (y == Arr2D[x].length - 1) {
            if (x == 0) {
                boolean top = Arr2D[x][y - 1] != 0;
                boolean right = Arr2D[x + 1][y] != 0;
                return (top && right);
            } else if (x == Arr2D.length - 1) {
                boolean left = Arr2D[x - 1][y] != 0;
                boolean top = Arr2D[x][y - 1] != 0;
                return (top && left);
            } else {
                boolean left = Arr2D[x - 1][y] != 0;
                boolean top = Arr2D[x][y - 1] != 0;
                boolean right = Arr2D[x + 1][y] != 0;
                return (top && right && left);
            }
        } else {
            if (x == 0) {
                // right , top , bottom
                boolean right = Arr2D[x + 1][y] != 0;
                boolean top = Arr2D[x][y - 1] != 0;
                boolean bottom = Arr2D[x][y + 1] != 0;
                return (right && top && bottom);
            } else if (x == Arr2D.length - 1) {
                boolean left = Arr2D[x - 1][y] != 0;
                boolean top = Arr2D[x][y - 1] != 0;
                boolean bottom = Arr2D[x][y + 1] != 0;
                return (left && top && bottom);
            }

            else {
                boolean left = Arr2D[x - 1][y] != 0;
                boolean right = Arr2D[x + 1][y] != 0;
                boolean top = Arr2D[x][y - 1] != 0;
                boolean bottom = Arr2D[x][y + 1] != 0;
                return (left && right && top && bottom);
            }
        }
    }

    static void visitMat(int x, int y, int[][] Arr2D) {
        if (Arr2D[x][y] == 0) {
            Arr2D[x][y] = count;
        }
    }

    enum Direction {
        Right, Left, Top, Bottom;
    }

}
