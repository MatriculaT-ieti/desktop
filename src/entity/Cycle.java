package entity;

import java.util.ArrayList;

public class Cycle {

	private String Code;
	private String Name;
	private String AdapCurricularAdaptation;
	private String TotalHours;
	private String StartedDate;
	private String FinalDate;
	private ArrayList<Modulo> ModuleList = new ArrayList<Modulo>();
	
	public Cycle() {
		super();
	}
	
	

	public Cycle(String name, ArrayList<Modulo> moduleList) {
		super();
		Name = name;
		ModuleList = moduleList;
	}

	public Cycle(String code, String name, String adapCurricularAdaptation, String totalHours, String startedDate,
			String finalDate, ArrayList<Modulo> moduleList) {
		super();
		Code = code;
		Name = name;
		AdapCurricularAdaptation = adapCurricularAdaptation;
		TotalHours = totalHours;
		StartedDate = startedDate;
		FinalDate = finalDate;
		ModuleList = moduleList;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAdapCurricularAdaptation() {
		return AdapCurricularAdaptation;
	}

	public void setAdapCurricularAdaptation(String adapCurricularAdaptation) {
		AdapCurricularAdaptation = adapCurricularAdaptation;
	}

	public String getTotalHours() {
		return TotalHours;
	}

	public void setTotalHours(String totalHours) {
		TotalHours = totalHours;
	}

	public String getStartedDate() {
		return StartedDate;
	}

	public void setStartedDate(String startedDate) {
		StartedDate = startedDate;
	}

	public String getFinalDate() {
		return FinalDate;
	}

	public void setFinalDate(String finalDate) {
		FinalDate = finalDate;
	}

	public ArrayList<Modulo> getModuleList() {
		return ModuleList;
	}

	public void setModuleList(ArrayList<Modulo> moduleList) {
		ModuleList = moduleList;
	}

	
//	codi_cicle_formatiu,nom_cicle_formatiu,codi_adaptacio_curricular,hores_cicle_formatiu,data_inici_cicle_formatiu,data_fi_cicle_formatiu
	
	
	@Override
	public String toString() {
		return "{\"codi_cicle_formatiu\":\"" + Code + "\", \"nom_cicle_formatiu\":\"" + Name + "\", \"codi_adaptacio_curricular\":\"" + AdapCurricularAdaptation
				+ "\", \"hores_cicle_formatiu\":\"" + TotalHours + "\", \"data_inici_cicle_formatiu\":\"" + StartedDate + "\", \"data_fi_cicle_formatiu\":\"" + FinalDate
				+ "\", \"moduls\":" + ModuleList + "}";
	}
}
