import { Injectable } from "@angular/core";
import { Subject, Subscription } from "rxjs";

@Injectable()
export class CartService {
    
    panier: {id: number, nom: string}[] = [];
    panierSubject = new Subject<any[]>();

    emitPanier() {
        this.panierSubject.next(this.panier.slice());
    }

    addToCart(produit: any) {
        this.panier.push({id: produit.id, nom: produit.nom});
        this.emitPanier();
    }

    removeFromCart(id: number) {
        this.panier = this.panier.filter(element => element.id !== id);
        this.emitPanier();
    }
}