package com.tec.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UploadExcel {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codigo;

    @Column
    private String nombre;

    @Column
    private Integer promedio;

    @Column
    private String resultado;

    @Column
    private String carrera;

    @Column
    private String tipo;

    public UploadExcel(Long id, String codigo, String nombre, Integer promedio, String resultado, String carrera, String tipo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.resultado = resultado;
        this.carrera = carrera;
        this.tipo = tipo;
    }

    public UploadExcel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPromedio() {
        return promedio;
    }

    public void setPromedio(Integer promedio) {
        this.promedio = promedio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
