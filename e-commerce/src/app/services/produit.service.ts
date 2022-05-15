import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { Produit } from "../models/produit.model";

@Injectable()
export class ProduitService {

    produitsSubject = new Subject<any[]>();
    private BASE_URL = 'https://e-commerce-d8b78-default-rtdb.europe-west1.firebasedatabase.app';

    private produits: { 
        id: number,
        nom: string,
        qte: number,
        prix: number }[] = [];

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

    addProduit(produit: Produit) {
        const produitObject = {
            id: 0,
            nom: '',
            qte: 0,
            prix : 0
        }

        produitObject.nom = produit.nom;
        produitObject.qte = produit.qte;
        produitObject.prix = produit.prix;
        produitObject.id = (this.produits.length)? this.produits[(this.produits.length - 1)].id + 1 : 1;

        this.produits.push(produitObject);
        this.emitProduit();
    }

    getfromIndex(index: number) {
        return this.produits[index];
    }

    removeOneItem(id: number) {
        this.produits = this.produits.map<any>(element => {
            if(element.id === id) {
                element.qte = element.qte - 1;
            }

            return element;
        });

        this.emitProduit();
    }

    addOneItem(id: number) {
        this.produits = this.produits.map<any>(element => {
            if(element.id === id) {
                element.qte = element.qte + 1;
            }

            return element;
        });

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