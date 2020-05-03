import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReadWriteLock;

public class Main {
    private static List<String> fileLines = new ArrayList<>();

    private static boolean ReadLines(String filePath) {
        Scanner scanner = null;
        try {
            FileInputStream stream = new FileInputStream(filePath);
            scanner = new Scanner(stream);
            while (scanner.hasNextLine())
                fileLines.add(scanner.nextLine());
            scanner.close();
        }
        catch (Exception e) {
            if (scanner != null)
                scanner.close();
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static boolean WriteLines(String filePath) {
        OutputStreamWriter osw = null;
        try {
            FileOutputStream stream = new FileOutputStream(filePath);
            osw = new OutputStreamWriter(stream);
            for (String fileLine : fileLines) {
                osw.write(fileLine);
                osw.write('\n');
            }
            osw.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String rootPath = "E:\\Program\\Java\\LAB5";
        if (!ReadLines(rootPath+"\\input.txt"))
            return;
        fileLines.sort((String a, String b) -> {
            if (a.length() > b.length())
                return 1;
            if (a.length() < b.length())
                return -1;
            return 0;
        });
        WriteLines(rootPath + "\\output.txt");
    }
}
