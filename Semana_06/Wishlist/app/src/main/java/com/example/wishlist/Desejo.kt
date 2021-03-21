package com.example.wishlist

import java.io.Serializable

class Desejo(var descricao: String, var valor: Float) : Serializable {
    override fun toString(): String {
        return String.format("${this.descricao} - R$ %.2f", valor)
    }
}