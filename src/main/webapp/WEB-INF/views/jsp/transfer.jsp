<jsp:directive.include file="top.jsp" />

<div class="container-fluid">
	<div class="col-sm-1"></div>
	<div class="col-sm-4">
		<h2>
			<strong>Neue Überweisung</strong>
		</h2>
	</div>
</div>
<hr>
<div class="container-fluid">
	<c:if test="${not empty error}">
		<jsp:directive.include file="error.jsp" />
	</c:if>

	<form:form method="POST" action="/ripple-rest-client/transfer"
		htmlEscape="true" cssClass="form-horizontal">

		<div class="form-group">
			<form:label cssClass="control-label col-sm-3" path="accountSource">Konto Auftraggeber:</form:label>
			
			<div class="col-sm-4">
					<form:select cssClass="form-control" path="accountSource">
						<form:option value="-" label="Konto auswählen" />
						<form:options items="${transfer.accountNrs}" />
					</form:select>
				</div>
		</div>
		<div class="form-group">
			<form:label cssClass="control-label col-sm-3"
				path="accountDestination">Konto Zahlungsempfänger:</form:label>
			<div class="col-sm-4">
				<form:input cssClass="form-control" path="accountDestination" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="control-label col-sm-3" path="amount">Betrag:</form:label>
			<div class="col-sm-2">
				<form:input cssClass="form-control" path="amount" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="control-label col-sm-3" path="currency">Devisen:</form:label>
			<div class="col-sm-2">
				<select class="form-control" name="currency">
					<option value="XRP">XRP</option>
					<option value="EUR">EUR</option>
					<option value="USD">USD</option>
				</select>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-3"></div>
			<div class="col-sm-2">
				<input type="submit" class="btn btn-primary btn-lg" value="Submit" />
			</div>
		</div>
	</form:form>

</div>

<jsp:directive.include file="bottom.jsp" />