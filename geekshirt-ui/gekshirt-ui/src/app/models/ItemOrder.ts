import {Item} from "./Item";

export class ItemOrder{
  accountId:number;
  items: Item;

  //constructor
  constructor(accountId:number,items: Item) {
    this.accountId=accountId;
    this.items=items;
  }
}

