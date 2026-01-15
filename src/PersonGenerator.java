import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> recs = new ArrayList();

        boolean newPerson = true;

        do {
            String ID;
            String firstName;
            String lastName;
            String title;
            int yob;

            ID = SafeInput.getNonZeroLenString(in, "Enter ID: ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter first name: ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter last name: ");
            title = SafeInput.getNonZeroLenString(in, "Enter title: ");
            yob = SafeInput.getInt(in, "Enter yob: ");

            String nextLine = String.format("%s, %s, %s, %s, %d", ID, firstName, lastName, title, yob);

            recs.add(nextLine);

            newPerson = SafeInput.getYNConfirm(in, "Add another person? (Y/N): ");
        } while(newPerson);

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