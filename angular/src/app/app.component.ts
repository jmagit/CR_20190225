import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  msg = 'angular';
  numPag = 0;
  listado: any;

  constructor(private http: HttpClient) {}

  cargar(delta: number) {
    this.numPag += delta;
    this.http.get(`http://localhost:5555/pelis?page=${this.numPag}`)
      .subscribe(
        data => this.listado = data,
        err => this.msg = err.message
      );
  }

  ngOnInit() {
    this.cargar(0);
  }
}
