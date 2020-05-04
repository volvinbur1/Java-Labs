import java.io.FilterReader;
import java.io.Reader;

public class Decoder extends FilterReader {
    public Decoder(Reader reader){
        super(reader);
    }
}
