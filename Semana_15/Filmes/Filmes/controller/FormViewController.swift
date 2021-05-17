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
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    @IBAction func salvar(_ sender: Any) {
        let filme = Filme(nome: self.tfNome.text!, nota: Int(self.sliderNota!.value), oscar: self.switchOscar.isOn, qtdeAssistido: Int(self.stepperQtde!.value))
        
        (UIApplication.shared.delegate as! AppDelegate).cadastro.add(filme: filme)
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
        
        self.lbValorQtde.text = "\(Int(self.stepperQtde.value))"
        
        self.lbValorNota.text = "\(Int(self.sliderNota.value))"
        
    }
    
}
    

