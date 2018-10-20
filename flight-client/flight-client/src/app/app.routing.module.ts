import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';



import { FlightComponent } from './flight/flight.component';
import {SchedulerComponent} from './scheduler/scheduler.component'

const routes: Routes = [
  { path: 'flight', component: FlightComponent },
  { path: 'scheduler', component: SchedulerComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }