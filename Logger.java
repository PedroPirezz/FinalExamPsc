import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String arquivoLog = "erros.txt";

    
    public static void registrarErro(String mensagemErro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoLog, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(timestamp + " - " + mensagemErro);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao registrar no log: " + e.getMessage());
        }
    }
}
