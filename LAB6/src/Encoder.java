import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class Encoder extends FilterWriter {
    public Encoder (Writer writer) {
        super(writer);
    }

    public void write(String str, char keySymbol) throws IOException {
        char[] strByChar = str.toCharArray();
        for (char c : strByChar)
            super.write((int) c + (int) keySymbol);
        super.write('\n');
    }
}
