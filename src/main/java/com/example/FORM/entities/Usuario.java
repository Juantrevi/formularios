package com.example.FORM.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Usuario {
    //IMPORTANTE: Los atributos tienen que ser identicos a los que ponemos en el name del HTML

    private String identificador;

    @NotEmpty//(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotEmpty//(message = "El apellido no puede estar vacio")
    private String apellido;

    @NotBlank//(message = "El usuario no puede estar vacio")
    @Size(min = 3, max = 8)//, message = "El tamaño debe estar entre 3 y 8 caracteres")
    private String username;

    @NotEmpty//(message = "La password no puede estar vacia")
    private String password;

    @NotEmpty//(message = "El email no puede estar vacio")
    @Email//(message = "El email no corresponde a un email valido")
    private String email;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy") //Si escogemos nosotros que nos pongan la fecha podemos poner /, pero si usamos el picker como abajo va con - y en ese formato
    private Date fechaDeNacimiento;

    @NotNull
    @Future(message = "Debe ser una fecha en el futuro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFutura;

    @NotNull
    @Past(message = "Debe ser una fecha en el pasado")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPasada;

    @NotEmpty
    private String pais;

    public Usuario() {
    }

    public Usuario(String identificador, String nombre, String apellido, String username, String password, String email, Date fechaDeNacimiento, Date fechaFutura, Date fechaPasada, String pais) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaFutura = fechaFutura;
        this.fechaPasada = fechaPasada;
        this.pais = pais;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Date getFechaFutura() {
        return fechaFutura;
    }

    public void setFechaFutura(Date fechaFutura) {
        this.fechaFutura = fechaFutura;
    }

    public Date getFechaPasada() {
        return fechaPasada;
    }

    public void setFechaPasada(Date fechaPasada) {
        this.fechaPasada = fechaPasada;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
