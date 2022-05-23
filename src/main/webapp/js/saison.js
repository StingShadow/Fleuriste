$(function() {
	getSaison();
	$("#bAjoutSaison").on("click", ajouterSaison);
});



function getSaison() {
	$("#errorSaison").css("display", "none");
	$.get("http://localhost:8080/18-projet-fleuriste/rs/saisons", afficherSaisons);
}


function ajouterSaison() {

	var data = {
		libelle: $("#libelleSaison").val(),
	}
	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/18-projet-fleuriste/rs/saisons',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			$("#libelleSaison").val("");
			getSaison();
		}
	})
	.fail(function() {
		$("#errorSaison").css("display", "block");
		$("#errorSaison").html("Une erreur est survenue lors de l'ajout");
	})

}


function afficherSaisons(saisons) {
	var data = "";
	saisons.forEach(function(s) {
		var tr = "<tr>";
		tr += "<td>" + s.id + "</td>";
		tr += "<td><input type='text' id='libelle" + s.id + "' value=" + s.libelle + " /></td>";
		tr += "<td class='centre'><button onclick='modifSaison(" + s.id + ")' type='button' >Modifier</button></td>";
		tr += "<td class='centre'><button onclick='suppSaison(" + s.id + ")' type='button'>Supprimer</button></td>";

		tr += "</tr>";

		data += tr;
	})
	$("#tbodyliste").html(data);
}



function suppSaison(id){
	$.ajax({
		type : 'delete',
		url : 'http://localhost:8080/18-projet-fleuriste/rs/saisons/' + id,
		success : function(){
			getSaison();
		}
	})
	.fail(function(){
		$("#errorSaison").css("display", "block");
		$("#errorSaison").html("Une erreur est survenue lors de la suppression");
	})
}



function modifSaison(id){
	
	var data = {
		libelle: $("#libelle" + id).val(),
	}
	

	$.ajax({
		type : 'put',
		url : 'http://localhost:8080/18-projet-fleuriste/rs/saisons/'+id,
		data : JSON.stringify(data),
		contentType : "application/json;charset=utf-8",
		success : function(){
			getSaison();
		}
	})
	.fail(function(){
		getSaison();
		$("#errorSaison").css("display", "block");
		$("#errorSaison").html("Une erreur est survenue lors de la modification");
	})
	
}