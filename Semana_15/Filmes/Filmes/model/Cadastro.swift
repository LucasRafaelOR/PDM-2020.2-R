//
//  Cadastro.swift
//  Filmes
//
//  Created by IFPB on 17/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

class Cadastro
{
    private var lista : Array<Filme>
    
    init()
    {
        self.lista = Array<Filme>()
    }
    
    func add(filme: Filme)
    {
        self.lista.append(filme)
    }
    
    func count() -> Int
    {
        return self.lista.count
    }
    
    func get() -> Array<Filme>
    {
        return self.lista
    }
}
