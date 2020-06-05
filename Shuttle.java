import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Shuttle {
    private String shuttleId;
    private String Name;
    private String year;
    private double fuelCapacity;
    private double passenger;
    private double cargoCap;
    private double speed;
    private String origin;

    public Shuttle(String shuttleId, String name, String year, double fuelCapacity, double passenger, double cargoCap, double speed, String origin) {
        this.shuttleId = shuttleId;
        Name = name;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
        this.passenger = passenger;
        this.cargoCap = cargoCap;
        this.speed = speed;
        this.origin = origin;
    }

    public Shuttle() {

    }

    public String getShuttleId() {
        return shuttleId;
    }

    public void setShuttleId(String shuttleId) {
        this.shuttleId = shuttleId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getPassenger() {
        return passenger;
    }

    public void setPassenger(double passenger) {
        this.passenger = passenger;
    }

    public double getCargoCap() {
        return cargoCap;
    }

    public void setCargoCap(double cargoCap) {
        this.cargoCap = cargoCap;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Shuttle>  readshuttle() throws IOException {
        InputStream in = new FileInputStream("sample missionToMars data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(in);
        XSSFSheet shuttle = wb.getSheet("shuttles");
        int row = shuttle.getPhysicalNumberOfRows();
        List<Shuttle> Allshuttle = new ArrayList<>();
        List<String> shuttleInfor = new ArrayList<>();
        for(int i = 0; i < row; i++){
            if(i == 0){
                continue;
            }
            XSSFRow rowInfor = shuttle.getRow(i);
            shuttleInfor = new ArrayList<>();
            for (int cellIndex =0;cellIndex < 8;cellIndex++){
                XSSFCell cell = rowInfor.getCell(cellIndex);
                switch (cell.getCellType()){
                    case NUMERIC:
                        Double doublev = cell.getNumericCellValue();
                        String value = String.valueOf(doublev);
                        shuttleInfor.add(value);
                        //System.out.println(cell.getNumericCellValue());
                        break;
                    case STRING:
                        String infor = cell.getStringCellValue().toString();
                        shuttleInfor.add(infor);
                        //System.out.println("row value"+cell.getStringCellValue().toString());
                        break;
                    default:
                        break;
                }

            }
            String id = String.valueOf(shuttleInfor.get(0));
            String name = shuttleInfor.get(1);
            String year = shuttleInfor.get(2);
            double fuelCapacity = Double.valueOf(shuttleInfor.get(3));
            Double passenger = Double.valueOf(shuttleInfor.get(4));
            double cargoCap = Double.valueOf(shuttleInfor.get(5));
            double speed = Double.valueOf(shuttleInfor.get(6));
            String origin = shuttleInfor.get(7);;
            Shuttle shuttle1 = new Shuttle(id,name,year,fuelCapacity,passenger,cargoCap,speed,origin);
            Allshuttle.add(shuttle1);

        }
        return Allshuttle;
    }
}
