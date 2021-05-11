import {Topping} from "./Topping";

export interface MancareComanda {
  id: number;
  nume: string;
  ingrediente:string;
  imagine: string;
  pret: number;
  gramaj: number;
  toppinguri: Topping;
}
