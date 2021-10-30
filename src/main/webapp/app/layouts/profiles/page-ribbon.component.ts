import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'cobis-page-ribbon',
  template: `
    <div class="ribbon" *ngIf="true">
      <a href="">"Develop"</a>
    </div>
  `,
  styleUrls: ['./page-ribbon.component.scss'],
})
export class PageRibbonComponent {}
