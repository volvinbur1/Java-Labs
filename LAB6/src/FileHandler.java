import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class FileHandler {
    private char keyChar;
    private FileReader fReader = null;
    private FileWriter fWriter = null;
    private CustomWriter customWriter = null;
    private CustomReader customReader = null;

    public FileHandler(String inputFile, String outputFile, char keyChar) {
        this.keyChar = keyChar;
        try {
            fReader = new FileReader(inputFile);
            this.customReader = new CustomReader(fReader);
            fWriter = new FileWriter(outputFile);
            customWriter = new CustomWriter(fWriter);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean Encode() {
        if (customReader == null || customWriter == null)
            return false;
        try {
            List<String> linesToEncode = customReader.readLines();
            for (String line : linesToEncode) {
                customWriter.write(line, keyChar);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            closeAllStreams();
            return false;
        }
        closeAllStreams();
        return true;
    }

    public boolean Decode() {
        if (customReader == null || customWriter == null)
            return false;
        try {
            List<String> linesToDecode = customReader.readLines(keyChar);
            for (String line : linesToDecode) {
                customWriter.write(line);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            closeAllStreams();
            return  false;
        }
        closeAllStreams();
        return true;
    }

    private void closeAllStreams() {
        try {
            if (fReader != null)
                fReader.close();
            if (fWriter != null)
                fWriter.close();
            if (customWriter != null)
                customWriter.close();
            if (customReader != null)
                customReader.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
