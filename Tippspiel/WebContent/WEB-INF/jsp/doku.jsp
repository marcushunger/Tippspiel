<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<%@ page contentType="text/html; charset=UTF-8" %>
<my:base>
<jsp:body>

<!-- Allgmein -->
<div class="container-fluid">
  <h3 class="margin">Tippspiel</h3>
  <div>
  <p>Wer kennt es nicht? Ein Kumpel beklagt sich das die Klausur zu schwer war und er fast nichts wusste. Und am Ende hat er doch wieder eine Note besser 2.0
Hier setzt das Tippspiel an:
Während der vergangenen Semester im Studiengang Wirtschaftsinformatik an der FOM haben einige unsere Kommilitonen angefangen Tipps auf Ihrer geschriebenen Mo-dulklausuren abzugeben. In unserer Gruppe wurden diese Tipps meist direkt nach dem Schreiben der Klausur schriftlich durch eine Person festgehalten. Nach Bekanntgabe der Klausurnoten wurde eine Abweichung zwischen Tipp-Note und der eigentlichen Klau-surnote errechnet. Eine höhere Abweichung hatte ein höheres vorher festgelegtes Bußgeld zur Folge.
Leider ist es oft nicht möglich alle Tipps direkt zu erfassen. Manchmal fehlt ein Kom-militone oder der Schriftführer, sodass nicht alle Daten erfasst werden. Zudem werden die Tipps immer mündlich abgegeben und im Nachhinein abermals angepasst.  
Zielsetzung ist die Umsetzung eines Webprojektes zur Unterstützung eines Klausurno-ten Tippspiels für mehr Transparenz und Bestimmtheit bei der Tippabgabe.
Die Arbeit besteht zum Teil aus dieser technischen Dokumentation sowie dem Webprojekt „Tippspiel“ als War-File. Ein SQL für eine grundlegende Datenbasis wurde dem Projekt beigefügt.

  </p>
  </div>
</div>

<!-- Fachliche Anforderung -->
<div class="container-fluid">
  <h4 class="margin">Fachliche Anforderung</h4>
  <h5>Registrierung</h5>
 Es soll die Möglichkeit geben werden, sich für das Tippspiel zu registrieren. Die Regist-rierung soll dabei nur die Felder Username, eMail und Passwort benötigen. Zum Login werden die eMail und das Passwort abgefragt. Nach der Eingabe der Login Daten oder einer erfolgreichen Registrierung kann der User direkt loslegen.
  <h5>Userlist</h5>
  Es werden alle bislang registrierten User angezeigt. In der Tabelle werden eMail und Username aufgelistet.
  <h5>Gruppen</h5>
 Der Nutzer soll neue Gruppen anlegen können. Dabei kann der Gruppenname frei ge-wählt (*muss einmalig sein) werden. Zudem muss für jede Gruppe ein Studiengang ausgewählt werden. Die Alternative ist der Beitritt einer schon bestehenden Gruppe. Hier werden in einer Combobox alle verfügbaren Gruppen angezeigt.
  <h5>Noten</h5>
 Unter dem Reiter Noten können die Notentipps und die real geschriebenen Noten einge-tragen werden. Die Auswahl geschieht jeweils über das Modul und die Note. Auch wer-den alle eingegebenen Noten in einer Tabelle angezeigt. Sind sowohl der Tipp und die eigentliche Note eingetragen worden, wird zudem die Abweichung angezeigt.
  <br>
  <h5>Daten ändern</h5>
 Unter dem Punkt "Daten ändern" ist es möglich seine Userdaten zu ändern.
 <h5>Fehlerbehandlung</h5>
 Bei Nicht- oder Falscheingabe soll dem Anwender in der entsprechenden View eine Fehlermeldung angezeigt werden. Diese Fehlermeldung erhält einen roten Hintergrund.
</div>



<!-- Technische Doku -->
<div class="container-fluid">
  <h4 class="margin">Technisch</h4>
  <p>Datenbank: MySQL</p>
  <p>Anwendung: Java</p>
  <p>Designpattern: MVC</p>
  <p>Oberfläche: Java Server Pages (jsp) + Bootstrap</p>
  <p>Building: Maven</p>
  <p>Repository: github</p>
  <p></p>
</div>

<div>
<p>Filter</p>
<p>SecurityFilter</p>
<p>Verweist bei keinem User auf die login.jsp zum einloggen</p>
<p>ServletLoggingFilter</p>
<p>Gibt die Servlet-Url und die Dauer des Servlets als Info-Log aus.</p>
</div>
<div class="container-fluid">
  <h4 class="margin">Datenbankmodell</h4>
  <img src="images/tippspiel.svg" alt="Datenbankmodel" width="700" height="450">
</div>

<div class="container-fluid">
  <h4 class="margin">Besondere Jars/ Apis</h4>
  <p>Zur Passwortverschlüsselung: BCrypt</p>
  <p>https://github.com/djmdjm/jBCrypt</p>
  <p>https://mvnrepository.com/artifact/org.mindrot/jbcrypt/0.4</p>
</div>

</jsp:body>
</my:base>