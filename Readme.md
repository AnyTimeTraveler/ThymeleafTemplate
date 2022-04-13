# Thymeleaf Template

Compatible with Tomcat 8 and Tomcat 9

## Installation (german)

1. Apache Tomcat Version 8 [Download](https://tomcat.apache.org/download-80.cgi) oder 9 [Download](https://tomcat.apache.org/download-90.cgi) herunterladen
2. Die heruntergeladene Datei entpacken und den Pfad merken (zum Beispiel auf dem Desktop)
3. Projekt herunterladen und auspacken
4. In IntelliJ: "Projekt öffnen"-Dialog öffnen
5. Im Öffnen-Dialog die Datei `pom.xml` auswählen
6. `Als Projekt importieren` auswählen
7. Warten bis IntelliJ und Maven alle Dependencies installiert haben
8. In IntelliJ: Plugin `Smart Tomcat` installieren
9. In IntelliJ: Oben rechts auf `Add Configuration...` klicken
10. In IntelliJ: Im neuen Fenster auf `Add new...` klicken und `Smart Tomcat` auswählen
11. In IntelliJ: In der Reihe nach `Tomcat Server` auf die drei Punkte `...` klicken
12. In IntelliJ: Im neuen Fenster den Pfad aus Schritt 2 suchen und den Tomcat-Ordner auswählen und auf `Ok` klicken
13. In IntelliJ: Das Fenster auch mit `Ok` schliessen
14. In IntelliJ: Oben rechts, wo vorhin noch `Add Configuration...` stand, den grünen Pfeil klicken zum Starten
15. In IntelliJ: Tomcat sollte jetzt starten und einige rote Meldungen anzeigen. Das ist normal.
16. In IntelliJ: Am Ende dieser Meldungen sollte der Link zum Tomcat Projekt angezeigt werden. Er sollte ähnlich aussehen wie: http://localhost:8080/ThymeleafTemplate

## Installation (english)

// TODO

## Eine neue Template-Webseite hinzufügen

Dieses Tutorial nimmt an, dass die neue Seite ein Impressum ist und dementsprechend werden die Dateien benannt.

1. Die Klasse `HomeController` kopieren und in `ImpressumController` umbenennen.
2. Neben die Datei `home.html` eine neue Datei namens `impressum.html` erstellen.
3. In der Klasse `Controllers` das folgende einfügen: `controllersByURL.put("/impressum", new ImpressumController());`

Die Adresse des Controllers bestimmt sich wie folgt:
```
controllersByURL.put("/test", new TestController());
                        ||
                         =================
                                        \||/
http://localhost:8080/ThymeleafTemplate/test
                          /||\
                           ||
                      Projektname
Dieser lässt sich in IntelliJ in der Run-Configuration von Tomcat
```

## Eine neues Servlet hinzufügen

1. Neues Servlet in den Ordner `servlets` erstellen.
2. In der `web.xml` das Servlet registrieren.

## Wichtige Dateien

### /src/main/java/thymeleaftemplate/controllers

Jedes Template braucht einen Controller.

Dieser liegt in diesem Ordner und implementiert das Interface `ThymeleafController`.

Jeder Controller muss auch wie in `/src/main/java/thymeleaftemplate/Controllers` registriert sein.

Controller können auch an mehreren Adressen gleichzeitig registriert sein.

### /src/main/java/thymeleaftemplate/helper/ThymeleafFilter

Hier wird die ThymeleafEngine aufgerufen.

Diese sollte in Ruhe gelassen werden.

### /src/main/java/thymeleaftemplate/servlets

Hier werden alle Servlets abgelegt.

Diese müssen auch in der `web.xml` registriert sein.

### /src/main/webapp/

Hier werden die Thymeleaf Templates, sowie alle statischen Dateien wie CSS und JavaScript gespeichert.

Neue Unterordner müssen in `ThymeleafFilter` in Zeile 61 registriert werden.

### /src/main/webapp/WEB-INF

Hier liegt die `web.xml`
