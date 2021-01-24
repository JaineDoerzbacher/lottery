package com.random.lottery.gateway.controller

import com.random.lottery.dtos.ApostaDTO
import com.random.lottery.dtos.EmailDTO
import com.random.lottery.dtos.ErrorMessage
import com.random.lottery.services.ApostaService
import com.random.lottery.util.EmailRequestValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/apostas"])
class ApostaController {

    @Autowired
    lateinit var apostaService: ApostaService

    @Autowired
    lateinit var emailRequestValidator: EmailRequestValidator

    @GetMapping("/email")
    fun findByEmail(@RequestBody emailDTO: EmailDTO): ResponseEntity<List<ApostaDTO>> {

        emailRequestValidator.verifica(emailDTO)
        val aposta = this.apostaService.findByEmail(emailDTO)

        return ResponseEntity(aposta, HttpStatus.OK)

    }

    @PostMapping()
    fun realizarAposta(@RequestBody emailDTO: EmailDTO): ResponseEntity<ApostaDTO> {

        emailRequestValidator.verifica(emailDTO)

        val criarAposta = this.apostaService.realizarAposta(emailDTO)

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