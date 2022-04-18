package nl.bos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Frames {
    private final List<Frame> framesRight = new ArrayList<>();
    private final List<Frame> framesLeft = new ArrayList<>();
    private final List<String> data = new ArrayList<>();

    public Frames(String input) {
        readFrames(input);
        initFrames();
    }

    List<Frame> getFramesRight() {
        return framesRight;
    }

    List<Frame> getFramesLeft() {
        return framesLeft;
    }

    private void readFrames(String input) {
        InputStream is;
        is = Walk.class.getClassLoader().getResourceAsStream(input);

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

    private void initFrames() {
        for (int i = 0; i < data.size(); i += 10) {
            List<String> frames = data.subList(i, i + 10);

            //right frames
            framesRight.add(new Frame(frames));

            //left frames (reverted!)
            List<String> framesReverted = new ArrayList<>(10);
            for (String frame : frames) {
                framesReverted.add(reverse(frame));
            }
            framesLeft.add(new Frame(framesReverted));
        }
    }

    private String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
