package br.edu.infnet.RafaelLeiteFernandes.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TEletronico")
public class ComponenteEletronico extends Componente {
    
    @Min(value = 0, message = "A potência deve ser maior ou igual a zero")
    private int potencia;
    
    @NotBlank(message = "O tipo de circuito não pode estar em branco")
    private String tipoCircuito;
    
    @Min(value = 0, message = "A voltagem deve ser maior ou igual a zero")
    private int voltagem;
    
    @Min(value = 0, message = "A frequência deve ser maior ou igual a zero")
    private int frequencia;
    
    // Getters e Setters
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getTipoCircuito() {
        return tipoCircuito;
    }

    public void setTipoCircuito(String tipoCircuito) {
        this.tipoCircuito = tipoCircuito;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
}