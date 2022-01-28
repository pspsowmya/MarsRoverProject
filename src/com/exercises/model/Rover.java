package com.exercises.model;

public class Rover implements NavigationControls {

     private String position;
     private String instruction;
     public int x;
     public int y;
     public String direction;

     public Rover(String position, String instruction){
         this.position = position;
         this.instruction = instruction;
     }

     public void splitGivenPositionToXYAndDirection(){
         x = Integer.parseInt(String.valueOf(position.charAt(0)));
         y = Integer.parseInt(String.valueOf(position.charAt(2)));
         direction = String.valueOf(position.charAt(4));
         System.out.println( x + " "+  y + " "+ direction);
     }


     public String getPositionBasedOnInstruction(){
         splitGivenPositionToXYAndDirection();
         for(int i=0; i<=instruction.length()-1; i++){
             if(instruction.charAt(i)=='L'){
                 position =  spinLeft();
             }
             else if(instruction.charAt(i)=='R'){
                 position =  spinRight();
             }
             else if(instruction.charAt(i)=='M'){
                position = movePosition();
             }
         }
         return position;
     }


    public String spinLeft(){
         if(direction.equals("N")){
             direction = "W";
         }
         else if(direction.equals("S")){
             direction = "E";
         }
         else if(direction.equals("E")){
             direction = "N";
         }
         else if(direction.equals("W")){
             direction = "S";
         }
        position = getCurrentPositionAsString(x, y ,direction);
        return position;
    }

    public String spinRight(){
        if(direction.equals("N")){
            direction = "E";
        }
        else if(direction.equals("S")){
            direction = "W";
        }
        else if(direction.equals("E")){
            direction = "S";
        }
        else if(direction.equals("W")){
            direction = "N";
        }
        position = getCurrentPositionAsString(x, y ,direction);
        return position;
    }

    public String movePosition(){
        if(direction.equals("N")){
            y = y+1;
        }
        else if(direction.equals("S")){
            y = y-1;
        }
        else if(direction.equals("E")){
            x = x+1;
        }
        else if(direction.equals("W")){
            x = x-1;
        }
        position = getCurrentPositionAsString(x, y ,direction);
        return position;
    }


    public String getCurrentPositionAsString(int x, int y, String direction){
         position = x + " "+ y + " "+ direction;
         return position;
    }

     public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

}
