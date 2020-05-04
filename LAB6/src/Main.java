public class Main {

    public static void main(String[] args) {
	    char keyChar = 'a';
	    String rootDir = "E:\\Program\\Java\\LAB6\\";
        FileHandler encodeFirst = new FileHandler(rootDir + "to_encode.txt", rootDir + "encoded.txt", keyChar);
        encodeFirst.Encode();
        FileHandler decodeThen = new FileHandler( rootDir + "encoded.txt", rootDir + "decoded.txt", keyChar);
        decodeThen.Decode();
    }
}
