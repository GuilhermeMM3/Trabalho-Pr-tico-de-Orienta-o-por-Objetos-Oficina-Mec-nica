package menu;

import javax.swing.JOptionPane;
import java.util.Date;
import cliente.Pessoa;
import cliente.Veiculo;
import manutencao.Peca;
import manutencao.Servico;
import manutencao.OrdemDeServico;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static List<Pessoa> pessoas = new ArrayList<>();
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Peca> pecas = new ArrayList<>();
    private static List<Servico> servicos = new ArrayList<>();
    private static List<OrdemDeServico> ordensDeServico = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
        	int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n"
        	        + "1. Criar Pessoa\n"
        	        + "2. Criar Veículo (usar Pessoa existente)\n"
        	        + "3. Criar Peça\n"
        	        + "4. Criar Serviço\n"
        	        + "5. Criar Ordem de Serviço (usar Veículo existente e adicionar Peças ou Serviços)\n"
        	        + "6. Imprimir Informações de uma Ordem de Serviço\n"
        	        + "7. Mostrar Veículos\n"
        	        + "8. Mostrar Peças\n"
        	        + "9. Mostrar Serviços\n"
        	        + "10. Sair"));

            switch (escolha) {
                case 1:
                    Pessoa pessoa = criarPessoa();
                    pessoas.add(pessoa);
                    break;
                case 2:
                    if (pessoas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Crie uma Pessoa antes de criar um Veículo.");
                        break;
                    }
                    Veiculo veiculo = criarVeiculo();
                    veiculos.add(veiculo);
                    break;
                case 3:
                    Peca peca = criarPeca();
                    pecas.add(peca);
                    break;
                case 4:
                    Servico servico = criarServico();
                    servicos.add(servico);
                    break;
                case 5:
                    if (veiculos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Crie um Veículo antes de criar uma Ordem de Serviço.");
                        break;
                    }
                    Veiculo veiculoOrdemServico = escolherVeiculo();
                    if (veiculoOrdemServico != null) {
                        OrdemDeServico ordemDeServico = criarOrdemDeServico(veiculoOrdemServico);

                        int opcaoItem;
                        do {
                            opcaoItem = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de item:\n"
                                    + "1. Adicionar Peça\n"
                                    + "2. Adicionar Serviço\n"
                                    + "3. Concluir"));

                            switch (opcaoItem) {
                                case 1:
                                    Peca pecaSelecionada = escolherPeca();
                                    if (pecaSelecionada != null) {
                                        ordemDeServico.adicionarItem(pecaSelecionada);
                                    }
                                    break;
                                case 2:
                                    Servico servicoSelecionado = escolherServico();
                                    if (servicoSelecionado != null) {
                                        ordemDeServico.adicionarItem(servicoSelecionado);
                                    }
                                    break;
                                case 3:
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                            }
                        } while (opcaoItem != 3);

                        ordensDeServico.add(ordemDeServico);
                    }
                    break;
                case 6:
                    imprimirOrdemDeServico();
                    break;
                case 7:
                	mostrarVeiculos();
                    break;
                case 8:
                	mostrarPecas();
                    break;
                case 9:
                	mostrarServicos();
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }

    private static Pessoa criarPessoa() {
        String nome = JOptionPane.showInputDialog("Digite o nome da Pessoa:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF da Pessoa:");

        return new Pessoa(nome, cpf);
    }

    private static Veiculo criarVeiculo() {
        String marca = JOptionPane.showInputDialog("Digite a marca do Veículo:");
        String modelo = JOptionPane.showInputDialog("Digite o modelo do Veículo:");
        int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricação do Veículo:"));
        int anoModelo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do modelo do Veículo:"));
        float quilometragemAtual = Float.parseFloat(JOptionPane.showInputDialog("Digite a quilometragem atual do Veículo:"));
        float nivelCombustivel = Float.parseFloat(JOptionPane.showInputDialog("Digite o nível de combustível do Veículo:"));
        String chassi = JOptionPane.showInputDialog("Digite o chassi do Veículo:");
   
        Pessoa proprietario = escolherPessoa();

        return new Veiculo(marca, modelo, anoFabricacao, anoModelo, quilometragemAtual, nivelCombustivel, chassi, proprietario);
    }

    private static Peca criarPeca() {
        String descricao = JOptionPane.showInputDialog("Digite a descrição da Peça:");
        float precoUnitario = Float.parseFloat(JOptionPane.showInputDialog("Digite o preço unitário da Peça:"));
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da Peça:"));
        String marca = JOptionPane.showInputDialog("Digite a marca da Peça:");
        String unidade = JOptionPane.showInputDialog("Digite a unidade da Peça:");

        return new Peca(descricao, precoUnitario, codigo, marca, unidade);
    }

    private static Servico criarServico() {
        String descricao = JOptionPane.showInputDialog("Digite a descrição do Serviço:");
        float precoUnitario = Float.parseFloat(JOptionPane.showInputDialog("Digite o preço unitário do Serviço:"));
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do Serviço:"));
        int horasPrevistas = Integer.parseInt(JOptionPane.showInputDialog("Digite as horas previstas do Serviço:"));

        return new Servico(descricao, precoUnitario, codigo, horasPrevistas);
    }

    private static Veiculo escolherVeiculo() {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Veículo cadastrado.");
            return null;
        }

        StringBuilder mensagem = new StringBuilder("Escolha um Veículo:\n");

        for (int i = 0; i < veiculos.size(); i++) {
            mensagem.append(i + 1).append(". ").append(veiculos.get(i).getMarca()).append(" ").append(veiculos.get(i).getModelo()).append("\n");
        }

        int escolha = Integer.parseInt(JOptionPane.showInputDialog(mensagem.toString())) - 1;

        if (escolha >= 0 && escolha < veiculos.size()) {
            return veiculos.get(escolha);
        } else {
            JOptionPane.showMessageDialog(null, "Escolha inválida.");
            return null;
        }
    }

    private static Pessoa escolherPessoa() {
        if (pessoas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma Pessoa cadastrada.");
            return null;
        }

        StringBuilder mensagem = new StringBuilder("Escolha uma Pessoa:\n");

        for (int i = 0; i < pessoas.size(); i++) {
            mensagem.append(i + 1).append(". ").append(pessoas.get(i).getNome()).append("\n");
        }

        int escolha = Integer.parseInt(JOptionPane.showInputDialog(mensagem.toString())) - 1;

        if (escolha >= 0 && escolha < pessoas.size()) {
            return pessoas.get(escolha);
        } else {
            JOptionPane.showMessageDialog(null, "Escolha inválida.");
            return null;
        }
    }

    private static Peca escolherPeca() {
        if (pecas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma Peça cadastrada.");
            return null;
        }

        StringBuilder mensagem = new StringBuilder("Escolha uma Peça:\n");

        for (int i = 0; i < pecas.size(); i++) {
            mensagem.append(i + 1).append(". ").append(pecas.get(i).getDescricao()).append("\n");
        }

        int escolha = Integer.parseInt(JOptionPane.showInputDialog(mensagem.toString())) - 1;

        if (escolha >= 0 && escolha < pecas.size()) {
            return pecas.get(escolha);
        } else {
            JOptionPane.showMessageDialog(null, "Escolha inválida.");
            return null;
        }
    }

    private static Servico escolherServico() {
        if (servicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Serviço cadastrado.");
            return null;
        }

        StringBuilder mensagem = new StringBuilder("Escolha um Serviço:\n");

        for (int i = 0; i < servicos.size(); i++) {
            mensagem.append(i + 1).append(". ").append(servicos.get(i).getDescricao()).append("\n");
        }

        int escolha = Integer.parseInt(JOptionPane.showInputDialog(mensagem.toString())) - 1;

        if (escolha >= 0 && escolha < servicos.size()) {
            return servicos.get(escolha);
        } else {
            JOptionPane.showMessageDialog(null, "Escolha inválida.");
            return null;
        }
    }

    private static OrdemDeServico criarOrdemDeServico(Veiculo veiculo) {
        Pessoa proprietario = veiculo.getProprietario();
        Date dataManutencao = new Date();
        String mecanicoResponsavel = JOptionPane.showInputDialog("Digite o nome do mecânico responsável:");

        return new OrdemDeServico(veiculo, proprietario, dataManutencao, mecanicoResponsavel);
    }

    private static void imprimirOrdemDeServico() {
        if (ordensDeServico.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma Ordem de Serviço cadastrada.");
            return;
        }

        StringBuilder mensagem = new StringBuilder("Escolha uma Ordem de Serviço:\n");
        for (int i = 0; i < ordensDeServico.size(); i++) {
            mensagem.append(i + 1).append(". ");
            mensagem.append("Veículo: ").append(ordensDeServico.get(i).getChassi());
            mensagem.append(" | Proprietário: ").append(ordensDeServico.get(i).getCpfProprietario());
            mensagem.append(" | Mecânico: ").append(ordensDeServico.get(i).getMecanicoResponsavel()).append("\n");
        }

        int escolha = Integer.parseInt(JOptionPane.showInputDialog(mensagem.toString())) - 1;

        if (escolha >= 0 && escolha < ordensDeServico.size()) {
            ordensDeServico.get(escolha).exibirInformacoes();
        } else {
            JOptionPane.showMessageDialog(null, "Escolha inválida.");
        }
    }
    private static void mostrarVeiculos() {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Veículo cadastrado.");
            return;
        }

        StringBuilder mensagem = new StringBuilder("Veículos cadastrados:\n");

        for (Veiculo veiculo : veiculos) {
            mensagem.append(veiculo.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    private static void mostrarPecas() {
        if (pecas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma Peça cadastrada.");
            return;
        }

        StringBuilder mensagem = new StringBuilder("Peças cadastradas:\n");

        for (Peca peca : pecas) {
            mensagem.append(peca.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    private static void mostrarServicos() {
        if (servicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Serviço cadastrado.");
            return;
        }

        StringBuilder mensagem = new StringBuilder("Serviços cadastrados:\n");

        for (Servico servico : servicos) {
            mensagem.append(servico.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    
}

