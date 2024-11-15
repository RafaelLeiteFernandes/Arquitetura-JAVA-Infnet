package br.edu.infnet.RafaelLeiteFernandes.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TMecanico")
public class ComponenteMecanico extends Componente {
    
    @NotBlank(message = "O material não pode estar em branco")
    private String material;
    
    @Min(value = 0, message = "O peso deve ser maior ou igual a zero")
    private double peso;
    
    @Min(value = 0, message = "A resistência deve ser maior ou igual a zero")
    private double resistencia;
    
    @NotBlank(message = "O processo de fabricação não pode estar em branco")
    private String processoFabricacao;
    
    // Getters e Setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public String getProcessoFabricacao() {
        return processoFabricacao;
    }

    public void setProcessoFabricacao(String processoFabricacao) {
        this.processoFabricacao = processoFabricacao;
    }
}