
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
public class Inventory extends javax.swing.JPanel {

    float totalFinal = 0;
    ArrayList<String> chartList = new ArrayList<>();
    Statement st;
    ResultSet rs;

    /**
     * Creates new form Inventory
     */
    public Inventory() {
        initComponents();
    }

    public void setTf() {
        jTextField1.setText(DataBase.date);
    }

    public float getTotalFinal(String date) {
        setInventory(date);
        return totalFinal;
    }

//    class price {
//
//        private String date;
//        private String jurnal;
//        private String product;
//        private int qty;
//        private int price;
//        private int value;
//
//        public price(String date, String jurnal, String product, int qty, int price, int value) {
//            this.date = date;
//            this.jurnal = jurnal;
//            this.product = product;
//            this.qty = qty;
//            this.price = price;
//            this.value = value;
//        }
//
//        public String getDate() {
//            return date;
//        }
//
//        public void setDate(String date) {
//            this.date = date;
//        }
//
//        public String getJurnal() {
//            return jurnal;
//        }
//
//        public void setJurnal(String jurnal) {
//            this.jurnal = jurnal;
//        }
//
//        public String getProduct() {
//            return product;
//        }
//
//        public void setProduct(String product) {
//            this.product = product;
//        }
//
//        public int getQty() {
//            return qty;
//        }
//
//        public void setQty(int qty) {
//            this.qty = qty;
//        }
//
//        public int getPrice() {
//            return price;
//        }
//
//        public void setPrice(int price) {
//            this.price = price;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//
//    }
//
//    public ArrayList<price> getList() {
//
//        ArrayList<price> list = new ArrayList<>();
//        Statement st;
//        ResultSet rs;
//        try {
//            st = DataBase.getStatement();
//
//            rs = st.executeQuery("SELECT Jurnal_date, Jurnal_id, Product_name, p_qty, p_price,p_value from inventory where jurnal_date like '"
//                    + date + "-%' and type like 'purchase';");
//            System.out.println("SELECT Jurnal_date, Jurnal_id, Product_name, p_qty, p_price,p_value from inventory where jurnal_date like '"
//                    + date + "-%' and type like 'purchase';");
//
//            price abc; //abc defaut  
//            while (rs.next()) {
//                abc = new price(rs.getString("Jurnal_date"),
//                        rs.getString("Jurnal_id"),
//                        rs.getString("Product_name"),
//                        rs.getInt("p_qty"),
//                        rs.getInt("p_price"),
//                        rs.getInt("p_value"));
//                list.add(abc);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    public void setInventory(String date) {

        this.date = date;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int in = 0, price = 0, out = 0;
        float avg = 0, total = 0;
        Statement st = DataBase.getStatement();
        ResultSet rs;

        try {
            rs = st.executeQuery("SELECT DISTINCT PRODUCT_NAME FROM inventory WHERE JURNAL_DATE LIKE '" + date + "-%';");
            System.out.println("SELECT DISTINCT PRODUCT_NAME FROM inventory WHERE JURNAL_DATE LIKE '" + date + "-%';");
            while (rs.next()) {
                chartList.add(rs.getString("product_name"));
            }
            int a = 1;
            for (String i : chartList) {
                System.out.println("select product_name, sum(qty), sum(value) from inventory where jurnal_date like '" + date + "-%' and"
                        + " product_name like '" + i + "';");
                rs = st.executeQuery("select product_name, sum(p_qty), sum(p_value),sum(s_qty), sum(s_value) from inventory where jurnal_date like '" + date + "-%' and"
                        + " product_name like '" + i + "';");
                while (rs.next()) {
                    in = rs.getInt("sum(p_qty)");
                    price = rs.getInt("sum(p_value)");
                    out = rs.getInt("sum(s_qty)");
                    avg = (float) price / in;
                    total = (float) avg * (in - out);
                    totalFinal += total;
                    model.addRow(new Object[]{a, i, String.format("Rp.%,.2f", avg), 0, in, out, (in - out), String.format("Rp.%,.2f", total)});
                    avg = 0;
                    total = 0;
                    a++;
                }
            }
            a = 0;
            model.addRow(new Object[]{null, null, null, null, null, null, "sum", String.format("Rp.%,.2f", totalFinal)});
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void Show_In_JTable() {
//        ArrayList<price> list = getList();
//        Object[] col = new Object[6];
//        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
//        for (int i = 0; i < list.size(); i++) {
//            col[0] = list.get(i).getDate();
//            col[1] = list.get(i).getJurnal();
//            col[2] = list.get(i).getProduct();
//            col[3] = list.get(i).getQty();
//            col[4] = String.format("Rp.%,2d", list.get(i).getPrice());
//            col[5] = String.format("Rp.%,2d", list.get(i).getValue());
//            model.addRow(col);
//        }
//    }
//    public void updateTable() {
//        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
//        model.setRowCount(0);
//        Show_In_JTable();
//    }
    public void setChart() {
        try {
            jComboBox1.removeAllItems();
            Statement st = DataBase.getStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT product_name FROM inventory WHERE JURNAL_DATE LIKE '" + date + "-%';");
            System.out.println("SELECT DISTINCT product_name FROM inventory WHERE JURNAL_DATE LIKE '" + date + "-%';");
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("product_name"));
            }
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
        jComboBox1 = new javax.swing.JComboBox<>();

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
                "NO", "PRODUCT_NAME", "PRICE", "OPEN", "IN", "OUT", "ENDING", "VALUE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false
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

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE", "JURNAL_NO", "PRODUCT", "QTY", "PRICE", "VALUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(25);
        jScrollPane2.setViewportView(jTable2);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(283, 283, 283))
        );
    }// </editor-fold>//GEN-END:initComponents
String date;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        date = jTextField1.getText();
//        updateTable();
        try {
            System.out.println(date);
            setChart();
            setInventory(date);
            DataBase.date = date;
            totalFinal = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        if (date != null) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            System.out.println(date);
            model.setRowCount(0);
            try {
//                for (String a : chartList) {
                st = DataBase.getStatement();
                System.out.println("SELECT Jurnal_date, Jurnal_id, Product_name, p_qty, p_price,p_value from inventory where jurnal_date like '"
                        + date + "-%' AND product_name like '" + jComboBox1.getSelectedItem() + "' AND TYPE LIKE 'PURCHASE'");
                rs = st.executeQuery("SELECT Jurnal_date, Jurnal_id, Product_name, p_qty, p_price,p_value from inventory where jurnal_date like '"
                        + date + "-%' AND product_name like '" + jComboBox1.getSelectedItem() + "' AND TYPE LIKE 'PURCHASE'");
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("JURNAL_DATE"),
                        rs.getString("Jurnal_id"),
                        rs.getString("Product_name"),
                        rs.getString("p_qty"),
                        String.format("Rp.%,.2f", rs.getDouble("p_price")),
                        String.format("Rp.%,.2f", rs.getDouble("p_value"))
                    });
//                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Enter Date First");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
