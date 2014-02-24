package ca.dda.fusion.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the invoiceitem database table.
 * 
 */
@Entity
@NamedQuery(name="Invoiceitem.findAll", query="SELECT i FROM Invoiceitem i")
public class Invoiceitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int invoiceItemId;

	private BigDecimal cost;

	private String description;

	private String itemName;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name="invoiceId")
	private Invoice invoice;

	public Invoiceitem() {
	}

	public int getInvoiceItemId() {
		return this.invoiceItemId;
	}

	public void setInvoiceItemId(int invoiceItemId) {
		this.invoiceItemId = invoiceItemId;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}