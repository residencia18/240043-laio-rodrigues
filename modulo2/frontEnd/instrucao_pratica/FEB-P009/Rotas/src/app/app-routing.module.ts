import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RotaWikiComponent } from './components/rota-wiki/rota-wiki.component';
import { RotaJreaderComponent } from './components/rota-jreader/rota-jreader.component';
import { RotaUescAppComponent } from './components/rota-uesc-app/rota-uesc-app.component';

const routes: Routes = [
  { path: 'wiki', component: RotaWikiComponent},
  { path: 'jreader', component: RotaJreaderComponent},
  { path: 'uesc', component: RotaUescAppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
