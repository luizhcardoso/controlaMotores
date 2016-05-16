package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Usinada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo = 0;
	
	@OneToMany(mappedBy="usinada", fetch=FetchType.EAGER ,cascade=CascadeType.ALL)
	private List<pontoDeLeitura> pontosDeLeituras; 
	@Column(nullable=true)
	private String status;

	public Usinada(){
		
	}
	public Usinada(List<pontoDeLeitura> pontosDeLeituras) {
		super();
		this.pontosDeLeituras = pontosDeLeituras;
	}
	public Usinada(List<pontoDeLeitura> pontosDeLeituras,String status) {
		super();
		this.pontosDeLeituras = pontosDeLeituras;
		this.status = status;
	}
		
	
	public List<pontoDeLeitura> getPontosDeLeituras() {
		return pontosDeLeituras;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setPontosDeLeituras(List<pontoDeLeitura> pontosDeLeituras) {
		this.pontosDeLeituras = pontosDeLeituras;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	}
