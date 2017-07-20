
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
public class BalanceSheet extends javax.swing.JPanel {

    Statement st = DataBase.getStatement();
    ResultSet rs;

    ArrayList<String> chartList = new ArrayList<>();

    String date;
    double totalAsset = 0, totalLiaAndCap = 0, totalLia = 0, totalCap = 0;

    /**
     * Creates new form BallanceSheet
     */
    public BalanceSheet() {
        initComponents();

    }

    public void setTf() {
        jTextField1.setText(DataBase.date);
    }

    public void setAsset(String date) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            rs = st.executeQuery("SELECT DISTINCT CHART_NAME FROM JURNAL NATURAL JOIN CHART WHERE JURNAL_DATE LIKE '"
                    + date + "-%' AND CHART_ID LIKE '1%'");
            System.out.println("SELECT DISTINCT CHART_NAME FROM JURNAL NATURAL JOIN CHART WHERE JURNAL_DATE LIKE '"
                    + date + "-%' AND CHART_ID LIKE '1%'");
            while (rs.next()) {
                chartList.add(rs.getString("chart_name"));
            }
            for (String a : chartList) {
                rs = st.executeQuery("SELECT CHART_NAME, SUM(DEBIT)-SUM(CREDIT) FROM JURNAL WHERE JURNAL_DATE LIKE '"
                        + date + "-%' AND CHART_NAME LIKE '" + a + "'");
                System.out.println("SELECT CHART_NAME, SUM(DEBIT)-SUM(CREDIT) FROM JURNAL WHERE JURNAL_DATE LIKE '"
                        + date + "-%' AND CHART_NAME LIKE '" + a + "'");
                while (rs.next()) {
                    double asset = rs.getDouble("SUM(DEBIT)-SUM(CREDIT)");
                    totalAsset += asset;
                    model.addRow(new Object[]{a, String.format("Rp.%,.2f", asset)});
                }
            }
            Inventory in = new Inventory();
            int inventory = (int) in.getTotalFinal(date);
            totalAsset += inventory;
            model.addRow(new Object[]{"inventory", String.format("Rp.%,d", inventory)});
            model.addRow(new Object[]{"TOTAL ASSET ", String.format("Rp.%,.2f", totalAsset)});
            chartList.clear();
            totalAsset = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLiabily(String date) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        try {
            rs = st.executeQuery("SELECT DISTINCT CHART_NAME FROM JURNAL NATURAL JOIN CHART WHERE JURNAL_DATE LIKE '"
                    + date + "-%' AND CHART_ID LIKE '2%'");
            System.out.println("SELECT DISTINCT CHART_NAME FROM JURNAL NATURAL JOIN CHART WHERE JURNAL_DATE LIKE '"
                    + date + "-%' AND CHART_ID LIKE '2%'");
            while (rs.next()) {
                chartList.add(rs.getString("chart_name"));
            }
            model.addRow(new Object[]{"LIABILITY"});
            for (String a : chartList) {
                rs = st.executeQuery("SELECT CHART_NAME,SUM(CREDIT)- SUM(DEBIT) FROM JURNAL WHERE JURNAL_DATE LIKE '"
                        + date + "-%' AND CHART_NAME LIKE '" + a + "'");
                System.out.println("SELECT CHART_NAME, SUM(CREDIT)- SUM(DEBIT) FROM JURNAL WHERE JURNAL_DATE LIKE '"
                        + date + "-%' AND CHART_NAME LIKE '" + a + "'");
                while (rs.next()) {
                    double lia = rs.getDouble("SUM(CREDIT)- SUM(DEBIT)");
                    totalLiaAndCap += lia;
                    totalLia += lia;
                    model.addRow(new Object[]{a, String.format("Rp.%,.2f", lia)});
                }
            }
            model.addRow(new Object[]{"TOTAL LIABILITY  ", String.format("Rp.%,.2f", totalLia)});
            model.addRow(new Object[]{});
            chartList.clear();
            totalAsset = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCapital(String date) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        try {
            rs = st.executeQuery("SELECT DISTINCT CHART_NAME FROM JURNAL NATURAL JOIN CHART WHERE JURNAL_DATE LIKE '"
                    + date + "-%' AND CHART_ID LIKE '3%'");
            System.out.println("SELECT DISTINCT CHART_NAME FROM JURNAL NATURAL JOIN CHART WHERE JURNAL_DATE LIKE '"
                    + date + "-%' AND CHART_ID LIKE '3%'");
            while (rs.next()) {
                chartList.add(rs.getString("chart_name"));
            }
            model.addRow(new Object[]{"CAPITAL"});
            for (String a : chartList) {
                rs = st.executeQuery("SELECT CHART_NAME, SUM(DEBIT)-SUM(CREDIT) FROM JURNAL WHERE JURNAL_DATE LIKE '"
                        + date + "-%' AND CHART_NAME LIKE '" + a + "'");
                System.out.println("SELECT CHART_NAME, SUM(DEBIT)-SUM(CREDIT) FROM JURNAL WHERE JURNAL_DATE LIKE '"
                        + date + "-%' AND CHART_NAME LIKE '" + a + "'");
                while (rs.next()) {
                    double Cap = rs.getDouble("SUM(DEBIT)-SUM(CREDIT)");
                    totalLia += Cap;
                    totalLiaAndCap += Cap;
                    model.addRow(new Object[]{a, String.format("Rp.%,.2f", Cap)});
                }
            }
            ProfitLoss profitLoss = new ProfitLoss();
            int profit = (int) profitLoss.getProfitLoss(date);
            totalLiaAndCap += profit;
            totalCap += profit;
            model.addRow(new Object[]{"CURRENT PERIOD", String.format("Rp.%,d",  profit)});
            model.addRow(new Object[]{"TOTAL CAPITAL  ",  String.format("Rp.%,.2f", totalCap)});
            model.addRow(new Object[]{"TOTAL LIABILITY AND CAP ",  String.format("Rp.%,.2f",  totalLiaAndCap)});
            chartList.clear();
            totalCap = 0;
        } catch (Exception e) {
            e.printStackTrace();
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

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(248, 238, 160));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "VALUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "VALUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(25);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        date = jTextField1.getText();
        setAsset(date);
        setLiabily(date);
        setCapital(date);
        DataBase.date = date;
        totalAsset = 0;
        totalLiaAndCap = 0;
        totalLia = 0;
        totalCap = 0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        date = jTextField1.getText();
        setAsset(date);
        setLiabily(date);
        setCapital(date);
        DataBase.date = date;
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
