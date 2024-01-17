import { Director } from "../../director/model/director";


export interface MovieDetails {
  id: string;
  title: string;
  releaseYear: number;
  director: Director;
}
