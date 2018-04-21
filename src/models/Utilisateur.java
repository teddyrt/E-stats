package models;

public class Utilisateur {

	private int idUtilisateur;
	private String email;
	private String civilite;
	private String pseudo;
	private String nom;
	private String prenom;
	private String mot_de_passe;
	private String telfixe;
	private String telmobile;
	private int id_adresse;
	private String role;

	public int getId_utilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int id_utilisateur) {
		this.idUtilisateur = id_utilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public String getTelfixe() {
		return telfixe;
	}

	public void setTelfixe(String telfixe) {
		this.telfixe = telfixe;
	}

	public String getTelmobile() {
		return telmobile;
	}

	public void setTelmobile(String telmobile) {
		this.telmobile = telmobile;
	}

	public int getId_adresse() {
		return id_adresse;
	}

	public void setId_adresse(int id_adresse) {
		this.id_adresse = id_adresse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
