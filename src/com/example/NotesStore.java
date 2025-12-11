package com.example;

import java.io.*;
import java.util.*;

public class NotesStore {
    private static final String FILE_PATH = "data/notes.csv";

    public NotesStore() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String[]> loadNotes() {
        List<String[]> notes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";", 2);
                notes.add(parts);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return notes;
    }

    public void saveNotes(List<String[]> notes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String[] n : notes) {
                pw.println(n[0] + ";" + n[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int add(String text) {
        List<String[]> notes = loadNotes();
        int id = notes.size() == 0 ? 1 : Integer.parseInt(notes.get(notes.size() - 1)[0]) + 1;
        notes.add(new String[]{String.valueOf(id), text});
        saveNotes(notes);
        return id;
    }

    public boolean remove(int id) {
        List<String[]> notes = loadNotes();
        boolean removed = notes.removeIf(n -> Integer.parseInt(n[0]) == id);
        if (removed) saveNotes(notes);
        return removed;
    }

    public int count() {
        return loadNotes().size();
    }
}
