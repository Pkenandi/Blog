export class Adresse {
  private _id: number;
  private _avenue: string;
  private _pays: string;
  private _ville: string;
  private _phone: string;
  private _email: string;

  constructor(id: number, avenue: string, pays: string, ville: string, phone: string, email: string) {
    this._id = id;
    this._avenue = avenue;
    this._pays = pays;
    this._ville = ville;
    this._phone = phone;
    this._email = email;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get avenue(): string {
    return this._avenue;
  }

  set avenue(value: string) {
    this._avenue = value;
  }

  get pays(): string {
    return this._pays;
  }

  set pays(value: string) {
    this._pays = value;
  }

  get ville(): string {
    return this._ville;
  }

  set ville(value: string) {
    this._ville = value;
  }

  get phone(): string {
    return this._phone;
  }

  set phone(value: string) {
    this._phone = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }
}
