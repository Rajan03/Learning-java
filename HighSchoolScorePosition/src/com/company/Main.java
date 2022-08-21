package com.company;

public class Main {
    public static final int DOOR_OPEN = 1;
    public static final int LIGHTS_ON = 2;
    public static final int THERMPSTATE_ON = 4;

//    public static void main(String[] args) {
////        Player 1
//        String playername = "Rajan";
//        int position = calculateHighScorePostion(1500);
//        displayHighScorePosition(playername, position);
////        Player 2
//         playername = "Tim";
//         position = calculateHighScorePostion(900);
//        displayHighScorePosition(playername, position);
////        Player 3
//         playername = "Aman";
//         position = calculateHighScorePostion(400);
//        displayHighScorePosition(playername, position);
////        Player 4
//        playername = "Kkaran";
//        position = calculateHighScorePostion(58);
//        displayHighScorePosition(playername, position);
//    }
//    public static void displayHighScorePosition(String playerName, int playerPosition) {
//        System.out.println(playerName + " managed to get into position " + playerPosition + " on the high score table");
//    }
//    public static int calculateHighScorePostion(int playerScore) {
//        if (playerScore>1000){
//            return 1;
//        }else if(playerScore>500 && playerScore<1000){
//            return 2;
//        }else if(playerScore>100 && playerScore<500){
//            return 3;
//        }else{
//            return 4;
//        }
//    }


    public static void main (String[] args) {

        testBitOperator(-3);
    }
    public static void testBitOperator(int inputValue){
        if (isInputNotValid(inputValue)){
            System.out.println("Invalid input value " + "\n" +
                    "Note :- Possible Values : "+
                    "\n" +"1 - Open/Close Doors" +
                    "\n" + "2 - Lights On/Off" +
                    "\n" +"4 - Thermostat On/Off" +
                    "\n" +"Any value from 1 to 7 will perform corresponding possible tasks"
            );
        }else {
            onAppliances(inputValue);
        }
    }

    private static void onAppliances(int inputValue) {
        if ((inputValue & DOOR_OPEN) == DOOR_OPEN){
            System.out.println("Doors are open");
        }else{
            System.out.println("Doors Closed");
        }
        if ((inputValue & LIGHTS_ON) == LIGHTS_ON) {
            System.out.println("Lights are on");
        }else{
            System.out.println("Lights off");
        }
        if ((inputValue & THERMPSTATE_ON) == THERMPSTATE_ON){
            System.out.println("Thermostat is on");
        }else{
            System.out.println("Thermostat off");
        }
    }

    private static boolean isInputNotValid(int input) {
        return input > 7 || input < 0;
    }
    
}


//                  1  0  0
//                  0  1  0
//                  0  0  1
//        1 001
//        2 010
//        3 011	 -	001 | 010
//        4 100
//        5 101	 -	100 | 001
//        6 110	 -	100 | 010
//        7 111	 -	001 | 010 | 100