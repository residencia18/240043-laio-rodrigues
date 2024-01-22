package quadrado;

public class Quadrado {
	private String estado;

	public String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Quadrado(String estado) {
		this.estado = estado;
	}
	
	public Quadrado() {
		this.estado = "XXXXXXXXX";
	}
	
	public void clique(int posicao) throws Exception {
		if(posicao < 1 || posicao > 9) throw new Exception("A posição deve ser entre 1 e 9");
		if(posicao == 1 || posicao == 2 || posicao == 4)
			inverte(0);
		if(posicao < 4 || posicao == 5)
			inverte(1);
		if(posicao == 2 || posicao == 3 || posicao == 6)
			inverte(2);
		if(posicao == 1 || posicao == 4 || posicao == 5 || posicao == 7)
			inverte(3);
		if(posicao == 5)
			inverte(4);
		if(posicao == 3 || posicao == 5 || posicao == 6 || posicao == 9)
			inverte(5);
		if(posicao == 4 || posicao == 7 || posicao == 8)
			inverte(6);
		if(posicao == 5 || posicao > 6)
			inverte(7);
		if(posicao == 6 || posicao > 7)
			inverte(8);
	}
	
	protected void inverte(int posicao) {
		StringBuilder str = new StringBuilder(estado);
		char c = estado.charAt(posicao) == 'X' ? 'O' : 'X';
		str.setCharAt(posicao, c);
		estado = str.toString();
	}
}
