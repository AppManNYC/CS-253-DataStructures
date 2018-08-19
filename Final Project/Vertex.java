/**
 * MK
 * 
 */

import java.util.*;

public class Vertex {
    private String country;
    private boolean visited;
    double percentInfected, interactionRate;
    // ~6.575 million travellers a day divided by 7.125 billion people on earth = 0.00092280701 (rate of travel - Int.)
    // ~1.73 million travellers a day in USA divided by 316.5 million population = 0.00547295159(rate of travel - USA)
    // AVERAGE OF THE ABOVE TWO NUMBERS (INT R.O.T. + USA R.O.T.) / 2 = 0.0031978793
    final double percentTravel = 1.0032;
    int arrayIndex;
    long infected, population;
    Random generator = new Random(); // RANDOM VARIABLE *(SEEDED AT CURRENT TIME IN MILLISECONDS)

    public Vertex(String country){
        this.country = country;
        visited = false;
    }

    public Vertex(int i, String c, long p){
        this.country = c;
        this.population = p;
        this.arrayIndex = i;
        this.infected = 0;
        this.percentInfected = (infected / population);
        this.interactionRate = population * .0001;
    }

    public int getArrayIndex(){
        return arrayIndex;
    }

    public void setArrayIndex(int newIndex){
        arrayIndex = newIndex;
    }

    public boolean isVisited(){
        return visited;
    }

    public String getCountry(){
        return country;
    }

    public void visit(){
        visited = true;
    }

    public void unvisit(){
        visited = false;
    }

    public void infect(){
        this.infected = 1;
    }

    public long getPopulation(){
        return population;
    }

    public void setPopulation(long p){
        this.population = p;
    }

    public long getInfected(){
        return infected;
    }

    public void setInfected(long i){
        this.infected = i;
    }

    // IF COUNTRY ISN'T INFECTED METHOD ADDS 1 TO ITS VALUE
    // ALSO INITIALIZED A RANDOM NUMBER GENERATOR FOR THE DENOMINATOR HERE (= 1 to DISTANCE (d))
    public long transport(double rate, int d){
        long temp = Math.round((this.infected * percentTravel * rate)/(double)d);
        if(temp > 1000) {
            return temp;
        }
        else{
            return random(1500,500);
        }
    }

    public long infect(double rate) {
        // QUESTIONABLE- SETS POPULATION AS INFECTED IF (RETURN > POPULATION)
        if ((this.calcInfected(rate) + this.infected) < this.population) {
            return (this.calcInfected(rate) + this.infected);
        } else {
            return this.population;
        }
    }

    long infect(double rate, int day) {
        // QUESTIONABLE- SETS POPULATION AS INFECTED IF (RETURN > POPULATION)
        if ((this.calcInfected(rate, day) + this.infected) < this.population) {
            return (this.calcInfected(rate, day) + this.infected);
        } else {
            return this.population;
        }
    }

    // **** NOT SURE HOW TO IMPLEMENT RANDOM METHODS HERE *****
    public long calcInfected(double rate, int day){
        // INFECTED POP. x # OF HUMAN CONTACTS IN DAY (= INTERACTION RATE x POPULATION [TOTAL - INFECTED]) x CONTAGIOUSNESS

        //double r = random(rate,0.1);
        //double i = random(this.interactionRate,0.0001);
        //double temp =
        double temp = (((this.interactionRate * this.percentInfected+(Math.log(day))/(double)10)) * this.population * rate);
        return Math.round(random(temp, temp/2.0));
    }

    public long calcInfected(double rate){
        // INFECTED POP. x # OF HUMAN CONTACTS IN DAY (= INTERACTION RATE x POPULATION [TOTAL - INFECTED]) x CONTAGIOUSNESS
        //double r = random(rate,0.1);
        //double i = random(this.interactionRate,0.0001);
        return Math.round(this.interactionRate * this.infected * rate);
    }

    // RANDOM NUMBER METHOD BELOW (DOUBLE)

    private int random(int max, int min){
        int g = generator.nextInt((max - min) + 1) + min;
        return g;
    }

    private long random(long max, long min){
        return Math.round((min+(max-min))*generator.nextDouble());
    }

    private double random(double max, double min) {
        return (max-min)*generator.nextDouble()+min;
    }
}