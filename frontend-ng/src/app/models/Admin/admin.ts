import {Role} from "../Role/role";
import {Education} from "../Education/education";
import {Interest} from "../Interest/interest";
import {Profile} from "../Profile/profile";
import { Competence } from "../Competence/competence";
import {Adresse} from "../Adresse/adresse";
import {Projet} from "../Projet/projet";
import {Langue} from "../Langue/langue";
import {Experience} from "../Experience/experience";
import {SocialMedia} from "../SocialMedia/social-media";

export class Admin {
  private _id: number;
  private _adminId: string;
  private _username: string;
  private _email: string;
  private _password: string;
  private _roles: Role[];
  private _educationDtoList: Education[];
  private _adresseDtoList: Adresse[];
  private _competenceDtoList: Competence[];
  private _centreInteretDtoList: Interest[];
  private _projetDtoList: Projet[];
  private _langueDtoList: Langue[];
  private _experienceDtoList: Experience[];
  private _socialMediaDtoList: SocialMedia[];
  private _profileDto: Profile;


  constructor(id: number, adminId: string, username: string, email: string, password: string, roles: Role[], educationDtoList: Education[], adresseDtoList: Adresse[], competenceDtoList: Competence[], centreInteretDtoList: Interest[], projetDtoList: Projet[], langueDtoList: Langue[], experienceDtoList: Experience[], socialMediaDtoList: SocialMedia[], profileDto: Profile) {
    this._id = id;
    this._adminId = adminId;
    this._username = username;
    this._email = email;
    this._password = password;
    this._roles = roles;
    this._educationDtoList = educationDtoList;
    this._adresseDtoList = adresseDtoList;
    this._competenceDtoList = competenceDtoList;
    this._centreInteretDtoList = centreInteretDtoList;
    this._projetDtoList = projetDtoList;
    this._langueDtoList = langueDtoList;
    this._experienceDtoList = experienceDtoList;
    this._socialMediaDtoList = socialMediaDtoList;
    this._profileDto = profileDto;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get adminId(): string {
    return this._adminId;
  }

  set adminId(value: string) {
    this._adminId = value;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get roles(): Role[] {
    return this._roles;
  }

  set roles(value: Role[]) {
    this._roles = value;
  }

  get educationDtoList(): Education[] {
    return this._educationDtoList;
  }

  set educationDtoList(value: Education[]) {
    this._educationDtoList = value;
  }

  get adresseDtoList(): Adresse[] {
    return this._adresseDtoList;
  }

  set adresseDtoList(value: Adresse[]) {
    this._adresseDtoList = value;
  }

  get competenceDtoList(): Competence[] {
    return this._competenceDtoList;
  }

  set competenceDtoList(value: Competence[]) {
    this._competenceDtoList = value;
  }

  get centreInteretDtoList(): Interest[] {
    return this._centreInteretDtoList;
  }

  set centreInteretDtoList(value: Interest[]) {
    this._centreInteretDtoList = value;
  }

  get projetDtoList(): Projet[] {
    return this._projetDtoList;
  }

  set projetDtoList(value: Projet[]) {
    this._projetDtoList = value;
  }

  get langueDtoList(): Langue[] {
    return this._langueDtoList;
  }

  set langueDtoList(value: Langue[]) {
    this._langueDtoList = value;
  }

  get experienceDtoList(): Experience[] {
    return this._experienceDtoList;
  }

  set experienceDtoList(value: Experience[]) {
    this._experienceDtoList = value;
  }

  get socialMediaDtoList(): SocialMedia[] {
    return this._socialMediaDtoList;
  }

  set socialMediaDtoList(value: SocialMedia[]) {
    this._socialMediaDtoList = value;
  }

  get profileDto(): Profile {
    return this._profileDto;
  }

  set profileDto(value: Profile) {
    this._profileDto = value;
  }
}
