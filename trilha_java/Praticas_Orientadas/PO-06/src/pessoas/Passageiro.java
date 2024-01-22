package pessoas;

import java.io.Serializable;

public class Passageiro extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cartao;
	public Passageiro(String nome, String cpf, String cartao) {
		super(nome, cpf);
		this.cartao = cartao;
	}
	public String getCartao() {
		return cartao;
	}
	protected void setCartao(String cartao) {
		this.cartao = cartao;
	}
	@Override
    public String toString() {
        return "Passageiro [nome=" + getNome() + ", cpf=" + getCPF() + ", cartao=" + cartao + "]";
    }
}
