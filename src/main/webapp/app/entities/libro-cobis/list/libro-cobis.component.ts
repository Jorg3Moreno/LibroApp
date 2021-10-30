import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { combineLatest } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ILibroCobis } from '../libro-cobis.model';

import { ASC, DESC, ITEMS_PER_PAGE, SORT } from 'app/config/pagination.constants';
import { LibroCobisService } from '../service/libro-cobis.service';
import { LibroCobisDeleteDialogComponent } from '../delete/libro-cobis-delete-dialog.component';

@Component({
  selector: 'cobis-libro-cobis',
  templateUrl: './libro-cobis.component.html',
})
export class LibroCobisComponent implements OnInit {
  libros?: ILibroCobis[];
  isLoading = false;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page?: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;

  fields: string[] = ['nombre', 'descripcion', 'autor', 'costo'];
  operators: string[] = ['contains', 'doesNotContain', 'equals', 'notEquals'];

  constructor(
    protected libroService: LibroCobisService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected modalService: NgbModal
  ) {}

  loadPage(page?: number, dontNavigate?: boolean): void {
    this.isLoading = true;
    const pageToLoad: number = page ?? this.page ?? 1;

    this.libroService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort(),
      })
      .subscribe(
        (res: HttpResponse<ILibroCobis[]>) => {
          this.isLoading = false;
          this.onSuccess(res.body, res.headers, pageToLoad, !dontNavigate);
        },
        () => {
          this.isLoading = false;
          this.onError();
        }
      );
  }

  ngOnInit(): void {
    this.handleNavigation();
  }

  trackId(index: number, item: ILibroCobis): number {
    return item.id!;
  }

  delete(libro: ILibroCobis): void {
    const modalRef = this.modalService.open(LibroCobisDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.libro = libro;
    // unsubscribe not needed because closed completes on modal close
    modalRef.closed.subscribe(reason => {
      if (reason === 'deleted') {
        this.loadPage();
      }
    });
  }

  searchByCriteria(field: string, operator: string, query: string): void {
    this.libroService.query({ [`${field}.${operator}`]: query }).subscribe(
      (res: HttpResponse<ILibroCobis[]>) => {
        this.isLoading = false;
        this.libros = res.body ?? [];
      },
      () => {
        this.isLoading = false;
        this.onError();
      }
    );
  }

  protected sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? ASC : DESC)];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected handleNavigation(): void {
    combineLatest([this.activatedRoute.data, this.activatedRoute.queryParamMap]).subscribe(([data, params]) => {
      const page = params.get('page');
      const pageNumber = +(page ?? 1);
      const sort = (params.get(SORT) ?? data['defaultSort']).split(',');
      const predicate = sort[0];
      const ascending = sort[1] === ASC;
      if (pageNumber !== this.page || predicate !== this.predicate || ascending !== this.ascending) {
        this.predicate = predicate;
        this.ascending = ascending;
        this.loadPage(pageNumber, true);
      }
    });
  }

  protected onSuccess(data: ILibroCobis[] | null, headers: HttpHeaders, page: number, navigate: boolean): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    if (navigate) {
      this.router.navigate(['/'], {
        queryParams: {
          page: this.page,
          size: this.itemsPerPage,
          sort: this.predicate + ',' + (this.ascending ? ASC : DESC),
        },
      });
    }
    this.libros = data ?? [];
    this.ngbPaginationPage = this.page;
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page ?? 1;
  }
}
