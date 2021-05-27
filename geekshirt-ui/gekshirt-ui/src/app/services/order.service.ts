import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Order} from "../models/Order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:8081/api/v1/order';

  getOrders(){
    return this.http.get<Order[]>(this.Url);
  }

}
