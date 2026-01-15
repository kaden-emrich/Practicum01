import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> recs = new ArrayList();

        boolean newProduct = true;

        do {
            String ID;
            String name;
            String description;
            double cost;

            ID = SafeInput.getNonZeroLenString(in, "Enter ID: ");
            name = SafeInput.getNonZeroLenString(in, "Enter product name: ");
            description = SafeInput.getNonZeroLenString(in, "Enter description: ");
            cost = SafeInput.getDouble(in, "Enter cost: ");

            String nextLine = String.format("%s, %s, %s, %f", ID, name, description, cost);

            recs.add(nextLine);

            newProduct = SafeInput.getYNConfirm(in, "Add another product? (Y/N): ");
        } while(newProduct);

        String filename = SafeInput.getNonZeroLenString(in, "Enter file name: ");

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(Path.of(filename)));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : recs) {
                writer.write(rec, 0, rec.length());
                writer.newLine();
//                System.out.println(rec);
            }

            writer.close();
            System.out.println("Data written to: " + filename);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}