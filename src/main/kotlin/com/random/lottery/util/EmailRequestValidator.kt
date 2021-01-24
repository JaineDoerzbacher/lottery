package com.random.lottery.util

import com.random.lottery.dtos.EmailDTO
import com.random.lottery.gateway.repositories.ApostaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class EmailRequestValidator {
    @Autowired
    lateinit var apostaRepository: ApostaRepository

    private fun verificaArroba(emailDTO: EmailDTO) {

        val email = emailDTO.email

        if (!email.contains("@")) {
            throw IllegalArgumentException("O e-mail digitado não é válido")
        }

    }

    private fun emailDuplicado(emailDTO: EmailDTO) {

        val email = emailDTO.email

        if (apostaRepository.findByEmail(email).isNotEmpty()){
            throw IllegalArgumentException("O e-mail digitado já existe!")
        }
    }

    fun verifica(emailDTO: EmailDTO) {

        verificaArroba(emailDTO)
        emailDuplicado(emailDTO)
    }
}