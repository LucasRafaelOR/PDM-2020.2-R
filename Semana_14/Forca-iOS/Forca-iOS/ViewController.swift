//
//  ViewController.swift
//  Forca-iOS
//
//  Created by IFPB on 17/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    var palavras = ["IFPB", "Valeria", "Paraiba", "Apple"]
    var dicas = ["Melhor instituicao de ensino", "Melhor professora do IF", "Estado do nordeste do Brasil", "Grande empresa de tecnologia"]
    
    
    @IBOutlet weak var qtdeLetras: UILabel!
    @IBOutlet weak var letrasJogadas: UILabel!
    @IBOutlet weak var tentativas: UILabel!
    @IBOutlet weak var tfLetra: UITextField!
    @IBOutlet weak var dica: UILabel!
    @IBOutlet weak var palavrasMask: UILabel!
    var jogo: Forca!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        let x = Int.random(in: 0..<palavras.count)
        self.jogo = Forca(palavra: self.palavras[x], dica: self.dicas[x])
        
    }

    @IBAction func jogarLetra(_ sender: Any) {
        let letra = Character(self.tfLetra.text!.uppercased())
        self.jogo.jogarLetra(letra: letra)
        self.refresh()
        if(self.jogo.isFinished())
        {
            let rvc = self.storyboard?.instantiateViewController(identifier: "view_resultado") as! ResultadoViewController
            rvc.resultado = self.jogo.resultado()
            self.present(rvc, animated: true, completion: nil)
        }
        
    }
    
    func refresh() {
        self.qtdeLetras.text = "\(self.jogo.palavra.count) letras"
        self.dica.text = self.jogo.dica
        self.tentativas.text = "\(self.jogo.falhas)"
        self.palavrasMask.text = String(self.jogo.maskedPalavra)
        self.letrasJogadas.text = String(self.jogo.letrasJogadas)
        self.tfLetra.text = ""
    }
    
     override func viewDidAppear(_ animated: Bool) {
           super.viewDidAppear(true)
           self.refresh()
       }
}

