import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Order} from "../models/Order";
import {ItemOrders} from "../models/ItemOrders";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:8081/api/v1/order';

  private orders: ItemOrders= new ItemOrders();


  getOrders(){
    return this.http.get<Order[]>(this.Url);
  }
  create(data:any):Observable<any>{
    return this.http.post(this.Url,data);
  }
  get ProductsOrders(){
    return this.orders;
  }
  saveOrder(order:ItemOrders){
    return this.http.post(this.Url,order);
  }


}
