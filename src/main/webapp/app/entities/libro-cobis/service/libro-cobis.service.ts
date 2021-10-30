import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as dayjs from 'dayjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { ILibroCobis, getLibroCobisIdentifier } from '../libro-cobis.model';

export type EntityResponseType = HttpResponse<ILibroCobis>;
export type EntityArrayResponseType = HttpResponse<ILibroCobis[]>;

@Injectable({ providedIn: 'root' })
export class LibroCobisService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/libros');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(libro: ILibroCobis): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(libro);
    return this.http
      .post<ILibroCobis>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(libro: ILibroCobis): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(libro);
    return this.http
      .put<ILibroCobis>(`${this.resourceUrl}/${getLibroCobisIdentifier(libro) as number}`, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  partialUpdate(libro: ILibroCobis): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(libro);
    return this.http
      .patch<ILibroCobis>(`${this.resourceUrl}/${getLibroCobisIdentifier(libro) as number}`, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ILibroCobis>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ILibroCobis[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  addLibroCobisToCollectionIfMissing(libroCollection: ILibroCobis[], ...librosToCheck: (ILibroCobis | null | undefined)[]): ILibroCobis[] {
    const libros: ILibroCobis[] = librosToCheck.filter(isPresent);
    if (libros.length > 0) {
      const libroCollectionIdentifiers = libroCollection.map(libroItem => getLibroCobisIdentifier(libroItem)!);
      const librosToAdd = libros.filter(libroItem => {
        const libroIdentifier = getLibroCobisIdentifier(libroItem);
        if (libroIdentifier == null || libroCollectionIdentifiers.includes(libroIdentifier)) {
          return false;
        }
        libroCollectionIdentifiers.push(libroIdentifier);
        return true;
      });
      return [...librosToAdd, ...libroCollection];
    }
    return libroCollection;
  }

  protected convertDateFromClient(libro: ILibroCobis): ILibroCobis {
    return Object.assign({}, libro, {
      fechaPublicacion: libro.fechaPublicacion?.isValid() ? libro.fechaPublicacion.toJSON() : undefined,
    });
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.fechaPublicacion = res.body.fechaPublicacion ? dayjs(res.body.fechaPublicacion) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((libro: ILibroCobis) => {
        libro.fechaPublicacion = libro.fechaPublicacion ? dayjs(libro.fechaPublicacion) : undefined;
      });
    }
    return res;
  }
}
