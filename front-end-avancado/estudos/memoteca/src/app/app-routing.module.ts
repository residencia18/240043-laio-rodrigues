import { ExcluirPensamentoComponent } from './components/pensamentos/excluir-pensamento/excluir-pensamento.component';
import { NgModule } from '@angular/core';
import { RouteReuseStrategy, RouterModule, Routes } from '@angular/router';
import { CriarPensamentoComponent } from './components/pensamentos/criar-pensamento/criar-pensamento.component';
import { ListarPensamentoComponent } from './components/pensamentos/listar-pensamento/listar-pensamento.component';
import { EditarPensamentoComponent } from './components/pensamentos/editar-pensamento/editar-pensamento.component';
import { CustomReuseStrategy } from './components/pensamentos/listar-pensamento/custom-reuse-estrategy';

const routes: Routes = [
  { path: 'criarPensamento', component: CriarPensamentoComponent },
  { path: 'listarPensamento', component: ListarPensamentoComponent, data: { reuseComponent: true} },
  { path: 'pensamentos/excluirPensamento/:id', component: ExcluirPensamentoComponent },
  { path: 'pensamentos/editarPensamento/:id', component: EditarPensamentoComponent },
  { path: '', redirectTo: 'listarPensamento', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule],
  providers: [
    {provide: RouteReuseStrategy, useClass: CustomReuseStrategy}
  ]
})
export class AppRoutingModule { }
