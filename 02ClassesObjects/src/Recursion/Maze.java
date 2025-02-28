package Recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        boolean result = findWay(map, 1, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 0表示尚未走过，1表示障碍物，2表示走过可通过，3表示走过不可通过
    // 探索路径的顺序为 down->right->up->left
    public static boolean findWay(int[][] map, int i, int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                // 假定可以走通
                map[i][j] = 2;
                // 验证是否真的可以走通
                if(findWay(map, i + 1, j)){
                    return true;
                }else if(findWay(map, i, j + 1)){
                    return true;
                }else if (findWay(map, i - 1, j)) {
                    return true;
                }else if (findWay(map, i, j - 1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
