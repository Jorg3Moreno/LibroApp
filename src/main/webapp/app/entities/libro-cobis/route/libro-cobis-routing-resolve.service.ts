import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { ILibroCobis, LibroCobis } from '../libro-cobis.model';
import { LibroCobisService } from '../service/libro-cobis.service';

@Injectable({ providedIn: 'root' })
export class LibroCobisRoutingResolveService implements Resolve<ILibroCobis> {
  constructor(protected service: LibroCobisService, protected router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ILibroCobis> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        mergeMap((libro: HttpResponse<LibroCobis>) => {
          if (libro.body) {
            return of(libro.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new LibroCobis());
  }
}
