import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'frontend';

  candidate = 'Ryan Fernandes';

  constructor(private service: AppService) {

  }

  ngOnInit() {}

  task3() {
    this.service.getCompanies().subscribe(result => {
    })
  }
}
