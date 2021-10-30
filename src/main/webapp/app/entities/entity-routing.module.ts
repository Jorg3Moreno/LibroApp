import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: '',
        data: { pageTitle: 'cobisApp.libro.home.title' },
        loadChildren: () => import('./libro-cobis/libro-cobis.module').then(m => m.LibroCobisModule),
      },
    ]),
  ],
})
export class EntityRoutingModule {}
