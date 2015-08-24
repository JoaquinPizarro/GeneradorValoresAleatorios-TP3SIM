/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.simulacion;
import Generador.Generador;
import javax.swing.*;
import java.math.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juaco
 */
public class Inicio extends javax.swing.JFrame {

    
    private Generador generador;
    private String botonSeleccionado;
    private DefaultTableModel model;
   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    public Inicio() {
     //no se muestra ninguno de los paneles para ingreso de parametros.Se muestran recien cuando se selecciona una distribucion.
        initComponents();
        setVisible(true);
        cargarInterfazTabla();
        
        this.jPanel_Param_Exp.setVisible(false);
        this.jPanel_Param_Exp.setSize(872, 66);
        this.jPanel_Param_Unif.setVisible(false);
        this.jPanel_Param_Unif.setSize(872, 66);
        this.jPanel_Param_Normal.setVisible(false);
        this.jPanel_Param_Normal.setSize(872, 66);
        this.jPanel_Param_Poisson.setVisible(false);
        this.jPanel_Param_Poisson.setSize(872, 66);
    
    }
    public void cargarInterfazTabla()
    {
        String data[][]= {};
        String col[]= {"n","Valores Generados"};
        model= new DefaultTableModel(data,col);
        
        this.jTable1.setModel(model);
        
    
    }
    public void generarValoresDistUniforme(int paramA, int paramB, int cantVal)
    {
        //genero valores para una distribucion uniforme.
        
        double random=Math.random();
        double nuevoRandom ;
        int a = paramA;
        int b= paramB;
        int n;
          
        
        for (int i = 0; i < cantVal; i++) {
            
            n= i+1;
            model.insertRow(i, new Object[]{});
            model.setValueAt(n, i, 0);
            nuevoRandom= a + random*(b-a);
            model.setValueAt(nuevoRandom, i, 1);
            random= Math.random();
            
        }
        
    }
    public void generarValoresDistNormal(int media, int varianza, int cantVal)
    {
        double random1= Math.random();
        double random2= Math.random();
        double z;
        double nuevoRandom;
        int n;
        
        for (int i = 0; i < cantVal ; i++) {
            n=i+1;
            model.insertRow(i, new Object[]{});
            model.setValueAt(n, i, 0);
            z=  Math.sqrt((-2)*Math.log(random1))*Math.cos((2*Math.PI)*random2);
            nuevoRandom= media+(varianza*z);
            model.setValueAt(nuevoRandom, i, 1);
            random1=Math.random();
            random2=Math.random();
                   
            }
     }
    public void generarValoresDistExp(int lambda, int cantVal)
    {
        double random1= Math.random();
        double nuevoRandom;
        int n;
        
        for (int i = 0; i < cantVal; i++) {
            
            n=i+1;
            model.insertRow(i, new Object[]{});
            model.setValueAt(n, i, 0);
//            nuevoRandom= ((-1)/lambda)*(Math.log((1-random1)));
            nuevoRandom= (-1)*Math.log(1-random1)/lambda;
            model.setValueAt(nuevoRandom, i, 1);
            random1= Math.random();
           
        }
    }
    public void generarValoresDistPoisson(int lambda, int cantVal)
    {
        int n=0;
        double a = Math.pow(Math.E, -(lambda));
        double b=1;
        double i=0;
        double ran= Math.random();
        
        for (int j = 0; j < cantVal; j++) {
            n=j+1;
            model.insertRow(j, new Object[]{});
            model.setValueAt(n, j, 0);
            //Generacion del numero aleatorio
            while(b>=a)//mientras b sea mayor o igual a e^-lambda
            {
            i++;//aumento en 1 el numero
            b*=ran; // a b lo lo multiplico por un random
            }
            model.setValueAt(i, j, 1);
            b=1;
            i=0;
            ran= Math.random();
        }
        
        
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Uniforme = new javax.swing.JButton();
        btn_Exponencial = new javax.swing.JButton();
        btn_Poisson = new javax.swing.JButton();
        btn_Normal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_generar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Grafico = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel_Param_Unif = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_a = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_b = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_cantVal_Unif = new javax.swing.JTextField();
        jPanel_Param_Exp = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_lambda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cantVal_Exp = new javax.swing.JTextField();
        jPanel_Param_Normal = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_media_DistNorm = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_varianza_DistNorm = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_cantVal_Norm = new javax.swing.JTextField();
        jPanel_Param_Poisson = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt_lambda_DistPoisson = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_cantVal_DistPoisson = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_cantIntervalos = new javax.swing.JTextField();
        btn_graficar = new javax.swing.JButton();

        setBounds(new java.awt.Rectangle(400, 400, 500, 500));
        setMinimumSize(new java.awt.Dimension(1200, 600));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel1.setText("TP3 - Variables Aleatorias");

        jLabel2.setText("Seleccione la distribucion:");

        btn_Uniforme.setText("Uniforme");
        btn_Uniforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UniformeActionPerformed(evt);
            }
        });

        btn_Exponencial.setText("Exponencial");
        btn_Exponencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExponencialActionPerformed(evt);
            }
        });

        btn_Poisson.setText("Poisson");
        btn_Poisson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PoissonActionPerformed(evt);
            }
        });

        btn_Normal.setText("Normal");
        btn_Normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NormalActionPerformed(evt);
            }
        });

        jLabel5.setText("Ingrese valores de Parametros:");

        btn_generar.setText("Generar");
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "n", "Variables Generadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setText("Valores Generados:");

        jLabel13.setText("Grafica de la Distribucion:");
        jLabel13.setToolTipText("");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout GraficoLayout = new javax.swing.GroupLayout(Grafico);
        Grafico.setLayout(GraficoLayout);
        GraficoLayout.setHorizontalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        GraficoLayout.setVerticalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(Grafico, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLayeredPane2.setDoubleBuffered(true);

        jPanel_Param_Unif.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("a :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 0, 0);
        jPanel_Param_Unif.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel_Param_Unif.add(txt_a, gridBagConstraints);

        jLabel4.setText("b :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 31, 0, 0);
        jPanel_Param_Unif.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel_Param_Unif.add(txt_b, gridBagConstraints);

        jLabel10.setText("Cantidad de Valores a Generar:");
        jPanel_Param_Unif.add(jLabel10, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel_Param_Unif.add(txt_cantVal_Unif, gridBagConstraints);

        jPanel_Param_Exp.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Lambda: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel_Param_Exp.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 13, 0);
        jPanel_Param_Exp.add(txt_lambda, gridBagConstraints);

        jLabel9.setText("Cantidad de Valores a Generar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel_Param_Exp.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 13, 37);
        jPanel_Param_Exp.add(txt_cantVal_Exp, gridBagConstraints);

        jPanel_Param_Normal.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel_Param_Normal.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Media: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel_Param_Normal.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel_Param_Normal.add(txt_media_DistNorm, gridBagConstraints);

        jLabel8.setText("Varianza: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel_Param_Normal.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        jPanel_Param_Normal.add(txt_varianza_DistNorm, gridBagConstraints);

        jLabel11.setText("Cantidad de Valores a Generar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 54, 0, 0);
        jPanel_Param_Normal.add(jLabel11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel_Param_Normal.add(txt_cantVal_Norm, gridBagConstraints);

        jPanel_Param_Poisson.setMinimumSize(new java.awt.Dimension(700, 27));
        jPanel_Param_Poisson.setPreferredSize(new java.awt.Dimension(670, 22));
        jPanel_Param_Poisson.setLayout(new java.awt.GridBagLayout());

        jLabel15.setText("Lambda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        jPanel_Param_Poisson.add(jLabel15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        jPanel_Param_Poisson.add(txt_lambda_DistPoisson, gridBagConstraints);

        jLabel16.setText("Cantidad de Valores a Generar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 18, 0, 0);
        jPanel_Param_Poisson.add(jLabel16, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 359);
        jPanel_Param_Poisson.add(txt_cantVal_DistPoisson, gridBagConstraints);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Param_Normal, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Param_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel_Param_Unif, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(195, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel_Param_Poisson, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Param_Normal, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jPanel_Param_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE)
                    .addGap(0, 6, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Param_Unif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(jPanel_Param_Poisson, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addGap(4, 4, 4)))
        );
        jLayeredPane2.setLayer(jPanel_Param_Unif, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jPanel_Param_Exp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jPanel_Param_Normal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jPanel_Param_Poisson, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setText("Cantidad Intervalos:");

        btn_graficar.setText("Graficar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btn_Uniforme, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Exponencial)
                            .addComponent(btn_Poisson, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Normal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cantIntervalos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(btn_graficar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_generar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(170, 170, 170)
                                .addComponent(jLabel13)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Uniforme, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Exponencial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Poisson, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Normal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_generar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txt_cantIntervalos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_graficar))
                                .addGap(11, 11, 11)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(450, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_UniformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UniformeActionPerformed
        botonSeleccionado="U";
        this.jLayeredPane2.setPosition(this.jPanel_Param_Unif, 5);
        this.jPanel_Param_Unif.setVisible(true);
//        
        this.jPanel_Param_Exp.setVisible(false);
        this.jPanel_Param_Poisson.setVisible(false);
        this.jPanel_Param_Normal.setVisible(false);
        
    
    }//GEN-LAST:event_btn_UniformeActionPerformed

    private void btn_ExponencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExponencialActionPerformed
        botonSeleccionado="E";
        this.jLayeredPane2.setPosition(this.jPanel_Param_Exp, 5);
        this.jPanel_Param_Exp.setVisible(true);
        this.jPanel_Param_Unif.setVisible(false);

        this.jPanel_Param_Poisson.setVisible(false);
        this.jPanel_Param_Normal.setVisible(false);
        
    }//GEN-LAST:event_btn_ExponencialActionPerformed

    private void btn_NormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NormalActionPerformed
        botonSeleccionado="N";
        this.jLayeredPane2.setPosition(this.jPanel_Param_Normal, 5);
        this.jPanel_Param_Normal.setVisible(true);
        this.jPanel_Param_Unif.setVisible(false);
        this.jPanel_Param_Exp.setVisible(false);
        this.jPanel_Param_Poisson.setVisible(false);
//       
//        
        
    }//GEN-LAST:event_btn_NormalActionPerformed

    private void Clear_Table(){
       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
           model.removeRow(i);
           i-=1;
       }}
   
    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
       // Aca se generan los datos de la tabla y tambien el grafico 
        
        
        this.Clear_Table();
        switch (botonSeleccionado) {
            case "U": 
                        if(this.txt_a.getText().isEmpty()||this.txt_b.getText().isEmpty()||this.txt_cantVal_Unif.getText().isEmpty())
                        {
                        JOptionPane.showMessageDialog(this, "Falta ingresar valor (a ,b,cantidad Valores)", "Error",JOptionPane.ERROR_MESSAGE);
                        } else {
                            
                            int variableA= Integer.parseInt(this.txt_a.getText());
                            int variableB= Integer.parseInt(this.txt_b.getText());
                            int variableCantVal= Integer.parseInt(this.txt_cantVal_Unif.getText());
                            
                            this.generarValoresDistUniforme(variableA, variableB,variableCantVal);
                            
                            
        }
                break;
            case "E":
                        if(this.txt_cantVal_Exp.getText().isEmpty()||this.txt_lambda.getText().isEmpty())
                        {
                        JOptionPane.showMessageDialog(this, "Falta ingresar valor (lambda,cantidad Valores)", "Error",JOptionPane.ERROR_MESSAGE);
                        }else{
                        int varCantVal= Integer.parseInt(this.txt_cantVal_Exp.getText());
                        int varLambda= Integer.parseInt(this.txt_lambda.getText());
                        
                        this.generarValoresDistExp(varLambda, varCantVal);
                        }
                
                break;
            case "N":
                        if(this.txt_cantVal_Norm.getText().isEmpty()||this.txt_media_DistNorm.getText().isEmpty()||this.txt_varianza_DistNorm.getText().isEmpty())
                        {
                        JOptionPane.showMessageDialog(this, "Falta ingresar valor (media,varianza,cantidad Valores)", "Error",JOptionPane.ERROR_MESSAGE);
                        }else{
                        int varCantVal= Integer.parseInt(this.txt_cantVal_Norm.getText());
                        int varMedia= Integer.parseInt(this.txt_media_DistNorm.getText());
                        int varVarianza= Integer.parseInt(this.txt_varianza_DistNorm.getText());
                        
                        this.generarValoresDistNormal(varMedia, varVarianza, varCantVal);
                            
                        
                        }   
                
                break;
                
            case "P":
                        if(this.txt_lambda_DistPoisson.getText().isEmpty()||this.txt_cantVal_DistPoisson.getText().isEmpty())
                        {
                        JOptionPane.showMessageDialog(this, "Falta ingresar valor (lambda,cantidad Valores)", "Error",JOptionPane.ERROR_MESSAGE);
                        }else{
                        int varLambda= Integer.parseInt(this.txt_lambda_DistPoisson.getText());
                        int varCantVal= Integer.parseInt(this.txt_cantVal_DistPoisson.getText());
                        this.generarValoresDistPoisson(varLambda, varCantVal);
                        }
            break;
            
            default:
//                throw new AssertionError();
                        JOptionPane.showMessageDialog(this,"Falta Seleccionar una Distribucion","Error",JOptionPane.ERROR_MESSAGE);
                
        }
            
    }//GEN-LAST:event_btn_generarActionPerformed

    private void btn_PoissonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PoissonActionPerformed
      
        botonSeleccionado = "P";
        this.jLayeredPane2.setPosition(this.jPanel_Param_Poisson, 5);
        this.jPanel_Param_Poisson.setVisible(true);

        this.jPanel_Param_Unif.setVisible(false);
        this.jPanel_Param_Exp.setVisible(false);
        this.jPanel_Param_Normal.setVisible(false);
        
    }//GEN-LAST:event_btn_PoissonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Grafico;
    private javax.swing.JButton btn_Exponencial;
    private javax.swing.JButton btn_Normal;
    private javax.swing.JButton btn_Poisson;
    private javax.swing.JButton btn_Uniforme;
    private javax.swing.JButton btn_generar;
    private javax.swing.JButton btn_graficar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel_Param_Exp;
    private javax.swing.JPanel jPanel_Param_Normal;
    private javax.swing.JPanel jPanel_Param_Poisson;
    private javax.swing.JPanel jPanel_Param_Unif;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_a;
    private javax.swing.JTextField txt_b;
    private javax.swing.JTextField txt_cantIntervalos;
    private javax.swing.JTextField txt_cantVal_DistPoisson;
    private javax.swing.JTextField txt_cantVal_Exp;
    private javax.swing.JTextField txt_cantVal_Norm;
    private javax.swing.JTextField txt_cantVal_Unif;
    private javax.swing.JTextField txt_lambda;
    private javax.swing.JTextField txt_lambda_DistPoisson;
    private javax.swing.JTextField txt_media_DistNorm;
    private javax.swing.JTextField txt_varianza_DistNorm;
    // End of variables declaration//GEN-END:variables
}
