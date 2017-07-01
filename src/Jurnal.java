
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JComboBox;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leonardy
 */
public class Jurnal extends javax.swing.JPanel {
//    jTable1 table = new JTable();
//    TableColumnModel cm= table.getColumnModel();
//    cm.getColumn(0).setCellEditor(new DefaultCellEditor(
//        new JComboBox(new DefaultComboBoxModel(new String[]{
//        "yes","no"
//    }))));
//   

//    jTable1 table = table.getColumnModel().getColumn(2);
    private int count = -1;
//    JComboBox[] combobox1 = new JComboBox[10];
//    JTextField[] textfield1 = new JTextField[10];
//    JTextField[] textfield2 = new JTextField[10];
//    JTextField[] textfield3 = new JTextField[10];
//    JTextField[] textfield4 = new JTextField[10];
//    JTextField[] textfield5 = new JTextField[10];
    JComboBox cProduct = new JComboBox(); //combo box
    JComboBox cPayment = new JComboBox();
    String chartid;
    String chartname;
    int pay = 0;

    public void setComboPayment() {
        cPayment.addItem("cash");
        cPayment.addItem("credit");
        cPayment.addItem("giro");
        cPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {
                    if (DataBase.jurnalShow == 1) {
                        tsales2.setValueAt(cPayment.getSelectedItem(), tsales2.getSelectedRow(), 1);
                    }
                    if (DataBase.jurnalShow == 2) {
                        tPur2.setValueAt(cPayment.getSelectedItem(), tPur2.getSelectedRow(), 1);
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
    }

    public void setComboProduct() {
        try {
            Statement st = DataBase.getStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CHART");
            while (rs.next()) {
                cProduct.addItem(rs.getString("chart_name"));
            }
            cProduct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    try {
                        if (DataBase.jurnalShow == 1) {
                            tsales1.setValueAt(cProduct.getSelectedItem(), tsales1.getSelectedRow(), 1);
                        }
                        if (DataBase.jurnalShow == 2) {
                            tPur1.setValueAt(cProduct.getSelectedItem(), tPur1.getSelectedRow(), 1);
                        }
                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void setComboCustomer() {
        try {
            Statement st = DataBase.getStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER");
            while (rs.next()) {
                cPurFrom.addItem(rs.getString("cust_name"));
                cSalesTo.addItem(rs.getString("cust_name"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public Jurnal() {
        initComponents();
        setComboProduct();
        setComboPayment();
        setComboCustomer();
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        JTable table = new JTable(model);
//        JComboBox combo = new JComboBox();
//        combo.addItem("test");
//        TableColumn col = table.getColumnModel().getColumn(2);
//        System.out.println(col);
//        col.setCellEditor(new DefaultCellEditor(combo));
//        
//        jComboBox3.addItem("diskon");
//        model = new DefaultTableModel();
//        model.setColumnIdentifiers(new Object[]{"Book Code", "Title", "Author", "Date"});
//        model.addRow(new Object[]{});
//        jTable2.setModel(model);
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        JComboBox combo = new JComboBox();
//        combo.addItem("test");
//        combo.addItem("test2");
        tsales1.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cProduct));
        tsales2.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cPayment));
        tPur1.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cProduct));
        tPur2.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cPayment));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton3 = new javax.swing.JButton();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        sales = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bSubmit = new javax.swing.JButton();
        cSalesTo = new javax.swing.JComboBox<>();
        bAddProdcut = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        bRemoveProduct = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tsales1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tsales2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfPurDate = new javax.swing.JTextField();
        cPurFrom = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPur1 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tPur2 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jTextField15 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        jComboBox11 = new javax.swing.JComboBox<>();
        jTextField18 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();

        jButton3.setText("jButton3");

        setLayout(new java.awt.BorderLayout());

        sales.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                salesComponentShown(evt);
            }
        });

        jLabel2.setText("DATE");

        jLabel3.setText("TO");

