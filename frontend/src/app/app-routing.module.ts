import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

/*
 Não é necessário utilzar as ROTAS para a tarefa passada. Mas um ponto importante no desenvolvimento
 em angular é o LazyLoading https://angular.io/guide/lazy-loading-ngmodules.
*/
const routes: Routes = [
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
