package com.random.lottery.gateway.repositories

import com.random.lottery.dtos.ApostaDTO
import com.random.lottery.entities.Aposta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ApostaRepository : JpaRepository<Aposta, Long> {

    @Query("select a from Aposta a where a.email = :email ")
    fun findByEmail (@Param("email") email: String) : List<Aposta>


}