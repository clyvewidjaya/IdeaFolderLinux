import java.io.*;

/**
 * Created by clyve on 09/02/17.
 */
public class FindAverage {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java FindAverage <inputFile> <columnName>");
            System.exit(0);

        }
        File inputFile = new File(args[0]);
        String desiredColumnName = args[1].trim();

        if(!inputFile.exists()){
            System.err.println("Could not find file: " + inputFile);
            System.exit(0);
        }

        try{
            FileReader reader = new FileReader(inputFile);
            BufferedReader in = new BufferedReader(reader);

            //read the header line
            String headerLine = in.readLine();
            String[] columnNames = headerLine.split(",");
            int columnIndex = 0;
            for (int i = 0; i < columnNames.length; i++){
                if (columnNames[i].equals(desiredColumnName)){
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex < 0){
                System.err.println("No such colum name: " + desiredColumn);
                System.exit(0);
            }

            float total = 0f;
            int count = 0;
            String line;
            while((line = in.readLine()) != null){
                if(line.trim().length() != 0){
                    String[] dataFields = line.split(",");
                    float nextValue = Float.parseFloat(dataFields[columnIndex]);
                    total += nextValue;
                    count++;
                }
            }

            System.out.printf("The average for column %s is %.2f");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
