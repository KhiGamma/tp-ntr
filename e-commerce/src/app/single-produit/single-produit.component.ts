import { Component, Input, OnInit } from '@angular/core';

@Component({
    selector: 'app-single-produit',
    templateUrl: './single-produit.component.html',
    styleUrls: ['./single-produit.component.scss']
})
export class SingleProduitComponent implements OnInit {

    @Input() id: number;
    @Input() nom: string;
    @Input() qte: number;

    constructor() { }

    ngOnInit(): void {
    }

}
