package prog2.exercise5.flight.booking.system;
import java.time.LocalDate;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.xml.transform.Source;


public class FlightBooking {

    private static final String company = null;
    private static final String source = null;
    private static final String destination = null;
    private static final String departure = null;
    private static final String returningDate = null;
    String flightCompany =  "Flights_of_Fancy";
    static LocalDate departureDate;
    static LocalDate returnDate;
    private int childrenPassengers;
    private int adultPassengers;
    int totalPassengers;
    private int daysToadd = 10;
    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;
    String[] ticketNumber;
    
    int size = 3;
    String[] PassengerFullName;
    String[] PassengerGender;
    int[] PassengerAge;
    
    private BookingClass bookingClass;
    enum BookingClass {
        FIRST, BUSINESS, ECONOMY
    }
    public void setBookingClass(String i){
        if (i == "1")
        {
            bookingClass = BookingClass.FIRST;
        }
        if (i == "2")
        {
            bookingClass = BookingClass.BUSINESS;
        }
        if (i == "3")
        {
            bookingClass = BookingClass.ECONOMY;
        }
    }
    public BookingClass getBookingClass(){
        return bookingClass;
    }

    
    private TripType tripType;
    enum TripType{
        ONE_WAY, RETURN;
    }
    public void setTripType(String j){
        if(j=="1"){
            tripType = TripType.ONE_WAY;
        }
        if(j=="2"){
            tripType = TripType.RETURN;
        }
    }

    private SourceAirport sourceAirport;
    private TripSource tripSource;
    enum TripSource{
        NANJING, BEIJING, OULU, HELSINKI;
    }
    enum SourceAirport{
        NANJING_LUKOU_International_Airport, Beijing_Capital_International_Airport, Oulu_Airport, Helsinki_Airport;
    }
    public void setTripSource(String i){
        if(i=="1"){
            tripSource = TripSource.NANJING;
        }
        if(i== "2"){
            tripSource = TripSource.BEIJING;
        }
        if(i=="3"){
            tripSource = TripSource.OULU;
        }
        if(i=="4"){
            tripSource = TripSource.HELSINKI;
        }
    }
    public TripSource getTripSource(){
        return tripSource;
    }
    public SourceAirport getSourceAirport() {
        return sourceAirport;
    }




    private DestinationAirport destinationAiport;
    private TripDestination tripDestination;
    enum TripDestination{
        NANJING, BEIJING, OULU, HELSINKI;
    }
    enum DestinationAirport{
        NANJING_LUKOU_International_Airport, Beijing_Capital_International_Airport, Oulu_Airport, Helsinki_Airport;
    }
    public void setTripDestination(String i, String j){
        if(i=="1"){
            tripDestination = TripDestination.NANJING;
        }
        if(i== "2"){
            tripDestination = TripDestination.BEIJING;
        }
        
        if(i=="3"){
            tripDestination = TripDestination.OULU;
        }
        if(i=="4"){
            tripDestination = TripDestination.HELSINKI;
        }
        
    }
    public TripDestination getTripDestination(){
        return tripDestination;
    }
    public DestinationAirport getDestinationAiport() {
        return destinationAiport;
    }

