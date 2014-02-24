package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the competition database table.
 * 
 */
@Entity
@NamedQuery(name="Competition.findAll", query="SELECT c FROM Competition c")
public class Competition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int competitionId;

	private String competitonName;

	private int version;

	//bi-directional many-to-one association to CompetitionSeason
	@OneToMany(mappedBy="competition")
	private List<CompetitionSeason> competitionSeasons;

	public Competition() {
	}

	public int getCompetitionId() {
		return this.competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}

	public String getCompetitonName() {
		return this.competitonName;
	}

	public void setCompetitonName(String competitonName) {
		this.competitonName = competitonName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<CompetitionSeason> getCompetitionSeasons() {
		return this.competitionSeasons;
	}

	public void setCompetitionSeasons(List<CompetitionSeason> competitionSeasons) {
		this.competitionSeasons = competitionSeasons;
	}

	public CompetitionSeason addCompetitionSeason(CompetitionSeason competitionSeason) {
		getCompetitionSeasons().add(competitionSeason);
		competitionSeason.setCompetition(this);

		return competitionSeason;
	}

	public CompetitionSeason removeCompetitionSeason(CompetitionSeason competitionSeason) {
		getCompetitionSeasons().remove(competitionSeason);
		competitionSeason.setCompetition(null);

		return competitionSeason;
	}

}