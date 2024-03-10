import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListaComponent } from './components/lista/lista.component';
import { DetalhesComponent } from './components/detalhes/detalhes.component';

const routes: Routes = [
  { path: 'cadastro', component:  FormularioComponent},
  { path: 'lista', component:  ListaComponent},
  { path: 'detalhe/:id', component:  DetalhesComponent},
  { path: 'editar/:id', component:  FormularioComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
