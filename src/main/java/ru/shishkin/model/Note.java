package ru.shishkin.model;

import java.util.Objects;

public class Note {
    private int id;
    private String title;
    private String text;

    public Note(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return getId() == note.getId() && Objects.equals(getTitle(), note.getTitle()) && Objects.equals(getText(), note.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getText());
    }
}
