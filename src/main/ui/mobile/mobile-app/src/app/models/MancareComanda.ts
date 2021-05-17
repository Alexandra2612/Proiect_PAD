import {Topping} from "./Topping";

export interface MancareComanda {
  id: number;
  nume: string;
  nume_restaurant:string;
  ingrediente:string;
  imagine: string;
  pret: number;
  gramaj: number;
  toppinguri: Topping;
}
