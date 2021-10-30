import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LibroCobisComponent } from '../list/libro-cobis.component';
import { LibroCobisDetailComponent } from '../detail/libro-cobis-detail.component';
import { LibroCobisUpdateComponent } from '../update/libro-cobis-update.component';
import { LibroCobisRoutingResolveService } from './libro-cobis-routing-resolve.service';

const libroRoute: Routes = [
  {
    path: '',
    component: LibroCobisComponent,
    data: {
      defaultSort: 'id,asc',
    },
  },
  {
    path: ':id/view',
    component: LibroCobisDetailComponent,
    resolve: {
      libro: LibroCobisRoutingResolveService,
    },
  },
  {
    path: 'new',
    component: LibroCobisUpdateComponent,
    resolve: {
      libro: LibroCobisRoutingResolveService,
    },
  },
  {
    path: ':id/edit',
    component: LibroCobisUpdateComponent,
    resolve: {
      libro: LibroCobisRoutingResolveService,
    },
  },
];

@NgModule({
  imports: [RouterModule.forChild(libroRoute)],
  exports: [RouterModule],
})
export class LibroCobisRoutingModule {}
