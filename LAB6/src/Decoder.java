import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class Decoder extends FilterReader {
    public Decoder(Reader reader){
        super(reader);
    }

    public String readLine() throws IOException {
        StringBuilder resultingStr = new StringBuilder();
        int ch;
        while ((ch = super.read()) != -1) {
            if (ch == '\n')
            resultingStr.append(ch);
        }
        return resultingStr.toString();
    }

    public String read(char keySymbol) throws IOException {
        StringBuilder resultingStr = new StringBuilder();
        int ch;
        while ((ch = super.read()) != -1)
            resultingStr.append(ch - (int) keySymbol);
        return resultingStr.toString();
    }
}
