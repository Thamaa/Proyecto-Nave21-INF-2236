
import java.io.*;

public class CSVUtil {
    public static void appendToCSV(String fileName, String data) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(data);
            writer.append("\n");
        }
    }

    public static void createCSVIfNotExists(String fileName, String header) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.append(header);
                writer.append("\n");
            }
        }
    }
    public static boolean idExistsInCSV(String fileName, int id) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[0]) == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean rutExistsInCSV(String fileName, String rut) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[3].equals(rut)) {
                    return true;
                }
            }
        }
        return false;
    }
}