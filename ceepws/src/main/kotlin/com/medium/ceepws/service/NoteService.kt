package com.medium.ceepws.service

import com.medium.ceepws.model.Note
import com.medium.ceepws.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService (private val noteRepository: NoteRepository) {

    fun all(): List<Note> {
        return noteRepository.findAll().toList()
    }

    fun save(note: Note): Note {
        return noteRepository.save(note)
    }

    fun alter(id: Long, note: Note): Note {
        if (noteRepository.existsById(id)) {
            val safeNote = note.copy(id = id)
            return noteRepository.save(safeNote)
        }
        return Note()
    }

    fun deleteById(id: Long) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id)
        }
    }

    fun existsById(id: Long): Boolean {
        return noteRepository.existsById(id)
    }

/*

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
    }
*/

}