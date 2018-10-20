import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Flight } from './model/flight.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class FlightServiceService {

  constructor(private http:HttpClient) { }
  private flightUrl = 'http://localhost:8080/flights';

  public getFlights() {
    console.log(this.flightUrl);
    return this.http.get<Flight[]>(this.flightUrl);
  }

  public deleteFlight(flight) {
    return this.http.delete(this.flightUrl + "/"+ flight.id);
  }

  public createFlight(flight) {
    return this.http.post<Flight>(this.flightUrl, flight);
  }
}