    public void setSourceAirport(String i) {
        switch (i)
        {
            case "1":
            sourceAirport = SourceAirport.NANJING_LUKOU_International_Airport;
            break;
            case "2":
            sourceAirport = SourceAirport.Beijing_Capital_International_Airport;
            break;
            case "3":
            sourceAirport = SourceAirport.Oulu_Airport;
            break;
            case "4":
            sourceAirport = SourceAirport.Helsinki_Airport;
            break;
        }
    } 
    public void setDestinationAirport(String i, String j) {
        switch(i)
        {
            case "1":
            switch(j)
            {
                case "1":
                System.out.println("ERROR!!!");
                break;
                case "2":
                destinationAiport = DestinationAirport.Beijing_Capital_International_Airport;
                break;
                case "3":
                destinationAiport = DestinationAirport.Oulu_Airport;
                break;
                case "4":
                destinationAiport = DestinationAirport.Helsinki_Airport;
                break;
            }
            break;
            case "2":
            switch(j)
            {
                case "1":
                destinationAiport = DestinationAirport.NANJING_LUKOU_International_Airport;
                break;
                case "2":
                System.out.println("ERROR!!!");
                break;
                case "3":
                destinationAiport = DestinationAirport.Oulu_Airport;
                break;
                case "4":
                destinationAiport = DestinationAirport.Helsinki_Airport;
                break;
            }
            break;
            case "3":
            switch(j)
            {
                case "1":
                destinationAiport = DestinationAirport.NANJING_LUKOU_International_Airport;
                break;
                case "2":
                destinationAiport = DestinationAirport.Beijing_Capital_International_Airport;
                break;
                case "3":
                System.out.println("ERROR!!!");
                break;
                case "4":
                destinationAiport = DestinationAirport.Helsinki_Airport;
                break;
            }
            break;
            case "4":
            switch(j)
            {
                case "1":
                destinationAiport = DestinationAirport.NANJING_LUKOU_International_Airport;
                break;
                case "2":
                destinationAiport = DestinationAirport.Beijing_Capital_International_Airport;
                break;
                case "3":
                destinationAiport = DestinationAirport.Oulu_Airport;
                break;
                case "4":
                System.out.println("ERROR!!!");
                break;
            }
            break;
        }
    }
    
    public FlightBooking(int i)
    {
        PassengerFullName = new String[i];
        PassengerGender = new String[i];
        PassengerAge = new int[i];
        ticketNumber = new String[i];
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public String getPassengerFullName(int index){
        return PassengerFullName[index];
    }
    public void setPassengerFullName(int index, String passengerFullName){
        this.PassengerFullName[index] = passengerFullName;
    }

    public String getPassengerGender(int index){
        return PassengerGender[index];
    }
    public void setPassengerGender(int index, String passengerGender){
        this.PassengerGender[index] = passengerGender;
    }

    public int getPassengerAge(int index){
        return PassengerAge[index];
    }
    public void setPassengerAge(int index, int passengerAge){
        this.PassengerAge[index] = passengerAge;
    }
    

    public LocalDate getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(LocalDate departureDate){
        FlightBooking.departureDate = departureDate;
    }

    public LocalDate getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate){
        int result = returnDate.compareTo(departureDate);
        if(result>=2){
            FlightBooking.returnDate = returnDate; 
        }
        if(result == 1){
            returnDate = returnDate.plusDays(1);
            FlightBooking.returnDate = returnDate;
        }
        if(result==0){
            returnDate = returnDate.plusDays(2);
            FlightBooking.returnDate = returnDate;
        }
    }

    public int getChildrenPassengers() {
        return childrenPassengers;
    }
    public void setChildrenPassengers(int childrenPassengers) {
        this.childrenPassengers = childrenPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }
    public void setAdultPassengers(int adultPassengers) {
        this.adultPassengers = adultPassengers;
    }

    public int getTotalPassengers() {
        return totalPassengers;
    }
    public void setTotalPassengers(int childrenPassengers,int adultPassengers) {
        this.totalPassengers = childrenPassengers + adultPassengers;
    }
    
    public double getDepartingTicketPrice() {
        return departingTicketPrice;
    }
    public void setDepartingTicketPrice(int i, int j) {

    }
    
    public double getReturnTicketPrice() {
        return returnTicketPrice;
    }
    public void setReturnTicketPrice() {

    }
  
    public String getTicketNumber() {
        return "11FASDFDOM";
    }
    public void setTicketNumber(int i){
        String a = "0";
        String b  = "0";
        String c ="0";
        if(tripType==TripType.ONE_WAY){
            a = "11";
        }
        if(tripType==TripType.RETURN){
            a = "22";
        }
        if(bookingClass==BookingClass.FIRST){
            b = "F";
        }
        if(bookingClass==BookingClass.BUSINESS){
            b = "B";
        }
        if(bookingClass==BookingClass.ECONOMY){
            b = "E";
        }
        if((tripSource==TripSource.NANJING&&tripDestination==TripDestination.BEIJING) ||(tripSource==TripSource.BEIJING&&tripDestination==TripDestination.NANJING) ||(tripSource==TripSource.OULU&&tripDestination==TripDestination.HELSINKI) ||(tripSource==TripSource.HELSINKI&&tripDestination==TripDestination.OULU)){
            c = "DOM";
        }
        else{
            c = "INT";
        }
        this.ticketNumber[i] = a + b + "0000" +c;
    }

