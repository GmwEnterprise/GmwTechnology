import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [
    HomeComponent,
    NavComponent,
    FooterComponent,
    ContentComponent
  ],
  imports: [
    CommonModule
  ]
})
export class HomeModule { }
