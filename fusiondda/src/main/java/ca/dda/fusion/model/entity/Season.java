package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the season database table.
 * 
 */
@Entity
@NamedQuery(name="Season.findAll", query="SELECT s FROM Season s")
public class Season implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seasonId;

	private BigDecimal duoChoreographyCost;

	private BigDecimal fusionBaseCost;

	private BigDecimal groupChoreographyCost;

	private String seasonName;

	private BigDecimal soloChoreographyCost;

	private BigDecimal trioChoreographyCost;

	//bi-directional many-to-one association to CompetitionSeason
	@OneToMany(mappedBy="season")
	private List<CompetitionSeason> competitionSeasons;

	//bi-directional many-to-one association to DancerSeason
	@OneToMany(mappedBy="season")
	private List<DancerSeason> dancerSeasons;

	//bi-directional many-to-one association to SeasonDance
	@OneToMany(mappedBy="season")
	private List<SeasonDance> seasonDances;

	public Season() {
	}

	public int getSeasonId() {
		return this.seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public BigDecimal getDuoChoreographyCost() {
		return this.duoChoreographyCost;
	}

	public void setDuoChoreographyCost(BigDecimal duoChoreographyCost) {
		this.duoChoreographyCost = duoChoreographyCost;
	}

	public BigDecimal getFusionBaseCost() {
		return this.fusionBaseCost;
	}

	public void setFusionBaseCost(BigDecimal fusionBaseCost) {
		this.fusionBaseCost = fusionBaseCost;
	}

	public BigDecimal getGroupChoreographyCost() {
		return this.groupChoreographyCost;
	}

	public void setGroupChoreographyCost(BigDecimal groupChoreographyCost) {
		this.groupChoreographyCost = groupChoreographyCost;
	}

	public String getSeasonName() {
		return this.seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	public BigDecimal getSoloChoreographyCost() {
		return this.soloChoreographyCost;
	}

	public void setSoloChoreographyCost(BigDecimal soloChoreographyCost) {
		this.soloChoreographyCost = soloChoreographyCost;
	}

	public BigDecimal getTrioChoreographyCost() {
		return this.trioChoreographyCost;
	}

	public void setTrioChoreographyCost(BigDecimal trioChoreographyCost) {
		this.trioChoreographyCost = trioChoreographyCost;
	}

	public List<CompetitionSeason> getCompetitionSeasons() {
		return this.competitionSeasons;
	}

	public void setCompetitionSeasons(List<CompetitionSeason> competitionSeasons) {
		this.competitionSeasons = competitionSeasons;
	}

	public CompetitionSeason addCompetitionSeason(CompetitionSeason competitionSeason) {
		getCompetitionSeasons().add(competitionSeason);
		competitionSeason.setSeason(this);

		return competitionSeason;
	}

	public CompetitionSeason removeCompetitionSeason(CompetitionSeason competitionSeason) {
		getCompetitionSeasons().remove(competitionSeason);
		competitionSeason.setSeason(null);

		return competitionSeason;
	}

	public List<DancerSeason> getDancerSeasons() {
		return this.dancerSeasons;
	}

	public void setDancerSeasons(List<DancerSeason> dancerSeasons) {
		this.dancerSeasons = dancerSeasons;
	}

	public DancerSeason addDancerSeason1(DancerSeason dancerSeasons) {
		getDancerSeasons().add(dancerSeasons);
		dancerSeasons.setSeason(this);

		return dancerSeasons;
	}

	public DancerSeason removeDancerSeasons(DancerSeason dancerSeasons) {
		getDancerSeasons().remove(dancerSeasons);
		dancerSeasons.setSeason(null);

		return dancerSeasons;
	}

	public List<SeasonDance> getSeasonDances() {
		return this.seasonDances;
	}

	public void setSeasonDances(List<SeasonDance> seasonDances) {
		this.seasonDances = seasonDances;
	}

	public SeasonDance addSeasonDance(SeasonDance seasonDance) {
		getSeasonDances().add(seasonDance);
		seasonDance.setSeason(this);

		return seasonDance;
	}

	public SeasonDance removeSeasonDance(SeasonDance seasonDance) {
		getSeasonDances().remove(seasonDance);
		seasonDance.setSeason(null);

		return seasonDance;
	}

}