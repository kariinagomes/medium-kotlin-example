package com.medium.ceepws.controller

import com.medium.ceepws.model.Note
import com.medium.ceepws.repository.NoteRepository
import com.medium.ceepws.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun list(): ResponseEntity<List<Note>> {
        val allNotes = noteService.all().toList()
        return ResponseEntity.ok(allNotes)
    }

    @PostMapping
    fun add(@RequestBody note: Note): ResponseEntity<Note> {
        val savedNode = noteService.save(note)
        return ResponseEntity.ok(savedNode)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note> {
        if (noteService.existsById(id)) {
            val updatedNode = noteService.alter(id, note)
            return ResponseEntity.ok(updatedNode)
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        if (noteService.existsById(id)) {
            noteService.deleteById(id)
            return ResponseEntity.noContent().build()
            //return ResponseEntity.status(HttpStatus.ACCEPTED).build()
        }
        return ResponseEntity.notFound().build()
    }
}