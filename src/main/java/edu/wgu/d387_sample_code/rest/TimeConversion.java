package edu.wgu.d387_sample_code.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/time")
@CrossOrigin
public class TimeConversion {
    final private String time = "10:00AM EST";
    final private String timeFormat = "hh:mma z";
    final String[] timeZone = new String[]{"EST","MST","UTC"};
    private SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);

    @GetMapping("/presentation")
    public ResponseEntity<List<String>> getLiveTime(){
        List<String> presentationTime = new ArrayList<>();
        try{
            Date date = dateFormat.parse(time);
            for (String time: timeZone){
                TimeZone timeZone = TimeZone.getTimeZone(time);
                dateFormat.setTimeZone(timeZone);
                String dateConverse = dateFormat.format(date);
                presentationTime.add(dateConverse);
            }
            TimeZone timeZoneEST = TimeZone.getTimeZone("EST");
            dateFormat.setTimeZone(timeZoneEST);

            TimeZone timeZoneMST = TimeZone.getTimeZone("MST");
            dateFormat.setTimeZone(timeZoneMST);

            TimeZone timeZoneUTC = TimeZone.getTimeZone("UTC");
        }catch (Exception e){
            System.out.println(e.toString());
            presentationTime.add(e.toString());
        }

        return ResponseEntity.ok(presentationTime);
    }
}
