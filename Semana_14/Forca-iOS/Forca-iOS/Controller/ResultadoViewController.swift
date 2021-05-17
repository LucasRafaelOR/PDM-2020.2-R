//
//  File.swift
//  Forca-iOS
//
//  Created by IFPB on 17/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class ResultadoViewController: UIViewController {
    
    var resultado : String?
    @IBOutlet weak var lbResultado: UILabel!
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.lbResultado.text = resultado
    }
    
    @IBAction func voltar(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
}
