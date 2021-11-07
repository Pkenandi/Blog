export class Projet {
  get imageUrl(): string {
    return this._imageUrl;
  }

  set imageUrl(value: string) {
    this._imageUrl = value;
  }
  private _id: number;
  private _projetName: string;
  private _start: Date;
  private _end: Date;
  private _techUsed: string;
  private _seulOuGroup: string;
  private _description: string;
  private _imageUrl: string;
  private _current: boolean;

  constructor(id: number, projetName: string, start: Date, end: Date, techUsed: string, seulOuGroup: string, description: string, imageUrl: string, current: boolean) {
    this._id = id;
    this._projetName = projetName;
    this._start = start;
    this._end = end;
    this._techUsed = techUsed;
    this._seulOuGroup = seulOuGroup;
    this._description = description;
    this._current = current;
    this._imageUrl = imageUrl;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get projetName(): string {
    return this._projetName;
  }

  set projetName(value: string) {
    this._projetName = value;
  }

  get start(): Date {
    return this._start;
  }

  set start(value: Date) {
    this._start = value;
  }

  get end(): Date {
    return this._end;
  }

  set end(value: Date) {
    this._end = value;
  }

  get techUsed(): string {
    return this._techUsed;
  }

  set techUsed(value: string) {
    this._techUsed = value;
  }

  get seulOuGroup(): string {
    return this._seulOuGroup;
  }

  set seulOuGroup(value: string) {
    this._seulOuGroup = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get current(): boolean {
    return this._current;
  }

  set current(value: boolean) {
    this._current = value;
  }
}
