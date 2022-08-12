package org.example;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemoryFileSearch{
    private List<String> lines;

    MemoryFileSearch(String path) throws IOException {
        this.lines = Files.readAllLines(Paths.get(path));

    }

    public List<String> search(String substring, String separator, int column) throws IOException {
        String word;
        ArrayList<String> result = new ArrayList<String>();
        for(String line : this.lines){
            word = line.split(separator)[column - 1];
            if (word.toLowerCase().indexOf(substring.toLowerCase()) == 0)
                result.add(word+" "+Arrays.toString(line.split(separator)));
        }
        return result;
    }
    public Integer columnCount(String separator){
        return this.lines.stream().limit(1).max(String::compareTo).get().split(separator).length;
    }
}
