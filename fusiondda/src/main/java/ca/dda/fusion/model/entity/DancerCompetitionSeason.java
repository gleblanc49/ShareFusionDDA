package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dancer_competition_season database table.
 * 
 */
@Entity
@Table(name="dancer_competition_season")
@NamedQuery(name="DancerCompetitionSeason.findAll", query="SELECT d FROM DancerCompetitionSeason d")
public class DancerCompetitionSeason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dancerCompetitionSeasonId;

	//bi-directional many-to-one association to CompetitionSeason
	@ManyToOne
	@JoinColumn(name="competitionSeasonId")
	private CompetitionSeason competitionSeason;

	//bi-directional many-to-one association to DancerSeason
	@ManyToOne
	@JoinColumn(name="dancerSeasonId")
	private DancerSeason dancerSeason;

	public DancerCompetitionSeason() {
	}

	public int getDancerCompetitionSeasonId() {
		return this.dancerCompetitionSeasonId;
	}

	public void setDancerCompetitionSeasonId(int dancerCompetitionSeasonId) {
		this.dancerCompetitionSeasonId = dancerCompetitionSeasonId;
	}

	public CompetitionSeason getCompetitionSeason() {
		return this.competitionSeason;
	}

	public void setCompetitionSeason(CompetitionSeason competitionSeason) {
		this.competitionSeason = competitionSeason;
	}

	public DancerSeason getDancerSeason() {
		return this.dancerSeason;
	}

	public void setDancerSeason(DancerSeason dancerSeason) {
		this.dancerSeason = dancerSeason;
	}

}