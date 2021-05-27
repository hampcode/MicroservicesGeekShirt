export class Order{
   orderId:String;
   status:String;
   accountId: String;
   totalAmount:number;
   totalTax:number;
   transactionDate:Date;

   constructor() {
     this.orderId="";
     this.status="";
     this.accountId="";
     this.totalAmount=0;
     this.totalTax=0;
     this.transactionDate= new Date();
   }

}
