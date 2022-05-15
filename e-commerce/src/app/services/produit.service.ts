import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class ProduitService {

    produitsSubject = new Subject<any[]>();
    private BASE_URL = 'https://e-commerce-d8b78-default-rtdb.europe-west1.firebasedatabase.app';

    private produits: { 
        id: number,
        nom: string,
        qte: number }[] = [];

    constructor(private httpclient: HttpClient) {}

    emitProduit() {
        this.produitsSubject.next(this.produits.slice());
    }

    getProduitById(id: number) {
        const produit = this.produits.find(
            (element) => {
                return element.id === id;
            }
        );
        return produit;
    }

    addProduit(nom: string, qte: number) {
        const produit = {
            id: 0,
            nom: '',
            qte: 0
        }

        produit.nom = nom;
        produit.qte = qte;
        produit.id = this.produits[(this.produits.length - 1)].id + 1;

        this.produits.push(produit);
        this.emitProduit();
    }

    saveProduitsToServer() {
        this.httpclient
            .put(`${this.BASE_URL}/produits.json`, this.produits)
            .subscribe({
                next: () => {
                    console.log('Enregistrement terminé');
                },
                error: (error) => {
                    console.log('Erreur de sauvegarde ! ' + error);
                }
            });
    }

    getProduitFromServer() {
        this.httpclient
            .get<any[]>(`${this.BASE_URL}/produits.json`)
            .subscribe({
                next: (response) => {
                    if (response !== null) {
                        this.produits = response;
                    }
                    else {
                        this.produits = [];
                    }
                    this.emitProduit();
                },
                error: (error) => {
                    console.log('Erreur lors du chargement ! ' + error);
                }
            });
    }
}