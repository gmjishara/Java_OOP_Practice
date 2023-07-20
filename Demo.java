import java.security.interfaces.DSAKey;
import java.util.Random;
import java.util.*;

class WaterLevelObserver{
    public void update(int waterLevel){
        //
    }
}

class Alarm extends WaterLevelObserver{
    public  void update(int waterLevel) {
        System.out.println(waterLevel >= 50 ? "ON" : "OFF");
    }
}

class Spliter extends WaterLevelObserver {
    public  void spliterOperate(int waterLevel) {
        System.out.println(waterLevel >= 75 ? "Spliter ON" : "Spliter OFF");
    }
}

class Display extends WaterLevelObserver {
    public static void displayLevel(int waterLevel) {
        System.out.println("Water Level: " + waterLevel);
    }
}

class Message extends WaterLevelObserver {
    public static void sendSMS(int waterLevel) {
        System.out.println("Sending SMS......" + waterLevel);
    }
}

class ControlRoom {
    private WaterLevelObserver[] observer = new WaterLevelObserver[100];

    int index=0;
    private int waterLevel;

    public void notifyObj() {
        for(int i=0;i<index;i++){
            observer[i].update(waterLevel);
        }
    }

    public void setWaterLevel(int waterLevel) {
        if (this.waterLevel != waterLevel) {
            this.waterLevel = waterLevel;
            notifyObj();
        }
    }

    public void addWaterLevelObserver(WaterLevelObserver obj){
        observer[index++]=obj;
    }
}

public class Demo {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ControlRoom obj = new ControlRoom();
        obj.addWaterLevelObserver(new Alarm());
        obj.addWaterLevelObserver(new Display());

        System.out.print("Input the water level: ");
        int waterLevel=input.nextInt();
        obj.setWaterLevel(waterLevel);

    }
}
