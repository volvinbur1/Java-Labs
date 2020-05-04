import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FileHandlerTest {

    @Test
    public void TestCoder() {
        String sourceStr = "EncodeMe228";
        String rootDir = "E:\\Program\\Java\\LAB6\\";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(rootDir + "to_encode.txt"));
            writer.write(sourceStr);
            writer.write("\n");
            writer.close();
        }
        catch (Exception e) {
            return;
        }
        char keyChar = 'R';
        FileHandler encodeFirst = new FileHandler(rootDir + "to_encode.txt", rootDir + "encoded.txt", keyChar);
        encodeFirst.Encode();
        FileHandler decodeThen = new FileHandler( rootDir + "encoded.txt", rootDir + "decoded.txt", keyChar);
        decodeThen.Decode();

        String resultStr = null;
        try {
            Scanner scanner = new Scanner(new FileReader(rootDir + "decoded.txt"));
            while (scanner.hasNextLine()) 
                resultStr = scanner.nextLine();
        }
        catch (Exception e) {
            return;
        }
        assertEquals(sourceStr, resultStr);
    }
}