package CipherPrueba;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import Cod_Descod.Descodificar;  //Otro archivo
import Cod_Descod.Codificar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CipherFrame extends JFrame{
    
  public static void main(String[] args) {
     CipherFrame cipherFrame = new CipherFrame();// Creamos una ventana
        //Le damos tamaño
       cipherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //La hacemos visible
       cipherFrame.setSize(600,900);
        //Y el comportamiento de cierre
       cipherFrame.setVisible(true);   
    }  
  
    private final JTextArea TextArea1;
    private final JButton BotonEncriptar;
    private final JButton BtnGuardartxt;
    private final JButton BtnGuardarvge;
    private final JButton BotonDesencriptar;
    private final JTextArea TextArea2;
//    private Controlador gestor;
    private FileNameExtensionFilter filter;
    
    public CipherFrame(){
        super("Cipher Prueba");
        
        setLayout(new FlowLayout());
        TextArea1 = new JTextArea(10, 15);
        add(TextArea1);
        
        BotonEncriptar = new JButton("Encriptar");
        add(BotonEncriptar);
        
        BotonDesencriptar = new JButton("Desencriptar");
        add(BotonDesencriptar);
        
        TextArea2 = new JTextArea(10, 15);
        add(TextArea2);
        
        BtnGuardartxt = new JButton("Guardar en TXT");
//      BotonGuardarTxt.setBounds(100,100,50,50);
        add(BtnGuardartxt);
        
        BtnGuardarvge = new JButton("Guardar en VGE");
//      BotonGuardarTxt.setBounds(100,100,50,50);
        add(BtnGuardarvge);
        
        
        BotonEncriptar.addActionListener(new HandlerEncriptar());
        BotonDesencriptar.addActionListener(new HandlerDesencriptar());
        BtnGuardartxt.addActionListener(new HandlerGuardar());
        BtnGuardarvge.addActionListener(new HandlerGuardarvge());
    }
    
    private class HandlerEncriptar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            String str = "", temp = "", temp2 = "";
            str = TextArea1.getText();
            String[] parte = str.split("\n");
            for (int i = 0; i < parte.length; i++) {
                temp2 = Codificar.inicio(parte[i]);
                temp = temp + "\n" + temp2;
            }
            temp = String.format("%s", temp);
            TextArea2.setText(temp);
            
        }
       
    }
    private class HandlerDesencriptar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            String str = "", temporal = "", temporal2 = "";
            str = TextArea1.getText();
            String[] parte = str.split("\n");
            for (int i = 0; i < parte.length; i++) {
                temporal2 = Descodificar.paso2(parte[i]);
                temporal = temporal + "\n" + temporal2;
            }
            temporal = String.format("%s", temporal);
            TextArea2.setText(temporal);
            
            try {
                String contenido = temporal;
                String Directorio = System.getProperty("user.dir");
                System.out.println(Directorio);
                File file = new File(Directorio);
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
  private class HandlerGuardar implements ActionListener{
       File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
  @Override
   public void actionPerformed(ActionEvent event) {
        try {
             String Directorio = System.getProperty("user.dir");
                System.out.println(Directorio);
                File file = new File(Directorio);
                archivo = new File(Directorio);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String guardar = "";
                String linea;
                while ((linea = br.readLine()) != null) {
                    guardar += " " + linea;
                }
                JOptionPane.showMessageDialog(null, guardar);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // En el finally cerramos el fichero, para asegurarnos
                // que se cierra tanto si todo va bien como si salta 
                // una excepcion.
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
   }

		
  }   
  private class HandlerGuardarvge implements ActionListener{
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
  @Override
   public void actionPerformed(ActionEvent event) {
   try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                archivo = new File("C:\\Users\\Marco\\OneDrive\\Documentos\\NetBeansProjects\\Tarea1Levy_ConriquezMarco\\Tarea1\\src\\DocumentosTxtyVeg\\Textovge.vge");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String guardar = "";
                String linea;
                while ((linea = br.readLine()) != null) {
                    guardar += " " + linea;
                }
                JOptionPane.showMessageDialog(null, guardar);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
   
   }		
  } 
}
