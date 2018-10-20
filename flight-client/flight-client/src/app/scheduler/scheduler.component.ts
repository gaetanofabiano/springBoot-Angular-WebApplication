import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {SchedulerService} from '../scheduler.service'
import {FlightSchedulerInput} from '../model/flight.scheduler.input.model';
import { MatInputModule } from '@angular/material/input';
@Component({
  selector: 'scheduler',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css']
})
export class SchedulerComponent implements OnInit {

 
  
  public name:string;

  public numberOfFligths:number;

  public probabilityOfDelayed:number;

  public probabilityOfCancelled:number;


  public done:boolean;
  constructor(private router: Router,private schedulerService: SchedulerService) { }

  ngOnInit() {
    this.done=false;
    
  }
  genereateScheduler():void{
   
    var scheduler= new FlightSchedulerInput();
  scheduler.name=this.name;

  scheduler.numberOfFligths=this.numberOfFligths;

  scheduler.probabilityOfDelayed=this.probabilityOfDelayed;

  scheduler.probabilityOfCancelled=this.probabilityOfCancelled;

 console.log(scheduler);
    this.schedulerService.createFlight(scheduler).subscribe( data => {
      this.done=true;
     
    });
    
  }
  isValid():boolean{
   return (this.name!="") &&  (this.numberOfFligths>0)  
   &&  (this.probabilityOfDelayed>0&&this.probabilityOfDelayed<50) 
   &&  (this.probabilityOfCancelled>0&&this.probabilityOfCancelled<50)
  }


}
