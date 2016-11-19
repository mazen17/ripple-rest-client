<jsp:directive.include file="top.jsp" />

<div class="container-fluid">
	<div class="col-sm-1"></div>
	<div class="col-sm-4">
		<h2>
			<strong>Konto Informationen</strong>
		</h2>
	</div>
</div>
<hr>

<c:if test="${not empty error}">
	<jsp:directive.include file="error.jsp" />
</c:if>


<div class="container-fluid">
		<form:form method="POST" action="/ripple-rest-client/account"
			htmlEscape="true" cssClass="form-horizontal">        
		<div class="form-group">
				<label class="control-label col-sm-1"></label>
				<div class="col-sm-4">
					<form:select cssClass="form-control" path="accountNr">
						<form:option value="-" label="Konto auswählen" />
						<form:options items="${account.accountNrs}" />
					</form:select>
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-primary btn-md" value="Submit" />
				</div>
			</div>
		</form:form>
	</div>

	<c:if test="${not empty account.accountNr and empty error}">
		<hr>
		<div class="container-fluid">
			<div class="row" class="text-muted">
				<label class="control-label col-sm-1"></label> <label
					class="control-label col-sm-4 small text-muted">Konto:</label> <label
					class="control-label col-sm-2 small text-muted">Kontostand:</label>
			</div>
			<div class="row">
				<label class="control-label col-sm-1"></label> <label
					class="control-label col-sm-4">${account.accountNr}</label> <label
					class="control-label col-sm-2">${account.balance}</label>
			</div>
		</div>
	</c:if>

	<jsp:directive.include file="bottom.jsp" />