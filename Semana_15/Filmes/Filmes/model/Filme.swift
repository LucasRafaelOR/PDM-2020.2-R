//
//  Filme.swift
//  Filmes
//
//  Created by IFPB on 17/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

class Filme
{
    var nome: String
    var nota: Int
    var oscarNominado: Bool
    var qtdeAssistido: Int
    
    init(nome: String, nota: Int, oscar: Bool, qtdeAssistido: Int) {
        self.nome = nome
        self.nota = nota
        self.oscarNominado = oscar
        self.qtdeAssistido = qtdeAssistido
    }
}
