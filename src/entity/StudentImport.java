package entity;

import com.google.gson.annotations.SerializedName;

public class StudentImport {
	
	private String Convocatioria;
	private String Codi_solicitud;
	private String Tipus_solicitud;
	private String Estat_solicitud;
	@SerializedName("Nom")
	private String Nom;
	@SerializedName("Primer Cognom")
	private String Primer_cognom;
	@SerializedName("Segon Cognom")
	private String Segon_cognom;
	private String Identificador_RALC;
	private String Tipus_alumne;
	private String Codi_centre_p1;
	private String nom_centre_p1;
	private String naturalesa_centre_p1;
	private String municipi_centre_p1;
	private String SSTT_centre_p1;
	private String codi_ensenyament;
	@SerializedName("cicle_formatiu")
	private String nom_ensenyament;
	private String codi_modalitat;
	private String modalitat;
	private String curs_p1;
	private String regim_p1;
	private String torn_p1;
	@SerializedName("DNI")
	private String dni;
	private String nie;
	private String pass;
	private String tis;
	private String data_naixament;
	private String sexe;
	private String nacionalitat;
	@SerializedName("Pais Naixament")
	private String pais_naixament;
	private String municipi_naixament;
	@SerializedName("Tipus via")
	private String tipus_via;
	@SerializedName("Nom via")
	private String nom_via;
	@SerializedName("Número via")
	private String numeros_via;
	private String altres_dades;
	private String provincia_residencia;
	@SerializedName("Municipi residència")
	private String municipi_residencia;
	private String localitat_residencia;
	private String cp;
	private String pais_residencia;
	@SerializedName("Telèfon")
	private String telefon;
	@SerializedName("Correu electrònic")
	private String correu_electronic;
	private String tipus_doc_tutor1;
	private String num_doc_tutor1;
	private String nom_tutor1;
	private String primer_cognom_tutor1;
	private String segon_cognom_tutor1;
	private String tipus_doc_tutor2;
	private String num_doc_tutor2;
	private String nom_tutor2;
	private String primer_cognom_tutor2;
	private String segon_cognom_tutor2;
	private String codi_centre_proc;
	private String nom_centre_proc;
	private String codi_ensenyament_proc;
	private String nom_ensenyament_proc;
	private String curs_proc;
	private String llengua_enten;
	private String religio;
	private String centre_asignat;
	
	public StudentImport() {
		
	}
	
