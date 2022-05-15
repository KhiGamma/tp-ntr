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

const appRoutes: Routes = [
    { path: '', component: ProductListComponent },
    { path: 'not-found', component: FourOhFourComponent },
    { path: '**', redirectTo: '/not-found' }
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    SingleProduitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
      ProduitService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
