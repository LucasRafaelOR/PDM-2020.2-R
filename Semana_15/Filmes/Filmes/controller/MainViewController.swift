//
//  ViewController.swift
//  Filmes
//
//  Created by IFPB on 17/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {
    @IBOutlet weak var lbQtde: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        let qtde = (UIApplication.shared.delegate as! AppDelegate).cadastro.count()
        self.lbQtde.text = "\(qtde)"
    }
}