        jButton1.setText("CANCEL");

        bSubmit.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        bSubmit.setForeground(new java.awt.Color(0, 155, 0));
        bSubmit.setText("SUBMIT");
        bSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitActionPerformed(evt);
            }
        });

        bAddProdcut.setForeground(new java.awt.Color(155, 0, 0));
        bAddProdcut.setText("Add PRODUCT");
        bAddProdcut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddProdcutActionPerformed(evt);
            }
        });

        jButton10.setText("jButton10");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        bRemoveProduct.setText("REMOVE");
        bRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveProductActionPerformed(evt);
            }
        });

        tsales1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tsales1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product", "PRODUCT", "QTY", "PRICE", "DISCOUNT", "TAX"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tsales1.setMaximumSize(new java.awt.Dimension(2147483647, 250));
        tsales1.setMinimumSize(new java.awt.Dimension(75, 60));
        tsales1.setPreferredSize(new java.awt.Dimension(375, 250));
        tsales1.setRequestFocusEnabled(false);
        tsales1.setRowHeight(25);
        jScrollPane3.setViewportView(tsales1);

        jLabel13.setText("DESCRIPTION");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        tsales2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tsales2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "PAYMENT", "PAYMENT", "PERCENT", "COMMENT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tsales2.setMaximumSize(new java.awt.Dimension(2147483647, 75));
        tsales2.setMinimumSize(new java.awt.Dimension(45, 50));
        tsales2.setPreferredSize(new java.awt.Dimension(225, 75));
        tsales2.setRowHeight(25);
        jScrollPane1.setViewportView(tsales2);

        jButton2.setText("MORE PAYMENT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("REMOVE ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salesLayout = new javax.swing.GroupLayout(sales);
        sales.setLayout(salesLayout);
        salesLayout.setHorizontalGroup(
            salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(92, 92, 92)
                                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfDate)
                                    .addComponent(cSalesTo, 0, 236, Short.MAX_VALUE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bAddProdcut)
                            .addComponent(bRemoveProduct)))
                    .addGroup(salesLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(42, 42, 42)
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salesLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButton10))
                            .addGroup(salesLayout.createSequentialGroup()
                                .addComponent(bSubmit)
                                .addGap(42, 42, 42)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(salesLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton4))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        salesLayout.setVerticalGroup(
            salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cSalesTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addComponent(bAddProdcut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bRemoveProduct)))
                .addGap(29, 29, 29)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salesLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel13))
                            .addGroup(salesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(salesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(jButton10)
                                .addGap(11, 11, 11)))
                        .addGap(83, 83, 83)
                        .addComponent(bSubmit))
                    .addGroup(salesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1308, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("SALES", sales);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jLabel9.setText("DATE");

        jLabel10.setText("FROM");

        jButton5.setText("Add Product");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("SUBMIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("ADD");

        tPur1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tPur1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "PRODCUT", "PRODCUT", "QTY", "PRICE", "DISCOUNT", "TAX"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPur1.setMaximumSize(new java.awt.Dimension(2147483647, 250));
        tPur1.setPreferredSize(new java.awt.Dimension(375, 250));
        tPur1.setRowHeight(25);
        jScrollPane2.setViewportView(tPur1);

        jButton12.setText("REMOVE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        tPur2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "PAYMENT", "PAYMENT", "PERCENT", "COMMENT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPur2.setMaximumSize(new java.awt.Dimension(2147483647, 75));
        tPur2.setPreferredSize(new java.awt.Dimension(225, 75));
        tPur2.setRowHeight(25);
        jScrollPane5.setViewportView(tPur2);

        jButton13.setText("MORE PAYMENT");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("REMOVE");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jLabel1.setText("DESCRIPTION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPurDate, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cPurFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jButton13))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButton14)))))
                .addGap(0, 172, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfPurDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cPurFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12)))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1320, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("PURCHASING", jPanel2);

        jLabel17.setText("Date");

        jLabel18.setText("Type");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("Payment");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton8.setText("Submit");

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel23.setText("Price");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel23))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4)
                            .addComponent(jComboBox7, 0, 157, Short.MAX_VALUE)
                            .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField15))))
                .addContainerGap(939, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1694, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(23, 23, 23))
        );

        jTabbedPane8.addTab("OPERASIONAL", jPanel3);

        jLabel20.setText("Date");

        jLabel21.setText("Description");

        jLabel22.setText("Payment");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setText("Submit");

        jLabel24.setText("Price");

        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox9, javax.swing.GroupLayout.Alignment.LEADING, 0, 155, Short.MAX_VALUE)))))
                .addContainerGap(797, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1627, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(93, 93, 93))
        );

        jTabbedPane8.addTab("PRIVET", jPanel4);

        jLabel25.setText("DATE");

        jLabel26.setText("PRODUCT");

        jLabel27.setText("QUANTITY");

        jLabel28.setText("FROM/TO");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField18.setText("jTextField18");

        jButton11.setText("jButton11");

        jLabel29.setText("Payment");

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29))
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox10, 0, 156, Short.MAX_VALUE)
                    .addComponent(jComboBox11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addContainerGap(687, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1779, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("RETURN", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1228, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1950, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("tab6", jPanel7);

        add(jTabbedPane8, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
//        int price;
//        int total = 0;
//        for (int i = 0; i <= count; i++) {
//            price = Integer.parseInt(textfield1[i].getText()) * Integer.parseInt(textfield2[i].getText());
//            //            price = Integer.parseInt(textfield1[0].getText()) * Integer.parseInt(textfield2[0].getText());
//            total = total + price;
//        }
//        //        System.out.println(price);
//        //price= Integer.parseInt(textfield1[0].getText())*Integer.parseInt(textfield2[0].getText());
//        jTextField5.setText(Integer.toString(total));
//        jTextField7.setText(textfield1[1].getText());
    }//GEN-LAST:event_jButton10ActionPerformed

//add product sales button
    private void bAddProdcutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddProdcutActionPerformed
        DefaultTableModel model = (DefaultTableModel) tsales1.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_bAddProdcutActionPerformed
//summit sales button
    private void bSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitActionPerformed
        try {
            int qty = 0, price = 0, total = 0, discount = 0, tax = 0, pay = 0, totalvalue = 0, totalpay = 0;
            for (int i = 0; i < tsales1.getRowCount(); i++) {
                for (int j = 0; j < tsales1.getColumnCount(); j++) {
                    if (j == 2) {
                        if (tsales1.getModel().getValueAt(i, j) != null) {
                            qty = (Integer) tsales1.getModel().getValueAt(i, j);
                        } else {
                            JOptionPane.showMessageDialog(tPur1, "Pleae Entry Qty");
                            break;
                        }
                    }
                    if (j == 3) {
                        if (tsales1.getModel().getValueAt(i, j) != null) {
                            price = (Integer) tsales1.getModel().getValueAt(i, j);
                            total = price * qty;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfDate.getText()
                                    + "','4010','sales income',0," + total + ",'" + jTextArea1.getText() + "')";
                            DataBase.setExecuteUpdate(sql);
                            System.out.println(sql);
                        } else {
                            JOptionPane.showMessageDialog(tPur1, "Pleae Entry Price");
                            break;
                        }
                    }
                    if (j == 4) {
                        if (tsales1.getModel().getValueAt(i, j) != null) {
                            discount = qty * price * (Integer) tsales1.getModel().getValueAt(i, j) / 100;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfDate.getText()
                                    + "','4020','sales discount'," + discount + ",0,'" + jTextArea1.getText() + "')";
                            System.out.println(sql);
                            DataBase.setExecuteUpdate(sql);
                        }
                    }
                    if (j == 5) {
                        if (tsales1.getModel().getValueAt(i, j) != null) {
                            tax = (qty * price - discount) * (Integer) tsales1.getModel().getValueAt(i, j) / 100;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfDate.getText()
                                    + "','1050','tax out',0," + tax + ",'" + jTextArea1.getText() + "')";
                            System.out.println(sql);
                            DataBase.setExecuteUpdate(sql);
                        }
                    }

                }
                totalvalue = total - discount + tax;
                pay += totalvalue;
                discount = 0;
                tax = 0;
                System.out.println(totalvalue + " " + pay);
            }//SALES PAYMENT SUBMIT
            for (int i = 0; i < tsales2.getRowCount(); i++) {
                for (int j = 0; j < tsales2.getColumnCount(); j++) {
                    if (j == 2) {
                        System.out.println("i ke berepa" + i);
                        System.out.println("col =" + tsales2.getModel().getValueAt(i, 1));
                        if (tsales2.getModel().getValueAt(i, 1).equals("cash")) {
                            if (pay != 0) {
                                if (tsales2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tsales2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfDate.getText()
                                            + "','1010','cash'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                }
                                if (tsales2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfDate.getText()
                                            + "','1010','cash'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                }
                            }
                        }
                        if (tsales2.getModel().getValueAt(i, 1).equals("credit")) {
                            if (pay != 0) {
                                if (tsales2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tsales2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfDate.getText()
                                            + "','1030','account receivable'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                }
                                if (tsales2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfDate.getText()
                                            + "','1030','account receivable'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                }
                            }
                        }
                    }
                }
            }
//        System.out.println(qty + " " + price + " " + discount+" "+tax);
            System.out.println(pay);
            System.out.println(total);
            //to add auto id
            DataBase.jurnalId++;
            DataBase.setExecuteUpdate("UPDATE SYSTEM SET SYSTEM_NUMBER=" + DataBase.jurnalId + " WHERE SYSTEM_DATE ='" + DataBase.date + "-1';");
            System.out.println("UPDATE SYSTEM SET SYSTEM_NUMBER=" + DataBase.jurnalId + " WHERE SYSTEM_DATE ='" + DataBase.date + "-1';");
            jTextArea1.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        //clear text
        tfDate.setText("");
        DefaultTableModel model = (DefaultTableModel) tsales1.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{});
        DefaultTableModel model2 = (DefaultTableModel) tsales2.getModel();
        model2.setRowCount(0);
        model2.addRow(new Object[]{});
    }//GEN-LAST:event_bSubmitActionPerformed
//REMOVE sales PRODUCT BUTTON
    private void bRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveProductActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tsales1.getModel();
            model.removeRow(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bRemoveProductActionPerformed

//add payement sales button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tsales2.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_jButton2ActionPerformed
//remove payment sales button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tsales2.getModel();
            model.removeRow(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

//P U R C H A S I N G
//submit purchasing button
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            int qty = 0, price = 0, total = 0, discount = 0, tax = 0, pay = 0, totalvalue = 0, totalpay = 0;
            for (int i = 0; i < tPur1.getRowCount(); i++) {
                for (int j = 0; j < tPur1.getColumnCount(); j++) {
                    if (j == 2) {
                        if (tPur1.getModel().getValueAt(i, j) != null) {
                            qty = (Integer) tPur1.getModel().getValueAt(i, j);
                        } else {
                            JOptionPane.showMessageDialog(this, "Pleae Entry Qty");
                            break;
                        }
                    }
                    if (j == 3) {
                        if (tPur1.getModel().getValueAt(i, j) != null) {
                            price = (Integer) tPur1.getModel().getValueAt(i, j);
                            total = price * qty;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfPurDate.getText()
                                    + "','5110','purchasing'," + total + ",0,'" + jTextArea2.getText() + "')";
                            DataBase.setExecuteUpdate(sql);
                            System.out.println(sql);
                        } else {
                            JOptionPane.showMessageDialog(this, "Pleae Entry Price");
                            break;
                        }
                    }
                    if (j == 4) {
                        if (tPur1.getModel().getValueAt(i, j) != null) {
                            discount = qty * price * (Integer) tPur1.getModel().getValueAt(i, j) / 100;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfPurDate.getText()
                                    + "','5120','purchasing discount',0," + discount + ",'" + jTextArea2.getText() + "')";
                            System.out.println(sql);
                            DataBase.setExecuteUpdate(sql);
                        }
                    }
                    if (j == 5) {
                        if (tPur1.getModel().getValueAt(i, j) != null) {
                            tax = (qty * price - discount) * (Integer) tPur1.getModel().getValueAt(i, j) / 100;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfPurDate.getText()
                                    + "','1051','tax in'," + tax + ",0,'" + jTextArea2.getText() + "')";
                            System.out.println(sql);
                            DataBase.setExecuteUpdate(sql);
                        }
                    }
                }
                totalvalue = total - discount + tax;
                pay += totalvalue;
                discount = 0;
                tax = 0;
                System.out.println(totalvalue + " " + pay);
            }
            //Purchasing payment 
            for (int i = 0; i < tPur2.getRowCount(); i++) {
                for (int j = 0; j < tPur2.getColumnCount(); j++) {
                    if (j == 2) {
                        if (tPur2.getModel().getValueAt(i, 1) == "cash") {
                            if (pay != 0) {
                                if (tPur2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tPur2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfPurDate.getText()
                                            + "','1010','cash',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                }
                                if (tPur2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfPurDate.getText()
                                            + "','1010','cash',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                }
                            }
                        }
                        if (tPur2.getModel().getValueAt(i, 1) == "credit") {
                            if (pay != 0) {
                                if (tPur2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tPur2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfPurDate.getText()
                                            + "','1030','account receivable',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                }
                                if (tPur2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.date + "-" + tfPurDate.getText()
                                            + "','1030','account receivable',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(pay);
            System.out.println(total);
            //to add auto id
            DataBase.jurnalId++;
            DataBase.setExecuteUpdate("UPDATE SYSTEM SET SYSTEM_NUMBER=" + DataBase.jurnalId + " WHERE SYSTEM_DATE ='" + DataBase.date + "-1';");
            System.out.println("UPDATE SYSTEM SET SYSTEM_NUMBER=" + DataBase.jurnalId + " WHERE SYSTEM_DATE ='" + DataBase.date + "-1';");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        //clear text
        tfPurDate.setText("");
        DefaultTableModel model = (DefaultTableModel) tPur1.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{});
        DefaultTableModel model2 = (DefaultTableModel) tPur2.getModel();
        model2.setRowCount(0);
        model2.addRow(new Object[]{});
        jTextArea2.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed
//purchasing add product button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tPur1.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_jButton5ActionPerformed
//purchasing remove product button
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tPur1.getModel();
            model.removeRow(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton12ActionPerformed
//purchasing add payment button
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tPur2.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_jButton13ActionPerformed
//purchasing remove payment button
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tPur2.getModel();
            model.removeRow(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void salesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_salesComponentShown
        DataBase.jurnalShow = 1;
        System.out.println("juranl show" + DataBase.jurnalShow);
    }//GEN-LAST:event_salesComponentShown

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        DataBase.jurnalShow = 2;
        System.out.println("juranl show" + DataBase.jurnalShow);
    }//GEN-LAST:event_jPanel2ComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddProdcut;
    private javax.swing.JButton bRemoveProduct;
    private javax.swing.JButton bSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cPurFrom;
    private javax.swing.JComboBox<String> cSalesTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel sales;
    private javax.swing.JTable tPur1;
    private javax.swing.JTable tPur2;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfPurDate;
    private javax.swing.JTable tsales1;
    private javax.swing.JTable tsales2;
    // End of variables declaration//GEN-END:variables
}
