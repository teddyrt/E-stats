package models;

public class Utilisateur {

	private int idUtilisateur;
	private String email;
	private String civilite;
	private String pseudo;
	private String nom;
	private String prenom;
	private String motDePasse;
	private String telfixe;
	private String telmobile;
	private int idAdresse;
	private String role;

	// Attributs aggrégé
	private int nombreAchats;
	private float totalPrixAchat;

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getNombreAchats() {
		return nombreAchats;
	}

	public void setNombreAchats(int nombreAchats) {
		this.nombreAchats = nombreAchats;
	}

	public float getTotalPrixAchat() {
		return totalPrixAchat;
	}

	public void setTotalPrixAchat(float totalPrixAchat) {
		this.totalPrixAchat = totalPrixAchat;
	}

}
