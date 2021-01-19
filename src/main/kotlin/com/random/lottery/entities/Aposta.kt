package com.random.lottery.entities

import javax.persistence.*

@Entity
@Table(name = "APOSTA")
data class Aposta(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val email: String,
    val numeroAposta: Long
)
