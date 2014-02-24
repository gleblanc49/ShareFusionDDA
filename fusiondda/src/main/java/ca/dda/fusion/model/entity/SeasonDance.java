package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the season_dance database table.
 * 
 */
@Entity
@Table(name="season_dance")
@NamedQuery(name="SeasonDance.findAll", query="SELECT s FROM SeasonDance s")
public class SeasonDance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seasonDanceId;

	private String seasonDanceName;

	private String seasonDanceType;

	//bi-directional many-to-one association to DancerSeasonDance
	@OneToMany(mappedBy="seasonDance")
	private List<DancerSeasonDance> dancerSeasonDances;

	//bi-directional many-to-one association to Season
	@ManyToOne
	@JoinColumn(name="seasonId")
	private Season season;

	public SeasonDance() {
	}

	public int getSeasonDanceId() {
		return this.seasonDanceId;
	}

	public void setSeasonDanceId(int seasonDanceId) {
		this.seasonDanceId = seasonDanceId;
	}

	public String getSeasonDanceName() {
		return this.seasonDanceName;
	}

	public void setSeasonDanceName(String seasonDanceName) {
		this.seasonDanceName = seasonDanceName;
	}

	public String getSeasonDanceType() {
		return this.seasonDanceType;
	}

	public void setSeasonDanceType(String seasonDanceType) {
		this.seasonDanceType = seasonDanceType;
	}

	public List<DancerSeasonDance> getDancerSeasonDances() {
		return this.dancerSeasonDances;
	}

	public void setDancerSeasonDances(List<DancerSeasonDance> dancerSeasonDances) {
		this.dancerSeasonDances = dancerSeasonDances;
	}

	public DancerSeasonDance addDancerSeasonDance(DancerSeasonDance dancerSeasonDance) {
		getDancerSeasonDances().add(dancerSeasonDance);
		dancerSeasonDance.setSeasonDance(this);

		return dancerSeasonDance;
	}

	public DancerSeasonDance removeDancerSeasonDance(DancerSeasonDance dancerSeasonDance) {
		getDancerSeasonDances().remove(dancerSeasonDance);
		dancerSeasonDance.setSeasonDance(null);

		return dancerSeasonDance;
	}

	public Season getSeason() {
		return this.season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

}