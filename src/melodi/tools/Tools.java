package melodi.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

public class Tools {

	
	public static String getText(String fichier){
		String chaine="";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
//				System.out.println(ligne);
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	
//		//création ou ajout dans le fichier texte
//		try {
//			FileWriter fw = new FileWriter (fichier);
//			BufferedWriter bw = new BufferedWriter (fw);
//			PrintWriter fichierSortie = new PrintWriter (bw); 
//				fichierSortie.println (chaine+"\n test de lecture et écriture !!"); 
//			fichierSortie.close();
//			System.out.println("Le fichier " + fichier + " a été créé!"); 
//		}
//		catch (Exception e){
//			System.out.println(e.toString());
//		}		
		
		String sStraing = chaine.replaceAll("\n", "");
		return chaine;
	}
	
    public static int getRow(int pos, JTextComponent editor) {
        int rn = (pos==0) ? 1 : 0;
        try {
            int offs=pos;
            while( offs>0) {
                offs=Utilities.getRowStart(editor, offs)-1;
                rn++;
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return rn;
    }

    public static int getColumn(int pos, JTextComponent editor) {
        try {
            return pos-Utilities.getRowStart(editor, pos)+1;
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
