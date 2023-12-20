package cliente;

public class Veiculo {
 private String marca;
 private String modelo;
 private int anoFabricacao;
 private int anoModelo;
 private float quilometragemAtual; 
 private float nivelCombustivel;
 private String chassi;
 private Pessoa proprietario;

 public Veiculo(String marca, String modelo, int anoFabricacao, int anoModelo, float quilometragemAtual, float nivelCombustivel, String chassi, Pessoa proprietario) {
     this.marca = marca;
     this.modelo = modelo;
     this.anoFabricacao = anoFabricacao;
     this.anoModelo = anoModelo;
     this.quilometragemAtual = quilometragemAtual;
     this.nivelCombustivel = nivelCombustivel;
     this.chassi = chassi;
     this.proprietario = proprietario;
 }

 public void associarProprietario(Pessoa proprietario) {
     this.proprietario = proprietario;
 }


 public String getMarca() {
     return marca;
 }

 public void setMarca(String marca) {
     this.marca = marca;
 }

 public String getModelo() {
     return modelo;
 }

 public void setModelo(String modelo) {
     this.modelo = modelo;
 }

 public int getAnoFabricacao() {
     return anoFabricacao;
 }

 public void setAnoFabricacao(int anoFabricacao) {
     this.anoFabricacao = anoFabricacao;
 }

 public int getAnoModelo() {
     return anoModelo;
 }

 public void setAnoModelo(int anoModelo) {
     this.anoModelo = anoModelo;
 }

 public float getQuilometragemAtual() {
     return quilometragemAtual;
 }

 public void setQuilometragemAtual(float quilometragemAtual) {
     this.quilometragemAtual = quilometragemAtual;
 }

 public float getNivelCombustivel() {
     return nivelCombustivel;
 }

 public void setNivelCombustivel(float nivelCombustivel) {
     this.nivelCombustivel = nivelCombustivel;
 }

 public String getChassi() {
     return chassi;
 }

 public void setChassi(String chassi) {
     this.chassi = chassi;
 }

 public Pessoa getProprietario() {
     return proprietario;
 }
public String toString() {
  return "Veículo: " +
          "Marca: " + marca +
          ", Modelo: " + modelo +
          ", Ano de Fabricação: " + anoFabricacao +
          ", Ano do Modelo: " + anoModelo +
          ", Quilometragem Atual: " + quilometragemAtual +
          ", Nível de Combustível: " + nivelCombustivel +
          ", Chassi: " + chassi +
          ", Proprietário: " + proprietario.getNome();
}

}
