package manutencao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import cliente.Pessoa;
import cliente.Veiculo;

public class OrdemDeServico {
    private Veiculo veiculo;
    private Pessoa proprietario;
    private String chassi; 
    private String cpfProprietario; 
    private Date dataManutencao;
    private String mecanicoResponsavel;
    private List<Item> itens;
    private float custoTotal;
    
    public OrdemDeServico(Veiculo veiculo, Pessoa proprietario, Date dataManutencao, String mecanicoResponsavel) {
        this.veiculo = veiculo;
        this.proprietario = proprietario;
        this.chassi = veiculo.getChassi(); 
        this.cpfProprietario = proprietario.getCpf(); 
        this.dataManutencao = dataManutencao;
        this.mecanicoResponsavel = mecanicoResponsavel;
        this.itens = new ArrayList<>();
        this.custoTotal = 0.0f;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        custoTotal += item.getPrecoUnitario();
    }

    public float calcularCustoTotal() {
        return custoTotal;
    }

    public void exibirInformacoes() {
        StringBuilder mensagem = new StringBuilder("Ordem de Serviço:\n");
        mensagem.append("Chassi do Veículo: ").append(veiculo.getChassi()).append("\n");
        mensagem.append("CPF do Proprietário: ").append(proprietario.getCpf()).append("\n");
        mensagem.append("Data da Manutenção: ").append(dataManutencao).append("\n");
        mensagem.append("Mecânico Responsável: ").append(mecanicoResponsavel).append("\n");
        mensagem.append("Itens da Ordem de Serviço:\n");

        for (Item item : itens) {
            mensagem.append("- ").append(item.getDescricao()).append(" | Preço Unitário: ").append(item.getPrecoUnitario()).append("\n");
        }

        mensagem.append("Custo Total: ").append(custoTotal).append("\n");

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

	public Object getChassi() {
		return chassi;
	}

	public Object getCpfProprietario() {
		return cpfProprietario;
	}

	public Object getMecanicoResponsavel() {
		return mecanicoResponsavel;
	}
}

