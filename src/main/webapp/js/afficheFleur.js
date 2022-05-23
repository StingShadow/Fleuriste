
$(function() {

	getFleurs()

});




function getFleurs() {
	$.get("http://localhost:8080/18-projet-fleuriste/rs/fleurs", afficherFleurs);
}



function afficherFleurs(fleurs) {
	var data = "";
	$("#nbPlantes").html(fleurs.length);
	fleurs.forEach(function(f) {
		var affichage = "<div class='card column' style='width: 18rem;'>"
			url = "./css/fleurs.jpg";
			affichage += "<img class='card-img-top' style='width:250px; height:250px;' src='"+ f.url+"' alt=''>"
			affichage += "<div class='card-body'>"
			affichage += "<p class='card-text'>"+f.nom+"</br> "+f.tarif+" €</p>"
			affichage += "<button type='button' class='btn btn-primary' data-bs-toggle='modal' data-bs-target='#Modal"+f.id+"'>Voir le détail</button>"
			affichage += "</div></div>"
			
			affichage += "<div class='modal fade'  style='background-image: url("+url+"); background-repeat: no-repeat; background-size: cover;' id='Modal"+f.id+"' tabindex='-1' aria-labelledby='exampleModalLabel' aria-hidden='true'>"
			affichage += "<div class='modal-dialog'>"
			affichage +=  "<div class='modal-content bg-info'>"
			affichage += "<div class='modal-header'>"
			affichage += "<h5 class='modal-title' id='exampleModalLabel'>Information détailés de votre fleur : "+ f.nom +"</h5>"
			affichage += "<button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button></div>"
			affichage += "<div class='modal-body'><p>Voici les différentes informations dont vous souhaitez la vision</p><p>informations : "+ f.informations+"</p>"
			affichage += "<p>tarif : "+f.tarif+" € avec une quantite restante de "+f.quantite+" exemplaires</p>"
			affichage += "<p> Couleur : "+f.couleur+" </p>"
			affichage += "<p>  Cette fleur pousse durant la saison : "+f.saison.libelle+" </p>"
			affichage += "</div>"
			affichage += "<div class='modal-footer'>"
			affichage += "<button type='button' class='btn btn-secondary' data-bs-dismiss='modal'>Fermer</button>"
			affichage += "</div> </div> </div> </div>"
 
			
			
			
			
		data += affichage;
	})
	$("#afficheFleur").html(data);
}



