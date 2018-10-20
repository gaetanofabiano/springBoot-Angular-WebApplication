export class Flight {
     public flightNumber:number;
     public companyNameDescription:string;
     public sourceAirport:string;
     public destinationAirport:string;
     public flightStatus:string;
     public scheduledTime: Date;
     public estimatedTime: Date; 
     public actualTime: Date;
     public delayed: boolean;
}