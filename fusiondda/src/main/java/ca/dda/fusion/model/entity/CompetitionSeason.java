package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the competition_season database table.
 * 
 */
@Entity
@Table(name="competition_season")
@NamedQuery(name="CompetitionSeason.findAll", query="SELECT c FROM CompetitionSeason c")
public class CompetitionSeason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int competitionSeasonId;

	private BigDecimal duoCost;

	private BigDecimal groupCost;

	private BigDecimal soloCost;

	private BigDecimal trioCost;

	//bi-directional many-to-one association to Competition
	@ManyToOne
	@JoinColumn(name="competitionId")
	private Competition competition;

	//bi-directional many-to-one association to Season
	@ManyToOne
	@JoinColumn(name="seasonId")
	private Season season;

	//bi-directional many-to-one association to DancerCompetitionSeason
	@OneToMany(mappedBy="competitionSeason")
	private List<DancerCompetitionSeason> dancerCompetitionSeasons;

	public CompetitionSeason() {
	}

	public int getCompetitionSeasonId() {
		return this.competitionSeasonId;
	}

	public void setCompetitionSeasonId(int competitionSeasonId) {
		this.competitionSeasonId = competitionSeasonId;
	}

	public BigDecimal getDuoCost() {
		return this.duoCost;
	}

	public void setDuoCost(BigDecimal duoCost) {
		this.duoCost = duoCost;
	}

	public BigDecimal getGroupCost() {
		return this.groupCost;
	}

	public void setGroupCost(BigDecimal groupCost) {
		this.groupCost = groupCost;
	}

	public BigDecimal getSoloCost() {
		return this.soloCost;
	}

	public void setSoloCost(BigDecimal soloCost) {
		this.soloCost = soloCost;
	}

	public BigDecimal getTrioCost() {
		return this.trioCost;
	}

	public void setTrioCost(BigDecimal trioCost) {
		this.trioCost = trioCost;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Season getSeason() {
		return this.season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public List<DancerCompetitionSeason> getDancerCompetitionSeasons() {
		return this.dancerCompetitionSeasons;
	}

	public void setDancerCompetitionSeasons(List<DancerCompetitionSeason> dancerCompetitionSeasons) {
		this.dancerCompetitionSeasons = dancerCompetitionSeasons;
	}

	public DancerCompetitionSeason addDancerCompetitionSeason(DancerCompetitionSeason dancerCompetitionSeason) {
		getDancerCompetitionSeasons().add(dancerCompetitionSeason);
		dancerCompetitionSeason.setCompetitionSeason(this);

		return dancerCompetitionSeason;
	}

	public DancerCompetitionSeason removeDancerCompetitionSeason(DancerCompetitionSeason dancerCompetitionSeason) {
		getDancerCompetitionSeasons().remove(dancerCompetitionSeason);
		dancerCompetitionSeason.setCompetitionSeason(null);

		return dancerCompetitionSeason;
	}

}