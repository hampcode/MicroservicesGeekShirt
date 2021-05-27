import { Component, OnInit } from '@angular/core';
import {Order} from "../../../models/Order";
import {OrderService} from "../../../services/order.service";

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders?:Order[];

  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
    this.orderService.getOrders()
      .subscribe( data=>{
                              this.orders=data;
                              console.log(data)},
                 error=> {
                              console.log(error);
                   });

  }

}
