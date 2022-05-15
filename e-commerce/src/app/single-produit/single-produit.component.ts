import { Component, Input, OnInit } from '@angular/core';
import { Produit } from '../models/produit.model';
import { CartService } from '../services/cart.service';
import { ProduitService } from '../services/produit.service';

@Component({
    selector: 'app-single-produit',
    templateUrl: './single-produit.component.html',
    styleUrls: ['./single-produit.component.scss']
})
export class SingleProduitComponent implements OnInit {

    @Input() id: number;
    @Input() nom: string;
    @Input() qte: number;
    @Input() index: number;
    @Input() prix: number;

    constructor(private produitService : ProduitService,
                private cartservice: CartService) { }

    ngOnInit(): void {
    }

    addToCart() {
        const produit = this.produitService.getfromIndex(this.index);
        this.cartservice.addToCart(produit);
        this.produitService.removeOneItem(produit.id);
    }

    removeFromCart() {
        const produit = this.produitService.getfromIndex(this.index);
        this.cartservice.removeFromCart(produit);
        this.produitService.addOneItem(produit.id);
    }

}
