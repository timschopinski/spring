import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MovieListComponent} from "./movie/view/movie-list/movie-list.component";
import {MovieService} from "./movie/service/movie.service";
import {DirectorService} from "./director/service/director.service";
import {HttpClientModule} from "@angular/common/http";
import {MovieDetailComponent} from "./movie/view/movie-detail/movie-detail.component";
import {DirectorListComponent} from "./director/view/director-list/director-list.component";
import {DirectorDetailComponent} from "./director/view/director-detail/director-detail.component";
import {DirectorCreateComponent} from "./director/view/director-create/director-create.component";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {DirectorEditComponent} from "./director/view/director-edit/director-edit.component";
import {DirectorDeleteComponent} from "./director/view/director-delete/director-delte.component";
import {MovieCreateComponent} from "./movie/view/movie-create/movie-create.component";


@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    MovieDetailComponent,
    DirectorListComponent,
    DirectorDetailComponent,
    DirectorCreateComponent,
    DirectorEditComponent,
    DirectorDeleteComponent,
    MovieCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [MovieService, DirectorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
