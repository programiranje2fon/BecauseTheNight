package music;

import java.util.ArrayList;

public class Band {
	
	private String name;
	private ArrayList<Performer> members;
	private boolean active;
	
	public Band(String name, ArrayList<Performer> members, boolean active) {
		super();
		this.name = name;
		this.members = members;
		this.active = active;
	}

	public Band() {
		super();
		this.name = "unknown";
		this.members = new ArrayList<Performer>();
		this.active = false;
	}
	
	public void addPerformer(Performer p) {
		this.members.add(p);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = (new StringBuffer()).append("Band: " + this.name + '\n');
		for (Performer performer : members) {
			sb.append('\t' + performer.getName() + '\n');
		}
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ArrayList<Performer> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Performer> members) {
		this.members = members;
	}

}
