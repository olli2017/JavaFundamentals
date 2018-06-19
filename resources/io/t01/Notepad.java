import java.util.Arrays;


public class Notepad {
    private Note[] notes;
    private int index;

    public Notepad() {
        notes = new Note[6];
    }

    public Notepad(int initialCapacity) {
        notes = new Note[initialCapacity];
    }

    public void addNote(String title, String body) {
        if (index == notes.length) {
            notes = Arrays.copyOf(notes, notes.length * 2);
        }

        notes[index++] = new Note().setTitle(title).setBody(body);
    }

    public void editNote(int editedIndex, String body) {
        notes[editedIndex] = notes[editedIndex].setBody(body);
    }

    public void deleteNote(int deletedIndex) {
        if (index == deletedIndex)
            notes[deletedIndex] = null;

        for (int i = deletedIndex; i < index; i++) {
            notes[i] = notes[i+1];
        }
    }

    public void printAllNotes() {
        for (int i = 0; i < index; i++) {
            System.out.println(notes[i].toString());
        }
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.addNote("Aydar", "Hye");
        notepad.addNote("Aydar", "Hye");
        notepad.addNote("Aydar", "Hye");
        notepad.addNote("Aydar", "Hye");
        notepad.addNote("Aydar", "Hye");
        notepad.addNote("Aydar", "Hye");
        notepad.addNote("Aydar", "Hye");
        notepad.printAllNotes();
    }
}
