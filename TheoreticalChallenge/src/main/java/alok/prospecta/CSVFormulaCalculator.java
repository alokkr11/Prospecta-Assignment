package alok.prospecta;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CSVFormulaCalculator {
    private Map<String, String> map = new LinkedHashMap<>();

    // Read the CSV file
    public void readCSV(File file) throws IOException {
        String line;
        char c = 'A';
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");

                for (int i = 0; i < values.length; i++) {
                    String x = values[i].trim();
                    if (x.startsWith("=")) {
                        String exp = evaluateExpression(x.substring(1), map);
                        String eval = String.valueOf(evaluateFormula(exp));
                        map.put(c + "" + (i + 1), eval);
                    } else {
                        map.put(c + "" + (i + 1), x.trim());
                    }
                }
                c++;
            }
        }
        System.out.println(map);
    }

    // Evaluate the expression and put the values to the references
    private String evaluateExpression(String substring, Map<String, String> map) {

        String[] positions = substring.split("(?=[+\\-*/])|(?<=[+\\-*/])");

        StringBuilder sb = new StringBuilder();

        for (String s : positions) {
            if (map.containsKey(s)) {
                sb.append(map.get(s));
            } else {
                sb.append(s);
            }

        }
        return sb.toString();
    }

    // Evaluate the formula
    public static int evaluateFormula(String str) {
        if (str.contains("+")) {
            String[] arr = str.split("\\+"); // Escape "+" as it is a regex metacharacter
            return Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
        } else if (str.contains("-")) {
            String[] arr = str.split("-");
            return Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
        } else if (str.contains("*")) {
            String[] arr = str.split("\\*"); // Escape "*" as it is a regex metacharacter
            return Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
        } else if (str.contains("/")) {
            String[] arr = str.split("/");
            return Integer.parseInt(arr[0]) / Integer.parseInt(arr[1]);
        }
        return 0;
    }

    // Write the map to a CSV file
    public void writeCSV(File outputFile, Map<String, String> map) throws IOException {
        // Open the file for writing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Extract keys to determine the rows and columns (e.g., A1, B1)
            Set<String> keys = map.keySet();

            // Find the max row and column based on keys
            int maxRow = 0;
            int maxCol = 0;
            for (String key : keys) {
                char column = key.charAt(0); // A, B, C, etc.
                int row = Integer.parseInt(key.substring(1)); // 1, 2, 3, etc.
                maxRow = Math.max(maxRow, row);
                maxCol = Math.max(maxCol, column - 'A' + 1);
            }

            // Build the CSV row by row
            for (int row = 1; row <= maxRow; row++) {
                StringBuilder line = new StringBuilder();
                for (int col = 0; col < maxCol; col++) {
                    String cell = (char) ('A' + col) + "" + row; // Create cell reference (e.g., A1, B1)
                    line.append(map.getOrDefault(cell, "")); // Write value or empty string if missing
                    if (col < maxCol - 1) {
                        line.append(","); // Add a comma except after the last column
                    }
                }
                writer.write(line.toString());
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "input.csv";
        File inputFile = new File(inputFilePath);
        CSVFormulaCalculator csvReader = new CSVFormulaCalculator();
        try {
            csvReader.readCSV(inputFile);
            System.out.println("Reading and Evaluation done!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String outputFilePath = "output.csv";
        File outputFile = new File(outputFilePath);

        try {
            csvReader.writeCSV(outputFile, csvReader.map);
            System.out.println("Output is in output.csv file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
