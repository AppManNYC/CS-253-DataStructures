/**
 * MK
 */

import java.text.*;

public class Graph {

    // DECIMAL FORMATS USEFUL FOR USER OUTPUT
    DecimalFormat twoDecimal = new DecimalFormat("0.00");
    DecimalFormat milli = new DecimalFormat("#,###,###,###");

    // ALL 3 VERTEX MATRICES USED ARE INITIALIZED BELOW
    private Vertex vertices[] = new Vertex[10];
    private Vertex sorted[] = new Vertex[10];
    private Vertex previous[] = new Vertex[10];
    private int adjacencyMatrix[][] = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 0, 7171, 7972, 6866, 4606, 4201, 4384, 5408, 4667, 5024},
            {2, 7171, 0, 2368, 1299, 4832, 5067, 5089, 3595, 10924, 5063},
            {3, 7972, 2368, 0, 3642, 3798, 4182, 4080, 2677, 8948, 3687},
            {4, 6866, 1299, 3642, 0, 5809, 5960, 6032, 4660, 11520, 6147},
            {5, 4606, 4832, 3798, 5809, 0, 410, 285, 1264, 6096, 599},
            {6, 4201, 5067, 4182, 5960, 410, 0, 216, 1581, 5879, 897},
            {7, 4384, 5089, 4080, 6032, 285, 216, 0, 1542, 5844, 684},
            {8, 5408, 3595, 2677, 4660, 1264, 1581, 1542, 0, 7326, 1488},
            {9, 4667, 10924, 8948, 11520, 6096, 5879, 5844, 7326, 0, 5861},
            {10, 5024, 5063, 3687, 6147, 599, 897, 684, 1488, 5861, 0}};


    // DEFAULT GRAPH CONSTRUCTOR
    public Graph(){
        //vertices[0] = new Vertex(0,"null", 0);
        vertices[0] = new Vertex(1, "United States of America", 316100000);
        vertices[1] = new Vertex(2, "China",1357000000);
        vertices[2] = new Vertex(3, "India",1252000000);
        vertices[3] = new Vertex(4, "Japan", 127300000);
        vertices[4] = new Vertex(5, "Germany", 80620000);
        vertices[5] = new Vertex(6, "United Kingdom", 64100000);
        vertices[6] = new Vertex(7, "France", 66030000);
        vertices[7] = new Vertex(8, "Russia", 143500000);
        vertices[8] = new Vertex(9, "Brazil", 200400000);
        vertices[9] = new Vertex(10, "Italy", 59830000);
    }

    public Vertex getRoot(int i){
        return vertices[i];
    } // GETS ROOT FROM USER'S INTEGER INPUT (1 to 10)

    public Vertex[] primsAlgorithm(Vertex v){
        /* Reset if called previously */
        for( int a = 0; a < sorted.length; a++)
        {
            if( sorted[a] != null && sorted[a].isVisited() ) sorted[a].unvisit();

            sorted[a] = null;
        }

        sorted[0] = v;
        v.visit();
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int numTraversed = 1;
        Vertex temp = null;

        while( numTraversed < vertices.length)
        {
            /* Consider all visited vertices and find the closest unvisited node */
            for( int j = 0; j < numTraversed; j++ )
            {
                for( int i = 1; i < adjacencyMatrix.length; i++)
                {
                    /* Ignore already visited vertices */
                    if( !vertices[i-1].isVisited() && adjacencyMatrix[sorted[j].getArrayIndex()][i] < min
                            && adjacencyMatrix[sorted[j].getArrayIndex()][i] > 0)
                    {
                        min = adjacencyMatrix[sorted[j].getArrayIndex()][i];
                        minIndex = i-1;
                        temp = sorted[j];
                    }
                }
            }

            /* Vertex located */
            min = Integer.MAX_VALUE;
            sorted[numTraversed] = vertices[minIndex];
            vertices[minIndex].visit();
            previous[numTraversed] = temp;  // Track which edge was taken
            numTraversed++;

        }

        return sorted;
    } // BREADTH FIRST SEARCH ALGORITHM

    public void spreadInfection(int day, double rate){
        if(day < 0){
            System.out.println("Number of days must be positive.");
        }
        else if (day > 1){
                for(int i = 0; i < sorted.length; i++){
                    // PROBLEM HERE- DOESN'T ACCOUNT FOR DAYS
                    sorted[i].setInfected(sorted[i].infect(rate, day));
                }
            System.out.println("Infection spread complete for " + day + " days.");
        }
        else{
            System.out.println("Infection spread complete for " + day + " day.");
        }
    } // SPREAD INFECTION (WHEN DAY > 1)

    // SIMULATE DAY 1 INFECTION IN SORTED[1] PRIOR TO TRANSPORTING INFECTION
    public void pretransInfection(double rate){
        sorted[0].setInfected(sorted[0].infect(rate));
    }

    // SIMULATES THE TRAVELING THAT WILL BE DONE ON DAY 1
    public void transportInfection(double rate){
        for(int i = 0; i < sorted.length-1; i++){
            sorted[i+1].setInfected(previous[i+1].transport(rate, i+1));
        }
        // DEBUG STATEMENT BELOW
        // System.out.println("Infection transportation successful.");
    } // TRANSPORT INFECTION (SIMULATES WHEN DAY == 1)

    public void infect(){
        sorted[0].infect();
    } // SETS FIRST INFECTED PERSON IN THE FIRST INFECTED COUNTRY

    // PRINT METHODS BELOW

    public void printInfected(){
        System.out.println("                   INFECTED STATISTICS           ");
        for(int i = 0; i < sorted.length; i++) {
            System.out.println(milli.format(sorted[i].getInfected()) +" infected people in " + sorted[i].getCountry() + ". (" + twoDecimal.format((sorted[i].getInfected()/(double)sorted[i].getPopulation())*100) + "% of " + milli.format(sorted[i].getPopulation()) + " total citizens).");
        }
        System.out.println();
    }

    public void printOrder(){
        System.out.println("           ORDER OF INFECTED COUNTRIES           ");
        for (int i = 0; i < sorted.length; i++){
            if(i == 0){
                System.out.println((i+1) + ". " + sorted[i].getCountry() + " (ORIGIN)");
            }
            else{
                System.out.println((i+1) + ". " + sorted[i].getCountry() + " (" + milli.format(adjacencyMatrix[previous[i].getArrayIndex()][sorted[i].getArrayIndex()]) +  " miles from " + previous[i].getCountry() + ")");
            }
        }
    }

    public void printDistances(){
        System.out.println("           DISTANCE BETWEEN INFECTED COUNTRIES           ");
        for(int i = 0; i < sorted.length; i++) {
            if(i == 0){
                System.out.println("The outbreak began in " + sorted[i].getCountry() + ".");
            }
            else if(i == sorted.length-1){
                System.out.println("Finally, the outbreak ended in " + sorted[i].getCountry() +", after traveling " + milli.format(adjacencyMatrix[previous[i].getArrayIndex()][sorted[i].getArrayIndex()]) + " miles from " + previous[i].getCountry() + ".");
            }
            else if(i % 2 == 0){
                System.out.println("Then it traveled, " + milli.format(adjacencyMatrix[previous[i].getArrayIndex()][sorted[i].getArrayIndex()]) + " miles from " + previous[i].getCountry() + " to " + sorted[i].getCountry() + ".");
            }
            else{
                System.out.println("Next it traveled, " + milli.format(adjacencyMatrix[previous[i].getArrayIndex()][sorted[i].getArrayIndex()]) + " miles from " + previous[i].getCountry() + " to " + sorted[i].getCountry() + ".");
            }
        }
        System.out.println();
    }

    public void printUninfected(){
        System.out.println("********** CURRENT UNINFECTED STATISTICS **********");
        for(int i = 0; i < sorted.length; i++) {
            System.out.println(milli.format(sorted[i].getPopulation() - sorted[i].getInfected()) +" uninfected person(s) in " + sorted[i].getCountry() + ". (" + twoDecimal.format(((sorted[i].getPopulation() - sorted[i].getInfected())/(double)sorted[i].getPopulation())*100) + "% of " + milli.format(sorted[i].getPopulation()) + " total citizens).");
        }
        System.out.println();
    }


    // MISC METHODS BELOW

    public void resetInfected(){
        for(int i = 1; i < sorted.length; i++){
            sorted[i].setInfected(0);
        }
    }

    public void setDistance(int x, int y, int distance) {
        try {
            adjacencyMatrix[x][y] = distance;
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("Vertex entered is not present.");
        }
    }

    public int getDistance(int x, int y) {
        try {
            return adjacencyMatrix[x][y];

        } catch (ArrayIndexOutOfBoundsException indexBounce)

        {

            System.out.println("Vertex entered is not present.");

        }
        return -1;
    }

    public void setInfo(int i, String c, int p){
        Vertex v = new Vertex(c);
        v.setPopulation(p);
        vertices[i] = v;
    }

    public String getCountry(int i){
        return vertices[i].getCountry();
    }

    public void setCountry(int i, String c){
        Vertex v = new Vertex(c);
        vertices[i] = v;
    }

    public long getPopulation(int i){
        return vertices[i].getPopulation();
    }

    public void setPopulation(long v, int i){
        vertices[i].setPopulation(v);
    }

    public long getInfected(int i){
        return sorted[i].getInfected();
    }

    public int getArrayIndex(int i){
        return vertices[i].getArrayIndex();
    }

    public void setArrayIndex(int v, int i){
        vertices[i].setArrayIndex(v);
    }

    public void calcInfected(double rate){
        for(int i = 1; i < sorted.length; i++){
            sorted[i].setInfected(sorted[i].calcInfected(rate));
        }
    }

}