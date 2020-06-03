import org.apache.poi.ss.excelant.IExcelAntWorkbookHandler;

import java.util.Scanner;

public class EditMission {

    public EditMission(){}



    public static Scanner sc= new Scanner(System.in);
    int mID;
    int choose;
    Mission mission = new Mission();

    public void showMenu() {
        boolean select = false;
        while (!select) {
            try {
                sc= new Scanner(System.in);
                System.out.println("Please enter your MissionID:");
                mID = sc.nextInt();
                select = true;
            } catch (Exception e) {
                System.out.println("Input a number");

            }
            check(mID);
        }
    }

    public void check(int missionID){
        mission = new MissionList().getMission(missionID);
        if (mission == null){
            System.out.println("Please try another ID.");
            System.out.println("  ");
            System.out.println("  ");
            showMenu();
        }else {
            showChange();
        }
    }

    public void showChange(){
        boolean select = false;
        while (!select){
            System.out.println("1. Change Mission Name;");
            System.out.println("2. Change Mission Description;");
            System.out.println("3. Change Mission Status;");
            System.out.println("4. Change Mission Country Allowed;");
            System.out.println("5. Change Mission Country of Origin;");
            System.out.println("6. Change Mission Job;");
            System.out.println("7. Change Mission Launch Date;");
            System.out.println("8. Change Mission Location;");
            System.out.println("9. Change Mission Duration;");
            System.out.println("10. ");
            try {
                sc= new Scanner(System.in);
                choose = sc.nextInt();
                select = true;
            }catch (Exception e){
                System.out.println("Please enter a number!");
            }
        }
        switch (choose){
            case 1:
                changeMissionName();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.out.println("PLease enter a valid number!");
                System.out.println("  ");
                System.out.println("  ");
                showChange();
                break;
        }
    }

    public void changeMissionName(){
        boolean select = false;
        int no = 0;
        String missionName;
        while (!select){
            System.out.println("You mission name: " + mission.getMissionName());
            System.out.println("1. Change mission name;");
            System.out.println("2. Exit.");
            try{
                sc = new Scanner(System.in);
                no = sc.nextInt();
                select = true;
            } catch (Exception e){
                System.out.println("Input a valid number.");
            }
        }
        switch (no){
            case 1:
                System.out.println("Please enter mission new name:");
                missionName = sc.nextLine();
                mission.setMissionName(missionName);
                System.out.print('\u000C');
                System.out.println("Mission's new Name:" + mission.getMissionName());
                System.out.println("Click enter to go back.");
                sc.nextLine();
                showMenu();
                break;
            case 2:
                System.out.print('\u000C');
                showMenu();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                changeMissionName();
                break;
        }
    }

    public void changeMissionDesc(){
        boolean select = false;
        int no = 0;
        String missionDesc;
        while (!select){
            System.out.println("You mission description: " + mission.getDescription());
            System.out.println("1. Change mission description;");
            System.out.println("2. Exit.");
            try{
                sc = new Scanner(System.in);
                no = sc.nextInt();
                select = true;
            } catch (Exception e){
                System.out.println("Input a valid number.");
            }
        }
        switch (no){
            case 1:

        }

    }

}
