package ca.dda.fusion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ca.dda.fusion.model.entity.Dancer;
import ca.dda.fusion.model.facade.DancerFacade;

@Model
public class DancerPage extends CommonPage {
	@Inject
	DancerFacade dancerFacade;// = new DancerFacade();
		
	private String pageName = "DancerPage";
	private Dancer dancer = new Dancer();
	private List<Dancer> dancers;
	private String currentLetter = "A";
	private List<String> alphabet = new ArrayList<String>();
	
	
	public DancerPage(){
		this.setupAlphabet();
	}
	
	public String getCurrentLetter() {
		return currentLetter;
	}

	public void setCurrentLetter(String currentLetter) {
		this.currentLetter = currentLetter;
	}

	public void selectLastNameLetter(){
		this.dancers = dancerFacade.findAllDancersByName(this.currentLetter);
	}

	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public Dancer getDancer() {
		return dancer;
	}
	public void setDancer(Dancer dancer) {
		this.dancer = dancer;
	}
	public List<Dancer> getDancers() {
		return dancers;
	}
	public void setDancers(List<Dancer> dancers) {
		this.dancers = dancers;
	}
	
	public String saveDancer(){
		dancerFacade.saveEntity(this.dancer);
		this.currentLetter = dancer.getLastName().substring(0,1);
		System.out.println("Current Letter after save - " + currentLetter);
		this.selectLastNameLetter();
		this.dancer = new Dancer();
		return "";
	}
	
	public List<String> findAlphabet() {
		return alphabet;
	}

	public void setAlphabet(List<String> alphabet) {
		this.alphabet = alphabet;
	}

	private void setupAlphabet(){
		this.alphabet.add("A");
		this.alphabet.add("B");
		this.alphabet.add("C");
		this.alphabet.add("D");
		this.alphabet.add("E");
		this.alphabet.add("F");
		this.alphabet.add("G");
		this.alphabet.add("H");
		this.alphabet.add("I");
		this.alphabet.add("J");
		this.alphabet.add("K");
		this.alphabet.add("L");
		this.alphabet.add("M");
		this.alphabet.add("N");
		this.alphabet.add("O");
		this.alphabet.add("P");
		this.alphabet.add("Q");
		this.alphabet.add("R");
		this.alphabet.add("S");
		this.alphabet.add("T");
		this.alphabet.add("U");
		this.alphabet.add("V");
		this.alphabet.add("W");
		this.alphabet.add("X");
		this.alphabet.add("Y");
		this.alphabet.add("Z");
	}
	
}
