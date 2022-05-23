
$(function() {
	getPlantes()
});




function getPlantes() {
	$.get("http://localhost:8080/18-projet-fleuriste/rs/plantes", afficherPlantes);
}


function afficherPlantes(plantes) {
	var data = "";
	$("#nbPlantes").html(plantes.length);
	plantes.forEach(function(f) {
		var affichage = "<div class='card column' style='width: 18rem;'>"
			url = "./css/plantes.jpg";
			affichage += "<img class='card-img-top' style='width:250px; height:250px;' src='"+ f.url+"' alt=''>"
			affichage += "<div class='card-body'>"
			affichage += "<p class='card-text'>"+f.nom+"</br> "+f.tarif+" €</p>"
			affichage += "<button type='button' class='btn btn-primary' data-bs-toggle='modal' data-bs-target='#Modal"+f.id+"'>Voir le détail</button>"
			affichage += "</div></div>"
			
			affichage += "<div class='modal fade' style='background-image: url("+url+"); background-repeat: no-repeat; background-size: cover;' id='Modal"+f.id+"' tabindex='-1' aria-labelledby='exampleModalLabel' aria-hidden='true'>"
			affichage += "<div class='modal-dialog'>"
			affichage += "<div class='modal-content bg-warning'>"
			affichage += "<div class='modal-header'>"
			affichage += "<h5 class='modal-title' id='exampleModalLabel'>Information détailés de votre plante : "+ f.nom +"</h5>"
			affichage += "<button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button></div>"
			affichage += "<div class='modal-body'><p>Voici les différentes informations dont vous souhaitez la vision</p><p>informations : "+ f.informations+"</p>"
			affichage += "<p>tarif : "+f.tarif+" € avec une quantite restante de "+f.quantite+" exemplaires</p>"
			affichage += "</div>"
			affichage += "<div class='modal-footer'>"
			affichage += "<button onclick='ajoutPanier(" + f.id +", "+ f.quantite + ")' type='button'  class='btn btn-secondary'>Ajouter au panier</button>"
			affichage += "<button type='button' class='btn btn-secondary' data-bs-dismiss='modal'>Fermer</button>"
			affichage += "</div> </div> </div> </div>"
			  
			
		data += affichage;
	})
	$("#affichePlante").html(data);
}

function ajoutPanier(id,quantite){

	var data = {
		
		quantite: quantite,
		article:{
			id: id
		}
		
	}


	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/18-projet-fleuriste/rs/lignepaniers',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			index.html
		}
	})
		.fail(function() {
			$("#errorBouquet").css("display", "block");
			$("#errorBouquet").html("Une erreur est survenue lors de l'ajout");
		})
}


