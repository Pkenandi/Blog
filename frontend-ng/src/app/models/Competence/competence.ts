export class Competence {
  private _id: number;
  private _name: string;
  private _numberOfYear: number;

  constructor(id: number, name: string, numberOfYear: number) {
    this._id = id;
    this._name = name;
    this._numberOfYear = numberOfYear;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get numberOfYear(): number {
    return this._numberOfYear;
  }

  set numberOfYear(value: number) {
    this._numberOfYear = value;
  }
}
