package thymeleaftemplate.controllers;

import java.util.HashMap;
import java.util.Map;

public class Controllers {
    public static final Map<String, ThymeleafController> controllersByURL = new HashMap<>();

    static {
        // Diese Zeile sorgt dafür, dass die Startseite vom HomeController erstellt wird
        controllersByURL.put("/", new HomeController());

        // Diese Zeile sorgt dafür, dass die Adresse "http://localhost:8080/ThymeleafTemplate/home" auch zum HomeController führt
        controllersByURL.put("/home", new HomeController());

        // Neue Controller sollten hier registriert werden

        // Die Adresse des Controllers bestimmt sich wie folgt:
        // controllersByURL.put("/test", new TestController());
        //                         ||
        //                          ================
        //                                        \|/
        // http://localhost:8080/ThymeleafTemplate/test
        //                           /||\
        //                            ||
        //                       Projektname
        // Dieser lässt sich in IntelliJ in der Run-Configuration von Tomcat
    }
}
