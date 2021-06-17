import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  loading=false;

  constructor(private fb:FormBuilder , private _snackBar: MatSnackBar ) {

    this.form=this.fb.group({
      user:['',Validators.required],
      password:['',Validators.required]
    })

  }

  ngOnInit(): void {
  }

  login(){
    const user = this.form.value.user;
    const password= this.form.value.password;

    if(user=="jtorres" && password=="admin123"){
      //Redireccionar algún lugar
      this.fakeLoading();

    }else{
      //Mostrariamos un mensaje de error
      this.openMessage();
      this.form.reset();

    }

  }

  openMessage(){
    this._snackBar.open("Usuario o contraseña son inválidos","Mensaje",{
      duration:5000,
      horizontalPosition:"center",
      verticalPosition:"bottom",
    });
  }


  fakeLoading(){
    this.loading=true;
    setTimeout(()=>{
      //Llamar al home

     this.loading=false;
    },2500)
  }









}