	public StudentImport(String convocatioria, String codi_solicitud, String tipus_solicitud, String estat_solicitud,
			String nom, String primer_cognom, String segon_cognom, String identificador_RALC, String tipus_alumne,
			String codi_centre_p1, String nom_centre_p1, String naturalesa_centre_p1, String municipi_centre_p1,
			String sSTT_centre_p1, String codi_ensenyament, String nom_ensenyament, String codi_modalitat,
			String modalitat, String curs_p1, String regim_p1, String torn_p1, String dni, String nie, String pass,
			String tis, String data_naixament, String sexe, String nacionalitat, String pais_naixament,
			String municipi_naixament, String tipus_via, String nom_via, String numeros_via, String altres_dades,
			String provincia_residencia, String municipi_residencia, String localitat_residencia, String cp,
			String pais_residencia, String telefon, String correu_electronic, String tipus_doc_tutor1,
			String num_doc_tutor1, String nom_tutor1, String primer_cognom_tutor1, String segon_cognom_tutor1,
			String tipus_doc_tutor2, String num_doc_tutor2, String nom_tutor2, String primer_cognom_tutor2,
			String segon_cognom_tutor2, String codi_centre_proc, String nom_centre_proc, String codi_ensenyament_proc,
			String nom_ensenyament_proc, String curs_proc, String llengua_enten, String religio,
			String centre_asignat) {
		super();
		Convocatioria = convocatioria;
		Codi_solicitud = codi_solicitud;
		Tipus_solicitud = tipus_solicitud;
		Estat_solicitud = estat_solicitud;
		Nom = nom;
		Primer_cognom = primer_cognom;
		Segon_cognom = segon_cognom;
		Identificador_RALC = identificador_RALC;
		Tipus_alumne = tipus_alumne;
		Codi_centre_p1 = codi_centre_p1;
		this.nom_centre_p1 = nom_centre_p1;
		this.naturalesa_centre_p1 = naturalesa_centre_p1;
		this.municipi_centre_p1 = municipi_centre_p1;
		SSTT_centre_p1 = sSTT_centre_p1;
		this.codi_ensenyament = codi_ensenyament;
		this.nom_ensenyament = nom_ensenyament;
		this.codi_modalitat = codi_modalitat;
		this.modalitat = modalitat;
		this.curs_p1 = curs_p1;
		this.regim_p1 = regim_p1;
		this.torn_p1 = torn_p1;
		this.dni = dni;
		this.nie = nie;
		this.pass = pass;
		this.tis = tis;
		this.data_naixament = data_naixament;
		this.sexe = sexe;
		this.nacionalitat = nacionalitat;
		this.pais_naixament = pais_naixament;
		this.municipi_naixament = municipi_naixament;
		this.tipus_via = tipus_via;
		this.nom_via = nom_via;
		this.numeros_via = numeros_via;
		this.altres_dades = altres_dades;
		this.provincia_residencia = provincia_residencia;
		this.municipi_residencia = municipi_residencia;
		this.localitat_residencia = localitat_residencia;
		this.cp = cp;
		this.pais_residencia = pais_residencia;
		this.telefon = telefon;
		this.correu_electronic = correu_electronic;
		this.tipus_doc_tutor1 = tipus_doc_tutor1;
		this.num_doc_tutor1 = num_doc_tutor1;
		this.nom_tutor1 = nom_tutor1;
		this.primer_cognom_tutor1 = primer_cognom_tutor1;
		this.segon_cognom_tutor1 = segon_cognom_tutor1;
		this.tipus_doc_tutor2 = tipus_doc_tutor2;
		this.num_doc_tutor2 = num_doc_tutor2;
		this.nom_tutor2 = nom_tutor2;
		this.primer_cognom_tutor2 = primer_cognom_tutor2;
		this.segon_cognom_tutor2 = segon_cognom_tutor2;
		this.codi_centre_proc = codi_centre_proc;
		this.nom_centre_proc = nom_centre_proc;
		this.codi_ensenyament_proc = codi_ensenyament_proc;
		this.nom_ensenyament_proc = nom_ensenyament_proc;
		this.curs_proc = curs_proc;
		this.llengua_enten = llengua_enten;
		this.religio = religio;
		this.centre_asignat = centre_asignat;
	}

