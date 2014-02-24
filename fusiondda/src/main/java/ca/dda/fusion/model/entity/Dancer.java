package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dancer database table.
 * 
 */
@Entity
@NamedQuery(name="Dancer.findAll", query="SELECT d FROM Dancer d")
public class Dancer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dancerId;

	private String address1;

	private String address2;

	private String city;

	private String email1;

	private String email2;

	private String email3;

	private String email4;

	private String email5;

	private String firstName;

	private String lastName;

	private String postalCode;

	private String province;

	//bi-directional many-to-one association to DancerSeason
	@OneToMany(mappedBy="dancer")
	private List<DancerSeason> dancerSeasons;

	public Dancer() {
	}

	public int getDancerId() {
		return this.dancerId;
	}

	public void setDancerId(int dancerId) {
		this.dancerId = dancerId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail1() {
		return this.email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return this.email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getEmail4() {
		return this.email4;
	}

	public void setEmail4(String email4) {
		this.email4 = email4;
	}

	public String getEmail5() {
		return this.email5;
	}

	public void setEmail5(String email5) {
		this.email5 = email5;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<DancerSeason> getDancerSeasons() {
		return this.dancerSeasons;
	}

	public void setDancerSeasons(List<DancerSeason> dancerSeasons) {
		this.dancerSeasons = dancerSeasons;
	}

	public DancerSeason addDancerSeason(DancerSeason dancerSeason) {
		getDancerSeasons().add(dancerSeason);
		dancerSeason.setDancer(this);

		return dancerSeason;
	}

	public DancerSeason removeDancerSeason(DancerSeason dancerSeason) {
		getDancerSeasons().remove(dancerSeason);
		dancerSeason.setDancer(null);

		return dancerSeason;
	}

}