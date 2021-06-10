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
  total: number;

  products:Item[]=[];

  order={} as ItemOrder;
  productItem: Item[]=[];

  constructor(private orderService:OrderService ) {
    this.paid=false;
    this.productSelected=false;
    this.total=0;

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
      this.productItem.push(product);
      console.log(product);
      this.productSelected=true;
      this.total=this.calculateTotal();

  }
  removeFromCart(product:Item){
    const index=this.getProductIndex(product);
    if(index>-1){
      this.productItem.splice(this.getProductIndex(product),1);
    }
    this.productSelected=false;
    this.total=this.calculateTotal();
  }

  pay(){
    this.order.accountId=1;
    this.order.items=this.productItem;
    console.log(this.order);

    this.orderService.saveOrder(this.order).subscribe();
    this.paid=true;

  }

  calculateTotal():number{
    let sum=0;
    this.productItem.forEach(value => {
      sum+=(value.price * value.quantity);
    });
    return sum;
  }


}
