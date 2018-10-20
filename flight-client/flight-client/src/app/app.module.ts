import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { FlightComponent } from './flight/flight.component';
import { FlightServiceService } from './flight-service.service';
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app.routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialAppModule } from './material.module';
import { SchedulerComponent } from './scheduler/scheduler.component';


@NgModule({
  declarations: [
    AppComponent,
    FlightComponent,
    SchedulerComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    MaterialAppModule
  ],
  providers: [FlightServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
