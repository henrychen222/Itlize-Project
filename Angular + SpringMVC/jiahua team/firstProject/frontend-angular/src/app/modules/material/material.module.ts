import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule,
  MatCheckboxModule,
  MatCardModule,
  MatFormFieldModule,
  MatDatepickerModule,
  MatRadioModule,
  MatSelectModule,
  MatIconModule,
  MatInputModule,
  MatAutocompleteModule,
  MatExpansionModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Ng5SliderModule } from 'ng5-slider';
import { NouisliderModule } from 'ng2-nouislider';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatCardModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatRadioModule,
    MatSelectModule,
    MatIconModule,
    MatInputModule,
    MatAutocompleteModule,
    MatExpansionModule,
    Ng5SliderModule,
    NouisliderModule
  ],
  exports: [
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatCardModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatRadioModule,
    MatSelectModule,
    MatIconModule,
    MatInputModule,
    MatAutocompleteModule,
    MatExpansionModule,
    Ng5SliderModule,
    NouisliderModule
  ]
})
export class MaterialModule {}
