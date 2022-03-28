package ru.shishkin.dao;

import org.springframework.stereotype.Component;
import ru.shishkin.config.ConnectionPool;
import ru.shishkin.model.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class PostgresNoteDAO implements NoteDAO{
    private static final String FIND_ALL = "SELECT * FROM notes";
    private static final String FIND_BY_ID = "SELECT * FROM notes WHERE id = ?";

    @Override
    public List<Note> findAll() {
        List<Note> notes = new ArrayList<>();

        try(Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Note note = new Note(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"));
                notes.add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }

    @Override
    public Note findById(int id) {
        return null;
    }
}
