package academico;

import javax.persistence.*;

@Entity
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String Nome;
	private String Email;
	private String Matricula;
	
	public Estudante() {}
	
	public Estudante(Integer Id, String Nome, String Email, String Matricula) {
		this.Id = null;
        this.Nome = Nome;
        this.Email = Email;
        this.Matricula = Matricula;
	}
	
	public int getId() {
        return Id;
    }
	
	public void setId(int Id) {
        this.Id = Id;
    }
	
	public String getNome() {
        return Nome;
    }
	
	public void setNome(String Nome) {
        this.Nome = Nome;
    }
	
	public String getEmail() {
        return Email;
    }
	
	public void setEmail(String Email) {
        this.Email = Email;
    }
	
	public String getMatricula() {
        return Matricula;
    }
	
	public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }
	
	@Override
    public String toString() {
        return "Estudante [Id=" + Id + ", Nome=" + Nome + ", Email=" + Email + ", Matricula=" + Matricula + "]";
    }
}
