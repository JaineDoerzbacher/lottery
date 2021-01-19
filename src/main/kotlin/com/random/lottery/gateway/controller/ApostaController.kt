package com.random.lottery.gateway.controller

import com.random.lottery.dtos.ApostaDTO
import com.random.lottery.dtos.ErrorMessage
import com.random.lottery.services.ApostaService
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
        var aposta = this.apostaService.findByEmail(email)

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