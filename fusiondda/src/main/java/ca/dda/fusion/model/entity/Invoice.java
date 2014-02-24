package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int invoiceId;

	private byte hst;

	@Temporal(TemporalType.TIMESTAMP)
	private Date invoiceDate;

	private byte paid;

	//bi-directional many-to-one association to DancerSeason
	@ManyToOne
	private DancerSeason dancerSeason;

	//bi-directional many-to-one association to Invoiceitem
	@OneToMany(mappedBy="invoice")
	private List<Invoiceitem> invoiceitems;

	public Invoice() {
	}

	public int getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public byte getHst() {
		return this.hst;
	}

	public void setHst(byte hst) {
		this.hst = hst;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public byte getPaid() {
		return this.paid;
	}

	public void setPaid(byte paid) {
		this.paid = paid;
	}

	public DancerSeason getDancerSeason() {
		return this.dancerSeason;
	}

	public void setDancerSeason(DancerSeason dancerSeason) {
		this.dancerSeason = dancerSeason;
	}

	public List<Invoiceitem> getInvoiceitems() {
		return this.invoiceitems;
	}

	public void setInvoiceitems(List<Invoiceitem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public Invoiceitem addInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().add(invoiceitem);
		invoiceitem.setInvoice(this);

		return invoiceitem;
	}

	public Invoiceitem removeInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().remove(invoiceitem);
		invoiceitem.setInvoice(null);

		return invoiceitem;
	}

}