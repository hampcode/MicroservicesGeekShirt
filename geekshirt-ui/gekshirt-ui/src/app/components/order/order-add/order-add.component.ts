import { Component, OnInit } from '@angular/core';
import {ItemOrder} from "../../../models/ItemOrder";
import {ItemOrders} from "../../../models/ItemOrders";
import {OrderService} from "../../../services/order.service";
import {Item} from "../../../models/Item";

@Component({
  selector: 'app-order-add',
  templateUrl: './order-add.component.html',
  styleUrls: ['./order-add.component.css']
})
export class OrderAddComponent implements OnInit {



  paid:boolean;
  productSelected:boolean;


  products:Item[]=[];
  order={} as ItemOrder;
  productItem: Item[]=[];

  constructor(private orderService:OrderService ) {
    this.paid=false;
    this.productSelected=false;

  }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(){
    this.products.push( { upc:1001,quantity:0,price:60 },
                        { upc:1002,quantity:0,price:50},
                        { upc:1003,quantity:0,price:10},
                        { upc:1004,quantity:0,price:140},
                        { upc:1005,quantity:0,price:132},
                        { upc:1006,quantity:0,price:122});
  }

  getProductIndex(item:Item):number{
    return this.productItem.findIndex(value => value.upc===item.upc);
  }

  isProductSelected(product: Item):boolean{
    return this.getProductIndex(product)>-1;
  }

  addToCart(product:Item){


  }
  removeFromCart(product:Item){

  }

  pay(){

  }

}
