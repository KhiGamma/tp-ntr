import { Injectable } from "@angular/core";
import { Subject, Subscription } from "rxjs";

@Injectable()
export class CartService {
    
    panier: {id: number, nom: string, qte: number, prixTotal: number}[] = [];
    panierSubject = new Subject<any[]>();

    emitPanier() {
        this.panierSubject.next(this.panier.slice());
    }

    getProduitById(id: number) {
        const produit = this.panier.find(
            (element) => {
                return element.id === id;
            }
        );
        return produit;
    }

    addToCart(produit: any) {
        const myProduit = this.getProduitById(produit.id);

        if (myProduit !== undefined) {
            this.panier = this.panier.map<any>(element => {
                if(element.id === produit.id) {
                    element.qte = element.qte + 1;
                    element.prixTotal += produit.prix;
                }
                
                return element;
            });
        }
        else {
            this.panier.push({id: produit.id, nom: produit.nom, qte:1, prixTotal: produit.prix});
        }

        this.emitPanier();
    }

    removeFromCart(produit: any) {
        const myProduit = this.getProduitById(produit.id);

        if (myProduit !== undefined) {
            this.panier = this.panier.map<any>(element => {
                if(element.id === produit.id) {
                    element.qte = element.qte - 1;
                    element.prixTotal -= produit.prix;
                }
                
                return element;
            });
        }

        this.panier = this.panier.filter(element => element.qte > 0);
        this.emitPanier();
    }
}