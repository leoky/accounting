
import java.sql.Connection;
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
public class Customer extends javax.swing.JPanel {

    int button_ok = 0;

    public void clearText() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) tCust.getModel();
        model.setRowCount(0);
        Show_In_JTable();
    }

//    jTable1.setModel ( 
//        new DefaultTableModel(){
//        @Override
//        public boolean isCellEditable(int row, int column){
//       return false;
//        }
//    }
//
//    );
    class customer {

        private String id;
        private String name;
        private String company;
        private String phone;
        private String address;

        public customer(String id, String name, String company, String phone, String address) {
            this.id = id;
            this.name = name;
            this.company = company;
            this.phone = phone;
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCompany() {
            return company;
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() {
            return address;
        }

    }

    public ArrayList<customer> getCustomerList() {
        ArrayList<customer> customerList = new ArrayList<customer>();
        String sql = "SELECT CONCAT('C',CUST_ID) AS CUST_ID, CUST_NAME, CUST_COMPANY, CUST_PHONE, CUST_ADDRESS fROM `customer`";
        Statement st;
        ResultSet rs;
        try {
            st = DataBase.getStatement();
            rs = st.executeQuery(sql);
            customer cust;
            while (rs.next()) {
                cust = new customer(rs.getString("cust_id"),
                        rs.getString("cust_name"),
                        rs.getString("cust_company"),
                        rs.getString("cust_phone"),
                        rs.getString("cust_address"));
                customerList.add(cust);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public void Show_In_JTable() {
        ArrayList<customer> list = getCustomerList();
        Object[] col = new Object[5];
        DefaultTableModel model = (DefaultTableModel) tCust.getModel();
        for (int i = 0; i < list.size(); i++) {
            col[0] = list.get(i).getId();
            col[1] = list.get(i).getName();
            col[2] = list.get(i).getCompany();
            col[3] = list.get(i).getPhone();
            col[4] = list.get(i).getAddress();
            model.addRow(col);
            System.out.println(i);
        }
    }

    public Customer() {
        initComponents();
        Show_In_JTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tCust = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("CUSTOMER");

        jLabel2.setText("NAME");

        jLabel3.setText("COMPANY");

        jLabel4.setText("PHONE");

        jLabel5.setText("ADDRESS");

        tCust.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "NAME", "COMPANY", "PHONE", "ADDRESS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tCust.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tCust);

        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CANCEL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("CLEAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton6))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 508, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
//ad button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (button_ok == 0) {
            try {
                String sql = "INSERT INTO CUSTOMER(CUST_NAME,CUST_COMPANY,CUST_PHONE,CUST_ADDRESS) VALUES('"
                        + jTextField1.getText() + "'," + "'" + jTextField2.getText() + "'," + "'"
                        + jTextField3.getText() + "'," + "'" + jTextField4.getText() + "')";
                System.out.println(sql);
                DataBase.getExecuteUpdate(sql);
                clearText();
                updateTable();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (button_ok == 1) {
            try {
                String s=(String) tCust.getValueAt(tCust.getSelectedRow(), 0);
                String sql = "UPDATE CUSTOMER SET cust_name='" + jTextField1.getText() + "', cust_company ='" + jTextField2.getText()
                        + "', cust_phone='" + jTextField3.getText() + "', cust_address = '" + jTextField4.getText()
                        + "' WHERE cust_id='" + s.substring(1) + "'";
                System.out.println(sql);
                DataBase.getExecuteUpdate(sql);
                clearText();
                updateTable();
                jButton3.setText("ADD");
                button_ok = 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
//refresh button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateTable();
    }//GEN-LAST:event_jButton1ActionPerformed
//edit button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            button_ok = 1;
            jButton3.setText("EDIT");
            jTextField1.setText((String) tCust.getValueAt(tCust.getSelectedRow(), 1));
            jTextField2.setText((String) tCust.getValueAt(tCust.getSelectedRow(), 2));
            jTextField3.setText((String) tCust.getValueAt(tCust.getSelectedRow(), 3));
            jTextField4.setText((String) tCust.getValueAt(tCust.getSelectedRow(), 4));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PLEASE SELECT WHAT YOU WANT TO EDIT IN TABLE");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
//clear button
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clearText();
    }//GEN-LAST:event_jButton6ActionPerformed
//delete button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            String s=(String) tCust.getValueAt(tCust.getSelectedRow(), 0);
            int check = JOptionPane.showConfirmDialog(this, "ARE YOU WANT TO DELETE ID = " + tCust.getValueAt(tCust.getSelectedRow(), 0));
            if (check == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM CUSTOMER WHERE cust_id='" + s.substring(1) + "'";
                DataBase.getExecuteUpdate(sql);
                updateTable();
                System.out.println(sql);
                JOptionPane.showMessageDialog(this, "DELETE SUCCESS");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
//cancel button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearText();
        jButton3.setText("ADD");
        button_ok = 0;
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tCust;
    // End of variables declaration//GEN-END:variables
}
