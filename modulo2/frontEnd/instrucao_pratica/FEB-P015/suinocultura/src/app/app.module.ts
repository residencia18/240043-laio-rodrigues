import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastroSuinoComponent } from './components/cadastro-suino/cadastro-suino.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { ListagemSuinosComponent } from './components/listagem-suinos/listagem-suinos.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { IdadePipe } from './pipes/idade.pipe';
import { EditarSuinoComponent } from './components/editar-suino/editar-suino.component';
import { MAT_DIALOG_DEFAULT_OPTIONS, MatDialogModule } from '@angular/material/dialog';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async'
import { MatButtonModule } from '@angular/material/button'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input';
import { CadastrarPesoComponent } from './components/cadastrar-peso/cadastrar-peso.component'
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { EditarPesoComponent } from './components/editar-peso/editar-peso.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroSuinoComponent,
    ListagemSuinosComponent,
    IdadePipe,
    EditarSuinoComponent,
    CadastrarPesoComponent,
    EditarPesoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    NgMultiSelectDropDownModule
  ],
  providers: [
    {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {hasBackdrop: true}},
    provideAnimationsAsync('noop'),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
