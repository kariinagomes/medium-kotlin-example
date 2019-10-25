package com.medium.ceepws.controller

import com.medium.ceepws.model.Note
import com.medium.ceepws.repository.NoteRepository
import com.medium.ceepws.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController //agora não precisamos mas indicar o @ResponseBody no fun list
@RequestMapping("/notes")
class NoteController (private val noteService: NoteService) {

   /* private val noteRepository: NoteRepository;

    @Autowired
    constructor(noteRepository: NoteRepository) {
        this.noteRepository = noteRepository;
    }*/

    @GetMapping
    fun list(): List<Note> {
        return noteService.all().toList()
    }

    @PostMapping
    fun add(@RequestBody note: Note): Note {
        return noteService.save(note)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note): Note {
        if (noteService.existsById(id)) {
            return noteService.alter(id, note)
        }
        return Note();
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        if (noteService.existsById(id)) {
            noteService.deleteById(id);
        }
    }
}