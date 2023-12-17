package br.com.exceptions;

public class DivisaoPorZeroException extends Exception {
	private static final long serialVersionUID = 1L;

	public DivisaoPorZeroException(String mensagem) {
		super(mensagem);
	}
}
