package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaderRunnable implements Runnable {

    private final String fileName;
    private final Map<String, Integer> result;

    public FileReaderRunnable(String fileName) {
        this.fileName = fileName;
        this.result = new HashMap<>();
    }

    @Override
    public void run() {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            for (String line : lines) {
                String [] words = line.split("\\s+");
                for (String w : words) {
                    if (result.containsKey(w)) {
                        result.put(w, result.get(w) + 1);
                    } else {
                        result.put(w, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
