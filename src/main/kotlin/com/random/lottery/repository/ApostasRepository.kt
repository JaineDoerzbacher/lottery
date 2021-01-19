package com.random.lottery.repository

import com.random.lottery.model.Aposta
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ApostasRepository : PagingAndSortingRepository<Aposta, Long>{

    @Query(
        value = "select a from Aposta a where a.email = :email"
    )
    fun findByEmail(@Param("email") email: String): Aposta
}