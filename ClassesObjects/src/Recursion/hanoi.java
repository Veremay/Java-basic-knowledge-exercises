package Recursion;

public class hanoi {
    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(4, 'A', 'B', 'C');
    }
}

class Tower {
    public void move(int num, char a, char b, char c){
        //如果只有一个盘子
        if(num == 1){
            System.out.println(a + "->" + c);
        }else{
            //如果有多个盘子，就把上面的看作一个，借助c 移动到b
            move(num - 1, a, c, b);
            //再把最下面那一个借助移动到c
            System.out.println(a + "->" + c);
            //然后把剩下的 借助a 移动到c
            move(num - 1, b, a, c);
//            System.out.println(b + "->" + c);
        }
    }
}
