import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { MenuComponent } from './components/menu/menu.component';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { DestaquesComponent } from './components/destaques/destaques.component';
import { ServicosComponent } from './components/servicos/servicos.component';
import { ResultadosComponent } from './components/resultados/resultados.component';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    NoticiasComponent,
    DestaquesComponent,
    ServicosComponent,
    ResultadosComponent,
    FooterComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
