package com.random.lottery.service

import com.random.lottery.model.Aposta
import com.random.lottery.model.ApostaDTO
import org.springframework.stereotype.Service

@Service
interface ApostaService {

    fun realizarAposta(email: String): ApostaDTO
    fun getByEmail(email: String): ApostaDTO?
    fun getAll(): List<ApostaDTO>
    fun count(): Long

}