package org.example.fileProcessors;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public List<String> GetFromFile(String p)  {

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(p))) {
            String line;
            while ((line = reader.readLine()) != null) lines.add(line);
        } catch (IOException e) {
            System.err.println("Error reading file: " + p);
            e.printStackTrace();
            System.exit(1);
        }

        return lines;
    }

    public void writeFile(String path, String prefix, String fileName, boolean append, String data) {
        if (data.isEmpty()) return;

        File file = new File(path, prefix + fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
                writer.write(data);
                writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing file: " + file.getPath());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
