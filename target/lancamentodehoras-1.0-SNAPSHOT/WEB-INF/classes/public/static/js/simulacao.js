var itens = [];

function gerarTabela(){

	$("#tblHoras tbody").html("");

	var tbody = '';
	var totalMinutos = 0;
	var diferencaMinutos = 0;

	for (var i = 0, max=itens.length; i<max; i++){
		
		diferencaMinutos = calcularDiferencaEntreHoras(itens[i].horainicio, itens[i].horafim);
		totalMinutos += diferencaMinutos;

		tbody += 
			'<tr>' +
			'<td>'+itens[i].data+'</td>'+
			'<td>'+itens[i].horainicio+'</td>'+
			'<td>'+itens[i].horafim+'</td>'+
			'<td>'+itens[i].projeto+'</td>'+
			'<td>'+itens[i].subprojeto+'</td>'+
			'<td>'+itens[i].grupo+'</td>'+
			'<td>'+itens[i].descricao+'</td>'+
			'<td>'+itens[i].tipo+'</td>'+					
			'<td>'+converterMinutosParaHorasMinutos(diferencaMinutos)+'</td>'+
			'<td>'+
				'<img src="resources/imagens/editar.png" class="editar"title="Editar"  id="e-'+i+'">'+
				'<img src="resources/imagens/deletar.png" class="deletar"title="Deletar" id="r-'+i+'">'+
				'<img src="resources/imagens/duplicar.png" class="duplicar"title="Duplicar" id="d-'+i+'">'+					
			'</td>';				
					
	}
	
	if(itens.length > 0){				

		tbody +='<tr>'	+
					'<td id="horas" colspan=8>Total de Horas:</td>'+
					'<td colspan=2>'+converterMinutosParaHorasMinutos(totalMinutos)+'</td>'+	
				'</tr>';		
	}
						
	$("#tblHoras tbody").html(tbody);	
	carregarEventos();	
}

function limparId(id){

	return id.substring(2);	

}

function limparModal(){
	$("#nova-atividade-data").val("");
	$("#nova-atividade-horainicio").val("");
	$("#nova-atividade-horafim").val("");
	$("#nova-atividade-projeto").val("");
	$("#nova-atividade-subprojeto").val("");
	$("#nova-atividade-grupo").val("");
	$("#nova-atividade-tipo").val("");
	$("#nova-atividade-descricao").val("");
	$("#nova-atividade-id").val("");	
}

function carregarFormularioModal(idHTML){

	var index = limparId(idHTML);
	var atividade = itens[index];

	$("#nova-atividade-data").val(atividade.data);
	$("#nova-atividade-horainicio").val(atividade.horainicio);
	$("#nova-atividade-horafim").val(atividade.horafim);
	$("#nova-atividade-projeto").val(atividade.projeto);
	$("#nova-atividade-subprojeto").val(atividade.subprojeto);
	$("#nova-atividade-grupo").val(atividade.grupo);
	$("#nova-atividade-tipo").val(atividade.tipo);
	$("#nova-atividade-descricao").val(atividade.descricao);

	$("#novaAtividadeModal").modal("show");	

}

function carregarEventos(){

	$(".deletar").click(function(){
	
		if(confirm("Deseja excluir esse registro?")){
			var index = limparId($(this).attr("id"));
			itens.splice(index, 1)
			gerarTabela();	
		}
	});	

	$(".editar").click(function(){

		$("#nova-atividade-id").val(index);
		carregarFormularioModal($(this).attr("id"));
	});

	$(".duplicar").click(function(){
		carregarFormularioModal($(this).attr("id"));
	});	
}


$(function(){

	gerarTabela();
	
	$(".limpar-modal").click(function(){
		limparModal();
	});

	$("#salvar").click(function(){
		
		var atividade = {
			data: $("#nova-atividade-data").val(),
			horainicio: $("#nova-atividade-horainicio").val(),
			horafim: $("#nova-atividade-horafim").val(),
			projeto: $("#nova-atividade-projeto").val(),
			subprojeto: $("#nova-atividade-subprojeto").val(),
			grupo: $("#nova-atividade-grupo").val(),
			tipo: $("#nova-atividade-tipo").val(),
			descricao: $("#nova-atividade-descricao").val()
		};		
		
		if( formularioAtividadeValido(atividade) ){

			var id = $("#nova-atividade-id").val();
			
			if(id.trim() === ""){
				itens.push(atividade);	
			} else {
				itens[id] = atividade;
			}				

			limparModal();
			gerarTabela();
			alert ("Atividade adicionada com sucesso!")			
		} 		
		
	});
});