export class Langue {
  private _id: number;
  private _name: string;
  private _level: string;

  constructor(id: number, name: string, level: string) {
    this._id = id;
    this._name = name;
    this._level = level;
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

  get level(): string {
    return this._level;
  }

  set level(value: string) {
    this._level = value;
  }
}
