package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.location.GetWelcomeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/resources")
@CrossOrigin
public class ResourceBundleController {
    private Executor messageExecutor = Executors.newFixedThreadPool(2);

    @GetMapping("welcome")
    public ResponseEntity<List<String>>GetMessage(){
        List<String> list = new ArrayList<String>();

        messageExecutor.execute(()->{
            GetWelcomeMessage messEN = new GetWelcomeMessage("en", "US");
            list.add(messEN.getMessage());
            System.out.println("en_US");
        });
        messageExecutor.execute(()->{
            GetWelcomeMessage messFR = new GetWelcomeMessage("fr", "CA");
            list.add(messFR.getMessage());
            System.out.println("fr_CA");
        });
        return ResponseEntity.ok(list);
    }
}
