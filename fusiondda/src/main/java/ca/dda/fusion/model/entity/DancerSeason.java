package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dancer_season database table.
 * 
 */
@Entity
@Table(name="dancer_season")
@NamedQuery(name="DancerSeason.findAll", query="SELECT d FROM DancerSeason d")
public class DancerSeason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dancerSeasonId;

	//bi-directional many-to-one association to DancerCompetitionSeason
	@OneToMany(mappedBy="dancerSeason")
	private List<DancerCompetitionSeason> dancerCompetitionSeasons;

	//bi-directional many-to-one association to Dancer
	@ManyToOne
	@JoinColumn(name="dancerId")
	private Dancer dancer;

	//bi-directional many-to-one association to Season
	@ManyToOne
	@JoinColumn(name="seasonId")
	private Season season;


	//bi-directional many-to-one association to DancerSeasonDance
	@OneToMany(mappedBy="dancerSeason")
	private List<DancerSeasonDance> dancerSeasonDances;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="dancerSeason")
	private List<Invoice> invoices;

	public DancerSeason() {
	}

	public int getDancerSeasonId() {
		return this.dancerSeasonId;
	}

	public void setDancerSeasonId(int dancerSeasonId) {
		this.dancerSeasonId = dancerSeasonId;
	}

	public List<DancerCompetitionSeason> getDancerCompetitionSeasons() {
		return this.dancerCompetitionSeasons;
	}

	public void setDancerCompetitionSeasons(List<DancerCompetitionSeason> dancerCompetitionSeasons) {
		this.dancerCompetitionSeasons = dancerCompetitionSeasons;
	}

	public DancerCompetitionSeason addDancerCompetitionSeason(DancerCompetitionSeason dancerCompetitionSeason) {
		getDancerCompetitionSeasons().add(dancerCompetitionSeason);
		dancerCompetitionSeason.setDancerSeason(this);

		return dancerCompetitionSeason;
	}

	public DancerCompetitionSeason removeDancerCompetitionSeason(DancerCompetitionSeason dancerCompetitionSeason) {
		getDancerCompetitionSeasons().remove(dancerCompetitionSeason);
		dancerCompetitionSeason.setDancerSeason(null);

		return dancerCompetitionSeason;
	}

	public Dancer getDancer() {
		return this.dancer;
	}

	public void setDancer(Dancer dancer) {
		this.dancer = dancer;
	}

	public Season getSeason() {
		return this.season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public List<DancerSeasonDance> getDancerSeasonDances() {
		return this.dancerSeasonDances;
	}

	public void setDancerSeasonDances(List<DancerSeasonDance> dancerSeasonDances) {
		this.dancerSeasonDances = dancerSeasonDances;
	}

	public DancerSeasonDance addDancerSeasonDance(DancerSeasonDance dancerSeasonDance) {
		getDancerSeasonDances().add(dancerSeasonDance);
		dancerSeasonDance.setDancerSeason(this);

		return dancerSeasonDance;
	}

	public DancerSeasonDance removeDancerSeasonDance(DancerSeasonDance dancerSeasonDance) {
		getDancerSeasonDances().remove(dancerSeasonDance);
		dancerSeasonDance.setDancerSeason(null);

		return dancerSeasonDance;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setDancerSeason(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setDancerSeason(null);

		return invoice;
	}

}