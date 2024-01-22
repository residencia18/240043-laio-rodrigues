package pessoas;

public class Passageiro extends Pessoa {
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
