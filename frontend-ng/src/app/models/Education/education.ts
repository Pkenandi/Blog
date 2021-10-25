export class Education {
  private _id: number;
  private _etablissement: string;
  private _degree: string;
  private _section: string;
  private _average: string;
  private _start: Date;
  private _expected_end: Date;
  private _current: string;
  private _image: string;

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get etablissement(): string {
    return this._etablissement;
  }

  get section(): string {
    return this._section;
  }

  set section(value: string) {
    this._section = value;
  }

  set etablissement(value: string) {
    this._etablissement = value;
  }

  get degree(): string {
    return this._degree;
  }

  set degree(value: string) {
    this._degree = value;
  }

  get average(): string {
    return this._average;
  }

  set average(value: string) {
    this._average = value;
  }

  get start(): Date {
    return this._start;
  }

  set start(value: Date) {
    this._start = value;
  }

  get expected_end(): Date {
    return this._expected_end;
  }

  set expected_end(value: Date) {
    this._expected_end = value;
  }

  get current(): string {
    return this._current;
  }

  set current(value: string) {
    this._current = value;
  }

  get image(): string {
    return this._image;
  }

  set image(value: string) {
    this._image = value;
  }
}
