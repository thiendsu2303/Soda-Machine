package model;

import java.util.Arrays;
import java.util.List;

public class ListNote {
    public static final List<Note> NOTES = Arrays.asList(
            new Note(10000),
            new Note(20000),
            new Note(50000),
            new Note(100000),
            new Note(200000)
    );
}