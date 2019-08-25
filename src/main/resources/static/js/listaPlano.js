function planoEstudo(diadasemana){
	$.ajax({
		url: "/planoEstudo/" + diadasemana,
		success: function (data){
			$("#content1").html(data).show();
			console.log(data);
		}
	})
	
}

function listaAssunto(plano, id){
	
	console.log($(plano).attr('id'), id);
	
	$.ajax({
		url: "/formularioPlano/ "+ id,
		success: function(data) {
		$("#"+$(plano).attr('id')).find('select').html(data);
		
	}
	})
}