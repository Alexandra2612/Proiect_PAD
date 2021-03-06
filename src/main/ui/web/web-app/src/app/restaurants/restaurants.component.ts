import {Component, Input, OnInit} from '@angular/core';
import {RestaurantsService} from "../services/restaurants.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {
  restaurantid = 1;
  restaurant = 4;
 public restaurants: any= [];


  constructor(private restaurantsService: RestaurantsService, private router:Router) {

  }
  id=1;

  ngOnInit(): void {


    this.restaurantsService.getAll()
      .subscribe(data => {
        for (const d of (data as any)) {
          this.restaurants.push({
            id: this.id,
            nume: d.nume,
            imagine: d.imagine,
            adresa:d.adresa,
            descriere:d.descriere,
            meniu:d.meniu,
          });
          this.id+=1;
        }
        console.log(this.restaurants);
      }, err=>console.log(err)
      );
    console.log(this.restaurants);

  }

  Click(id:string) {

    this.router.navigateByUrl("/restaurant/"+id);
    //location.reload()
    //routerLink="/restaurant/{{rest.id}}"

  }
}
