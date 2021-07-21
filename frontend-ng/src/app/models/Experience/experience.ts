export class Experience {
  private _id: number;
  private _realisedAt: string;
  private _start: Date;
  private _expected_end: Date;
  private _description: string;

  constructor(id: number, realisedAt: string, start: Date, expected_end: Date, description: string) {
    this._id = id;
    this._realisedAt = realisedAt;
    this._start = start;
    this._expected_end = expected_end;
    this._description = description;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get realisedAt(): string {
    return this._realisedAt;
  }

  set realisedAt(value: string) {
    this._realisedAt = value;
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

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }
}
