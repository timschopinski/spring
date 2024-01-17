import {Movie} from "../../movie/model/movie";

export interface DirectorDetails {
  id: string;
  name: string;
  age: number;
  movies: Movie[];
}
