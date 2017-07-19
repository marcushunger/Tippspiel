<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="<c:url value="/home.html"/>">FOM Tippspiel</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li<c:if test="${forward eq 'personlist' }"> class="active"</c:if>><a href="<c:url value="/personlist.html"/>">Userliste</a></li>
        <li<c:if test="${forward eq 'groups' }"> class="active"</c:if>><a href="<c:url value="/groups.html"/>">Gruppen</a></li>
        <li<c:if test="${forward eq 'noteeintragen' }"> class="active"</c:if>><a href="<c:url value="/noteeintragen.html"/>">Note</a></li>
        <li<c:if test="${forward eq 'change' }"> class="active"</c:if>><a href="<c:url value="/change.html"/>">Daten ändern</a></li>
        <li<c:if test="${forward eq 'doku' }"> class="active"</c:if>><a href="<c:url value="/doku.html"/>">Doku</a></li>
        <li><a href="<c:url value="/logout.html"/>">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>