<jsp:directive.include file="top.jsp" />

<div class="container-fluid">
	<div class="col-sm-1"></div>
	<div class="col-sm-4">
		<h2>
			<strong>Überweisungdetails</strong>
		</h2>
	</div>
</div>
<hr>

<div class="container-fluid">
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">Engine Result</label> <label
			class="control-label col-sm-2">${transferInfo.engineResult}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">Engine Result Message</label> <label
			class="control-label col-sm-5">${transferInfo.engineResultMessage}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">Status</label> <label
			class="control-label col-sm-2">${transferInfo.status}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">Account</label> <label
			class="control-label col-sm-2">${transferInfo.account}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">Amount</label> <label
			class="control-label col-sm-2">${transferInfo.amount}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">Currency</label> <label
			class="control-label col-sm-2">${transferInfo.currency}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">Destination</label> <label
			class="control-label col-sm-2">${transferInfo.destination}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">Fee</label> <label
			class="control-label col-sm-2">${transferInfo.fee}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">SigningPubKey</label> <label
			class="control-label col-sm-2">${transferInfo.signingPubKey}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <label
			class="control-label col-sm-2">TransactionType</label> <label
			class="control-label col-sm-2">${transferInfo.transactionType}</label>
	</div>
	<div class="row">
		<label class="control-label col-sm-1"></label> <a
			class="btn btn-primary btn-md col-sm-1.4 pull-left"
			href="/ripple-rest-client/account"> Kontostand</a>
			<label class="control-label col-sm-0.5"></label>
			 <a
			class="btn btn-primary btn-md col-sm-1.4 "
			href="/ripple-rest-client/newTransfer">Überweisung</a>

	</div>
</div>


<jsp:directive.include file="bottom.jsp" />