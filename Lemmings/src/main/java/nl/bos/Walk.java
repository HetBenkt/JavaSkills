package nl.bos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Walk {
    private static final Logger logger = Logger.getLogger(Walk.class.getName());

    private static final List<String> data = new ArrayList<>();

    static {
        InputStream is;
        is = Walk.class.getClassLoader().getResourceAsStream("frames");

        try (InputStreamReader streamReader = new InputStreamReader(
                Objects.requireNonNull(is),
                StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new LemmingsException("Frames input not found!", e);
        }
    }

    public static void main(String[] args) {
        List<nl.bos.Frame> frames = new ArrayList<>();

        for (int i = 0; i < data.size(); i += 10) {
            frames.add(new Frame(data.subList(i, i + 10)));
        }
    }
}
