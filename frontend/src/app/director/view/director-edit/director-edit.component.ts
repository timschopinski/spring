import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DirectorService } from "../../service/director.service";

@Component({
  selector: 'app-director-edit',
  templateUrl: 'director-edit.component.html',
  styleUrls: ['director-edit.component.css']
})
export class DirectorEditComponent implements OnInit {
  directorId: string = '';
  directorName: string = '';
  directorAge: number = 0;

  constructor(
    private directorService: DirectorService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.directorId = params['id'];
      this.directorService.getDirector(this.directorId).subscribe(director => {
        this.directorName = director.name;
        this.directorAge = director.age;
      });
    });
  }

  onSubmit(): void {
    const updatedDirector = {
      id: this.directorId,
      name: this.directorName,
      age: this.directorAge
    };

    this.directorService.putDirector(this.directorId, updatedDirector).subscribe(() => {
      this.router.navigate(['/directors']);
    });
  }
}
