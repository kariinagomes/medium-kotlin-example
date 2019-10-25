package com.medium.ceepws.controller

import com.medium.ceepws.model.Note
import com.medium.ceepws.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController //agora não precisamos mas indicar o @ResponseBody no fun list
@RequestMapping("/notes")
class NoteController {

    @Autowired
    lateinit var noteRepository: NoteRepository;

    @GetMapping
    fun list(): List<Note> {
        return noteRepository.findAll().toList();
        /*return listOf(Note("Leitura", "Livro de Spring Boot"),
                Note("Pesquisa", "Ambiente com Docker"))*/
    }

    @PostMapping
    fun add(@RequestBody note: Note): Note {
        return noteRepository.save(note);
        //return note;
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note): Note {
        if (noteRepository.existsById(id)) {
            val safeNote = note.copy(id = id);
            return noteRepository.save(safeNote);
        }

        return Note();
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
    }
}