package com.random.lottery.model

import javax.persistence.*

@Entity
@Table(name = "APOSTAS")
data class Aposta(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val email: String,
    val numeroAposta: Long
)
