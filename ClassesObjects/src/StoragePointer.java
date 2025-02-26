public class StoragePointer {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int[] b = a;
        b[0] = 4;
        System.out.println(a[0]);
        System.out.println(b[0]);
    }
}
