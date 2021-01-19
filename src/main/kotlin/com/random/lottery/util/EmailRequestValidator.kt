package com.random.lottery.util

import com.random.lottery.dtos.EmailDTO
import org.springframework.stereotype.Service

@Service
class EmailRequestValidator {
    fun verificaArroba(emailDTO: EmailDTO): Boolean {

        val email = emailDTO.email

        return email.contains("@")
    }
}