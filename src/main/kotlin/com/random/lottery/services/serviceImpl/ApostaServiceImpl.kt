package com.random.lottery.services.serviceImpl

import com.random.lottery.dtos.ApostaDTO
import com.random.lottery.dtos.EmailDTO
import com.random.lottery.entities.Aposta
import com.random.lottery.exceptions.EntityNotFoundException
import com.random.lottery.gateway.repositories.ApostaRepository
import com.random.lottery.services.ApostaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class ApostaServiceImpl : ApostaService {

    @Autowired
    lateinit var apostaRepository: ApostaRepository

    override fun realizarAposta(emailDTO: EmailDTO): ApostaDTO {
        val numero = Random.nextLong()
        var aposta = Aposta(null, emailDTO.email, numero)
        aposta = apostaRepository.save(aposta)
        return ApostaDTO(aposta.email, aposta.numeroAposta)
    }


    override fun findByEmail(emailDTO: EmailDTO): List<ApostaDTO> {

        val apostas = apostaRepository.findByEmail(emailDTO.email)
        if (apostas.isEmpty()) {
            throw EntityNotFoundException("E-mail não encontrado")
        }
        val lista = ArrayList<ApostaDTO>()
        for (aposta in apostas) {
            val x = ApostaDTO(aposta.email, aposta.numeroAposta)
            lista.add(x)
        }

        return lista
    }

    override fun getAll(): List<ApostaDTO> {

        val apostas = apostaRepository.findAll().toList().sortedBy { it.email }
        val lista = ArrayList<ApostaDTO>()

        for (aposta in apostas) {

            val apostaDTO = ApostaDTO(aposta.email, aposta.numeroAposta)
            lista.add(apostaDTO)
        }
        return lista
    }

    override fun count(): Long = this.apostaRepository.count()
}