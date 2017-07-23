
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

    public void setTf() {
        jTextField1.setText(DataBase.date);
    }

    public JurnalView() {
        initComponents();
        Show_In_JTable();
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
        System.out.println(sql);
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
            col[4] = String.format("Rp.%,d", list.get(i).getDebit());
            col[5] = String.format("Rp.%,d", list.get(i).getCredit());
            col[6] = list.get(i).getDescription();
            model.addRow(col);
        }
//        for (int i = 0; i < list.size(); i++) {
//            list.remove(i);
//        }
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

        setBackground(new java.awt.Color(248, 238, 160));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setText("REFRESH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton3.setText("COUNT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
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
        jTable1.setAutoscrolls(false);
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton1)
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)
                        .addGap(38, 38, 38)
                        .addComponent(jButton3)
                        .addGap(28, 28, 28)
                        .addComponent(jButton4)))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
//refresh button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        date = DataBase.date;
        updateTable();
    }//GEN-LAST:event_jButton2ActionPerformed
//delete button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int check = JOptionPane.showConfirmDialog(this, "ARE YOU WANT TO DELETE ID = " + jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            if (check == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM JURNAL WHERE jurnal_id='" + (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "'";
                DataBase.setExecuteUpdate(sql);
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
            date = jTextField1.getText();
            updateTable();
            DataBase.date = date;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//count buton
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int debit = 0, credit = 0;
        int[] row = jTable1.getSelectedRows();
        for (int i : row) {
            String a1 = (String) jTable1.getModel().getValueAt(i, 4);
            String b1 = a1.substring(3);
            String c1 = b1.replace(",", "");

            String a2 = (String) jTable1.getModel().getValueAt(i, 5);
            String b2 = a2.substring(3);
            String c2 = b2.replace(",", "");
            debit += Integer.parseInt(c1);
            credit += Integer.parseInt(c2);
//            debit += (Integer) jTable1.getModel().getValueAt(i, 4);
//            credit += (Integer) jTable1.getModel().getValueAt(i, 5);
        }
        JOptionPane.showMessageDialog(this, " Debit: " + debit + " Credit = " + credit);
        debit = 0;
        credit = 0;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        try {
            date = jTextField1.getText();
            updateTable();
            DataBase.date = date;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jTextField1ActionPerformed


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
