import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RealLogin {

    public static void main(String[] args) throws IOException {
        //login
        MissionList missionList = new MissionList();
        System.out.println("Welcome Mission TO Mars");
        boolean login = false;
        while (!login) {
            System.out.println("Please enter your account name");
            Scanner ac = new Scanner(System.in);
            String acc = ac.next();
            System.out.println("Please enter your password");
            String passw = ac.next();
            boolean hasAcc = readAccount(acc, passw);
            if (!hasAcc) {
                System.out.println("Please enter correct account or password");
                // System.exit(1);
            } else {
                login = hasAcc;
            }
        }
        new login().showMenu();
    }

    public static boolean readAccount(String acc, String passw) throws IOException {
        boolean login = false;
        InputStream in = new FileInputStream("sample missionToMars data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(in);
        XSSFSheet account = wb.getSheet("Admin");
        int rowa = account.getPhysicalNumberOfRows();
        List<HashMap> accountList = new ArrayList<>();
        for (int i = 0; i < rowa; i++) {
            if (i == 0) {
                continue;
            }
            XSSFRow rowInfor = account.getRow(i);
            HashMap<String, String> map = new HashMap<>();
            for (int cellIndex = 0; cellIndex < 2; cellIndex++) {
                XSSFCell cell = rowInfor.getCell(cellIndex);
                switch (cell.getCellType()) {
                    case NUMERIC:
                        int password = (int) cell.getNumericCellValue();
                        String pw = String.valueOf(password);
                        map.put("password", pw);
                        break;
                    case STRING:
                        String accountInfor = cell.getStringCellValue();
                        map.put("account", accountInfor);
                        break;
                    default:
                        break;
                }


            }
            accountList.add(map);
        }

        for (int i = 0; i < accountList.size(); i++) {
            if (acc.equals(accountList.get(i).get("account"))) {
                if (passw.equals(accountList.get(i).get("password"))) {
                    login = true;
                }
            }
        }
        in.close();
        return login;
    }
}
