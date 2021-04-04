package hackerrank;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IotDevices {
    public static void main(String[] args) {

        //date.setTime(ts.getTime());
        String formattedDate = new SimpleDateFormat("MM-YYYY").format(Long.parseLong("1552799232246"));
        System.out.println(formattedDate);
    }


}
