export class Profile {
  private _id: number;
  private _content: string;


  constructor(id: number, content: string, imgUrl: string) {
    this._id = id;
    this._content = content;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get content(): string {
    return this._content;
  }

  set content(value: string) {
    this._content = value;
  }
}
