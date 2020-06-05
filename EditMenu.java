import java.io.IOException;
import java.util.Scanner;

public class EditMenu {
    public static Scanner sc = new Scanner(System.in);
    public static int choose;
    private char enter;
    int mID;
    MissionList missionList = new MissionList();
    Mission mission = new Mission();

    public EditMenu() {
    }

    public void chooseMission() throws IOException {
        try {
            missionList.setList(new Read().readMission());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void check(int missionID) throws IOException {
        mission =  missionList.getMission(missionID);
        if (mission == null){
            System.out.println("Please try another ID.");
            System.out.println("  ");
            System.out.println("  ");
            chooseMission();
        }
        showMenu();
    }



    public void showMenu() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number:");
        System.out.println("1. Edit mission Information");
        System.out.println("2. Shuttle Selection;");
        System.out.println("3. Employee Fast;");
        System.out.println("0. Exit;");
        String e = scan.nextLine();

        switch (e) {
            case "1":
                new EditMission(mission).showMissionInfo();
                break;
            case "2":
                new ShuttleInfo(mission).edit();
                break;
            case "3":
                new SelectCan().selectCandidate(mission);
                break;
            case "0":
                new login().showMenu();
               // System.exit(0);
                break;
            default:
                System.out.print('\u000C');
                System.out.println("Your enter the wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                showMenu();break;
        }
    }
}


