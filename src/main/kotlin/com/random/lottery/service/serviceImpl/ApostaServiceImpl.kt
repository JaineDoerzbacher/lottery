package com.random.lottery.service.serviceImpl

import com.random.lottery.model.Aposta
import com.random.lottery.model.ApostaDTO
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

    override fun realizarAposta(email: String): ApostaDTO {
        val numero = Random.nextLong()
        var aposta = Aposta(null, email, numero)
        aposta = apostasRepository.save(aposta)
        return ApostaDTO(aposta.email, aposta.numeroAposta)
    }


    override fun getByEmail(email: String): ApostaDTO? {

        val aposta =  apostasRepository.findByEmail(email)
        return ApostaDTO(aposta.email, aposta.numeroAposta )
    }

    override fun getAll(): List<ApostaDTO> {

        val apostas = apostasRepository.findAll().toList().sortedBy { it.email }
        val lista = ArrayList<ApostaDTO>()

        for (aposta in apostas){

            val apostaDTO = ApostaDTO(aposta.email, aposta.numeroAposta)
            lista.add(apostaDTO)
        }
        return lista
    }

    override fun count(): Long = this.apostasRepository.count()
}