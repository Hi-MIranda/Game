import java.util.*;

public class Driver{
    static int[][] connect4 = new int[6][7];
    static int count = 1, flag = 0, currentRow, currentCol;
    public static void main(String[] args){
        print();
        System.out.println("Player " + playerTurn() + "'s turn");
        while(!insert()){continue;};
        //System.out.println("Player " + playerTurn() + "'s turn");
        while (!(winCondition())){
            count++;
            print();
            System.out.println("Player " + playerTurn() + "'s turn");
            while(!insert()){continue;};
            if (tieCondition()) {
                break;
            }
        }
        count++;
        if (flag == 1)
            System.out.println("Tie!");
        else {
            print();
            if (playerTurn()==1)
                System.out.println("Player " + 2 + " won");
            else
                System.out.println("Player " + 1 + " won");
        }
    }
    public static int playerTurn(){
        if (count%2==0)
            return 2;
        else
            return 1;
    }
    public static boolean insert(){
        int column;
        Scanner input = new Scanner(System.in);
        try{
            System.out.print("pick a column (0-6): ");
            column = input.nextInt();
            int randomTest = connect4[0][column];
        }catch(InputMismatchException e){
            System.out.println("Please enter a valid input!");
            return false;
        }catch (IndexOutOfBoundsException e){
            System.out.println("index out of bound, try again");
            return false;
        }
        int row=5;
        try {
            while (true) {
                if (connect4[row][column] == 0) {
                    connect4[row][column] = playerTurn();
                    currentRow = row;
                    currentCol = column;
                    return true;
                } else
                    row--;
            }
        }catch(IndexOutOfBoundsException e) {
            System.out.println("this column is filled!");
            return false;
        }
    }
    public static void print(){
        for (int[] ints : connect4) {
            for (int column = 0; column < 7; column++) {
                if (ints[column] == 1)
                    System.out.print("|R");
                else if (ints[column] == 2)
                    System.out.print("|Y");
                else
                    System.out.print("| ");
            }
            System.out.println("|");
        }
    }
    public static boolean tieCondition(){
        int count=0;
        for (int i = 0; i < 7; i++){
            if (connect4[0][i] != 0)
                count++;
        }
        if (count == 7){
            flag = 1;
            return true;
        }else
            return false;
    }
    public static boolean winCondition(){
        int currentColor = playerTurn();
//        System.out.println(currentColor);
//        System.out.println(currentRow);
//        System.out.println(currentCol);
        int ccount = 0;
        for (int i = Math.max(0, currentRow-3); i <= Math.min(5, currentRow+3); i++){
            if(connect4[i][currentCol] == currentColor){
                ccount ++;
            }
            else {
                ccount = 0;
            }
            if(ccount == 4){
                return true;
            }
        }
        ccount = 0;
        for (int j = Math.max(0, currentCol-3); j <= Math.min(6, currentCol+3); j++){
            if(connect4[currentRow][j] == currentColor){
                ccount ++;
            }
            else {
                ccount = 0;
            }
            if(ccount == 4){
                return true;
            }
        }
        ccount = 0;
        for(int k = -3; k <= 3; k++){
            if(currentRow+k>=0 && currentRow+k <=5 && currentCol+k >=0 && currentCol+k <=6){
                if(connect4[currentRow+k][currentCol+k] == currentColor){
                    ccount ++;
                }
                else{
                    ccount = 0;
                }
                if(ccount == 4){
                    return  true;
                }
            }
        }
        ccount = 0;
        for(int k = 3; k >= -3; k--){
            if(currentRow+k>=0 && currentRow+k <=5 && currentCol-k >=0 && currentCol-k <=6){
//                System.out.println(currentRow+k);
//                System.out.println(currentCol-k);
//                System.out.println(ccount);
                if(connect4[currentRow+k][currentCol-k] == currentColor){
                    ccount ++;
                }
                else{
                    ccount = 0;
                }
                if(ccount == 4){
                    return  true;
                }
            }
        }
        return false;
    }
}