import { Component, OnInit } from '@angular/core';
import { Flight } from '../model/flight.model';
import { FlightServiceService } from '../flight-service.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedColumns: string[] = ['flightNumber', 'sourceAirport', 'destinationAirport','flightStatus', 'scheduledTime', 'estimatedTime', 'actualTime','delayed','companyNameDescription'];
  
  dataSource;

  flights: Flight[];

  constructor(private router: Router, private flightService: FlightServiceService) {

  }

  ngOnInit() {
    
    this.flightService.getFlights()
      .subscribe( data => {
        this.flights = data;
        this.dataSource= new MatTableDataSource<Flight>(this.flights);
        this.dataSource.paginator = this.paginator;
        console.log(this.flights);
        console.log(this.dataSource);
      });
  };

  deleteFlight(flight: Flight): void {
    this.flightService.deleteFlight(flight)
      .subscribe( data => {
        this.flights = this.flights.filter(u => u !== flight);
      })
  };
}