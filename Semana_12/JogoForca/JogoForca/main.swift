//
//  main.swift
//  JogoForca
//
//  Created by IFPB on 15/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

var palavras = ["IFPB", "Valeria", "Paraiba", "Apple"]
var dicas = ["Melhor instituicao de ensino", "Melhor professora do IF", "Estado do nordeste do Brasil", "Grande empresa de tecnologia"]

var x = Int.random(in:0..<palavras.count)
var jogo = Forca(palavra: palavras[x], dica: dicas[x])

while(!jogo.isFinished())
{
    print("Dica: \(jogo.dica)")
    print("Letras jogadas: \(jogo.letrasJogadas)")
    print("Tentativas restantes: \(10 - jogo.falhas)")
    print("")
    print((String(jogo.maskedPalavra)))
    print("")
    print("Digite uma letra: ")
    let resposta = Array(readLine()!.uppercased())
    let letra = resposta[0]
    jogo.jogarLetra(letra: letra)
}

print(jogo.resultado()!)


