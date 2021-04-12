import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  @Input() currentUser: any;
}
