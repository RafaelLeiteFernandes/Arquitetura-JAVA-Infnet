package br.edu.infnet.RafaelLeiteFernandes.model.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PLinhaProducao")
public class LinhaProducao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String identificador; 
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idSupervisor")
    private Supervisor supervisor;
    private String status;
    private Date dataInicio;
    private Date dataFimPrevisto;
    private double custoOperacional;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idLinhaProducao")
    @JsonManagedReference
    private List<Componente> componentes;
    
    
    public LinhaProducao() {
    	componentes = new ArrayList<Componente>();
	}
    
    @Override
    public String toString() {
    	
        return String.format("[%s %s %d cadastrado com sucesso! Componentes: %d]", 
                identificador,
                supervisor,
                id,
                componentes.size()
            
    		);
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFimPrevisto() {
		return dataFimPrevisto;
	}

	public void setDataFimPrevisto(Date dataFimPrevisto) {
		this.dataFimPrevisto = dataFimPrevisto;
	}

	public double getCustoOperacional() {
		return custoOperacional;
	}

	public void setCustoOperacional(double custoOperacional) {
		this.custoOperacional = custoOperacional;
	}
    
}
