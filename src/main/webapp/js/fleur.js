
$(function() {

	getSaison()
	getFleurs()
	$("#bModifier").on("click", modifier);
	$("#bEnvoyer").on("click", envoyer);

});




function getFleurs() {
	$("#errorFleur").css("display", "none");
	$.get("http://localhost:8080/18-projet-fleuriste/rs/fleurs", afficherFleurs);
}

function getFleur(id) {
	$("#errorFleur").css("display", "none");
	$.get("http://localhost:8080/18-projet-fleuriste/rs/fleurs/" + id, modifFleur);
}


function afficherFleurs(Fleurs) {
	var data = "";
	$("#nbFleurs").html(Fleurs.length);
	Fleurs.forEach(function(f) {
		var tr = "<tr>";
		tr += "<td>" + f.nom + "</td>";
		tr += "<td>" + f.tarif + "</td>";
		tr += "<td>" + f.quantite + "</td>";
		tr += "<td>" + f.couleur + "</td>";
		tr += "<td>" + f.saison.libelle + "</td>";
		tr += "<td class='centre'><button onclick='getFleur(" + f.id + ")' type='button'>Modifier</button></td>";
		tr += "<td class='centre'><button onclick='suppFleur(" + f.id + ")' type='button'>Supprimer</button></td>";

		tr += "</tr>";

		data += tr;
	})
	$("#tbodyliste").html(data);
}


function modifFleur(Fleur) {

	var texte = document.getElementById("libelleFleur");
	texte.innerHTML = "Modification d'une fleur";
	$("#id").val(Fleur.id);
	$("#nom").val(Fleur.nom);
	$("#tarif").val(Fleur.tarif);
	$("#quantite").val(Fleur.quantite);
	$("#informations").val(Fleur.informations);
	$("#url").val(Fleur.url);
	$("#couleur").val(Fleur.couleur);
	$("#saison").val(Fleur.saison.id);
	$("#bEnvoyer").css("display", "none");
	$("#bModifier").css("display", "contents");
}




function suppFleur(id) {
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/18-projet-fleuriste/rs/fleurs/' + id,
		success: function() {
			getFleurs();
		}
	})
		.fail(function() {
			$("#errorFleur").css("display", "block");
			$("#errorFleur").html("Une erreur est survenue lors de la suppression");
		})
}

function modifier() {

	var data = {
		nom: $("#nom").val(),
		tarif: $("#tarif").val(),
		quantite: $("#quantite").val(),
		informations: $("#informations").val(),
		url: $("#url").val(),
		couleur: $("#couleur").val(), 
		saison:{ 
			id: $("#saison").val()
		} 
	}


	var id = $("#id").val();

	if ($("#id").val() != null) {

		$.ajax({
			type: 'put',
			url: 'http://localhost:8080/18-projet-fleuriste/rs/fleurs/' + id,
			data: JSON.stringify(data),
			contentType: "application/json;charset=utf-8",
			success: function() {
				var texte = document.getElementById("libelleFleur");
				texte.innerHTML = "Ajout d'une fleur";
				$("#id").val("");
				$("#nom").val("");
				$("#tarif").val("");
				$("#quantite").val("");
				$("#informations").val("");
				$("#url").val("");
				getFleurs();
			}
		})
			.fail(function() {
				$("#errorFleur").css("display", "block");
				$("#errorFleur").html("Une erreur est survenue lors de la modif");
			})
	}

}


function envoyer() {

	var data = {
		nom: $("#nom").val(),
		tarif: $("#tarif").val(),
		quantite: $("#quantite").val(),
		informations: $("#informations").val(),
		url: $("#url").val(),
		couleur: $("#couleur").val(),
		saison:{ 
			id: $("#saison").val()
		} 
		
	}


	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/18-projet-fleuriste/rs/fleurs',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			$("#nom").val("");
			$("#tarif").val("");
			$("#informations").val("");
			$("#url").val("");
			$("#couleur").val("");
			getFleurs();
		}
	})
		.fail(function() {
			$("#errorFleur").css("display", "block");
			$("#errorFleur").html("Une erreur est survenue lors de l'ajout");
		})


}



function getSaison() {
		$("#errorFleur").css("display", "none");

	$.get("http://localhost:8080/18-projet-fleuriste/rs/saisons", function(saisons){

		var data = "";
		saisons.forEach(function(s){
			data += "<option value="+s.id +">" + s.libelle + "</option>";
		});
		
		$("#saison").html(data);
		
	});
}



