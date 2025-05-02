package ReaderSimulation;

public class Test_ {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader = new BufferedReader_(new FileReader_());
        bufferedReader.readFiles(3);

        BufferedReader_ bufferedReader_ = new BufferedReader_(new StringReader_());
        bufferedReader_.readStrings(2);
    }
}
