import java.io.FilterWriter;
import java.io.Writer;

public class Encoder extends FilterWriter {
    public Encoder (Writer writer) {
        super(writer);
    }
}
