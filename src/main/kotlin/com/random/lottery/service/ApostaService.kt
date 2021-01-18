package com.random.lottery.service

import com.random.lottery.model.Aposta
import org.springframework.stereotype.Service

@Service
interface ApostaService {

    fun create(aposta: Aposta)
    fun getByEmail(email: String): Aposta?
    fun getAll(): List<Aposta>
    fun count(): Long

}