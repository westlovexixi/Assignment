import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateMission {

    public CreateMission() {
    }


    public static Scanner sc = new Scanner(System.in);
    public static int choose;
    public Mission mission = new Mission();
    String missionName;
    String missionDescription;
    String countryOfOrigin;
    String countryOfAllow;
    String job;
    String launchDate;
    String location;
    String status;
    String cRequirement;
    String jobNo;
    String enter;
    String duration;
    String eRequirement;

    public static void main(String argus[]) throws IOException {
        new CreateMission().showMenu();
    }


    public void showMenu() throws IOException {
        System.out.println("Please enter the number:");
        System.out.println("1. Create new mission");
        if (mission.getMissionName() != null) {
            System.out.println("2. Change mission name;");
            System.out.println("3. Change mission description;");
            System.out.println("4. Change mission's country of origin;");
            System.out.println("5. Change mission's country of allowed;");
            System.out.println("6. Change mission's job;");
            System.out.println("7. Change mission's employmentRequirement;");
            System.out.println("8. Change mission's cargoRequirement;");
            System.out.println("9. Change mission's launch date;");
            System.out.println("10. Change mission's location;");
            System.out.println("11. Change mission's state;");
            System.out.println("12. Change mission's duration;");
            System.out.println("0. Exit.");
        } else {
            System.out.println("0. Exit.");
        }
        enter = sc.nextLine();

        if(!isNumeric(enter)){
            System.out.println("Please enter a number!");
            System.out.println("  ");
            System.out.println("  ");
            showMenu();
        }

        choose = Integer.valueOf(enter);

        switch (choose) {
            case 1:
                CollectMissionInfo();
                break;
            case 2:
                changeMissionName();
                break;
            case 3:
                changeMissionDesc();
                break;
            case 4:
                changeCountryOfOrigin();
                break;
            case 5:
                changeCountryOfAllowed();
                break;
            case 6:
                changeMissionJob();
                break;
            case 7:
                changeMissionEmploymentRequirement();
                break;
            case 8:
                changeCargoRequirement();
                break;
            case 9:
                changeLaunchDate();
                break;
            case 10:
                changeMissionLocation();
                break;
            case 11:
                changeMissionStatus();
                break;
            case 12:
                changeMissionDuration();
                break;
            case 0:
                if (mission.getMissionName() != null){
                    new MissionList().addList(mission);
                }
                new login().showMenu();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Your enter the wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                showMenu();
                break;
        }
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;
        }

        Matcher isNum = pattern.matcher(bigStr);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


    public void CollectMissionInfo() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter you Mission Name:(click enter to exit create)");
        missionName = sc.nextLine();
        if (missionName.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            mission.setMissionName(missionName);
        }
        System.out.print('\u000C');

        System.out.println("Please enter Mission description:(click enter to exit create)");
        missionDescription = sc.nextLine();
        if (missionDescription.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            mission.setDescription(missionDescription);
        }
        System.out.print('\u000C');

        System.out.println("Please enter your Country Of Origin:(click enter to exit create)");
        countryOfOrigin = sc.nextLine();
        if (countryOfOrigin.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            mission.setCountryOforigin(countryOfOrigin);
        }
        System.out.print('\u000C');

        System.out.println("Please enter Country of Allowed:(click enter to exit create)");
        countryOfAllow = sc.nextLine();
        if (countryOfAllow.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            mission.setCountryAllowed(countryOfAllow);
        }
        System.out.print('\u000C');

        System.out.println("Please enter Mission's duration:(click Enter to exit create)");
        duration = sc.nextLine();
        if (duration.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            mission.setDuration(duration);
        }
        System.out.print('\u000C');


        System.out.println("Please choose your Job:(click Enter to exit create)");
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
            Scanner scanv = new Scanner(System.in);
            int a = sc.nextInt();
            job = String.valueOf(a);
            if (job.length() == 0){
                System.out.print('\u000C');
                showMenu();
            } else {
                mission.setJob(job);
                System.out.println("Please enter the total number of job you need:");
                jobNo = sc.nextLine();
            }
            System.out.print('\u000C');
        }catch (Exception e){
            System.out.println("Enter a number");
        }

        /*System.out.println("Please choose your Employment Requirement:(click Enter to exit create)");
        eRequirement = sc.nextLine();*/

        System.out.println("Please choose your Cargo For:(click Enter to exit create)");
        System.out.println("1. journey");
        System.out.println("2. mission");
        System.out.println("3. journeyAndMission");
        cRequirement = sc.nextLine();
        if (cRequirement.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            mission.setCargoRequirement(cRequirement);
        }
        System.out.print('\u000C');


        System.out.println("Please enter your Launch Date:(DD/MM/YYYY)(click Enter to exit create)");
        launchDate = sc.nextLine();
        if (launchDate.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            mission.setLaunchDate(launchDate);
        }
        System.out.print('\u000C');

        System.out.println("Please enter your location:(click Enter to exit create)");
        location = sc.nextLine();
        if (location.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            mission.setLocation(location);
        }
        System.out.print('\u000C');



        showState();
    }

    public void showState() throws IOException {
        System.out.println("Please select your status:(click Enter to exit create)");
        System.out.println("1. Planning phase");
        System.out.println("2. Departed Earth");
        System.out.println("3. Landed on Mars");
        System.out.println("4. Mission in progress");
        System.out.println("5. Returned to Earth");
        System.out.println("6. Mission completed");
        status = sc.nextLine();
        if (status.length() == 0){
            System.out.print('\u000C');
            showMenu();
        } else {
            switch (Integer.valueOf(status)){
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
                default:
                    System.out.print('\u000C');
                    System.out.println("Your enter the wrong number. Please Enter again.");
                    System.out.println(" ");
                    System.out.println(" ");
                    showState();break;
            }
        }
        System.out.print('\u000C');
        showMenu();
    }


    public void changeMissionName() throws IOException {
        System.out.println("Your mission name:" + missionName);
        System.out.println("1. Change mission name;");
        System.out.println("2. Exit.");
        Scanner sc = new Scanner(System.in);
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Please enter mission new name:");
                missionName = sc.nextLine();
                mission.setMissionName(missionName);
                System.out.print('\u000C');
                System.out.println("Mission's new Name:" + mission.getMissionName());
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
            changeMissionName();break;
        }
    }

    public void changeMissionDesc() throws IOException {
        System.out.println("Your mission description:" + mission.getDescription());
        System.out.println("1. Change mission description;");
        System.out.println("2. Exit.");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Please enter new description:");
                missionDescription = sc.nextLine();
                mission.setDescription(missionDescription);
                System.out.print('\u000C');
                System.out.println("Mission's new description:" + mission.getDescription());
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
                changeMissionDesc();break;
        }
    }

    public void changeCountryOfOrigin() throws IOException {
        System.out.println("Your mission's Country Of Origin:" + mission.getCountryOforigin());
        System.out.println("1. Change mission's Country Of Origin;");
        System.out.println("2. Exit.");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Please enter new Country Of Origin:");
                countryOfOrigin = sc.nextLine();
                mission.setCountryOforigin(countryOfOrigin);
                System.out.print('\u000C');
                System.out.println("Mission's new Country Of Origin:" + mission.getCountryOforigin());
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
                changeCountryOfOrigin();break;
        }
    }


    public void changeCountryOfAllowed() throws IOException {
        System.out.println("Your mission's Country of Allowed:" + mission.getCountryAllowed());
        System.out.println("1. Change mission's Country of Allowed;");
        System.out.println("2. Exit.");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Please enter new Country of Allowed:");
                countryOfAllow = sc.nextLine();
                mission.setCountryAllowed(countryOfAllow);
                System.out.print('\u000C');
                System.out.println("Mission's new Country of Allowed:" + mission.getCountryAllowed());
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
                changeCountryOfAllowed();break;
        }
    }

    public void changeMissionJob() throws IOException {
        boolean select = false;
        System.out.println("Your mission Job is:" + mission.getJob());
        while (!select){
            System.out.println("1. Change mission Jon;");
            System.out.println("2. Exit.");
            try {
                choose = sc.nextInt();
                select = true;
            }catch (Exception e){
                System.out.println("Input a valid number!");

            }
        }
        switch (choose){
            case 1:
                select = false;
                int no = 0;
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
                        no = sc.nextInt();
                        select = true;
                    } catch (Exception e){
                        System.out.println("Input a valid number!");
                        System.out.println("  ");
                        System.out.println("  ");
                    }
                }
                changeJob(no);
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
                changeMissionJob();break;
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

    public void changeMissionDuration() throws IOException{
        System.out.println("Your mission duration is:" + mission.getDuration());
        System.out.println("1. Change mission's launch date;");
        System.out.println("2. Exit.");
        choose = sc.nextInt();
        switch (choose){
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
                changeMissionDuration();break;
        }
    }

    public void changeMissionEmploymentRequirement(){

    }

    public void changeCargoRequirement() throws IOException{
        boolean select = false;
        System.out.println("Your mission's cargo requirement: " + mission.getCargoRequirement());
        while (!select){
            System.out.println("1. Change mission cargo requirement;");
            System.out.println("2. Exit.");
            try {
                sc = new Scanner(System.in);
                choose = sc.nextInt();
                select = true;
            } catch (Exception e){
                System.out.println("Input a valid number!");
                System.out.println("  ");
                System.out.println("  ");
            }
        }
        switch (choose){
            case 1:
                select = false;
                int no = 0;
                System.out.println("Please choose a new cargo");
                while (!select){
                    System.out.println("1. journey");
                    System.out.println("2. mission");
                    System.out.println("3. journeyAndMission");
                    try {
                        sc = new Scanner(System.in);
                        no = sc.nextInt();
                        select = true;
                    }catch (Exception e){
                        System.out.println("Input a valid number!");
                        System.out.println("  ");
                        System.out.println("  ");
                    }
                    switch (no){
                        case 1:
                            mission.setCargoRequirement("journey");
                            break;
                        case 2:
                            mission.setCargoRequirement("mission");
                            break;
                        case 3:
                            mission.setCargoRequirement("journeyAndMission");
                            break;
                        default:
                            System.out.print('\u000C');
                            System.out.println("Wrong number. Please try again.");
                            System.out.println(" ");
                            System.out.println(" ");
                            changeCargoRequirement();break;
                    }
                }
                System.out.println("Change successful!");
                System.out.println("  ");
                System.out.println("  ");
                changeCargoRequirement();
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
                changeCargoRequirement();break;
        }
    }


    public void changeLaunchDate() throws IOException{
        System.out.println("Your mission's launch date:" + mission.getLaunchDate());
        System.out.println("1. Change mission's launch date;");
        System.out.println("2. Exit.");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Please enter new launch date:(DD/MM/YYYY)");
                launchDate = sc.nextLine();
                mission.setLaunchDate(launchDate);
                System.out.print('\u000C');
                System.out.println("Mission's new location:" + mission.getLaunchDate());
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
                changeMissionLocation();break;
        }
    }

    public void changeMissionLocation() throws IOException{
        System.out.println("Your mission's location:" + mission.getLocation());
        System.out.println("1. Change mission location;");
        System.out.println("2. Exit.");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Please enter new location:");
                location = sc.nextLine();
                mission.setLocation(location);
                System.out.print('\u000C');
                System.out.println("Mission's new location:" + mission.getLocation());
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
                changeMissionLocation();break;
        }
    }

    public void changeMissionStatus() throws IOException{
        System.out.println("Your mission status:" + mission.getStatus());
        System.out.println("1. Change mission status;");
        System.out.println("2. Exit.");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Please enter new status:");
                status = sc.nextLine();
                mission.setStatus(status);
                System.out.print('\u000C');
                System.out.println("Mission's new status:" + mission.getStatus());
                System.out.println("Click Enter to go back.");
                sc.nextLine();
                showMenu();
                break;
            case 2:
                showMenu();
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                changeMissionStatus();break;
        }
    }
}
