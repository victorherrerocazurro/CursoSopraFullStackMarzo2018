package com.curso.modelo.entidad;

public class DatosBancarios {
	
	private String banco;
	private String numeroCuenta;

	@Override
	public String toString() {
		return "DatosBancarios [banco=" + banco + ", numeroCuenta=" + numeroCuenta + "]";
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public DatosBancarios(String banco, String numeroCuenta) {
		super();
		this.banco = banco;
		this.numeroCuenta = numeroCuenta;
	}

	public DatosBancarios() {
		super();
	}


}
