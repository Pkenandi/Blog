export class SocialMedia {
  private _id: number;
  private _mediaName: string;
  private _socialUrl: string;

  constructor(id: number, mediaName: string, socialUrl: string) {
    this._id = id;
    this._mediaName = mediaName;
    this._socialUrl = socialUrl;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get mediaName(): string {
    return this._mediaName;
  }

  set mediaName(value: string) {
    this._mediaName = value;
  }

  get socialUrl(): string {
    return this._socialUrl;
  }

  set socialUrl(value: string) {
    this._socialUrl = value;
  }
}
