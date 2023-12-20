package manutencao;

public class Item {
 private String descricao;
 private float precoUnitario;
 private int codigo;

 public Item(String descricao, float precoUnitario, int codigo) {
     this.descricao = descricao;
     this.precoUnitario = precoUnitario;
     this.codigo = codigo;
 }

 public String getDescricao() {
     return descricao;
 }

 public void setDescricao(String descricao) {
     this.descricao = descricao;
 }

 public float getPrecoUnitario() {
     return precoUnitario;
 }

 public void setPrecoUnitario(float precoUnitario) {
     this.precoUnitario = precoUnitario;
 }

 public int getCodigo() {
     return codigo;
 }

 public void setCodigo(int codigo) {
     this.codigo = codigo;
 }
}
