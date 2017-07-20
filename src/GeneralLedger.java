
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
public class GeneralLedger extends javax.swing.JPanel {

    /**
     * Creates new form GeneralLedger
     */
    public GeneralLedger() {
        initComponents();
    }

    public void setTf() {
        jTextField1.setText(DataBase.date);
    }

    class generalledger {

        private String date;
        private String jurnalid;
        private String description;
        private int debit;
        private int credit;

        public generalledger(String date, String jurnalid, String description, int debit, int credit) {
            this.date = date;
            this.jurnalid = jurnalid;
            this.description = description;
            this.debit = debit;
            this.credit = credit;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getJurnalid() {
            return jurnalid;
        }

        public void setJurnalid(String jurnalid) {
            this.jurnalid = jurnalid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDebit() {
            return debit;
        }

        public void setDebit(int debit) {
            this.debit = debit;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }
    }

    public void setChart() {
        try {
            jComboBox1.removeAllItems();
            Statement st = DataBase.getStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT CHART_NAME FROM JURNAL WHERE JURNAL_DATE LIKE '" + date + "-%';");
            System.out.println("SELECT DISTINCT CHART_NAME FROM JURNAL WEHRE JURNAL_DATE LIKE '" + date + "-%';");
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("chart_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUpdateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Show_In_JTable();
    }
    String date;

    public ArrayList<generalledger> getList(String date) {
        this.date = date;
        ArrayList<generalledger> list = new ArrayList<generalledger>();
        String sql = "SELECT * fROM `jurnal` WHERE jurnal_date like '" + date + "-%' AND CHART_NAME ='" + jComboBox1.getSelectedItem() + "';";
        System.out.println(sql);
        Statement st;
        ResultSet rs;
        try {
            st = DataBase.getStatement();
            rs = st.executeQuery(sql);
            generalledger abc; //abc defaut  
            while (rs.next()) {
                abc = new generalledger(rs.getString("jurnal_id"),
                        rs.getString("jurnal_date"),
                        rs.getString("description"),
                        rs.getInt("debit"),
                        rs.getInt("credit"));
                list.add(abc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void Show_In_JTable() {
        ArrayList<generalledger> list = getList(date);
        Object[] col = new Object[5];
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < list.size(); i++) {
            col[0] = list.get(i).getDate();
            col[1] = list.get(i).getJurnalid();
            col[2] = list.get(i).getDescription();
            col[3] = String.format("Rp.%,d", list.get(i).getDebit());
            col[4] = String.format("Rp.%,d", list.get(i).getCredit());
            model.addRow(col);
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(248, 238, 160));
        setForeground(new java.awt.Color(248, 238, 160));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
                "DATE", "JURNAL ID", "DESCRIPTION", "DEBIT", "CREDIT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
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

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        date = jTextField1.getText();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Show_In_JTable();

        //insert to gl database
//        int debit = 0, credit = 0;
//        for (int i = 0; i < jTable1.getRowCount(); i++) {
//            for (int j = 0; j < jTable1.getColumnCount(); j++) {
//                if (j == 3) {
//                    debit += (Integer) jTable1.getModel().getValueAt(i, 3);
//                }
//                if (j == 4) {
//                    credit += (Integer) jTable1.getModel().getValueAt(i, 4);
//                }
//            }
//        }
//        model.addRow(new Object[]{null, null, "SUM", debit, credit});
//        DataBase.setExecuteUpdate("INSERT INTO TRIALBALLANCE VALUES('" + date + "-01','" + jComboBox1.getSelectedItem() + "',0,"
//                + debit + ", " + credit + ", 0);");
//        JOptionPane.showMessageDialog(this, " Debit: " + debit + " Credit = " + credit);
//        System.out.println("INSERT INTO TRIALBALLANCE VALUES('" + date + "-01','" + jComboBox1.getSelectedItem() + "',0,"
//                + debit + ", " + credit + ", 0);");
//        debit = 0;
//        credit = 0;
        DataBase.date = date;
    }//GEN-LAST:event_jButton1ActionPerformed
//auto show gl combobox
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        date = jTextField1.getText();
        if (date != null) {
            System.out.println(date);
            setChart();
        } else {
            JOptionPane.showMessageDialog(this, "Please Enter Date First");
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
