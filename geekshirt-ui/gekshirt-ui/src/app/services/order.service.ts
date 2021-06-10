import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Order} from "../models/Order";
import {ItemOrders} from "../models/ItemOrders";
import {Observable} from "rxjs";
import {ItemOrder} from "../models/ItemOrder";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:8081/api/v1/order';


  getOrders(){
    return this.http.get<Order[]>(this.Url);
  }

  saveOrder(order:ItemOrder){
    return this.http.post(this.Url,order);
  }


}
