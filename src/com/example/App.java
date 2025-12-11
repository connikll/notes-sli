package com.example;

public class App {

    public static void main(String[] args) {
        String cmd = null;
        String text = null;
        Integer id = null;

        for (String arg : args) {
            if (arg.startsWith("--cmd=")) cmd = arg.substring(6);
            if (arg.startsWith("--text=")) text = arg.substring(7);
            if (arg.startsWith("--id=")) id = Integer.parseInt(arg.substring(5));
        }

        NotesStore store = new NotesStore();

        if ("add".equals(cmd)) {
            if (text == null) {
                System.out.println("No text provided");
                return;
            }
            int newId = store.add(text);
            System.out.println("Added #" + newId);
        }

        else if ("list".equals(cmd)) {
            var notes = store.loadNotes();
            if (notes.isEmpty()) {
                System.out.println("(empty)");
                return;
            }
            for (String[] n : notes) {
                System.out.println(n[0] + ";" + n[1]);
            }
        }

        else if ("rm".equals(cmd)) {
            if (id == null) {
                System.out.println("No id provided");
                return;
            }
            boolean ok = store.remove(id);
            if (!ok) System.out.println("Not found #" + id);
        }

        else if ("count".equals(cmd)) {
            System.out.println(store.count());
        }

        else {
            System.out.println("Unknown command");
        }
    }
}
