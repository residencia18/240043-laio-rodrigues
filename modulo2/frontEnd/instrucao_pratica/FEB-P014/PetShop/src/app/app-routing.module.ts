import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListaComponent } from './components/lista/lista.component';
import { DetalhesComponent } from './components/detalhes/detalhes.component';
import { LoginComponent } from './components/login/login.component';
import { autenticadorGuard } from './services/autenticador.guard';

const routes: Routes = [
  { path: 'cadastro', component: FormularioComponent , canActivate: [autenticadorGuard] },
  { path: 'lista', component: ListaComponent , canActivate: [autenticadorGuard] },
  { path: 'detalhe/:id', component: DetalhesComponent , canActivate: [autenticadorGuard] },
  { path: 'editar/:id', component: FormularioComponent , canActivate: [autenticadorGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: LoginComponent },
  { path: '**', redirectTo: '/login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
