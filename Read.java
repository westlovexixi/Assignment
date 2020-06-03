
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.*;

import static org.apache.poi.ss.usermodel.CellType.*;

public class Read {
    public static void main(String[] args) throws IOException {

       // new CreateMission().showMenu();
        System.out.println("Welcome Mission TO Mars");
        boolean login = false;
        while (!login) {
            System.out.println("Please enter your account name");
            Scanner ac = new Scanner(System.in);
            String acc = ac.next();
            System.out.println("Please enter your password");
            String passw = ac.next();
            boolean hasAcc = readAccount(acc,passw);
            if (!hasAcc){
                System.out.println("Please enter correct account or password");
               // System.exit(1);
            }else {
                login = hasAcc;
            }
        }
        List<Shuttle> allShuttle = new Shuttle().readshuttle();




        List<CandidateInfor> selectInfors = readCandid();
        int canSize = selectInfors.size();
        while (canSize != 0) {
            //int canSize = selectInfors.size();
            Scanner sc = new Scanner(System.in);
            int numOfCan = -1;
            boolean select  = false;
            while (!select) {
                try {
                    sc = new Scanner(System.in);
                    System.out.println("please select candidate");
                    numOfCan = sc.nextInt();
                    if (numOfCan > canSize){
                        System.out.println("No Candidate");
                        sc = new Scanner(System.in);
                    }else
                        select = true;
                    selectInfors.remove(numOfCan-1);
                }catch (Exception e){
                    System.out.println("Please select number behind Candidate id");
                }
            }

                System.out.println("Select more? 1.Yes  2.No");
                sc = new Scanner(System.in);
                int choose = sc.nextInt();
                if (choose != 1 || choose != 2) {
                    System.out.println("Enter number 1 or 2");
                }
                if (choose == 2){
                    break;
                }


        }
       /* int canSize = selectInfors.size();
        Scanner sc = new Scanner(System.in);
        int numOfCan = -1;
        boolean select  = false;
        while (!select) {
            try {
                sc = new Scanner(System.in);
                System.out.println("please select candidate");
                numOfCan = sc.nextInt();
                if (numOfCan > canSize){
                    System.out.println("No Candidate");
                    sc = new Scanner(System.in);
                }else
                    select = true;
            }catch (Exception e){
                System.out.println("Please select number behind Candidate id");
            }
        }*/

        List<CandidateInfor> adminSelect = new ArrayList<>();
    }



    public static boolean readAccount(String acc, String passw) throws IOException {
        boolean login = false;
        InputStream in = new FileInputStream("sample missionToMars data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(in);
        XSSFSheet account = wb.getSheet("Admin");
        int rowa = account.getPhysicalNumberOfRows();
        List<HashMap> accountList = new ArrayList<>();
        for(int i = 0; i < rowa; i++){
            if(i == 0){
                continue;
            }
            XSSFRow rowInfor = account.getRow(i);
            HashMap<String,String> map = new HashMap<>();
            for (int cellIndex =0;cellIndex < 2;cellIndex++){
                XSSFCell cell = rowInfor.getCell(cellIndex);
                switch (cell.getCellType()){
                    case NUMERIC:
                        int password = (int) cell.getNumericCellValue();
                        String pw = String.valueOf(password);
                        map.put("password",pw);
                        break;
                    case STRING:
                        String accountInfor = cell.getStringCellValue();
                        map.put("account",accountInfor);
                        break;
                    default:
                        break;
                }


            }
            accountList.add(map);
        }

        for (int i = 0; i < accountList.size(); i++) {
            if(acc.equals(accountList.get(i).get("account"))){
                if (passw.equals(accountList.get(i).get("password"))) {
                    login = true;
                }
            }
        }
        in.close();
        return login;
    }

    public static List<CandidateInfor> readCandid() throws IOException {
        int workyear = -1;
        boolean correct = false;
        while (!correct) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter year of work experience");
                workyear  = sc.nextInt();
                correct = true;
            }catch (Exception e){
                System.out.println("please enter a number");
                // System.out.println("please enter to input a number");
                // Scanner next = new Scanner(System.in);
                // String nextline = next.nextLine();
            }
        }
        InputStream in = new FileInputStream("sample missionToMars data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(in);
        XSSFSheet candidate = wb.getSheet("candidates");
        int crow = candidate.getPhysicalNumberOfRows();
        List<CandidateInfor> candidateInfors = new ArrayList<>();
        List<String> canInfor = new ArrayList<>();
        for(int i = 0; i < crow; i++){
            if(i == 0){
                continue;
            }
            XSSFRow rowInfor = candidate.getRow(i);
            canInfor = new ArrayList<>();
            XSSFCell cell = rowInfor.getCell(14);
            if (rowInfor.getCell(14)==null ||rowInfor.getCell(13)==null){
                continue;
            }
            // candidate id
            XSSFCell cell1 = rowInfor.getCell(0);
            int doublid = (int) cell1.getNumericCellValue();
            String id = String.valueOf(doublid);
            // candidate name
            XSSFCell cell2 = rowInfor.getCell(1);
            String name = cell2.getStringCellValue().toString();
            //candidate job and year experience
            XSSFCell cell3 = rowInfor.getCell(13);
            String yearInfor = cell3.getStringCellValue().replace("yr", " ");
            List<String> year = Arrays.asList(yearInfor.split(","));
            XSSFCell cell4 = rowInfor.getCell(14);
            String JobInfor = cell4.getStringCellValue();
            List<String> jobin = Arrays.asList(JobInfor.split(","));
            List<Job> jobInfor = new ArrayList<>();
            if (year.size() >= jobin.size()) {
                for (int n = 0; n <jobin.size();n++ ) {
                    String jobname = jobin.get(n);
                    Double y= Double.parseDouble(year.get(n));
                    Job job = new Job(jobname,y);
                    jobInfor.add(job);
                }
            }
            else{
                for (int n = 0; n <year.size();n++ ) {
                    String jobname = jobin.get(n);
                    Double y= Double.parseDouble(year.get(n));
                    Job job = new Job(jobname,y);
                    jobInfor.add(job);
                }
            }
            CandidateInfor can = new CandidateInfor(id,name,jobInfor);
            candidateInfors.add(can);
        }
        String chooseJob = "civil engineer";
        System.out.println("The year of work experience is " + workyear );
        List<CandidateInfor> selectCan = new ArrayList<>();
        for (int n = 0; n < candidateInfors.size();n ++) {
            int m = candidateInfors.get(n).getJobList().size();
            for (int a = 0; a < m; a ++ ) {
                if (candidateInfors.get(n).getJobList().get(a).getName().equals(chooseJob) &&
                        candidateInfors.get(n).getJobList().get(a).getYear() > workyear){
                    selectCan.add(candidateInfors.get(n));
                }
            }
        }

        System.out.println("There are "+selectCan.size()+" candidate to select");
        for (int p = 0; p < selectCan.size();p++ ) {
            int m = selectCan.get(p).getJobList().size();
            for (int a = 0; a < m; a ++ ) {
                if (selectCan.get(p).getJobList().get(a).getName().equals(chooseJob)){
                    System.out.println((p+1) + ":"+ "Candidate id: " + selectCan.get(p).getId());
                    System.out.println("  Candidate name: " +selectCan.get(p).getName() );
                    System.out.println("  Work year: " + selectCan.get(p).getJobList().get(a).getYear());
                    System.out.println("  Job: " + selectCan.get(p).getJobList().get(a).getName());
                }
            }
        }
        in.close();
        return selectCan;
    }




}

