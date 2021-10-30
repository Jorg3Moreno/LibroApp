import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ILibroCobis } from '../libro-cobis.model';

@Component({
  selector: 'cobis-libro-cobis-detail',
  templateUrl: './libro-cobis-detail.component.html',
})
export class LibroCobisDetailComponent implements OnInit {
  libro: ILibroCobis | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ libro }) => {
      this.libro = libro;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
