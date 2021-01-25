package com.random.lottery.services

import com.random.lottery.dtos.ApostaDTO
import com.random.lottery.dtos.EmailDTO
import org.springframework.stereotype.Service
/*
 *São serviços relacionados a Aposta
 */
interface ApostaService {

    /**
     * Funcão que realiza uma aposta para o e-mail recebido.
     * @param emailDTO [EmailDTO] - um email
     * @return [ApostaDTO] - aposta realizada
     */
    fun realizarAposta(emailDTO: EmailDTO): ApostaDTO

    /**
     * Função que busca uma aposta a partir do email recebido.
     * @param emailDTO [EmailDTO] - um email
     * @return [ApostaDTO]? - uma aposta caso encontrada
     */
    fun findByEmail(emailDTO: EmailDTO): List<ApostaDTO>

    /**
     * Funçao que lista todas as apostas registradas
     * @return [List]<[ApostaDTO]> - uma lista de apostas registradas
     */
    fun getAll(): List<ApostaDTO>

    /**
     * Funão que realiza a contagem da quantidade de apostas
     * @return [Long] - numero de apostas registradas
     */
    fun count(): Long


}