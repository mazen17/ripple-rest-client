<jsp:directive.include file="top.jsp" />

<div class="container-fluid">
	<div class="col-sm-1"></div>
	<div class="col-sm-4">
		<h2>Enter Employee Information</h2>
	</div>

</div>

<div class="container-fluid">
	<form:form method="POST" action="/ripple-rest-client/transfer"
		htmlEscape="true" cssClass="form-horizontal">
		<div class="form-group">
			<form:label cssClass="control-label col-sm-2" path="accountSource">Konto Auftraggeber:</form:label>
				<div class="col-sm-3">
				<select class="form-control" name="accountSource">
					<option value="select">Bitte waehlen Sie ein Konto</option>
					<option value="rsmgeDu6javY78ZJDA6PRdPFNYw85VKKJi">rsmgeDu6javY78ZJDA6PRdPFNYw85VKKJi</option>
					<option value="rfPKSgr6eB7yjXmwzfytvAMn4NdxXWvAz7">rfPKSgr6eB7yjXmwzfytvAMn4NdxXWvAz7</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="control-label col-sm-2" path="accountDestination">Konto Zahlungsempfänger:</form:label>
			<div class="col-sm-2">
				<form:input cssClass="form-control" path="accountDestination" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="control-label col-sm-2" path="value">Betrag</form:label>
			<div class="col-sm-2">
				<form:input cssClass="form-control" path="value" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="control-label col-sm-2" path="currency">Devisen</form:label>
			<div class="col-sm-2">
				<select class="form-control" name="currency">
					<option value="select">---auswaehlen---</option>
					<option value="XRP">XRP</option>
					<option value="EUR">EUR</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2"></label>
			<div class="col-sm-2">
				<input type="submit" class="btn btn-primary btn-lg" value="Submit" />
			</div>
		</div>
	</form:form>

</div>

<jsp:directive.include file="bottom.jsp" />