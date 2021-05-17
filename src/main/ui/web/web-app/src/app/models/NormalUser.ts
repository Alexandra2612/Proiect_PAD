import {User} from "./User";

export class NormalUser implements User{
  constructor(public adrese: string,
  public email: string,
  public nickname: string,
  public nume: string,
  public parola: string,
  public phone_number: string,
  public prenume: string,
  public rol: string,
){}



}
