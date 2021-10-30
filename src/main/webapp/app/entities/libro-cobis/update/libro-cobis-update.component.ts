import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import * as dayjs from 'dayjs';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';

import { ILibroCobis, LibroCobis } from '../libro-cobis.model';
import { LibroCobisService } from '../service/libro-cobis.service';

@Component({
  selector: 'cobis-libro-cobis-update',
  templateUrl: './libro-cobis-update.component.html',
})
export class LibroCobisUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    nombre: [null, [Validators.maxLength(150)]],
    descripcion: [null, [Validators.maxLength(300)]],
    autor: [null, [Validators.maxLength(150)]],
    fechaPublicacion: [],
    numeroEjemplares: [],
    costo: [],
  });

  constructor(
    protected libroService: LibroCobisService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ libro }) => {
      if (libro.id === undefined) {
        const today = dayjs().startOf('day');
        libro.fechaPublicacion = today;
      }

      this.updateForm(libro);
    });
  }

  previousState(): void {
    this.router.navigate(['/']);
  }

  save(): void {
    this.isSaving = true;
    const libro = this.createFromForm();
    if (libro.id !== undefined) {
      this.subscribeToSaveResponse(this.libroService.update(libro));
    } else {
      this.subscribeToSaveResponse(this.libroService.create(libro));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ILibroCobis>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(libro: ILibroCobis): void {
    this.editForm.patchValue({
      id: libro.id,
      nombre: libro.nombre,
      descripcion: libro.descripcion,
      autor: libro.autor,
      fechaPublicacion: libro.fechaPublicacion ? libro.fechaPublicacion.format(DATE_TIME_FORMAT) : null,
      numeroEjemplares: libro.numeroEjemplares,
      costo: libro.costo,
    });
  }

  protected createFromForm(): ILibroCobis {
    return {
      ...new LibroCobis(),
      id: this.editForm.get(['id'])!.value,
      nombre: this.editForm.get(['nombre'])!.value,
      descripcion: this.editForm.get(['descripcion'])!.value,
      autor: this.editForm.get(['autor'])!.value,
      fechaPublicacion: this.editForm.get(['fechaPublicacion'])!.value
        ? dayjs(this.editForm.get(['fechaPublicacion'])!.value, DATE_TIME_FORMAT)
        : undefined,
      numeroEjemplares: this.editForm.get(['numeroEjemplares'])!.value,
      costo: this.editForm.get(['costo'])!.value,
    };
  }
}
