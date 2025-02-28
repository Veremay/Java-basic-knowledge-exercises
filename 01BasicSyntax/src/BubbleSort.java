public class BubbleSort {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided. Please provide integer values.");
            return;
        }

        int[] numbers = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer: " + args[i]);
                return;
            }
        }

        int n = numbers.length;
        if (n <= 1){
            System.out.println("Invalid Array");
        }else {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers.length - i - 1; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }

                for (int num : numbers) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