	public String getConvocatioria() {
		return Convocatioria;
	}
	public void setConvocatioria(String convocatioria) {
		Convocatioria = convocatioria;
	}
	public String getCodi_solicitud() {
		return Codi_solicitud;
	}
	public void setCodi_solicitud(String codi_solicitud) {
		Codi_solicitud = codi_solicitud;
	}
	public String getTipus_solicitud() {
		return Tipus_solicitud;
	}
	public void setTipus_solicitud(String tipus_solicitud) {
		Tipus_solicitud = tipus_solicitud;
	}
	public String getEstat_solicitud() {
		return Estat_solicitud;
	}
	public void setEstat_solicitud(String estat_solicitud) {
		Estat_solicitud = estat_solicitud;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrimer_cognom() {
		return Primer_cognom;
	}
	public void setPrimer_cognom(String primer_cognom) {
		Primer_cognom = primer_cognom;
	}
	public String getSegon_cognom() {
		return Segon_cognom;
	}
	public void setSegon_cognom(String segon_cognom) {
		Segon_cognom = segon_cognom;
	}
	public String getIdentificador_RALC() {
		return Identificador_RALC;
	}
	public void setIdentificador_RALC(String identificador_RALC) {
		Identificador_RALC = identificador_RALC;
	}
	public String getTipus_alumne() {
		return Tipus_alumne;
	}
	public void setTipus_alumne(String tipus_alumne) {
		Tipus_alumne = tipus_alumne;
	}
	public String getCodi_centre_p1() {
		return Codi_centre_p1;
	}
	public void setCodi_centre_p1(String codi_centre_p1) {
		Codi_centre_p1 = codi_centre_p1;
	}
	public String getNom_centre_p1() {
		return nom_centre_p1;
	}
	public void setNom_centre_p1(String nom_centre_p1) {
		this.nom_centre_p1 = nom_centre_p1;
	}
	public String getNaturalesa_centre_p1() {
		return naturalesa_centre_p1;
	}
	public void setNaturalesa_centre_p1(String naturalesa_centre_p1) {
		this.naturalesa_centre_p1 = naturalesa_centre_p1;
	}
	public String getMunicipi_centre_p1() {
		return municipi_centre_p1;
	}
	public void setMunicipi_centre_p1(String municipi_centre_p1) {
		this.municipi_centre_p1 = municipi_centre_p1;
	}
	public String getSSTT_centre_p1() {
		return SSTT_centre_p1;
	}
	public void setSSTT_centre_p1(String sSTT_centre_p1) {
		SSTT_centre_p1 = sSTT_centre_p1;
	}
	public String getCodi_ensenyament() {
		return codi_ensenyament;
	}
	public void setCodi_ensenyament(String codi_ensenyament) {
		this.codi_ensenyament = codi_ensenyament;
	}
	public String getNom_ensenyament() {
		return nom_ensenyament;
	}
	public void setNom_ensenyament(String nom_ensenyament) {
		this.nom_ensenyament = nom_ensenyament;
	}
	public String getCodi_modalitat() {
		return codi_modalitat;
	}
	public void setCodi_modalitat(String codi_modalitat) {
		this.codi_modalitat = codi_modalitat;
	}
	public String getModalitat() {
		return modalitat;
	}
	public void setModalitat(String modalitat) {
		this.modalitat = modalitat;
	}
	public String getCurs_p1() {
		return curs_p1;
	}
	public void setCurs_p1(String curs_p1) {
		this.curs_p1 = curs_p1;
	}
	public String getRegim_p1() {
		return regim_p1;
	}
	public void setRegim_p1(String regim_p1) {
		this.regim_p1 = regim_p1;
	}
	public String getTorn_p1() {
		return torn_p1;
	}
	public void setTorn_p1(String torn_p1) {
		this.torn_p1 = torn_p1;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNie() {
		return nie;
	}
	public void setNie(String nie) {
		this.nie = nie;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTis() {
		return tis;
	}
	public void setTis(String tis) {
		this.tis = tis;
	}
	public String getData_naixament() {
		return data_naixament;
	}
	public void setData_naixament(String data_naixament) {
		this.data_naixament = data_naixament;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getNacionalitat() {
		return nacionalitat;
	}
	public void setNacionalitat(String nacionalitat) {
		this.nacionalitat = nacionalitat;
	}
	public String getPais_naixament() {
		return pais_naixament;
	}
	public void setPais_naixament(String pais_naixament) {
		this.pais_naixament = pais_naixament;
	}
	public String getMunicipi_naixament() {
		return municipi_naixament;
	}
	public void setMunicipi_naixament(String municipi_naixament) {
		this.municipi_naixament = municipi_naixament;
	}
	public String getTipus_via() {
		return tipus_via;
	}
	public void setTipus_via(String tipus_via) {
		this.tipus_via = tipus_via;
	}
	public String getNom_via() {
		return nom_via;
	}
	public void setNom_via(String nom_via) {
		this.nom_via = nom_via;
	}
	public String getNumeros_via() {
		return numeros_via;
	}
	public void setNumeros_via(String numeros_via) {
		this.numeros_via = numeros_via;
	}
	public String getAltres_dades() {
		return altres_dades;
	}
	public void setAltres_dades(String altres_dades) {
		this.altres_dades = altres_dades;
	}
	public String getProvincia_residencia() {
		return provincia_residencia;
	}
	public void setProvincia_residencia(String provincia_residencia) {
		this.provincia_residencia = provincia_residencia;
	}
	public String getMunicipi_residencia() {
		return municipi_residencia;
	}
	public void setMunicipi_residencia(String municipi_residencia) {
		this.municipi_residencia = municipi_residencia;
	}
	public String getLocalitat_residencia() {
		return localitat_residencia;
	}
	public void setLocalitat_residencia(String localitat_residencia) {
		this.localitat_residencia = localitat_residencia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPais_residencia() {
		return pais_residencia;
	}
	public void setPais_residencia(String pais_residencia) {
		this.pais_residencia = pais_residencia;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getCorreu_electronic() {
		return correu_electronic;
	}
	public void setCorreu_electronic(String correu_electronic) {
		this.correu_electronic = correu_electronic;
	}
	public String getTipus_doc_tutor1() {
		return tipus_doc_tutor1;
	}
	public void setTipus_doc_tutor1(String tipus_doc_tutor1) {
		this.tipus_doc_tutor1 = tipus_doc_tutor1;
	}
	public String getNum_doc_tutor1() {
		return num_doc_tutor1;
	}
	public void setNum_doc_tutor1(String num_doc_tutor1) {
		this.num_doc_tutor1 = num_doc_tutor1;
	}
	public String getNom_tutor1() {
		return nom_tutor1;
	}
	public void setNom_tutor1(String nom_tutor1) {
		this.nom_tutor1 = nom_tutor1;
	}
	public String getPrimer_cognom_tutor1() {
		return primer_cognom_tutor1;
	}
	public void setPrimer_cognom_tutor1(String primer_cognom_tutor1) {
		this.primer_cognom_tutor1 = primer_cognom_tutor1;
	}
	public String getSegon_cognom_tutor1() {
		return segon_cognom_tutor1;
	}
	public void setSegon_cognom_tutor1(String segon_cognom_tutor1) {
		this.segon_cognom_tutor1 = segon_cognom_tutor1;
	}
	public String getTipus_doc_tutor2() {
		return tipus_doc_tutor2;
	}
	public void setTipus_doc_tutor2(String tipus_doc_tutor2) {
		this.tipus_doc_tutor2 = tipus_doc_tutor2;
	}
	public String getNum_doc_tutor2() {
		return num_doc_tutor2;
	}
	public void setNum_doc_tutor2(String num_doc_tutor2) {
		this.num_doc_tutor2 = num_doc_tutor2;
	}
	public String getNom_tutor2() {
		return nom_tutor2;
	}
	public void setNom_tutor2(String nom_tutor2) {
		this.nom_tutor2 = nom_tutor2;
	}
	public String getPrimer_cognom_tutor2() {
		return primer_cognom_tutor2;
	}
	public void setPrimer_cognom_tutor2(String primer_cognom_tutor2) {
		this.primer_cognom_tutor2 = primer_cognom_tutor2;
	}
	public String getSegon_cognom_tutor2() {
		return segon_cognom_tutor2;
	}
	public void setSegon_cognom_tutor2(String segon_cognom_tutor2) {
		this.segon_cognom_tutor2 = segon_cognom_tutor2;
	}
	public String getCodi_centre_proc() {
		return codi_centre_proc;
	}
	public void setCodi_centre_proc(String codi_centre_proc) {
		this.codi_centre_proc = codi_centre_proc;
	}
	public String getNom_centre_proc() {
		return nom_centre_proc;
	}
	public void setNom_centre_proc(String nom_centre_proc) {
		this.nom_centre_proc = nom_centre_proc;
	}
	public String getNom_ensenyament_proc() {
		return nom_ensenyament_proc;
	}
	public void setNom_ensenyament_proc(String nom_ensenyament_proc) {
		this.nom_ensenyament_proc = nom_ensenyament_proc;
	}
	public String getCurs_proc() {
		return curs_proc;
	}
	public void setCurs_proc(String curs_proc) {
		this.curs_proc = curs_proc;
	}
	public String getLlengua_enten() {
		return llengua_enten;
	}
	public void setLlengua_enten(String llengua_enten) {
		this.llengua_enten = llengua_enten;
	}
	public String getReligio() {
		return religio;
	}
	public void setReligio(String religio) {
		this.religio = religio;
	}
	public String getCentre_asignat() {
		return centre_asignat;
	}
	public void setCentre_asignat(String centre_asignat) {
		this.centre_asignat = centre_asignat;
	}

	public String getCodi_ensenyament_proc() {
		return codi_ensenyament_proc;
	}

	public void setCodi_ensenyament_proc(String codi_ensenyament_proc) {
		this.codi_ensenyament_proc = codi_ensenyament_proc;
	}

	@Override
	public String toString() {
		return "StudentImport [Convocatioria=" + Convocatioria + ", Codi_solicitud=" + Codi_solicitud
				+ ", Tipus_solicitud=" + Tipus_solicitud + ", Estat_solicitud=" + Estat_solicitud + ", Nom=" + Nom
				+ ", Primer_cognom=" + Primer_cognom + ", Segon_cognom=" + Segon_cognom + ", Identificador_RALC="
				+ Identificador_RALC + ", Tipus_alumne=" + Tipus_alumne + ", Codi_centre_p1=" + Codi_centre_p1
				+ ", nom_centre_p1=" + nom_centre_p1 + ", naturalesa_centre_p1=" + naturalesa_centre_p1
				+ ", municipi_centre_p1=" + municipi_centre_p1 + ", SSTT_centre_p1=" + SSTT_centre_p1
				+ ", codi_ensenyament=" + codi_ensenyament + ", nom_ensenyament=" + nom_ensenyament
				+ ", codi_modalitat=" + codi_modalitat + ", modalitat=" + modalitat + ", curs_p1=" + curs_p1
				+ ", regim_p1=" + regim_p1 + ", torn_p1=" + torn_p1 + ", dni=" + dni + ", nie=" + nie + ", pass=" + pass
				+ ", tis=" + tis + ", data_naixament=" + data_naixament + ", sexe=" + sexe + ", nacionalitat="
				+ nacionalitat + ", pais_naixament=" + pais_naixament + ", municipi_naixament=" + municipi_naixament
				+ ", tipus_via=" + tipus_via + ", nom_via=" + nom_via + ", numeros_via=" + numeros_via
				+ ", altres_dades=" + altres_dades + ", provincia_residencia=" + provincia_residencia
				+ ", municipi_residencia=" + municipi_residencia + ", localitat_residencia=" + localitat_residencia
				+ ", cp=" + cp + ", pais_residencia=" + pais_residencia + ", telefon=" + telefon
				+ ", correu_electronic=" + correu_electronic + ", tipus_doc_tutor1=" + tipus_doc_tutor1
				+ ", num_doc_tutor1=" + num_doc_tutor1 + ", nom_tutor1=" + nom_tutor1 + ", primer_cognom_tutor1="
				+ primer_cognom_tutor1 + ", segon_cognom_tutor1=" + segon_cognom_tutor1 + ", tipus_doc_tutor2="
				+ tipus_doc_tutor2 + ", num_doc_tutor2=" + num_doc_tutor2 + ", nom_tutor2=" + nom_tutor2
				+ ", primer_cognom_tutor2=" + primer_cognom_tutor2 + ", segon_cognom_tutor2=" + segon_cognom_tutor2
				+ ", codi_centre_proc=" + codi_centre_proc + ", nom_centre_proc=" + nom_centre_proc
				+ ", nom_ensenyament_proc=" + nom_ensenyament_proc + ", curs_proc=" + curs_proc + ", llengua_enten="
				+ llengua_enten + ", religio=" + religio + ", centre_asignat=" + centre_asignat + "]";
	}
}