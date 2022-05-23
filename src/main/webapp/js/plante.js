
$(function() {

	getPlantes()
	$("#bModifier").on("click", modifier);
	$("#bEnvoyer").on("click", envoyer);

});




function getPlantes() {
	$("#errorPlante").css("display", "none");
	$.get("http://localhost:8080/18-projet-fleuriste/rs/plantes", afficherPlantes);
}

function getPlante(id) {
	$("#errorPlante").css("display", "none");
	$.get("http://localhost:8080/18-projet-fleuriste/rs/plantes/" + id, modifPlante);
}


function afficherPlantes(plantes) {
	var data = "";
	$("#nbPlantes").html(plantes.length);
	plantes.forEach(function(f) {
		var tr = "<tr>";
		tr += "<td>" + f.nom + "</td>";
		tr += "<td>" + f.tarif + "</td>";
		tr += "<td>" + f.quantite + "</td>";
		tr += "<td class='centre'><button onclick='getPlante(" + f.id + ")' type='button'>Modifier</button></td>";
		tr += "<td class='centre'><button onclick='suppPlante(" + f.id + ")' type='button'>Supprimer</button></td>";

		tr += "</tr>";

		data += tr;
	})
	$("#tbodyliste").html(data);
}


function modifPlante(plante) {

	var texte = document.getElementById("libellePlante");
	texte.innerHTML = "Modification d'une plante";
	$("#id").val(plante.id);
	$("#nom").val(plante.nom);
	$("#tarif").val(plante.tarif);
	$("#quantite").val(plante.quantite);
	$("#informations").val(plante.informations);
	$("#url").val(plante.url);
	$("#bEnvoyer").css("display", "none");
	$("#bModifier").css("display", "contents");
}




function suppPlante(id) {
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/18-projet-fleuriste/rs/plantes/' + id,
		success: function() {
			getPlantes();
		}
	})
		.fail(function() {
			$("#errorPlante").css("display", "block");
			$("#errorPlante").html("Une erreur est survenue lors de la suppression");
		})
}

function modifier() {

	var data = {
		nom: $("#nom").val(),
		tarif: $("#tarif").val(),
		quantite: $("#quantite").val(),
		informations: $("#informations").val(),
		url: $("#url").val()
	}


	var id = $("#id").val();

	if ($("#id").val() != null) {

		$.ajax({
			type: 'put',
			url: 'http://localhost:8080/18-projet-fleuriste/rs/plantes/' + id,
			data: JSON.stringify(data),
			contentType: "application/json;charset=utf-8",
			success: function() {
				var texte = document.getElementById("libellePlante");
				texte.innerHTML = "Ajout d'une plante";
				$("#id").val("");
				$("#nom").val("");
				$("#tarif").val("");
				$("#quantite").val("");
				$("#informations").val("");
				$("#url").val("");
				getPlantes();
			}
		})
			.fail(function() {
				$("#errorPlante").css("display", "block");
				$("#errorPlante").html("Une erreur est survenue lors de l'ajout");
			})
	}

}


function envoyer() {

	var data = {
		nom: $("#nom").val(),
		tarif: $("#tarif").val(),
		quantite: $("#quantite").val(),
		informations: $("#informations").val(),
		url: $("#url").val()
	}


	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/18-projet-fleuriste/rs/plantes',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			$("#nom").val("");
			$("#tarif").val("");
			$("#informations").val("");
			$("#url").val("");
			getPlantes();
		}
	})
		.fail(function() {
			$("#errorPlante").css("display", "block");
			$("#errorPlante").html("Une erreur est survenue lors de l'ajout");
		})


}





