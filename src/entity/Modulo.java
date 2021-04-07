package entity;

import java.util.ArrayList;

public class Modulo {

	private String Code;
	private String Name;
	private String MaxHours;
	private String MinHours;
	private String StartDate;
	private String FinalDate;
	private ArrayList<Unit> UnitList = new ArrayList<Unit>();
	
	public Modulo() {
		super();
	}
  
	public Modulo(String name, ArrayList<Unit> moduleList) {
		super();
		Name = name;
		UnitList = moduleList;
	}

	public Modulo(String code, String name, String maxHours, String minHours, String startDate, String finalDate,
			ArrayList<Unit> unitList) {
		super();
		Code = code;
		Name = name;
		MaxHours = maxHours;
		MinHours = minHours;
		StartDate = startDate;
		FinalDate = finalDate;
		UnitList = unitList;
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
	public ArrayList<Unit> getUnitList() {
		return UnitList;
	}
	public void setUnitList(ArrayList<Unit> unitList) {
		UnitList = unitList;
	}
	
	@Override
	public String toString() {
		return "{\"codi_modul\":\"" + Code + "\", \"nom_modul\":\"" + Name + "\", \"durada_min_modul\":\"" + MinHours + "\", \"durada_max_modul\":\"" + MaxHours + "\", \"durada_min_modul\":\"" + MinHours
	}	
}
