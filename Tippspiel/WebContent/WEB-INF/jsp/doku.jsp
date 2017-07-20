<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<my:base>
<jsp:body>

<!-- Allgmein -->
<div class="container-fluid">
  <h3 class="margin">Tippspiel</h3>
  <div>
  <p>Wer kennt es nicht? Ein Kumpel beklagt sich das die Klausur zu schwer war und er fast nichts wusste. Und am Ende hat er doch wieder eine Note besser 2.0<br>
  Hier setzt das Tippspiel an:
  Es können in Gruppen die Klausurnoten nach geschriebener Klausur getippt werden. Nach Rückgabe der Note wird dann für jede Abweichung ein vorher festgelegter Betrag in eine Gruppenkasse 
  eingezahlt oder eine "Währung".
  </p>
  </div>
</div>

<!-- Fachliche Anforderung -->
<div class="container-fluid">
  <h4 class="margin">Fachliche Anforderung</h4>
  <h5>Registrierung</h5>
  Es soll die Möglichkeit geben sich für das Tippspiel zu registrieren. Die Registrierung soll dabei nur die
  Felder Username, eMail und Passwort benötigen. Zum Login soll dabei die eMail und das Passwort dienen. 
  Nach der Eingabe kann der User direkt loslegen.
  <h5>Userlist</h5>
  Es werden alle bislang registrierten User angezeigt. In der Tabelle werden eMail und Username aufgelistet.
  <h5>Gruppen</h5>
  Der Nutzer soll neue Gruppen anlegen können. Dabei kann der Gruppenname frei gewählt (*muss einmalig sein) werden. 
  Außerdem wird zu jeder Gruppe ein Studiengang gewählt.
  <br>
  Die Alternative ist, der Beitritt einer schon bestehenden Gruppe. Hier werden in einer Combobox alle verfügbaren Gruppen 
  angezeigt.
  <br>
  <h5>Noten</h5>
  Unter dem Reiter Noten können die Notentipps und die real geschriebenen Noten eingetragen werden. Die Auswahl geschieht 
  jeweils über das Modul und die Note.
  Auch werden alle eingegebenen Noten in einer Tabelle angezeigt.
  <br>
  <h5>Daten ändern</h5>
  Unter dem Punkt "Daten ändern" ist es möglich seine Userdaten zu ändern.
</div>



<!-- Technische Doku -->
<div class="container-fluid">
  <h4 class="margin">Technisch</h4>
</div>

<div class="container-fluid">
  <h4 class="margin">Datenbankmodell</h4>
  <img src="/images/tippspiel.svg" alt="Datenbankmodel" width="700" height="450">
</div>

<div class="container-fluid">
  <h4 class="margin">Jars/ Apis</h4>
  <p>https://github.com/djmdjm/jBCrypt</p>
  <p>https://mvnrepository.com/artifact/org.mindrot/jbcrypt/0.4</p>
</div>

</jsp:body>
</my:base>