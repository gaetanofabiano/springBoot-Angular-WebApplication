import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FlightSchedulerInput } from './model/flight.scheduler.input.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class SchedulerService {

  constructor(private http:HttpClient) { }
  private simulatorUrl = 'http://localhost:8080/simulator';

  
  public createFlight(scheduler: FlightSchedulerInput) {
    return this.http.post<FlightSchedulerInput>(this.simulatorUrl, scheduler);
  }
}
