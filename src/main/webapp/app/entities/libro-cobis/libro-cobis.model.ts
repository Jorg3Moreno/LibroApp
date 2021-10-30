import * as dayjs from 'dayjs';

export interface ILibroCobis {
  id?: number;
  nombre?: string | null;
  descripcion?: string | null;
  autor?: string | null;
  fechaPublicacion?: dayjs.Dayjs | null;
  numeroEjemplares?: number | null;
  costo?: number | null;
}

export class LibroCobis implements ILibroCobis {
  constructor(
    public id?: number,
    public nombre?: string | null,
    public descripcion?: string | null,
    public autor?: string | null,
    public fechaPublicacion?: dayjs.Dayjs | null,
    public numeroEjemplares?: number | null,
    public costo?: number | null
  ) {}
}

export function getLibroCobisIdentifier(libro: ILibroCobis): number | undefined {
  return libro.id;
}
