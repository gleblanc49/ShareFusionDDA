package ca.dda.fusion.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the dancer_season_dance database table.
 * 
 */
@Entity
@Table(name="dancer_season_dance")
@NamedQuery(name="DancerSeasonDance.findAll", query="SELECT d FROM DancerSeasonDance d")
public class DancerSeasonDance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dancerSeasonDanceId;

	//bi-directional many-to-one association to DancerSeason
	@ManyToOne
	@JoinColumn(name="dancerSeasonId")
	private DancerSeason dancerSeason;

	//bi-directional many-to-one association to SeasonDance
	@ManyToOne
	@JoinColumn(name="seasonDanceId")
	private SeasonDance seasonDance;

	public DancerSeasonDance() {
	}

	public int getDancerSeasonDanceId() {
		return this.dancerSeasonDanceId;
	}

	public void setDancerSeasonDanceId(int dancerSeasonDanceId) {
		this.dancerSeasonDanceId = dancerSeasonDanceId;
	}

	public DancerSeason getDancerSeason() {
		return this.dancerSeason;
	}

	public void setDancerSeason(DancerSeason dancerSeason) {
		this.dancerSeason = dancerSeason;
	}

	public SeasonDance getSeasonDance() {
		return this.seasonDance;
	}

	public void setSeasonDance(SeasonDance seasonDance) {
		this.seasonDance = seasonDance;
	}

}