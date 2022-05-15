import { Component, Input, OnInit } from '@angular/core';

@Component({
    selector: 'app-produit-panier',
    templateUrl: './produit-panier.component.html',
    styleUrls: ['./produit-panier.component.scss']
})
export class ProduitPanierComponent implements OnInit {

    @Input() nom: string;

    constructor() { }

    ngOnInit(): void {
    }

}
