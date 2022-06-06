package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FileReaderCallable implements Callable<Map<String, Integer>> {

    private final String fileName;

    public FileReaderCallable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Map<String, Integer> call() {
        Map<String, Integer> result = new HashMap<>();
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

        return result;
    }

}
