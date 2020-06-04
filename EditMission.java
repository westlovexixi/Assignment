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
            System.out.println("10. Exit");
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
                ChangeMissionName();
                break;
            case 2:
                ChangeMissionDesc();
                break;
            case 3:
                ChangeMissionStatus();
                break;
            case 4:
                ChangeCountryAllowed();
                break;
            case 5:
                ChangeCountryOrigin();
                break;
            case 6:
                ChangeJob();
                break;
            case 7:
                ChangeDate();
                break;
            case 8:
                ChangeLocation();
                break;
            case 9:
                ChangeDuration();
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

    public void ChangeMissionName(){
        boolean select = false;
        int no = 0;
        String missionName;
        System.out.println("You mission name: " + mission.getMissionName());
        while (!select){
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
                showChange();
                break;
            case 2:
                System.out.print('\u000C');
                showChange();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                ChangeMissionName();
                break;
        }
    }

    public void ChangeMissionDesc(){
        boolean select = false;
        int no = 0;
        String missionDesc;
        System.out.println("You mission description: " + mission.getDescription());
        while (!select){
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
                System.out.println("Please enter new description:");
                missionDesc = sc.nextLine();
                mission.setDescription(missionDesc);
                System.out.print('\u000C');
                System.out.println("Mission's new description:" + mission.getDescription());
                System.out.println("Click Enter to go back.");
                sc.nextLine();
                showChange();
                break;
            case 2:
                System.out.print('\u000C');
                showChange();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                ChangeMissionDesc();break;

        }

    }

    public void ChangeMissionStatus(){
        boolean select = false;
        int no = 0;
        int status = 0;
        System.out.println("You mission status: " + mission.getStatus());
        while (!select){
            System.out.println("1. Change mission status;");
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
                while(!select){
                    System.out.println("Please select new status:");
                    System.out.println("1. Planning phase");
                    System.out.println("2. Departed Earth");
                    System.out.println("3. Landed on Mars");
                    System.out.println("4. Mission in progress");
                    System.out.println("5. Returned to Earth");
                    System.out.println("6. Mission completed");
                    try{
                        sc = new Scanner(System.in);
                        status = sc.nextInt();
                        select = true;
                    } catch (Exception e){
                        System.out.println("Input a valid number.");
                    }
                    ChangeStatus(status);
                }break;
            case 2:
                System.out.print('\u000C');
                showChange();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                ChangeMissionDesc();break;
        }
    }

    public void ChangeStatus(int no){
        switch (no){
            case 1:
                mission.setStatus("Planning phase");break;
            case 2:
                mission.setStatus("Departed Earth");break;
            case 3:
                mission.setStatus("Landed on Mars");break;
            case 4:
                mission.setStatus("Mission in progress");break;
            case 5:
                mission.setStatus("Returned to Earth");break;
            case 6:
                mission.setStatus("Mission completed");break;
        }
    }

    public void ChangeCountryAllowed(){
        boolean select = false;
        int no = 0;
        String countryOfAllow;
        System.out.println("Your mission's Country of Allowed:" + mission.getCountryAllowed());
        while (!select){
            System.out.println("1. Change mission's Country of Allowed;");
            System.out.println("2. Exit.");
            try{
                sc = new Scanner(System.in);
                no = sc.nextInt();
                select = true;
            } catch (Exception e){
                System.out.println("Input a valid number.");
            }
        }
        switch (no) {
            case 1:
                System.out.println("Please enter new Country of Allowed:");
                countryOfAllow = sc.nextLine();
                mission.setCountryAllowed(countryOfAllow);
                System.out.print('\u000C');
                System.out.println("Mission's new Country of Allowed:" + mission.getCountryAllowed());
                System.out.println("Click enter to go back.");
                sc.nextLine();
                showChange();
                break;
            case 2:
                System.out.print('\u000C');
                showChange();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                ChangeCountryAllowed();break;
        }
    }

    public void ChangeCountryOrigin(){
        boolean select = false;
        int no = 0;
        String countryOfOrigin;
        System.out.println("Your mission's Country Of Origin:" + mission.getCountryOforigin());
        while (!select){
            System.out.println("1. Change mission's Country Of Origin;");
            System.out.println("2. Exit.");
            try{
                sc = new Scanner(System.in);
                no = sc.nextInt();
                select = true;
            } catch (Exception e){
                System.out.println("Input a valid number.");
            }
        }
        switch (no) {
            case 1:
                System.out.println("Please enter new Country Of Origin:");
                countryOfOrigin = sc.nextLine();
                mission.setCountryOforigin(countryOfOrigin);
                System.out.print('\u000C');
                System.out.println("Mission's new Country Of Origin:" + mission.getCountryOforigin());
                System.out.println("Click enter to go back.");
                sc.nextLine();
                showChange();
                break;
            case 2:
                System.out.print('\u000C');
                showChange();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                ChangeCountryOrigin();break;
        }
    }

    public void ChangeJob(){
        boolean select = false;
        int no = 0;
        String countryOfOrigin;
        System.out.println("Your mission's Job is:" + mission.getJob());
        while (!select){
            System.out.println("1. Change mission's Job;");
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
                select = false;
                int number = 0;
                System.out.println("Please select a new Job:");
                while (!select){
                    System.out.println("1. builder");
                    System.out.println("2. carpenter");
                    System.out.println("3. civil engineer");
                    System.out.println("4. designer");
                    System.out.println("5. electrician");
                    System.out.println("6. general practitioner");
                    System.out.println("7. manufacturer");
                    System.out.println("8. nurse");
                    System.out.println("9. painter");
                    System.out.println("0. surgeon");
                    try {
                        sc = new Scanner(System.in);
                        number = sc.nextInt();
                        select = true;
                    } catch (Exception e){
                        System.out.println("Input a valid number!");
                        System.out.println("  ");
                        System.out.println("  ");
                    }
                }
                changeJob(number);
            case 2:
                System.out.print('\u000C');
                showChange();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                ChangeJob();break;
        }
    }

    public void changeJob(int no){
        switch (no){
            case 1:
                mission.setJob("builder");
                break;
            case 2:
                mission.setJob("carpenter");
                break;
            case 3:
                mission.setJob("civil engineer");
                break;
            case 4:
                mission.setJob("designer");
                break;
            case 5:
                mission.setJob("electrician");
                break;
            case 6:
                mission.setJob("general practitioner");
                break;
            case 7:
                mission.setJob("manufacturer");
                break;
            case 8:
                mission.setJob("nurse");
                break;
            case 9:
                mission.setJob("painter");
                break;
            case 10:
                mission.setJob("surgeon");
                break;
        }
    }

    public void ChangeDate(){
        boolean select = false;
        int no = 0;
        String launchDate;
        System.out.println("Your mission's launch date:" + mission.getLaunchDate());
        while (!select){
            System.out.println("1. Change mission's launch date;");
            System.out.println("2. Exit.");
            try {
                sc = new Scanner(System.in);
                no = sc.nextInt();
                select = true;
            }catch (Exception e){
                System.out.println("Input a valid number!");
            }
        }
        switch (no){
            case 1:
                System.out.println("Please enter new launch date:(DD/MM/YYYY)");
                launchDate = sc.nextLine();
                mission.setLaunchDate(launchDate);
                System.out.print('\u000C');
                System.out.println("Mission's new location:" + mission.getLaunchDate());
                System.out.println("Click enter to go back.");
                sc.nextLine();
                showMenu();
                break;
            case 2:
                System.out.print('\u000C');
                showChange();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                ChangeDate();break;
        }
    }

    public void ChangeLocation(){
        boolean select = false;
        int no = 0;
        String location;
        System.out.println("Your mission's location:" + mission.getLocation());
        while (!select){
            System.out.println("1. Change mission location;");
            System.out.println("2. Exit.");
            try {
                no = sc.nextInt();
                select = true;
            } catch (Exception e){
                System.out.println("Input a valid number!");
                System.out.println("  ");
                System.out.println("  ");
            }
        }
        switch (no){
            case 1:
                System.out.println("Please enter new location:");
                location = sc.nextLine();
                mission.setLocation(location);
                System.out.print('\u000C');
                System.out.println("Mission's new location:" + mission.getLocation());
                System.out.println("Click enter to go back.");
                sc.nextLine();
                showChange();
                break;
            case 2:
                System.out.print('\u000C');
                showChange();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                ChangeLocation();break;
        }

    }

    public void ChangeDuration(){
        boolean select = false;
        int no = 0;
        String duration;
        System.out.println("Your mission's duration:" + mission.getDuration());
        while (!select){
            System.out.println("1. Change mission duration;");
            System.out.println("2. Exit.");
            try {
                no = sc.nextInt();
                select = true;
            } catch (Exception e){
                System.out.println("Input a valid number!");
                System.out.println("  ");
                System.out.println("  ");
            }
        }
        switch (no){
            case 1:
                System.out.println("Please enter a new duration:");
                duration = sc.nextLine();
                mission.setDuration(duration);
                System.out.print('\u000C');
                System.out.println("Mission's new duration is:" + mission.getDuration());
                System.out.println("Click Enter to go back.");
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
                ChangeDuration();break;
        }
    }
}
