package com.random.lottery.repository

import com.random.lottery.model.Aposta
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ApostasRepository : PagingAndSortingRepository<Aposta, Long>