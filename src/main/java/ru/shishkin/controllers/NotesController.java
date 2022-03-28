package ru.shishkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.shishkin.dao.NoteDAO;

@Controller
@RequestMapping("/notes")
public class NotesController {
    private final NoteDAO noteDAO;

    @Autowired
    public NotesController(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("notes", noteDAO.findAll());
        return "/notes/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return "/notes/show";
    }
}
