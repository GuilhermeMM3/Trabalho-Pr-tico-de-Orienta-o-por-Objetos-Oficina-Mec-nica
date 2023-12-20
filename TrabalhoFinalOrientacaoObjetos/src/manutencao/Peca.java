package manutencao;

public class Peca extends Item {
 private String marca;
 private String unidade;

 public Peca(String descricao, float precoUnitario, int codigo, String marca, String unidade) {
     super(descricao, precoUnitario, codigo);
     this.marca = marca;
     this.unidade = unidade;
 }

 public String getMarca() {
     return marca;
 }

 public void setMarca(String marca) {
     this.marca = marca;
 }

 public String getUnidade() {
     return unidade;
 }

 public void setUnidade(String unidade) {
     this.unidade = unidade;
 }
 public String toString() {
	    return "Peca{" +
	            "descricao='" + getDescricao() + '\'' +
	            ", precoUnitario=" + getPrecoUnitario() +
	            ", codigo=" + getCodigo() +
	            ", marca='" + marca + '\'' +
	            ", unidade='" + unidade + '\'' +
	            '}';
	}
}
