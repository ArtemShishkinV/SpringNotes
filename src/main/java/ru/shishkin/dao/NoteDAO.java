package ru.shishkin.dao;

import ru.shishkin.model.Note;

import java.util.List;

public interface NoteDAO {
    List<Note> findAll();

    Note findById(int id);
}
