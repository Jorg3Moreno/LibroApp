import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ILibroCobis } from '../libro-cobis.model';
import { LibroCobisService } from '../service/libro-cobis.service';

@Component({
  templateUrl: './libro-cobis-delete-dialog.component.html',
})
export class LibroCobisDeleteDialogComponent {
  libro?: ILibroCobis;

  constructor(protected libroService: LibroCobisService, protected activeModal: NgbActiveModal) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.libroService.delete(id).subscribe(() => {
      this.activeModal.close('deleted');
    });
  }
}
