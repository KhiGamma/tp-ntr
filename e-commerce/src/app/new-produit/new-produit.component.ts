import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Produit } from '../models/produit.model';
import { ProduitService } from '../services/produit.service';

@Component({
    selector: 'app-new-produit',
    templateUrl: './new-produit.component.html',
    styleUrls: ['./new-produit.component.scss']
})
export class NewProduitComponent implements OnInit {

    produitForm: FormGroup;

    constructor(private formBuilder: FormBuilder,
                private produitService: ProduitService,
                private router: Router) { }

    ngOnInit(): void {
        this.initForm();
    }

    initForm() {
        this.produitForm = this.formBuilder.group({
            nom: ['', Validators.required],
            qte: [0, Validators.required],
        })
    }

    onSubmit() {
        const formValue = this.produitForm.value;
        const newProduit = new Produit(
            formValue['nom'],
            formValue['qte']
        );
        this.produitService.addProduit(newProduit);
        this.router.navigate(['/']);
    }
}
