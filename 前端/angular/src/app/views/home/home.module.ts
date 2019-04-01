import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { ToString } from 'src/app/pipes/to-string.pipe';

@NgModule({
  declarations: [
    HomeComponent,
    ToString
  ],
  imports: [
    CommonModule
  ]
})
export class HomeModule { }
