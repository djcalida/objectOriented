import java.util.Scanner;

public class DestinationCalculation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Recommended Route:\nCebu City (Start)\nMinglanilla (Route 1)\nSan Fernando (Route 2)\nCarcar (Route 3)\nBarili (Route 4.1)\nDumanjug (Route 4.1.1)\nRonda (Route 4.1.2)\nMoalboal (End)");
        System.out.print("\nIs Carcar via Barili obstructed? (1 = Yes, 0 = No): ");
        int isBariliObstructed = scan.nextInt();
        
        //Check if Carcar via Barili obstructed 
        if (isBariliObstructed == 0) {
            double distanceCarcarViaBarili = 86.7; //Constant Value of the Distance from Cebu City (Start)\nMinglanilla (Route 1)\nSan Fernando (Route 2)\nCarcar (Route 3)\nBarili (Route 4.1)\nDumanjug (Route 4.1.1)\nRonda (Route 4.1.2)\nMoalboal (End)..
            double speed = getInputSpeed(scan); //Scan after if the user type 0 (NO) if Carcar via Barili obstructed. 
            calculateEstTOA(distanceCarcarViaBarili, speed); //Set to the method private static void calculateEstTOA() to calculate the ETA..
            
        } else {
            System.out.println("\nRecommended Route:\nCebu City (Start)\nMinglanilla (Route 1)\nSan Fernando (Route 2)\nCarcar (Route 3)\nSibonga (Route 4.2)\nDumanjug (Route 4.2.1)\nRonda (Route 4.2.2)\nMoalboal (End)");
            System.out.print("\nIs Carcar via Sibonga via Dumanjug obstructed? (1 = Yes, 0 = No): ");
            int isSibongaViaDumanjugObstructed = scan.nextInt();

            if (isSibongaViaDumanjugObstructed == 0) {
                double distanceCarcarViaSibongaViaDumanjug = 95.4; //Constant Value of the Distance from Cebu City (Start)\nMinglanilla (Route 1)\nSan Fernando (Route 2)\nCarcar (Route 3)\nSibonga (Route 4.2)\nDumanjug (Route 4.2.1)\nRonda (Route 4.2.2)\nMoalboal (End)");
                double speed = getInputSpeed(scan);
                calculateEstTOA(distanceCarcarViaSibongaViaDumanjug, speed); //Set to the method private static void calculateEstTOA() to calculate the ETA..
                
            } else {
               System.out.println("\nRecommended Route:\nCebu City (Start)\nMinglanilla (Route 1)\nSan Fernando (Route 2)\nCarcar (Route 3)\nSibonga (Route 4.3)\nArgao (Route 4.3.1)\nAlcantara (Route 4.3.2)\nRonda (Route 4.3.3)\nMoalboal (End)");
               System.out.print("\nIs Carcar via Sibonga via Argao via Alcantara via Ronda obstructed? (1 = Yes, 0 = No): ");
               int isSibongaViaArgaoViaAlcantaraViaRondaObstructed = scan.nextInt();
               
               if(isSibongaViaArgaoViaAlcantaraViaRondaObstructed == 0){
                double distanceCarcarViaSibongaViaArgaoViaAlcantarViaRonda = 94.4; //Constant Value of the Distance from Cebu City (Start)\nMinglanilla (Route 1)\nSan Fernando (Route 2)\nCarcar (Route 3)\nSibonga (Route 4.3)\nArgao (Route 4.3.1)\nAlcantara (Route 4.3.2)\nRonda (Route 4.3.3)\nMoalboal (End)");
                double speed = getInputSpeed(scan);
                calculateEstTOA(distanceCarcarViaSibongaViaArgaoViaAlcantarViaRonda, speed); //Set to the method private static void calculateEstTOA() to calculate the ETA..
                
               }
               else{
                  double distanceTuyokSantander = 200; //Constant Value of the Distance from Cebu City (Start)\nTalisay (Route 1)\nMinglanilla (Route 2)\nNaga (Route 3)\nSan Fernando (Route 4)\nCarcar (Route 5)\nSibonga (Route 6)\nArgao (Route 7)\nDalaguete (Route 8)\nAlcoy (Route 9)\nBoljoon (Route 10)\nOslob (Route 11)\nSantander (Route 12)\nSamboan (Route 13)\nGinatilan (Route 14)\nMalabuyoc (Route 15)\nAlegria (Route 16)\nBadian (Route 17)\nMoalboal (End)");
                  System.out.println("\nTuyok lng tag Santander Bai:\n\nCebu City (Start)\nTalisay (Route 1)\nMinglanilla (Route 2)\nNaga (Route 3)\nSan Fernando (Route 4)\nCarcar (Route 5)\nSibonga (Route 6)\nArgao (Route 7)\nDalaguete (Route 8)\nAlcoy (Route 9)\nBoljoon (Route 10)\nOslob (Route 11)\nSantander (Route 12)\nSamboan (Route 13)\nGinatilan (Route 14)\nMalabuyoc (Route 15)\nAlegria (Route 16)\nBadian (Route 17)\nMoalboal (End)");
                  double speed = getInputSpeed(scan);
                  calculateEstTOA(distanceTuyokSantander, speed); //Set to the method private static void calculateEstTOA() to calculate the ETA..
               }
               }
          }
    }
    //Method to scan what the driver speed in kph
    private static double getInputSpeed(Scanner scanner) {
        System.out.print("\nInput Speed in kph: ");
        return scanner.nextDouble();
    }
    //Enable to calculate the Estimated Time of Arrival
    private static void calculateEstTOA(double distance, double speed) {
        System.out.println("Distance: " + distance + " km");
        double estTOA = distance / speed;
        convertDecimalHours(estTOA);
    }
    //Enable to print Hours, Minutes, and Seconds
    private static void convertDecimalHours(double decimalHours) {
        int hours = (int) decimalHours;
        double decimalMinutes = (decimalHours - hours) * 60;
        int minutes = (int) decimalMinutes;
        int seconds = (int) ((decimalMinutes - minutes) * 60);

        System.out.println("Estimated TOA: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
    }
}