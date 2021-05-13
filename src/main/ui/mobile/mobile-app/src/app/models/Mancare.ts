import {Topping} from "./Topping";

export interface Mancare {
  id: number;
  nume: string;
  ingrediente:string;
  imagine: string;
  pret: number;
  gramaj: number;
  toppinguri: Array<Topping>;
}
