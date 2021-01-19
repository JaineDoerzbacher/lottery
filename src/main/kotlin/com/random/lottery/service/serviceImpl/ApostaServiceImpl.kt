package com.random.lottery.service.serviceImpl

import com.random.lottery.model.Aposta
import com.random.lottery.repository.ApostasRepository
import com.random.lottery.service.ApostaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class ApostaServiceImpl : ApostaService {

    @Autowired
  lateinit var  apostasRepository: ApostasRepository


    override fun create(aposta: Aposta) {
        TODO("Not yet implemented")
    }

    override fun getByEmail(email: String): Aposta? {
       return apostasRepository.
    }

    override fun getAll(): List<Aposta> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }
}