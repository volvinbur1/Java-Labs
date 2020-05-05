import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CustomReader extends FilterReader {
    public CustomReader(java.io.Reader reader){
        super(reader);
    }

    public List<String> readLines() throws IOException {
        StringBuilder strCreator = new StringBuilder();
        List<String> resultList = new ArrayList<String>();
        int ch;
        while ((ch = super.read()) != -1) {
            if (ch == '\n' && strCreator.length() != 0) {
                resultList.add(strCreator.toString());
                strCreator = new StringBuilder();
                continue;
            }
            strCreator.append((char) ch);
        }
        return resultList;
    }

    public List<String> readLines(char keySymbol) throws IOException {
        StringBuilder strCreator = new StringBuilder();
        List<String> resultList = new ArrayList<String>();
        int ch;
        while ((ch = super.read()) != -1) {
            if (ch == '\n' && strCreator.length() != 0) {
                resultList.add(strCreator.toString());
                strCreator = new StringBuilder();
                continue;
            }
            strCreator.append((char) ( ch - (int)keySymbol));
        }
        return resultList;
    }
}
