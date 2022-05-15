import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { BanqueService } from '../services/banque.service';
import { CartService } from '../services/cart.service';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

    panier: any[];
    numcompte = '23';
    panierSubscription: Subscription;

    constructor(private cartService: CartService,
                private banqueService: BanqueService) { }

    ngOnInit(): void {
        this.panierSubscription = this.cartService.panierSubject.subscribe({
            next: (panier: any[]) => {
                this.panier = panier;
            }
        });
        this.cartService.emitPanier();
    }

    onPay() {
        if (this.panier.length) {
            let sommeTotale = 0;

            for (let produit of this.panier) {
                sommeTotale += produit.prixTotal;
            }

            const operation = {
                type: 'debit',
                montant: sommeTotale,
                compte: this.numcompte
            };

            this.banqueService.debitercompte(operation);
        }
    }
}
