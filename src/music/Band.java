package music;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class Band implements PerformingArtist, Iterator<Performer>, Iterable<Performer> {
	
	private String name;
	private ArrayList<Performer> members;
	private boolean active;
	private Performance firstPerformance;
	private double avgPerformanceTime;
	private int iterCount;
	
	public Band(String name, ArrayList<Performer> members, boolean active, Performance firstPerformance,
            double avgPerformanceTime) {
        super();
        this.name = name;
        this.members = members;
        this.active = active;
        this.firstPerformance = firstPerformance;
        this.avgPerformanceTime = avgPerformanceTime;
        this.iterCount = 0;
    }

    public Band(String name, ArrayList<Performer> members, boolean active, double avgPerformanceTime) {
        super();
        this.name = name;
        this.members = members;
        this.active = active;
        this.avgPerformanceTime = avgPerformanceTime;
        this.iterCount = 0;
    }

    public Band(String name, ArrayList<Performer> members, boolean active) {
		super();
		this.name = name;
		this.members = members;
		this.active = active;
        this.iterCount = 0;
	}

	public Band() {
		super();
		this.name = "unknown";
		this.members = new ArrayList<Performer>();
		this.active = false;
        this.iterCount = 0;
	}
	
	public void addPerformer(Performer p) {
		this.members.add(p);
	}
	
    public void remove(int i) {
        this.members.remove(i);
    }
    
    public void remove(Performer p) {
        this.members.remove(p);
    }
    
    @Override
    public Iterator<Performer> iterator() {
        return this.members.iterator();
    }
    
    public void removeAllMembers() {
//        for (Performer p : this.members) {        // No! Throws ConcurrentModificationException.
//            this.remove(p);
//        }
        Iterator<Performer> i = this.members.iterator();
        while (i.hasNext()) {
            i.next();
            i.remove();
        }
    }
    
    @Override
    public void showFirstPerformance() {
        SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
        System.out.println(this.name + " has performed in public for the first time on " + 
                            df.format(this.firstPerformance.getDate().getTime()) + ", in " + 
                            this.firstPerformance.getLocation() + ".");
    }

    @Override
    public double avgPerformanceTime() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public void showMembers() {
        StringBuffer sb = (new StringBuffer()).append("The members of " + this.name + ": \n");
        for (Performer performer : members) {
            sb.append('\t' + performer.getName() + '\n');
        }
        System.out.println(sb.toString());
    }

    @Override
    public boolean hasNext() {
        if (this.iterCount < this.members.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Performer next() {
        if (this.hasNext()) {
            return this.members.get(this.iterCount++);
        } else {
            return null;
        }
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

    public double getAvgPerformanceTime() {
        return avgPerformanceTime;
    }

    public void setAvgPerformanceTime(double avgPerformanceTime) {
        this.avgPerformanceTime = avgPerformanceTime;
    }

    public Performance getFirstPerformance() {
        return firstPerformance;
    }

    public void setFirstPerformance(Performance firstPerformance) {
        this.firstPerformance = firstPerformance;
    }

}
