import java.util.Scanner;

public class EditMenu {
    public static Scanner sc = new Scanner(System.in);
    public static int choose;
    private char enter;

    public EditMenu() {
    }

    public void showMenu() {
        System.out.println("Please enter the number:");
        System.out.println("1. Edit mission Information");
        System.out.println("2. Shuttle Selection;");
        System.out.println("3. Employee Fast;");
        enter = sc.nextLine().charAt(0);

        //choose = Integer.valueOf(enter);

        switch (enter) {
            case '1':
                new EditMission();
                break;
            case '2':
                new ShuttleInfo();
                break;
            case '3':
                //new EmployeeInfo();
                break;
            case '0':
                System.exit(0);
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


