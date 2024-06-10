import java.io.*;
import java.util.ArrayList;

public class GerenciadorDeEntregas {
    private ArrayList<Entrega> entregas;
    private final String arquivoEntregas = "entregas.txt";

    public GerenciadorDeEntregas() {
        this.entregas = new ArrayList<>();
    }

    public void adicionarEntrega(Entrega entrega) throws Exception {
        if (entrega == null) {
            throw new Exception("Entrega inválida!");
        }
        entregas.add(entrega);
        salvarEntregas();
    }

    public void listarEntregas() {
        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada.");
        } else {
            for (Entrega entrega : entregas) {
                System.out.println(entrega);
            }
        }
    }

    public void salvarEntregas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoEntregas))) {
            for (Entrega entrega : entregas) {
                writer.write(entrega.getCodigoPedido() + ";" + entrega.getDestinatario() + ";" + entrega.getEndereco() + ";" + entrega.getDataEntrega());
                writer.newLine();
            }
            System.out.println("Entregas salvas com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar entregas: " + e.getMessage());
            Logger.registrarErro("Erro ao salvar entregas: " + e.getMessage());
        }
    }

    public void carregarEntregas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoEntregas))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    entregas.add(new Entrega(dados[0], dados[1], dados[2], dados[3]));
                }
            }
            System.out.println("Entregas carregadas com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de entregas não encontrado. Um novo arquivo será criado.");
            Logger.registrarErro("Arquivo de entregas não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao carregar entregas: " + e.getMessage());
            Logger.registrarErro("Erro ao carregar entregas: " + e.getMessage());
        }
    }
}
