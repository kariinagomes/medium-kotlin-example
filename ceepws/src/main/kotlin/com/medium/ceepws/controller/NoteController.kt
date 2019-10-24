package com.medium.ceepws.controller

import com.medium.ceepws.model.Note
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController //agora não precisamos mas indicar o @ResponseBody no fun list
@RequestMapping("/notes")
class NoteController {

    @GetMapping
    fun list(): List<Note> {
        return listOf(Note("Leitura", "Livro de Spring Boot"),
                Note("Pesquisa", "Ambiente com Docker"))
    }
}