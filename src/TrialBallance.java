
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leonardy
 */
public class TrialBallance extends javax.swing.JPanel {

    /**
     * Creates new form TrialBallance
     */
    public TrialBallance() {
        initComponents();
    }

    public void setTf() {
        jTextField1.setText(DataBase.date);
    }
//    class trialballance {
//
//        private String chart_name;
//        private int opening;
//        private int debit;
//        private int credit;
//        private int clossing;
//
//        public trialballance(String chart_name, int openning, int debit, int credit, int clossing) {
//            this.chart_name = chart_name;
//            this.opening = openning;
//            this.debit = debit;
//            this.credit = credit;
//            this.clossing = clossing;
//        }
//
//        public String getChart_name() {
//            return chart_name;
//        }
//
//        public void setChart_name(String chart_name) {
//            this.chart_name = chart_name;
//        }
//
//        public int getOpening() {
//            return opening;
//        }
//
//        public void setOpenning(int openning) {
//            this.opening = openning;
//        }
//
//        public int getDebit() {
//            return debit;
//        }
//
//        public void setDebit(int debit) {
//            this.debit = debit;
//        }
//
//        public int getCredit() {
//            return credit;
//        }
//
//        public void setCredit(int credit) {
//            this.credit = credit;
//        }
//
//        public int getClossing() {
//            return clossing;
//        }
//
//        public void setClossing(int clossing) {
//            this.clossing = clossing;
//        }
//
//    }

    public void setUpdateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

    }
    String date;

//    public ArrayList<trialballance> getList(String date) {
//        this.date = date;
//        ArrayList<trialballance> list = new ArrayList<trialballance>();
//        String sql = "SELECT * fROM `trialballance` WHERE tb_date like '" + date + "-%';";
//        System.out.println(sql);
//        Statement st;
//        ResultSet rs;
//        try {
//            st = DataBase.getStatement();
//            rs = st.executeQuery(sql);
//            trialballance abc; //abc defaut  
//            while (rs.next()) {
//                abc = new trialballance(rs.getString("tb_chart_name"),
//                        rs.getInt("tb_opening"),
//                        rs.getInt("tb_debit"),
//                        rs.getInt("tb_credit"),
//                        rs.getInt("tb_ending"));
//                list.add(abc);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public void Show_In_JTable() {
//        ArrayList<trialballance> list = getList(date);
//        Object[] col = new Object[5];
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        for (int i = 0; i < list.size(); i++) {
//            col[0] = list.get(i).getChart_name();
//            col[1] = list.get(i).getOpening();
//            col[2] = list.get(i).getDebit();
//            col[3] = list.get(i).getCredit();
//            col[4] = list.get(i).getClossing();
//            model.addRow(col);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(248, 238, 160));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHART NAME", "OPENNING", "DEBIT", "CREDIT", "ENDING"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("COUNT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void setTrialBallance() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        ArrayList<String> chartList = new ArrayList<>();
        try {
            Statement st = DataBase.getStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT CHART_NAME FROM JURNAL WHERE JURNAL_DATE LIKE '" + date + "-%';");
            System.out.println("SELECT DISTINCT CHART_NAME FROM JURNAL WHERE JURNAL_DATE LIKE '" + date + "-%';");
            while (rs.next()) {
                chartList.add(rs.getString("chart_name"));
            }
            for (String a : chartList) {
                rs = st.executeQuery("SELECT chart_name, sum(debit),sum(credit) fROM `jurnal` WHERE jurnal_date like '" + date + "-%' AND CHART_NAME ='" + a + "';");
                while (rs.next()) {
                    String debit = String.format("Rp.%,d", rs.getInt("sum(debit)"));
                    String credit = String.format("Rp.%,d", rs.getInt("sum(credit)"));
                    model.addRow(new Object[]{a, 0, debit, credit, 0});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        date = jTextField1.getText();
        setTrialBallance();
        DataBase.date = date;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        date = jTextField1.getText();
        setTrialBallance();
        DataBase.date = date;
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int debit = 0, credit = 0;
        int[] row = jTable1.getSelectedRows();
        for (int i : row) {
//            debit += (Integer) jTable1.getModel().getValueAt(i, 2);
//            credit += (Integer) jTable1.getModel().getValueAt(i, 3);
            String a1 = (String) jTable1.getModel().getValueAt(i, 2);
            String b1 = a1.substring(3);
            String c1 = b1.replace(",", "");

            String a2 = (String) jTable1.getModel().getValueAt(i, 3);
            String b2 = a2.substring(3);
            String c2 = b2.replace(",", "");
            debit += Integer.parseInt(c1);
            credit += Integer.parseInt(c2);
        }
        JOptionPane.showMessageDialog(this, " Debit: " + debit + " Credit = " + credit);
        debit = 0;
        credit = 0;
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
