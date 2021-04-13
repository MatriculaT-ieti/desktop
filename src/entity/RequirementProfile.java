package entity;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class RequirementProfile {

	@SerializedName("profile_name")
	private String Name;
	@SerializedName("description")
	private String Description;
	@SerializedName("requirements")
	private ArrayList<String> Requiriment;
	
	public RequirementProfile() {
		super();
	}

	public RequirementProfile(String name, String description, ArrayList<String> requiriment) {
		super();
		Name = name;
		Description = description;
		Requiriment = requiriment;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public ArrayList<String> getRequiriment() {
		return Requiriment;
	}

	public void setRequiriment(ArrayList<String> requiriment) {
		Requiriment = requiriment;
	}

	@Override
	public String toString() {
		return "RequirementProfile [Name=" + Name + ", Description=" + Description + ", Requiriment=" + Requiriment
				+ "]";
	}	
}
