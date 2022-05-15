import { Component, Input, OnInit } from '@angular/core';
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

    constructor(private produitService : ProduitService,
                private cartservice: CartService) { }

    ngOnInit(): void {
    }

    addToCart() {
        const produit = this.produitService.getfromIndex(this.index);
        this.cartservice.addToCart(produit);
    }

    removeFromCart() {
        this.cartservice.removeFromCart(this.id);
    }

}
