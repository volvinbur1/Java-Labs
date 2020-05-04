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
            if (ch == '\n') {
                resultList.add(strCreator.toString());
                strCreator = new StringBuilder();
                continue;
            }
            strCreator.append(ch);
        }
        return resultList;
    }

    public String read(char keySymbol) throws IOException {
        StringBuilder resultingStr = new StringBuilder();
        int ch;
        while ((ch = super.read()) != -1)
            resultingStr.append(ch - (int) keySymbol);
        return resultingStr.toString();
    }
}
