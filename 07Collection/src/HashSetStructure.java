public class HashSetStructure {
    public static void main(String[] args) {
        //模拟HashSet底层存储数据的实现（即HashMap的底层实现，其实质是数组+链表+红黑树）
        //可以将其看作散列表+红黑树（暂时不涉及）
        //先创建一维数组
        Node[] table=new Node[16];
        Node jack = new Node("jack", null);
        table[2]=jack;
        //在jack后继续挂载
        Node tom = new Node("tom", null);
        jack.next=tom;

        Node rose = new Node("Rose", null);
        tom.next=rose;//将rose 结点挂载到tom
        System.out.println("table="+ table);

        Node may = new Node("May", null);
        table[3] = may;
        System.out.println("table="+ table);
    }

    static class Node{     //单个表节点
        Object item;
        Node next;

        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
