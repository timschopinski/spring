// director-edit.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DirectorService } from "../../service/director.service";

@Component({
  selector: 'app-director-create',
  templateUrl: 'director-create.component.html',
  styleUrls: ['director-create.component.css']
})
export class DirectorCreateComponent {
  directorName: string = '';
  directorAge: number = 0;

  constructor(private directorService: DirectorService, private router: Router) {}

  onSubmit(): void {
    const newDirector = {
      name: this.directorName,
      age: this.directorAge
    };

    this.directorService.createDirector(newDirector).subscribe(() => {
      this.router.navigate(['/directors']);
    });
  }
}
