
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
public class JurnalView extends javax.swing.JPanel {

    String date = DataBase.date;
    /**
     * Creates new form JurnalView
     */
    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Show_In_JTable();
    }

    public JurnalView() {
        initComponents();
        updateTable();
        jTextField1.setText(DataBase.date);
    }

    class jurnalview {

        private String id;
        private String date;
        private String chartnum;
        private String chartname;
        private int debit, credit;
        private String description;

        public jurnalview(String id, String date, String chartnum, String chartname, int debit, int credit, String description) {
            this.id = id;
            this.date = date;
            this.chartnum = chartnum;
            this.chartname = chartname;
            this.debit = debit;
            this.credit = credit;
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getChartnum() {
            return chartnum;
        }

        public void setChartnum(String chartnum) {
            this.chartnum = chartnum;
        }

        public String getChartname() {
            return chartname;
        }

        public void setChartname(String chartname) {
            this.chartname = chartname;
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

        public void setCredut(int credit) {
            this.credit = credit;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public ArrayList<jurnalview> getList(String date) {
        this.date = date;
        System.out.println("date" + date);
        ArrayList<jurnalview> list = new ArrayList<jurnalview>();
        String sql = "SELECT * FROM `jurnal` WHERE JURNAL_DATE LIKE '" + date + "-%'";
        Statement st;
        ResultSet rs;
        try {
            st = DataBase.getStatement();
            rs = st.executeQuery(sql);
            jurnalview abc; //abc defaut  
            while (rs.next()) {
                abc = new jurnalview(rs.getString("jurnal_id"),
                        rs.getString("jurnal_date"),
                        rs.getString("chart_no"),
                        rs.getString("chart_name"),
                        rs.getInt("debit"),
                        rs.getInt("credit"),
                        rs.getString("description"));
                list.add(abc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void Show_In_JTable() {
        ArrayList<jurnalview> list = getList(date);
        Object[] col = new Object[7];
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < list.size(); i++) {
            col[0] = list.get(i).getId();
            col[1] = list.get(i).getDate();
            col[2] = list.get(i).getChartnum();
            col[3] = list.get(i).getChartname();
            col[4] = list.get(i).getDebit();
            col[5] = list.get(i).getCredit();
            col[6] = list.get(i).getDescription();
            model.addRow(col);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("REFRESH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("PRINT");

        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JURNAL ID", "JURNAL DATE", "CHART NO", "CHART NAME", "DEBIT", "CREDIT", "DESCRIPTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(68, 68, 68)
                .addComponent(jButton2)
                .addGap(44, 44, 44)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(39, 39, 39))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
//refresh button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        date = DataBase.date;
        updateTable();
    }//GEN-LAST:event_jButton2ActionPerformed
//delete button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int check = JOptionPane.showConfirmDialog(this, "ARE YOU WANT TO DELETE ID = " + jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            if (check == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM JURNAL WHERE jurnal_id='" + (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "'";
                DataBase.getExecuteUpdate(sql);
                updateTable();
                JOptionPane.showMessageDialog(this, "DELETE SUCCESS");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
//search buton
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
//            Statement st = DataBase.getStatement();
//            ResultSet sr = st.executeQuery(sql);
//            DataBase.getExecuteUpdate("SELECT * fROM `jurnal` WHERE JURNAL_DATE LIKE '" + jTextField1.getText() + "-%'");
//            System.out.println("SELECT * fROM `jurnal` WHERE JURNAL_DATE LIKE '" + jTextField1.getText() + "-%'");
//            updateTable();
            date = jTextField1.getText();
            updateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
