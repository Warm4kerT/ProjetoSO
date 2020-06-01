package app;
import java.io.*;
import java.util.*;


public class fileRW {
    public static int sTi(final String s) {
        try {
            return Integer.parseInt(s);
        } catch (final NumberFormatException e) {
            return 0;
        }
    }

    public static ArrayList<Memory> readMem(final String path) {
        final ArrayList<Memory> mList = new ArrayList<>();

        try {
            final BufferedReader buff = new BufferedReader(new FileReader(path));
            String line;
            while ((line = buff.readLine()) != null) {
                if (!line.equals("\n") && !line.equals(" ") && line.contains(" ")) {
                    String[] parts=line.split(" ");
                    String[] imp={parts[0], parts[1], ""};
                    if (sTi(imp[1])==0){
                        imp[2] = parts[1];
                        imp[1] = "0";
                    }
                    Memory aux=new Memory(imp[0], sTi(imp[1]), imp[2]);    
                    mList.add(aux);
                }
            }
            if (buff != null) {
                buff.close();
            }

            if (!mList.isEmpty()) {
                return mList;
            } else {
                return null;
            }

        } catch (final IOException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    public static ArrayList<PCB> readPCB(final String path) {
        final ArrayList<PCB> pList = new ArrayList<>();

        try {
            final BufferedReader buff = new BufferedReader(new FileReader(path));
            String line;
            while ((line = buff.readLine()) != null) {
                if (!line.equals("\n") && !line.equals(" ")) {
                    if (line.contains(" ")) {
                        final String[] parts = line.split(" ");
                        final PCB aux = new PCB();
                        aux.setNome(parts[0]);
                        aux.setArrivalTime(sTi(parts[1]));
                        aux.setPC(pList.size()-1);
                        pList.add(aux);
                    }
                }
            }
            if (buff != null) {
                buff.close();
            }

            if (!pList.isEmpty()) {
                return pList;
            } else {
                return null;
            }

        } catch (final IOException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    public static void writeF(final String path, final ArrayList<?> lista) {
        final File fl = new File("output/" + path + ".txt");
        BufferedWriter writer;
        try {
            if ((fl.exists()) == false) {
                fl.createNewFile();
            }

            for (final Object aux : lista) {
                writer = new BufferedWriter(new FileWriter("output/" + path + ".txt"));
                writer.append(aux.toString() + "\r\n");
                writer.flush();
            }

        } catch (final IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printList(final ArrayList<?> list) {
        for (final Object aux : list) {
            System.out.println(aux.toString());
        }
    }
}