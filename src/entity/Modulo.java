package entity;

import java.util.ArrayList;

public class Modulo {

	private String Code;
	private String Name;
	private String MaxHours;
	private String MinHours;
	private String StartDate;
	private String FinalDate;
	private ArrayList<Unit> ModuleList = new ArrayList<Unit>();
	
	public Modulo() {
		super();
	}
	
	
	
	public Modulo(String name, ArrayList<Unit> moduleList) {
		super();
		Name = name;
		ModuleList = moduleList;
	}

	public Modulo(String code, String name, String maxHours, String minHours, String startDate, String finalDate,
			ArrayList<Unit> moduleList) {
		super();
		Code = code;
		Name = name;
		MaxHours = maxHours;
		MinHours = minHours;
		StartDate = startDate;
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
	public String getMaxHours() {
		return MaxHours;
	}
	public void setMaxHours(String maxHours) {
		MaxHours = maxHours;
	}
	public String getMinHours() {
		return MinHours;
	}
	public void setMinHours(String minHours) {
		MinHours = minHours;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getFinalDate() {
		return FinalDate;
	}
	public void setFinalDate(String finalDate) {
		FinalDate = finalDate;
	}
	public ArrayList<Unit> getModuleList() {
		return ModuleList;
	}
	public void setModuleList(ArrayList<Unit> moduleList) {
		ModuleList = moduleList;
	}
	
	@Override
	public String toString() {
		return "Module [Code=" + Code + ", Name=" + Name + ", MaxHours=" + MaxHours + ", MinHours=" + MinHours
				+ ", StartDate=" + StartDate + ", FinalDate=" + FinalDate + ", ModuleList=" + ModuleList + "]";
	}	
}
