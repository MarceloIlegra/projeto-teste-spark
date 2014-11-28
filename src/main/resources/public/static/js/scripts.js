
$(function(){

	$("#pesquisarBotao").click(function(){
	    var formSel = $("#formulario_pesquisa");  
	    if(formSel.is(":visible")){
	      formSel.slideUp("slow");
	    } else {
	      formSel.slideDown("slow");
	    }
	 });
	$( ".datepicker" ).datepicker();
});

function isEmpty(valor){
	return valor.trim() === "";
}

function converterHoraParaMinutos(valor){

	var splitValor = valor.split(":");
	var hora = splitValor[0];
	var min  = splitValor[1];

	return parseInt(hora) * 60 + parseInt(min);
	
}

function converterMinutosParaHorasMinutos(valor){
	
	var hora = Math.floor(valor / 60);
	var minuto = valor % 60;

	if(minuto < 10 ){
		minuto = "0"+minuto;
	}

	return hora + ":" + minuto;		
}

function calcularDiferencaEntreHoras(horaInicial, horaFinal){

	var minInicial = converterHoraParaMinutos(horaInicial);
	var minFinal   = converterHoraParaMinutos(horaFinal);

	return minFinal - minInicial;

}

function isDatadeLancamentoValida(dataLancamento){
	

	var limite = 5;
	var dataLimite = new Date();
 	dataLimite.setDate(dataLimite.getDate()-limite);

	var novadata = new Date(dataLancamento + " 00:00:00");
	var valido = true;

	if(novadata < dataLimite){
		valido = false;
		alert("Data ultrapassa limite!");
	}
	if( novadata > new Date()){
		valido = false;
		alert("Data não pode ser futura!");
	}

	return valido;

}

function formularioAtividadeValido(atividade){

	var seletor = "";
	var alvo = "";
	var valido = true;

	for(propriedade in atividade){

		seletor = ".valida-" + propriedade;
		alvo = $(seletor);

		if(isEmpty(atividade[propriedade])){	
			alvo.addClass("has-error");
			valido = false
		} else {
			alvo.removeClass("has-error");
		}

	}

	if(!valido){
		alert ("O campos em vermelho estão com erro!");
	}

	if(valido && calcularDiferencaEntreHoras(atividade.horainicio, atividade.horafim) < 0){		
		valido = false;
		$(".valida-horafim").addClass("has-error");
		$(".nova-atividade-horafim").val("");
		alert("Hora Fim deve ser posterior a Hora Inicio!");
	} 

	if( !isDatadeLancamentoValida(atividade.data) ){
		valido = false;
		$(".valida-data").addClass("has-error");
		$(".nova-atividade-data").val("");				
	}

	return valido;

}
