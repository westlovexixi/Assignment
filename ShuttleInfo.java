import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ShuttleInfo {

    public ShuttleInfo(Mission mission){
        this.mission = mission;
    }

    public static Scanner sc = new Scanner(System.in);
    Character choose = 0;

    String missionID;
    String enterID;
    Mission mission = new Mission();
    List<Shuttle> shuttles = new ArrayList<>();
    Read read = new Read();


    public void edit() throws IOException {

        try {
            shuttles = read.Read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < shuttles.size(); i += 10) {
            for (int j = 0; j < 10; j++) {


                System.out.println("Shuttle id: " + shuttles.get(i + j).getShuttleId());
                System.out.println("Shuttle name: " + shuttles.get(i + j).getName());
                System.out.println("Manufacturing year: " + shuttles.get(i + j).getYear());
                System.out.println("Fuel capacity: " + shuttles.get(i + j).getFuelCapacity());
                System.out.println("Passenger capacity: " + shuttles.get(i + j).getPassenger());
                System.out.println("Cargo capacity: " + shuttles.get(i + j).getCargoCap());
                System.out.println("Travel speed: " + shuttles.get(i + j).getSpeed());
                System.out.println("Shuttle origin: " + shuttles.get(i + j).getOrigin());
                System.out.println("");
            }
            System.out.println("Please select :");
            System.out.println("1. Select Shuttle");
            System.out.println("2. Next Page");
            System.out.println("0. Exit");
            System.out.println("  ");
            System.out.println("  ");
            do {
                choose = '9';
                choose = sc.nextLine().charAt(0);
                switch (choose) {
                    case '1':
                        System.out.println("Enter Shuttle Id");
                        String tempID = sc.nextLine();
                        mission.setShuttle(getShuttle(tempID));//try catch?
                        System.out.println("New Shuttle is " + mission.getShuttle().getShuttleId());
                        new EditMenu().chooseMission();
                        break;
                    case '2':
                        break;
                    case '0':
                       // System.exit(0);
                        new EditMenu().chooseMission();
                        break;
                    default:
                        System.out.print('\u000C');
                        System.out.println("Your enter the wrong number. Please enter again.");
                        System.out.println(" ");
                        System.out.println(" ");
                        break;
                }
            }while (choose != '2');
        }


    }

    public Shuttle getShuttle(String shuttleID){
        Shuttle shuttle = new Shuttle();
        for (int i = 0; i < shuttles.size(); i++){
            if (shuttles.get(i).getShuttleId().equals(shuttleID)){
                shuttle = shuttles.get(i);
            }
        }
        return shuttle;
    }
}
