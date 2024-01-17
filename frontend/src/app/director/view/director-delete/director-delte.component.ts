// director-delete.component.ts
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DirectorService } from "../../service/director.service";

@Component({
  selector: 'app-director-delete',
  templateUrl: 'director-delete.component.html',
  styleUrls: ['director-delete.component.css']
})
export class DirectorDeleteComponent implements OnInit {
  directorId: string = '';
  directorName: string = '';

  constructor(
    private directorService: DirectorService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // Get the director ID from the route parameters
    this.route.params.subscribe(params => {
      this.directorId = params['id'];
      // Fetch the director details using the ID
      this.directorService.getDirector(this.directorId).subscribe(director => {
        this.directorName = director.name;
      });
    });
  }

  onDelete(): void {
    this.directorService.deleteDirector(this.directorId).subscribe(() => {
      this.router.navigate(['/directors']);
    });
  }

  onCancel(): void {
    // Redirect back to the director details page
    this.router.navigate(['/directors', this.directorId]);
  }
}
