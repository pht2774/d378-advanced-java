package edu.wgu.d387_sample_code.location;

import org.springframework.core.SpringVersion;

import java.util.Locale;
import java.util.ResourceBundle;

public class GetWelcomeMessage {
    private Locale locale;
    private ResourceBundle resourceBundle;

    public GetWelcomeMessage(){}
    public String getMessage(){
        return resourceBundle.getString("Welcome");
    }

    public GetWelcomeMessage(String lang, String country){
        locale = new Locale(lang, country);
        resourceBundle = ResourceBundle.getBundle("resourceBundle", locale);
        System.out.printf("%s, %s%n",lang, country);
    }
}
