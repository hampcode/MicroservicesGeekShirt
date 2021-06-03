import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {OrderListComponent} from "./components/order/order-list/order-list.component";
import {OrderAddComponent} from "./components/order/order-add/order-add.component";

const routes: Routes = [
  {path:'orders',component:OrderListComponent},
  {path:'orderAdd',component:OrderAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
