import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from './movie/view/movie-list/movie-list.component';
import {MovieDetailComponent} from "./movie/view/movie-detail/movie-detail.component";
import {DirectorListComponent} from "./director/view/director-list/director-list.component";
import {DirectorDetailComponent} from "./director/view/director-detail/director-detail.component";
import {DirectorCreateComponent} from "./director/view/director-create/director-create.component";
import {DirectorEditComponent} from "./director/view/director-edit/director-edit.component";
import {DirectorDeleteComponent} from "./director/view/director-delete/director-delte.component";
import {MovieCreateComponent} from "./movie/view/movie-create/movie-create.component";
// import { MovieFormComponent } from './movie-form/movie-form.component';

const routes: Routes = [
  { path: 'movies', component: MovieListComponent },
  { path: 'directors', component: DirectorListComponent },
  { path: 'directors/:id', component: DirectorDetailComponent },
  { path: 'directors/create', component: DirectorCreateComponent },
  { path: 'directors/:id/edit', component: DirectorEditComponent },
  { path: 'directors/:id/delete', component: DirectorDeleteComponent },
  { path: 'movies/:id', component: MovieDetailComponent },
  { path: 'movies/create/:id', component: MovieCreateComponent },
  { path: '', redirectTo: '/', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
