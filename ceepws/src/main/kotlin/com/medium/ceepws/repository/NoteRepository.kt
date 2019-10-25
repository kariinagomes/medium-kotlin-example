package com.medium.ceepws.repository

import com.medium.ceepws.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long>