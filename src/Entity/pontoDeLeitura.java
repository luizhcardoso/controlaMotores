package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table
public class pontoDeLeitura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo = 0;
	
	public pontoDeLeitura(Date data, boolean motorPressaoSkidA, boolean motorPressaoSkidB, boolean motorVacuo,
			boolean motorTransferenciaSkidA, boolean motorTransferenciaSkidB, boolean portaUsina) {
		super();
		this.data = data;
		this.motorPressaoSkidA = motorPressaoSkidA;
		this.motorPressaoSkidB = motorPressaoSkidB;
		this.motorVacuo = motorVacuo;
		this.motorTransferenciaSkidA = motorTransferenciaSkidA;
		this.motorTransferenciaSkidB = motorTransferenciaSkidB;
		this.portaUsina = portaUsina;
	}
	public pontoDeLeitura(int codigo, Date data, boolean motorPressaoSkidA,
			boolean motorPressaoSkidB, boolean motorVacuo, boolean motorTransferenciaSkidA,
			boolean motorTransferenciaSkidB, boolean portaUsina, String status) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.motorPressaoSkidA = motorPressaoSkidA;
		this.motorPressaoSkidB = motorPressaoSkidB;
		this.motorVacuo = motorVacuo;
		this.motorTransferenciaSkidA = motorTransferenciaSkidA;
		this.motorTransferenciaSkidB = motorTransferenciaSkidB;
		this.portaUsina = portaUsina;
		this.status = status;
	}
	public pontoDeLeitura(){
		
	}

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="usinada")
	private Usinada usinada; 
	
	@Column(nullable = false)
	private boolean motorPressaoSkidA;
	
	@Column(nullable = false)
	private boolean motorPressaoSkidB;
	
	@Column(nullable = false)
	private boolean motorVacuo;
	
	@Column(nullable = false)
	private boolean motorTransferenciaSkidA;
	
	@Column(nullable = false)
	private boolean motorTransferenciaSkidB;
	
	@Column(nullable = false)
	private boolean portaUsina;
	
	@Column(nullable = true)
	private String status;
		
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public boolean isMotorPressaoSkidA() {
		return motorPressaoSkidA;
	}

	public void setMotorPressaoSkidA(boolean motorPressaoSkidA) {
		this.motorPressaoSkidA = motorPressaoSkidA;
	}

	public boolean isMotorPressaoSkidB() {
		return motorPressaoSkidB;
	}

	public void setMotorPressaoSkidB(boolean motorPressaoSkidB) {
		this.motorPressaoSkidB = motorPressaoSkidB;
	}

	public boolean isMotorVacuo() {
		return motorVacuo;
	}

	public void setMotorVacuo(boolean motorVacuo) {
		this.motorVacuo = motorVacuo;
	}

	public boolean isMotorTransferenciaSkidA() {
		return motorTransferenciaSkidA;
	}

	public void setMotorTransferenciaSkidA(boolean motorTransferenciaSkidA) {
		this.motorTransferenciaSkidA = motorTransferenciaSkidA;
	}

	public boolean isMotorTransferenciaSkidB() {
		return motorTransferenciaSkidB;
	}

	public void setMotorTransferenciaSkidB(boolean motorTransferenciaSkidB) {
		this.motorTransferenciaSkidB = motorTransferenciaSkidB;
	}

	public boolean isPortaUsina() {
		return portaUsina;
	}

	public void setPortaUsina(boolean portaUsina) {
		this.portaUsina = portaUsina;
	}
	
	public String toStringThis() {
					return ("codigo      = "+getCodigo()+ "\n"
					+ "PressaoA    = " + isMotorPressaoSkidA()+"\n"
					+ "PressaoB    = " + isMotorPressaoSkidB()+"\n"
					+ "TRANSF A    = " + isMotorTransferenciaSkidA()+"\n"
					+ "TRASNF B    = " + isMotorTransferenciaSkidB()+"\n"
					+ "VACUO       = " + isMotorVacuo()+"\n"
					+ "PORTA USINA = " + isPortaUsina()+"\n"
					+ "DATA        = " + getData()+"\n"
					+ "Status        = " + getStatus()+"\n"
							+ "-------------------------------");
		
	}
	
	
}
