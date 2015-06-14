package babel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="Babel_trophy")
@JsonInclude(Include.NON_NULL)
public class Trophy {

	public Trophy(){};

	public Trophy(int trophyId, List<User> userTrophy, String trophyName,
			int points) {
		super();
		this.trophyId = trophyId;
		this.userTrophy = userTrophy;
		this.trophyName = trophyName;
		this.points = points;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int trophyId;
	
	@JsonBackReference
	@ManyToMany()
	@JoinColumn(name="username")
	protected List<User> userTrophy;

	protected String trophyName;
	
	protected int points;

	public int getTrophyId() {
		return trophyId;
	}

	public void setTrophyId(int trophyId) {
		this.trophyId = trophyId;
	}

	public List<User> getUserTrophy() {
		return userTrophy;
	}

	public void setUserTrophy(List<User> userTrophy) {
		this.userTrophy = userTrophy;
	}

	public String getTrophyName() {
		return trophyName;
	}

	public void setTrophyName(String trophyName) {
		this.trophyName = trophyName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}	
	
}