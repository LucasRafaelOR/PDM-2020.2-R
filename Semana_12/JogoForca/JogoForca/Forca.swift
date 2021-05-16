//
//  Forca.swift
//  JogoForca
//
//  Created by IFPB on 15/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

class Forca
{
    var palavra : Array<Character>
    var letrasJogadas : Array<Character>
    var dica : String
    var falhas : Int
    var maskedPalavra : Array<Character>
    
    init(palavra: String, dica: String) {
        self.palavra = Array(palavra.uppercased())
        self.letrasJogadas = Array()
        self.dica = dica
        self.falhas = 0
        self.maskedPalavra = Array(repeating: "_", count: self.palavra.count)
    }
    
    func isValid(letra:Character) -> Bool
    {
        return !self.letrasJogadas.contains(letra) && self.falhas < 10
    }
    
    func jogarLetra(letra: Character)
    {
        if(self.isValid(letra: letra))
        {
            self.letrasJogadas.append(letra)
            if(self.palavra.contains(letra))
            {
                for i in 0..<self.palavra.count{
                    if(palavra[i] == letra){
                        self.maskedPalavra[i] = letra
                    }
                }
            }
            else
            {
                self.falhas += 1
            }
        }
    }
    
    func isFinished() -> Bool
    {
        return self.palavra == self.maskedPalavra || self.falhas >= 10
    }
    
    func resultado() -> String?
    {
        if(self.isFinished())
        {
            if(self.palavra == self.maskedPalavra)
            {
                return "Ganhou"
            }
            else
            {
                return "Perdeu"
            }
        }
        else
        {
            return nil
        }
    }
}
