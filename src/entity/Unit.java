package entity;

public class Unit {

	private String Code;
	private String Name;
	private String TotalHours;
	private String Fct;
	private String Synthesis;
	private String Language;
	private String Project;
	
	public Unit() {
		super();
	}

	public Unit(String code, String name, String totalHours, String fct, String synthesis, String language,
			String project) {
		super();
		Code = code;
		Name = name;
		TotalHours = totalHours;
		Fct = fct;
		Synthesis = synthesis;
		Language = language;
		Project = project;
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

	public String getTotalHours() {
		return TotalHours;
	}

	public void setTotalHours(String totalHours) {
		TotalHours = totalHours;
	}

	public String getFct() {
		return Fct;
	}

	public void setFct(String fct) {
		Fct = fct;
	}

	public String getSynthesis() {
		return Synthesis;
	}

	public void setSynthesis(String synthesis) {
		Synthesis = synthesis;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getProject() {
		return Project;
	}

	public void setProject(String project) {
		Project = project;
	}

	@Override
	public String toString() {
		return "Unit [Code=" + Code + ", Name=" + Name + ", TotalHours=" + TotalHours + ", Fct=" + Fct + ", Synthesis="
				+ Synthesis + ", Language=" + Language + ", Project=" + Project + "]";
	}	
}
