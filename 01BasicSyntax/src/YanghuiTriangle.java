public class YanghuiTriangle {
    public static void main(String[] args) {
        int line_num = 10;
        int[][] triangles = new int[line_num][];

        for (int i = 0; i < triangles.length; i++) {
            int[] row = new int[i+1];
            if(i == 0){
                row[0] = 1;
                triangles[i] = row;
            }
            else if(i == 1){
                row[0] = 1;
                row[1] = 1;
                triangles[i] = row;
            }
            else{
                row[0] = 1;
                for (int j = 1; j < i; j++) {
                    row[j] = triangles[i-1][j-1] + triangles[i-1][j];
            }
                row[i] = 1;
                triangles[i] = row;
            }
        }

        for (int i = 0; i < triangles.length; i++) {
            for (int j = 0; j < triangles[i].length; j++) {
                System.out.print(triangles[i][j] + " ");
            }
            System.out.println();
        }
    }
}
