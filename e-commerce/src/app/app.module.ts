import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FourOhFourComponent } from './four-oh-four/four-oh-four.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProduitService } from './services/produit.service';
import { SingleProduitComponent } from './single-produit/single-produit.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NewProduitComponent } from './new-produit/new-produit.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CartService } from './services/cart.service';
import { CartComponent } from './cart/cart.component';
import { ProduitPanierComponent } from './produit-panier/produit-panier.component';
import { BanqueService } from './services/banque.service';

const appRoutes: Routes = [
    { path: 'produits', component: ProductListComponent },
    { path: 'new', component: NewProduitComponent },
    { path: '', component: ProductListComponent },
    { path: 'not-found', component: FourOhFourComponent },
    { path: '**', redirectTo: '/not-found' }
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    SingleProduitComponent,
    NewProduitComponent,
    CartComponent,
    ProduitPanierComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    NgbModule
  ],
  providers: [
      ProduitService,
      CartService,
      BanqueService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
