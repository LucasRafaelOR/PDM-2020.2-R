//
//  FormViewController.swift
//  Filmes
//
//  Created by IFPB on 17/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//
 
import UIKit

class FormViewController: UIViewController {
    @IBOutlet weak var sliderNota: UISlider!
    @IBOutlet weak var stepperQtde: UIStepper!
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var switchOscar: UISwitch!
    @IBOutlet weak var lbValorNota: UILabel!
    @IBOutlet weak var lbValorQtde: UILabel!
    
    var indexEditar: Int?
    var cadastro: Cadastro!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.cadastro = (UIApplication.shared.delegate as! AppDelegate).cadastro
        // Do any additional setup after loading the view.
    }
    

    @IBAction func salvar(_ sender: Any) {
        let filme = Filme(nome: self.tfNome.text!, nota: Int(self.sliderNota!.value), oscar: self.switchOscar.isOn, qtdeAssistido: Int(self.stepperQtde!.value))
        
        if(self.indexEditar != nil)
        {
            self.cadastro.update(index: self.indexEditar!, filme: filme)
        }
        else
        {
            self.cadastro.add(filme: filme)
        }
        
        self.navigationController?.popViewController(animated: true)
    }
    

    @IBAction func sliderNotaChanged(_ sender: UISlider) {
        self.lbValorNota.text = "\(Int(self.sliderNota.value))"
    }
    
    @IBAction func stepperQtdeChanged(_ sender: UIStepper) {
        self.lbValorQtde.text = "\(Int(self.stepperQtde.value))"
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        
        
        
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        if(self.indexEditar != nil)
        {
            let filme = self.cadastro.get(index:self.indexEditar!)
            self.tfNome.text = filme.nome
            self.sliderNota.value = Float(filme.nota)
            self.stepperQtde.value = Double(filme.qtdeAssistido)
            self.switchOscar.isOn = filme.oscarNominado
        }
        self.lbValorQtde.text = "\(Int(self.stepperQtde.value))"
        self.lbValorNota.text = "\(Int(self.sliderNota.value))"
    }
    
}
    

