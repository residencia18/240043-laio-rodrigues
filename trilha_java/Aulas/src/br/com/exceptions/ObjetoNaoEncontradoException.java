package br.com.exceptions;

public class ObjetoNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoException(String message) {
        super(message);
    }
}
