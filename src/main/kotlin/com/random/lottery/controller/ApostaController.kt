package com.random.lottery.controller

import com.random.lottery.model.Aposta
import com.random.lottery.model.ApostaDTO
import com.random.lottery.model.ErrorMessage
import com.random.lottery.service.ApostaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/apostas"])
class ApostaController {

    @Autowired
    lateinit var apostaService: ApostaService

    @GetMapping("/{email}")
    fun getByEmail(@PathVariable email: String): ResponseEntity<Any> {
        var aposta = this.apostaService.getByEmail(email)

        return if (aposta != null)
            return ResponseEntity(aposta, HttpStatus.OK)
        else return ResponseEntity(
            ErrorMessage("Aposta nao localizada", "Aposta ${email} nao localizada"),
            HttpStatus.NOT_FOUND
        )
    }


    @PostMapping()
    fun realizarAposta(@RequestBody email: String): ResponseEntity<Any> {

        val criarAposta = this.apostaService.realizarAposta(email)

        return ResponseEntity(criarAposta, HttpStatus.CREATED)
    }

    @GetMapping()
    fun getAll(): ResponseEntity<List<ApostaDTO>> {

        val list = this.apostaService.getAll()
        val status = if (list.size == 0) HttpStatus.NOT_FOUND else HttpStatus.OK

        return ResponseEntity(list, status)
    }

    @GetMapping("/count")
    fun count(): ResponseEntity<Map<String, Long>> =
        ResponseEntity.ok().body(mapOf("count" to this.apostaService.count()))
}