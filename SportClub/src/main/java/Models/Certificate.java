package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Certificate {
    private int id;
    public LocalDate startDate;
    public LocalDate endDate;
    public LocalDate expireDate;
    private static ArrayList<Certificate> instances=new ArrayList<>();

    public Certificate(int id, LocalDate startDate, LocalDate endDate, LocalDate expireDate) throws Exception {
        if(startDate.isAfter(endDate) || endDate.isAfter(expireDate))
            throw new Exception("Wrong date");
        for(Certificate c : instances){
            if (c.id==id)
                throw new Exception("Certificate of this ID already exists");
        }
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.expireDate = expireDate;

    }
}