    public String getTicketNumber(int i) {
        return ticketNumber[i];
    }



    public void setTotalTicketPrice() {
        this.totalTicketPrice = Math.abs((((2 *((300 + (0.1*300)) + (0.05*300))) + (5*((300 + (0.1*300)) + (0.05*300)))) + 250)*2);
    }
    public double getTotalTicketPrice() {
        return 2* (((0*(300 + (0.15*300) + (0.1*300))) + (3*(300 + (0.15*300) + (0.1*300)))) + 250);
    }
    
    public void  reserveTickets(int j){
        this.size = j;
        Scanner a = new Scanner(System.in);
        for(int i = 0;i<size;i++){
            System.out.println("Please enter No." + (i+1) + "Passenger's fullname");
            String fullname = a.nextLine();
            setPassengerFullName(i, fullname);
            System.out.println("Please enter No." + (i+1) + "Passenger's gender");
            String gender = a.nextLine();
            setPassengerGender(i, gender);
            System.out.println("Please enter No." + (i+1) + "Passenger's age");
            int age = a.nextInt();
            setPassengerAge(i, age);
            
        }
        a.close();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Please choose BookingClass from 1.First 2.business 3.Economy:");
        int bookingClass = input1.nextInt();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Please choose tripType from 1.One way 2.Return:");
        int tripType = input2.nextInt();

        Scanner input3 = new Scanner(System.in);
        System.out.println("Please choose tripsource from 1.NANJING 2.BEIJING 3.OULU 4.HELSINKI:");
        int tripSource = input3.nextInt();

        Scanner input4 = new Scanner(System.in);
        System.out.println("Please choose tripdestination from 1.NANJING 2.BEIJING 3.OULU 4.HELSINKI:");
        int tripDestination = input4.nextInt();

        Scanner input5 = new Scanner(System.in);
        System.out.println("Please enter your departingdate:");
        String departing = input5.next();
        LocalDate departure = LocalDate.parse(departing);

        Scanner input6 = new Scanner(System.in);
        System.out.println("Please enter your returningdate:");
        String returning = input5.next();
        LocalDate returningDate = LocalDate.parse(returning);
        
        input1.close();
        input2.close();
        input3.close();
        input4.close();
        input5.close();
        input6.close();
    }
    
    public void displayTripDetails(){
        if(daysToadd < 2){
            for(int i = 0;i<size;i++){
                System.out.println("Thank you for booking your flights with FLIGHT_COMPANY." + "\n" +
                 "You reserved a total of 3 tickets." + "\n" + 
                "Here are the trip details for Passenger No." + (i+1) + "\n" +
                "Passenger's Ticket Number:" + ticketNumber[i] + "\n" + 
                "Passenger's Full Name:" + PassengerFullName[i] + "\n" +
                "Passenger's Age:" + PassengerAge[i] + "\n" +
                "Passenger's Gender:" + PassengerGender[i] + "\n" +
                "From:" + tripSource + "\n" +
                "To:" + tripDestination+ "\n" +
                "The flight departs on:" + tripDestination + "\n" +
                "And the return flight is on:" + returnDate + "\n" +
                "The total ticket price is:" + totalTicketPrice + "\n" +
                "IMPORTANT NOTICE: As per our policy, the return date was changed because it was less than two days apart from your departure date.");
            }
        }
        else{
            for(int i = 0;i < size;i++){
                System.out.println("Thank you for booking your flights with FLIGHT_COMPANY." + "\n" +
                 "You reserved a total of 3 tickets." + "\n" + 
                "Here are the trip details for Passenger No." + (i+1) + "\n" +
                "Passenger's Ticket Number:" + ticketNumber[i] + "\n" + 
                "Passenger's Full Name:" + PassengerFullName[i] + "\n" +
                "Passenger's Age:" + PassengerAge[i] + "\n" +
                "Passenger's Gender:" + PassengerGender[i] + "\n" +
                "From:" + tripSource + "\n" +
                "To:" + tripDestination+ "\n" +
                "The flight departs on:" + tripDestination + "\n" +
                "And the return flight is on:" + returnDate + "\n" +
                "The total ticket price is:" + totalTicketPrice + "\n");
            }
            
        }
    }

    

  
        


        
    
}
