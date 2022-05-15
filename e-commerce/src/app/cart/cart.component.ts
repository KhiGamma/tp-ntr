import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { CartService } from '../services/cart.service';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

    panier: any[];
    panierSubscription: Subscription;

    constructor(private cartService: CartService) { }

    ngOnInit(): void {
        this.panierSubscription = this.cartService.panierSubject.subscribe({
            next: (panier: any[]) => {
                this.panier = panier;
            }
        });
        this.cartService.emitPanier();
    }

}
