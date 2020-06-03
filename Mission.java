import java.util.Date;

public class Mission {
    private int missionID;
    private String status;
    private String missionName;
    private String description;
    private String countryOforigin;
    private String countryAllowed;
    private String job;
    private String cargoRequirement;
    private String launchDate;
    private String location;
    private String duration;
    private Shuttle shuttle;
    private String eRequirement;

    public Mission(){}

    public Mission(int missionID, String status, String missionName, String description, String countryOforigin, String countryAllowed, String job, String cargoRequirement, String launchDate, String location, String duration, String eRequirement) {
        this.missionID = missionID;
        this.status = status;
        this.missionName = missionName;
        this.description = description;
        this.countryOforigin = countryOforigin;
        this.countryAllowed = countryAllowed;
        this.job = job;
        this.cargoRequirement = cargoRequirement;
        this.launchDate = launchDate;
        this.location = location;
        this.duration = duration;
        this.eRequirement = eRequirement;
    }

    public int getMissionID() {
        return missionID;
    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryOforigin() {
        return countryOforigin;
    }

    public void setCountryOforigin(String countryOforigin) {
        this.countryOforigin = countryOforigin;
    }

    public String getCountryAllowed() {
        return countryAllowed;
    }

    public void setCountryAllowed(String countryAllowed) {
        this.countryAllowed = countryAllowed;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public String getCargoRequirement() {
        return cargoRequirement;
    }

    public void setCargoRequirement(String cargoRequirement) {
        this.cargoRequirement = cargoRequirement;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Shuttle getShuttle() {
        return shuttle;
    }

    public void setShuttle(Shuttle shuttle) {
        this.shuttle = shuttle;
    }

    public String geteRequirement() {
        return eRequirement;
    }

    public void seteRequirement(String eRequirement) {
        this.eRequirement = eRequirement;
    }
}
