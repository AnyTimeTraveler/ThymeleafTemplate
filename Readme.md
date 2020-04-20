# Thymeleaf Template

## Installation (german)

1. Projekt runterladen und entzippen
2. TomEE oder Apache Tomcat herunterladen
3. In IntelliJ: "Projekt öffnen"-Dialog öffnen
4. Im Öffnen-Dialog die Datei `pom.xml` auswählen
5. `Als Projekt importieren` auswählen
6. Warten bis IntelliJ und Maven alle Dependencies installiert haben
7. TomEE Run-Configuration hinzufügen und starten

## Installation (english)

// TODO

## Eine neue Template-Webseite hinzufügen

Dieses Tutorial nimmt an, dass die neue Seite ein Impressum ist und dementsprechend werden die Dateien benannt.

1. Die Klasse `HomeController` kopieren und in `ImpressumController` umbenennen.
2. Neben die Datei `home.html` eine neue Datei namens `impressum.html` erstellen.
3. In der Klasse `ThymeleafApplication` in Zeile 42 das folgende einfügen: `controllersByURL.put("/impressum", new ImpressumController());`

## Eine neues Servlet hinzufügen

1. Neues Servlet in den Ordner `servlets` erstellen.
2. In der `web.xml` das Servlet registrieren.

## Wichtige Dateien

### /src/main/java/org/simonscode/thymeleafexample/controllers

Jedes Template braucht einen Controller.

Dieser liegt in diesem Ordner und implementiert das Interface `ThymeleafController`.

Jeder Controller muss auch wie in `/src/main/java/org/simonscode/thymeleafexample/helper/ThymeleafApplication` in Zeile 41 registriert sein.

### /src/main/java/org/simonscode/thymeleafexample/helper/ThymeleafApplication

Jeder Controller muss hier wie in Zeile 41 registriert werden.

### /src/main/java/org/simonscode/thymeleafexample/helper/ThymeleafFilter

Hier wird die ThymeleafEngine aufgerufen.

Diese sollte in Ruhe gelassen werden.

### /src/main/java/org/simonscode/thymeleafexample/servlets

Hier werden alle Servlets abgelegt.

Diese muessen auch in der `web.xml` registriert sein.

### /src/main/webapp/

Hier werden die Thymeleaf Templates, sowie alle statischen Dateien wie CSS und JavaScript gespeichert.

Neue Unterordner muessen in `ThymeleafFilter` in Zeile 61 registriert werden.

### /src/main/webapp/WEB-INF

Hier liegt die `web.xml`
