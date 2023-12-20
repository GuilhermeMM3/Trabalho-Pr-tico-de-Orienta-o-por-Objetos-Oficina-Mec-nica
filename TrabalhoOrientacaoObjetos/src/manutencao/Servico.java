package manutencao;

public class Servico extends Item {
 private int horasPrevistas;

 public Servico(String descricao, float precoUnitario, int codigo, int horasPrevistas) {
     super(descricao, precoUnitario, codigo);
     this.horasPrevistas = horasPrevistas;
 }

 public int getHorasPrevistas() {
     return horasPrevistas;
 }

 public void setHorasPrevistas(int horasPrevistas) {
     this.horasPrevistas = horasPrevistas;
 }
}
