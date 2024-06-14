package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Diploma implements Serializable {
    public int id;
    public String university;
    public String title;

    public LocalDate startDate;
    public LocalDate endDate;
    private static final ArrayList<Diploma> instances=new ArrayList<>();
    public Diploma(int id, String university, String title, LocalDate startDate, LocalDate endDate) throws Exception {
        if(startDate.isAfter(endDate))
            throw new Exception("Wrong date");
        for(Diploma d : instances){
            if (d.id==id)
                throw new Exception("Certificate of this ID already exists");
        }
        this.id = id;
        this.university = university;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        instances.add(this);
    }
}
