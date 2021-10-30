import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';
import { LibroCobisComponent } from './list/libro-cobis.component';
import { LibroCobisDetailComponent } from './detail/libro-cobis-detail.component';
import { LibroCobisUpdateComponent } from './update/libro-cobis-update.component';
import { LibroCobisDeleteDialogComponent } from './delete/libro-cobis-delete-dialog.component';
import { LibroCobisRoutingModule } from './route/libro-cobis-routing.module';

@NgModule({
  imports: [SharedModule, LibroCobisRoutingModule],
  declarations: [LibroCobisComponent, LibroCobisDetailComponent, LibroCobisUpdateComponent, LibroCobisDeleteDialogComponent],
  entryComponents: [LibroCobisDeleteDialogComponent],
})
export class LibroCobisModule {}
