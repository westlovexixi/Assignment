import java.util.ArrayList;
import java.util.List;

public class MissionList {

    public MissionList(){}

    List<Mission> list = new ArrayList<>();

    public List<Mission> getList() {
        return list;
    }

    public void setList(List<Mission> list) {
        this.list = list;
    }

    public void addList(Mission mission){
        list.add(mission);
    }

    public Mission getMission(int missionID){
        Mission mission = new Mission();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getMissionID() == missionID){
                mission = list.get(i);
            }
        }
        return mission;
    }
}
