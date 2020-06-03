import java.io.IOException;
import java.util.Scanner;

public class login {

    public static Scanner sc = new Scanner(System.in);
    Character choose = 0;
    Read read = new Read();

    public login(){}

    public static void main(String argus[]) {
        new login().showMenu();
    }

    public void showMenu(){
        /*try {
            new MissionList().setList(read.readMission());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("Please select the number:");
        System.out.println("1. Create a new Mission.");
        System.out.println("2. Edit an existing Mission");
        System.out.println("0. Exit");
        System.out.println("  ");
        System.out.println("  ");
        choose = sc.nextLine().charAt(0);
        switch (Integer.valueOf(choose)){
            case 1:
                new CreateMission().showMenu();break;
            case 2:
                new EditMenu().showMenu();
                break;
            case 0:
                System.exit(0);break;
            default:
                System.out.print('\u000C');
                System.out.println("Your enter the wrong number. Please enter again.");
                System.out.println(" ");
                System.out.println(" ");
                showMenu();break;
        }
    }
}
