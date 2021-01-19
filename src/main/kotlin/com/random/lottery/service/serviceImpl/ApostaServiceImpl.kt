package com.random.lottery.service.serviceImpl

import com.random.lottery.model.Aposta
import com.random.lottery.repository.ApostasRepository
import com.random.lottery.service.ApostaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class ApostaServiceImpl : ApostaService {

    @Autowired
    lateinit var apostasRepository: ApostasRepository

    override fun realizarAposta(email: String): Aposta {
        val numero = Random.nextLong()
        val aposta = Aposta(null, email, numero)

        return apostasRepository.save(aposta)
    }


    override fun getByEmail(email: String): Aposta? {

        return apostasRepository.findByEmail(email)
    }

    override fun getAll(): List<Aposta> {

        return this.apostasRepository.findAll().toList()
    }

    override fun count(): Long = this.apostasRepository.count()
}