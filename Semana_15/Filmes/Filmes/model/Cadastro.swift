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
    
    func get(index: Int) -> Filme
    {
        return self.lista[index]
    }
    
    func remove(index: Int)
    {
        self.lista.remove(at: index)
    }
    
    func move(de: Int, para: Int)
    {
        self.lista.swapAt(de, para)
    }
    
    func update(index: Int, filme: Filme)
    {
        self.lista[index] = filme
    }
}
