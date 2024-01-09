import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PesquisaComponent } from './components/pesquisa/pesquisa.component';
import { CategoriasComponent } from './components/categorias/categorias.component';
import { FirstCategoriaComponent } from './components/first-categoria/first-categoria.component';
import { SecondCategoriaComponent } from './components/second-categoria/second-categoria.component';
import { ThirdCategoriaComponent } from './components/third-categoria/third-categoria.component';
import { LastCategoriaComponent } from './components/last-categoria/last-categoria.component';

@NgModule({
  declarations: [
    AppComponent,
    PesquisaComponent,
    CategoriasComponent,
    FirstCategoriaComponent,
    SecondCategoriaComponent,
    ThirdCategoriaComponent,
    LastCategoriaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
