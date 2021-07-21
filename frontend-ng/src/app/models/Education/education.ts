export class Education {
  private _id: number;
  private _etablissement: string;
  private _degree: string;
  private _average: string;
  private _start: Date;
  private _expected_end: Date;
  private _current: boolean;

  constructor(id: number, etablissement: string, degree: string, average: string, start: Date, expected_end: Date, current: boolean) {
    this._id = id;
    this._etablissement = etablissement;
    this._degree = degree;
    this._average = average;
    this._start = start;
    this._expected_end = expected_end;
    this._current = current;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get etablissement(): string {
    return this._etablissement;
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

  get current(): boolean {
    return this._current;
  }

  set current(value: boolean) {
    this._current = value;
  }
}
