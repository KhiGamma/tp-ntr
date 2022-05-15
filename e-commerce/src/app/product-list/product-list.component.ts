import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ProduitService } from '../services/produit.service';

@Component({
    selector: 'app-product-list',
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

    produits: any[];
    produitSubscription: Subscription;

    constructor(private produitService: ProduitService) { }

    ngOnInit(): void {
        this.produitSubscription = this.produitService.produitsSubject.subscribe({
            next: (produits: any[]) => {
                this.produits = produits;
            }
        });
        this.produitService.emitProduit();
    }

    onSave() {
        this.produitService.saveProduitsToServer();
    }

    onFetch() {
        this.produitService.getProduitFromServer();
    }
}
