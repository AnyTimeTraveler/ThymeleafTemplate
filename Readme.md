# Thymeleaf Template

## Installation (german)

1. Projekt runterladen und entzippen
2. TomEE oder Apache Tomcat herunterladen
3. Entsprechende IntelliJ-Plugins installieren
4. In IntelliJ: Projekt oeffnen Dialog oeffnen
5. Im OEffnen-Dialog die Datei `pom.xml` auswaehlen
6. `Als Projekt importieren` auswaehlen
7. Warten bis IntelliJ und Maven alle Dependencies installiert haben
8. TomEE Run-Configuration hinzufuegen und starten

## Installation (english)

// TODO

## Wichtige Dateien

### /src/main/java/org/simonscode/thymeleafexample/controllers

Jedes Template braucht einen Controller.
Dieser liegt in diesem Ordner und implementiert das Interface `ThymeleafController`.
Jeder Controller muss auch wie in `/src/main/java/org/simonscode/thymeleafexample/helper/ThymeleafApplication` in Zeile 64 registriert sein.

### /src/main/java/org/simonscode/thymeleafexample/helper/ThymeleafApplication

Jeder Controller muss hier wie in Zeile 64 registriert werden.

### /src/main/java/org/simonscode/thymeleafexample/helper/ThymeleafFilter

Hier wird die ThymeleafEngine aufgerufen.
Diese sollte in Ruhe gelassen werden.

### /src/main/java/org/simonscode/thymeleafexample/servlets

Hier werden alle Servlets abgelegt.
Diese muessen auch in der `web.xml` registriert sein.

### /src/main/webapp/static

Hier liegen alle Dateien, die __keine__ Templates sind.
Neue Unterordner muessen in `ThymeleafFilter` in Zeile 67 registriert werden.

### /src/main/webapp/templates

Hier werden die Thymeleaf Templates gespeichert.

### /src/main/webapp/WEB-INF

Hier liegt die `web.xml`
