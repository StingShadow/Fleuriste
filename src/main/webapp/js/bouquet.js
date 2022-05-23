
$(function() {

	getStyles()
	getSaison()
	getBouquets()
	$("#bModifier").on("click", modifier);
	$("#bEnvoyer").on("click", envoyer);

});




function getBouquets() {
	$("#errorBouquet").css("display", "none");
	$.get("http://localhost:8080/18-projet-fleuriste/rs/bouquets", afficherBouquets);
}

function getBouquet(id) {
	$("#errorBouquet").css("display", "none");
	$.get("http://localhost:8080/18-projet-fleuriste/rs/bouquets/" + id, modifBouquet);
}


function afficherBouquets(Bouquets) {
	var data = "";
	$("#nbBouquets").html(Bouquets.length);
	Bouquets.forEach(function(f) {
		var tr = "<tr>";
		tr += "<td>" + f.nom + "</td>";
		tr += "<td>" + f.tarif + "</td>";
		tr += "<td>" + f.quantite + "</td>";
		tr += "<td>" + f.couleur + "</td>";
		tr += "<td>" + f.style.libelle + "</td>";
		tr += "<td>" + f.saison.libelle + "</td>";
		tr += "<td class='centre'><button onclick='getBouquet(" + f.id + ")' type='button'>Modifier</button></td>";
		tr += "<td class='centre'><button onclick='suppBouquet(" + f.id + ")' type='button'>Supprimer</button></td>";

		tr += "</tr>";

		data += tr;
	})
	$("#tbodyliste").html(data);
}


function modifBouquet(Bouquet) {

	var texte = document.getElementById("libelleBouquet");
	texte.innerHTML = "Modification d'un Bouquet";
	$("#id").val(Bouquet.id);
	$("#nom").val(Bouquet.nom);
	$("#tarif").val(Bouquet.tarif);
	$("#quantite").val(Bouquet.quantite);
	$("#informations").val(Bouquet.informations);
	$("#url").val(Bouquet.url);
	$("#couleur").val(Bouquet.couleur);
	$("#style").val(Bouquet.style.id);
	$("#saison").val(Bouquet.saison.id);
	$("#bEnvoyer").css("display", "none");
	$("#bModifier").css("display", "contents");
}




function suppBouquet(id) {
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/18-projet-fleuriste/rs/bouquets/' + id,
		success: function() {
			getBouquets();
		}
	})
		.fail(function() {
			$("#errorBouquet").css("display", "block");
			$("#errorBouquet").html("Une erreur est survenue lors de la suppression");
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
		style:{
			id:$("#style").val()
		}, 
		saison:{ 
			id: $("#saison").val()
		} 
	}


	var id = $("#id").val();

	if ($("#id").val() != null) {

		$.ajax({
			type: 'put',
			url: 'http://localhost:8080/18-projet-fleuriste/rs/bouquets/' + id,
			data: JSON.stringify(data),
			contentType: "application/json;charset=utf-8",
			success: function() {
				var texte = document.getElementById("libelleBouquet");
				texte.innerHTML = "Ajout d'un Bouquet";
				$("#id").val("");
				$("#nom").val("");
				$("#tarif").val("");
				$("#quantite").val("");
				$("#informations").val("");
				$("#url").val("");
				getBouquets();
			}
		})
			.fail(function() {
				$("#errorBouquet").css("display", "block");
				$("#errorBouquet").html("Une erreur est survenue lors de l'ajout");
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
		style:{
			id:$("#style").val()
		}, 
		saison:{ 
			id: $("#saison").val()
		} 
		
	}


	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/18-projet-fleuriste/rs/bouquets',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			$("#nom").val("");
			$("#tarif").val("");
			$("#informations").val("");
			$("#url").val("");
			$("#couleur").val("");
			getBouquets();
		}
	})
		.fail(function() {
			$("#errorBouquet").css("display", "block");
			$("#errorBouquet").html("Une erreur est survenue lors de l'ajout");
		})


}

function getStyles() {
		$("#errorBouquet").css("display", "none");

	$.get("http://localhost:8080/18-projet-fleuriste/rs/styles", function(styles){

		var data = "";
		styles.forEach(function(s){
			data += "<option value="+s.id +">" + s.libelle + "</option>";
		});
		
		$("#style").html(data);
		
	});
}


function getSaison() {
		$("#errorBouquet").css("display", "none");

	$.get("http://localhost:8080/18-projet-fleuriste/rs/saisons", function(saisons){

		var data = "";
		saisons.forEach(function(s){
			data += "<option value="+s.id +">" + s.libelle + "</option>";
		});
		
		$("#saison").html(data);
		
	});
}



