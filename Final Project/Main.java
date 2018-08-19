/**
 * MK
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int input = 1;
        Scanner scan = new Scanner(System.in);

        while (input != -1) {

            Graph g = new Graph();

            System.out.println("Country of Origin ");
            System.out.println("1. United States of America");
            System.out.println("2. China");
            System.out.println("3. India");
            System.out.println("4. Japan");
            System.out.println("5. Germany");
            System.out.println("6. United Kingdom");
            System.out.println("7. France");
            System.out.println("8. Russia");
            System.out.println("9. Brazil");
            System.out.println("10. Italy");
            System.out.println("0. to exit");
            input = (scan.nextInt()-1);

            if (-1 < input && input < 10) {
                System.out.println("Processing your request...");
                System.out.println();
                System.out.println("ENTER THE INFECTION RATE: ");
                double rate = scan.nextDouble();

                if (rate == 0) {
                    System.out.println();
                    break;
                }
                System.out.println("Preparing your disease...");
                System.out.println();
                System.out.println("NUMBER OF DAYS TO SIMULATE: ");
                int day = scan.nextInt();
                if (day == 0) {
                    System.out.println();
                    break;
                }
                System.out.println("Allocating " + day + " day(s) of virtual time...");
                System.out.println();
                System.out.println("Spreading outbreak in...");

                // i SECOND COUNT DOWN
                for (int i = 3; i > 0; i--) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }

                // BFS SEARCH ALGORITHM
                g.primsAlgorithm(g.getRoot(input));
                System.out.println();

                g.infect();  // SETS SORTED[1] INFECTED TO 1
                g.pretransInfection(rate);  // INFECTS SORTED[1] PRIOR TO TRANSPORTING THE INFECTION
                g.transportInfection(rate); // TRANSPORTS INFECTION THROUGHOUT SORTED[] *(IF INFECTED == 0 IT SETS INFECTED = 1)
                g.spreadInfection(day, rate); // SPREADS INFECTION FOR # OF USER INPUT DAYS

                System.out.println();
                g.printOrder(); // PRINTS ORDER INFECTED, PLUS DISTANCES
                System.out.println();

                //int in = 1;
                int count = 1;
                while (count != 0) {
                    //while(in != 0) {
                        System.out.println("Statics to be displayed: ");
                        System.out.println("1. Print Infected");
                        System.out.println("2. Print Uninfected");
                        System.out.println("3. Print distances traveled");
                        //System.out.println("4. Add days");
                        System.out.println("4. Restart program");
                        System.out.println("0. to exit");
                        count = (scan.nextInt());
                        System.out.println();
                        if (count == 1) {
                            g.printInfected(); // PRINTS INFECTED WITH PERCENTAGE BASED ON TOTAL POPULATION (USES STRING FORMATTING)
                        } else if (count == 2) {
                            g.printUninfected(); // PRINTS UNINFECTED WITH PERCENTAGE BASED ON TOTAL POPULATION (USES STRING FORMATTING)
                        } else if (count == 3) {
                            g.printDistances();
                        } else if(count == 4){
                            count = 0;
                        }
                        else if (count == 0){
                            count = 0;
                            input = -1;
                        }
                        else{
                            System.out.println("There is no option #" + count + ".");
                            System.out.println();
                        }
                   }
                   /* g = new Graph();
                    g.primsAlgorithm(g.getRoot(input));
                    System.out.println("How would you like to proceed?");
                    System.out.println("1. Edit infection rate");
                    System.out.println("2. Edit number of days simulated");
                    System.out.println("3. Edit both values");
                    System.out.println("4. Reset origin");
                    System.out.println("0. to exit");
                    int i = scan.nextInt();
                    if (i == 1) {
                        System.out.println("NEW INFECTION RATE: (0. to exit)");
                        rate = (scan.nextDouble()/(double)100);
                        if (rate == 0) {
                            input = -1;
                            count = 0;
                        }
                        System.out.println("Preparing your disease...");
                        System.out.println();
                        g.infect();  // SETS SORTED[1] INFECTED TO 1
                        g.pretransInfection(rate);  // INFECTS SORTED[1] PRIOR TO TRANSPORTING THE INFECTION
                        g.transportInfection(rate); // TRANSPORTS INFECTION THROUGHOUT SORTED[] *(IF INFECTED == 0 IT SETS INFECTED = 1)
                        g.spreadInfection(day, rate); // SPREADS INFECTION FOR # OF USER INPUT DAYS
                        System.out.println();
                        in = 1;
                    } else if (i == 2) {
                        System.out.println("NEW NUMBER OF DAYS: (0. to exit)");
                        day = scan.nextInt();
                        if (day == 0) {
                            input = -1;
                            count = 0;
                        }
                        System.out.println("Processing your request...");
                        System.out.println();
                        g.infect();  // SETS SORTED[1] INFECTED TO 1
                        g.pretransInfection(rate);  // INFECTS SORTED[1] PRIOR TO TRANSPORTING THE INFECTION
                        g.transportInfection(rate); // TRANSPORTS INFECTION THROUGHOUT SORTED[] *(IF INFECTED == 0 IT SETS INFECTED = 1)
                        g.spreadInfection(day, rate); // SPREADS INFECTION FOR # OF USER INPUT DAYS
                        System.out.println();
                        in = 1;
                    } else if(i == 3){
                        System.out.println("NEW INFECTION RATE: (0. to exit)");
                        rate = (scan.nextDouble()/(double)100);
                        if (rate == 0) {
                            input = -1;
                            count = 0;
                        }
                        System.out.println("Preparing your disease...");
                        System.out.println();
                        System.out.println("NEW NUMBER OF DAYS: (0. to exit)");
                        day = scan.nextInt();
                        if (day == 0) {
                            input = -1;
                            count = 0;
                        }
                        System.out.println("Processing your request...");
                        System.out.println();
                        System.out.println("Allocating " + day + " day(s) of virtual time...");
                        System.out.println();
                        System.out.println("Spreading outbreak in...");
                        g.infect();  // SETS SORTED[1] INFECTED TO 1
                        g.pretransInfection(rate);  // INFECTS SORTED[1] PRIOR TO TRANSPORTING THE INFECTION
                        g.transportInfection(rate); // TRANSPORTS INFECTION THROUGHOUT SORTED[] *(IF INFECTED == 0 IT SETS INFECTED = 1)
                        g.spreadInfection(day, rate); // SPREADS INFECTION FOR # OF USER INPUT DAYS
                        System.out.println();
                        in = 1;
                    } else if (i == 4){
                        System.out.println();
                        System.out.println("COUNTRY OF ORIGIN: ");
                        System.out.println("1. United States of America");
                        System.out.println("2. China");
                        System.out.println("3. India");
                        System.out.println("4. Japan");
                        System.out.println("5. Germany");
                        System.out.println("6. United Kingdom");
                        System.out.println("7. France");
                        System.out.println("8. Russia");
                        System.out.println("9. Brazil");
                        System.out.println("10. Italy");
                        System.out.println("0. to exit");
                        input = scan.nextInt()-1;
                        if (-1 < input && input < 10) {
                            System.out.println("NEW INFECTION RATE: (0. to exit)");
                            rate = (scan.nextDouble()/(double)100);
                            if (rate == 0) {
                                input = -1;
                                count = 0;
                            }
                            System.out.println("Preparing your disease...");
                            System.out.println();
                            System.out.println("NEW NUMBER OF DAYS: (0. to exit)");
                            day = scan.nextInt();
                            if (day == 0) {
                                input = -1;
                                count = 0;
                            }
                            System.out.println("Processing your request...");
                            System.out.println();
                            System.out.println("Allocating " + day + " day(s) of virtual time...");
                            System.out.println();
                            System.out.println("Spreading outbreak in...");

                            // i SECOND COUNT DOWN
                            for (i = 3; i > 0; i--) {
                                System.out.println(i);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }
                            }

                            g.primsAlgorithm(g.getRoot(input));
                            System.out.println();

                            g.infect();  // SETS SORTED[1] INFECTED TO 1
                            g.pretransInfection(rate);  // INFECTS SORTED[1] PRIOR TO TRANSPORTING THE INFECTION
                            g.transportInfection(rate); // TRANSPORTS INFECTION THROUGHOUT SORTED[] *(IF INFECTED == 0 IT SETS INFECTED = 1)
                            g.spreadInfection(day, rate); // SPREADS INFECTION FOR # OF USER INPUT DAYS
                            System.out.println();
                            in = 1;
                        }
                    } else if (i == 0) {
                        input = -1;
                        count = 0;
                    } else{
                        System.out.println("There is no option #" + input+1 + ".");
                    }
                }*/

            }
            else if(input == -1){
                System.out.println();
                break;
            }
            else{
                System.out.println("There is no option #" + (input+1) + ".");
            }
            // input = -1;  // STATEMENT DETERMINES IF THE PROGRAM WILL LOOP CONTINUOUSLY OR NOT
        }

        System.out.println("Program closing...");

        scan.close();

        /* SPECIFIC DEBUG METHODS BELOW
            System.out.println();
            System.out.println(g.getRoot(1).getCountry());
            System.out.println("Index between " + g.getCountry(3) + " and " + g.getCountry(6) + ": " + g.getEdge(3, 6));
            System.out.println(g.getCountry(10));
            */

    }
}

