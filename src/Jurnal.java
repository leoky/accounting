
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.sql.Statement;
import javax.swing.Action;
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
    JComboBox cExpend = new JComboBox();

    String chartid;
    String chartname;
    int pay = 0;

    public void setUpdateCombo() {
        cProduct.removeAllItems();
        setComboProduct();
    }

    public void setComboExpend() {
        try {
            Statement st = DataBase.getStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM chart where chart_id like '6%'");
            while (rs.next()) {
                cExpend.addItem(rs.getString("chart_name"));
            }
            cExpend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    try {
                        if (DataBase.jurnalShow == 3) {
                            tExped1.setValueAt(cExpend.getSelectedItem(), tExped1.getSelectedRow(), 1);
                        }
                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setComboPayment() {
        cPayment.addItem("cash");
        cPayment.addItem("credit");
        cPayment.addItem("giro");
        cPayment.addItem("bank");
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
                    if (DataBase.jurnalShow == 4) {
                        tExpend2.setValueAt(cPayment.getSelectedItem(), tExpend2.getSelectedRow(), 1);
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
            ResultSet rs = st.executeQuery("SELECT * FROM product");
            while (rs.next()) {
                cProduct.addItem(rs.getString("product_name"));
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
        setComboExpend();
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
        tExped1.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cExpend));
        tExpend2.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cPayment));
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
        jButton15 = new javax.swing.JButton();
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
        jButton16 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        tfPrivetDate = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cPrivet = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        tfPrivetPrice = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        taPrivetDesc = new javax.swing.JTextArea();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tExped1 = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tExpend2 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setLayout(new java.awt.BorderLayout());

        jTabbedPane8.setBackground(new java.awt.Color(248, 238, 160));

        sales.setBackground(new java.awt.Color(248, 238, 160));
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

        jButton2.setForeground(new java.awt.Color(51, 102, 255));
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

        jButton15.setText("REFRESH");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salesLayout = new javax.swing.GroupLayout(sales);
        sales.setLayout(salesLayout);
        salesLayout.setHorizontalGroup(
            salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(salesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(92, 92, 92)
                                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfDate)
                                    .addComponent(cSalesTo, 0, 236, Short.MAX_VALUE))))
                        .addGap(104, 104, 104)
                        .addComponent(jButton15))
                    .addGroup(salesLayout.createSequentialGroup()
                        .addComponent(bAddProdcut)
                        .addGap(28, 28, 28)
                        .addComponent(bRemoveProduct))
                    .addComponent(jScrollPane1)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(bSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(115, 115, 115))
        );
        salesLayout.setVerticalGroup(
            salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15))
                .addGap(18, 18, 18)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cSalesTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bRemoveProduct)
                    .addComponent(bAddProdcut))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bSubmit)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(salesLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addContainerGap(1614, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("SALES", sales);

        jPanel2.setBackground(new java.awt.Color(248, 238, 160));
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

        jButton7.setText("CANCEL");

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

        jButton16.setText("REFRESH");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cPurFrom, 0, 159, Short.MAX_VALUE)
                            .addComponent(tfPurDate))
                        .addGap(61, 61, 61)
                        .addComponent(jButton16))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 264, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfPurDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cPurFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14)
                    .addComponent(jButton13))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1604, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("PURCHASING", jPanel2);

        jPanel4.setBackground(new java.awt.Color(248, 238, 160));
        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel20.setText("Date");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel21.setText("Description");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel22.setText("Payment");

        cPrivet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cash", "bank", "credit", "giro" }));
        cPrivet.setName(""); // NOI18N

        jButton9.setText("Submit");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel24.setText("Price");

        tfPrivetPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrivetPriceActionPerformed(evt);
            }
        });

        jButton10.setText("REFRESH");

        taPrivetDesc.setColumns(20);
        taPrivetDesc.setRows(5);
        jScrollPane8.setViewportView(taPrivetDesc);

        jButton20.setText("ADD");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("CANCEL");

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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tfPrivetDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton10))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(cPrivet, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfPrivetPrice))))
                .addContainerGap(807, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrivetDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel21))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cPrivet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tfPrivetPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1655, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(93, 93, 93))
        );

        jTabbedPane8.addTab("PRIVET", jPanel4);

        jPanel6.setBackground(new java.awt.Color(248, 238, 160));

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
                .addContainerGap(696, Short.MAX_VALUE))
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
                .addContainerGap(2033, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("RETURN", jPanel6);

        jPanel7.setBackground(new java.awt.Color(248, 238, 160));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1237, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2204, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("tab6", jPanel7);

        jPanel3.setBackground(new java.awt.Color(248, 238, 160));
        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel17.setText("Date");

        jButton8.setText("Submit");

        tExped1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tExped1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "TYPE", "TYPE", "PRICE", "DISCOUNT", "TAX"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tExped1.setPreferredSize(new java.awt.Dimension(375, 250));
        tExped1.setRowHeight(25);
        jScrollPane7.setViewportView(tExped1);

        jButton17.setText("SEARCH");

        tExpend2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tExpend2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PAYMENT", "PAYMENT", "PERCENT", "COMMMENT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
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
        tExpend2.setMaximumSize(new java.awt.Dimension(2147483647, 75));
        tExpend2.setMinimumSize(new java.awt.Dimension(60, 75));
        tExpend2.setPreferredSize(new java.awt.Dimension(300, 75));
        tExpend2.setRowHeight(25);
        jScrollPane9.setViewportView(tExpend2);

        jButton18.setText("SUBMIT");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("CANCEL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton17))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton18)
                        .addGap(65, 65, 65)
                        .addComponent(jButton19)))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1654, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(23, 23, 23))
        );

        jTabbedPane8.addTab("OPERASIONAL", jPanel3);

        add(jTabbedPane8, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void tfPrivetPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrivetPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrivetPriceActionPerformed

//add product sales button
    private void bAddProdcutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddProdcutActionPerformed
        DefaultTableModel model = (DefaultTableModel) tsales1.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_bAddProdcutActionPerformed
//summit sales button
    private void bSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitActionPerformed
        try {
            int qty = 0, price = 0, total = 0, discount = 0, tax = 0, pay = 0, totalvalue = 0, totalpay = 0, taxper = 0, discountper = 0;
            for (int i = 0; i < tsales1.getRowCount(); i++) {
                for (int j = 0; j < tsales1.getColumnCount(); j++) {
                    if (j == 2) {
                        if (tsales1.getModel().getValueAt(i, j) != null) {
                            qty = (Integer) tsales1.getModel().getValueAt(i, j);
                        } else {
                            JOptionPane.showMessageDialog(this, "Pleae Entry Qty");
                            break;
                        }
                    }
                    if (j == 3) {
                        if (tsales1.getModel().getValueAt(i, j) != null) {
                            price = (Integer) tsales1.getModel().getValueAt(i, j);
                            total = price;
                            DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                    + "','4010','sales income',0," + total * qty + ",'" + jTextArea1.getText() + "')");
                            System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                    + "','4010','sales income',0," + total * qty + ",'" + jTextArea1.getText() + "')");

                        } else {
                            JOptionPane.showMessageDialog(this, "Pleae Entry Price");
                            break;
                        }
                    }
                    if (j == 4) {
                        if (tsales1.getModel().getValueAt(i, j) != null) {
                            discountper = (Integer) tsales1.getModel().getValueAt(i, j);
                            discount = price * discountper / 100;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                    + "','4020','sales discount'," + discount * qty + ",0,'" + jTextArea1.getText() + "')";
                            System.out.println(sql);
                            DataBase.setExecuteUpdate(sql);
                        } else {
                            discount = 0;
                        }
                    }
                    if (j == 5) {
                        if (tsales1.getModel().getValueAt(i, j) != null) {
                            taxper = (Integer) tsales1.getModel().getValueAt(i, j);
                            tax = (price - discount) * taxper / 100;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                    + "','1050','tax out',0," + tax * qty + ",'" + jTextArea1.getText() + "')";
                            System.out.println(sql);
                            DataBase.setExecuteUpdate(sql);
                        } else {
                            tax = 0;
                        }
                    }
                }
                totalvalue = (total - discount + tax) * qty;

                DataBase.setExecuteUpdate("INSERT INTO INVENTORY VALUES('S" + DataBase.salesId + "','" + DataBase.jurnalDate + "-" + tfDate.getText() + "', 'J" + DataBase.jurnalId + "','"
                        + tsales1.getModel().getValueAt(i, 1) + "',0,0,0," + qty + "," + (total - discount + tax) + ","
                        + totalvalue + ",'sales','" + cSalesTo.getSelectedItem() + "'," + discountper + "," + taxper + "," + price + ")");
                System.out.println("INSERT INTO INVENTORY VALUES('S" + DataBase.salesId + "','" + DataBase.jurnalDate + "-" + tfDate.getText() + "', 'J" + DataBase.jurnalId + "','"
                        + tsales1.getModel().getValueAt(i, 1) + "',0,0,0," + qty + "," + (total - discount + tax) + ","
                        + totalvalue + ",'sales','" + cSalesTo.getSelectedItem() + "'," + discountper + "," + taxper + "," + price + ")");

                DataBase.setExecuteUpdate("INSERT INTO INVOICE(INVENTORY_ID ,JURNAL_DATE, JURNAL_ID,PAYMENT_ID) VALUES('S" + DataBase.salesId + "','" + DataBase.jurnalDate + "-"
                        + tfDate.getText() + "', 'J" + DataBase.jurnalId + "','Y" + DataBase.payId + "')");
                System.out.println("INSERT INTO INVOICE(INVENTORY_ID ,JURNAL_DATE, JURNAL_ID,PAYMENT_ID) VALUES('S" + DataBase.salesId + "','" + DataBase.jurnalDate + "-"
                        + tfDate.getText() + "', 'J" + DataBase.jurnalId + "','Y" + DataBase.payId + "')");

                pay += totalvalue;
                discount = 0;
                tax = 0;
                taxper = 0;
                discountper = 0;
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
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                            + "','1010','cash'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CASH','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tsales2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CASH','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tsales2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                }
                                if (tsales2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                            + "','1010','cash'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CASH','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CASH','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                }
                            }
                        }
                        if (tsales2.getModel().getValueAt(i, 1).equals("credit")) {
                            if (pay != 0) {
                                if (tsales2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tsales2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                            + "','1030','account receivable'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CREDIT','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tsales2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CREDIT','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tsales2.getModel().getValueAt(i, j) + "," + totalpay + ")");

                                }
                                if (tsales2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                            + "','1030','account receivable'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CREDIT','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CREDIT','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");

                                }
                            }
                        }
                        if (tsales2.getModel().getValueAt(i, 1).equals("bank")) {
                            if (pay != 0) {
                                if (tsales2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tsales2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','BANK','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tsales2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','bank','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tsales2.getModel().getValueAt(i, j) + "," + totalpay + ")");

                                }
                                if (tsales2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','Bank','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','Bank','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");

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
            DataBase.salesId++;
            DataBase.payId++;

            DataBase.setExecuteUpdate("UPDATE SYSTEM SET SYSTEM_JURNAL=" + DataBase.jurnalId + ", SYSTEM_SALES =" + DataBase.salesId + " , SYSTEM_PUR = " + DataBase.purId
                    + ",  SYSTEM_PAY = " + DataBase.payId + " WHERE SYSTEM_DATE ='" + DataBase.jurnalDate + "-1';");
            System.out.println("UPDATE SYSTEM SET SYSTEM_JURNAL=" + DataBase.jurnalId + ", SYSTEM_SALES =" + DataBase.salesId + " , SYSTEM_PUR = " + DataBase.purId
                    + ",  SYSTEM_PAY = " + DataBase.payId + " WHERE SYSTEM_DATE ='" + DataBase.jurnalDate + "-1';");
            jTextArea1.setText("");

            //icon detail
            Detail.setCash(DataBase.date);
            Detail.setBank(DataBase.date);
            //

            //clear text
            tfDate.setText("");
            DefaultTableModel model = (DefaultTableModel) tsales1.getModel();
            model.setRowCount(0);
            model.addRow(new Object[]{});
            DefaultTableModel model2 = (DefaultTableModel) tsales2.getModel();
            model2.setRowCount(0);
            model2.addRow(new Object[]{});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_bSubmitActionPerformed
//REMOVE sales PRODUCT BUTTON
    private void bRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveProductActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tsales1.getModel();
            model.removeRow(tsales1.getSelectedRow());
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
            model.removeRow(tsales2.getSelectedRow());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

//P U R C H A S I N G
//submit purchasing button
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            int qty = 0, price = 0, total = 0, discount = 0, tax = 0, pay = 0, totalvalue = 0, totalpay = 0, taxper = 0, discountper = 0;;
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
                            total = price;
                            DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                    + "','5110','purchasing'," + total * qty + ",0,'" + jTextArea2.getText() + "')");
                            System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                    + "','5110','purchasing'," + total * qty + ",0,'" + jTextArea2.getText() + "')");

                        } else {
                            JOptionPane.showMessageDialog(this, "Pleae Entry Price");
                            break;
                        }
                    }
                    if (j == 4) {
                        if (tPur1.getModel().getValueAt(i, j) != null) {
                            discountper = (Integer) tPur1.getModel().getValueAt(i, j);
                            discount = price * discountper / 100;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                    + "','5120','purchasing discount',0," + discount * qty + ",'" + jTextArea2.getText() + "')";
                            System.out.println(sql);
                            DataBase.setExecuteUpdate(sql);
                        }
                    }
                    if (j == 5) {
                        if (tPur1.getModel().getValueAt(i, j) != null) {
                            taxper = (Integer) tPur1.getModel().getValueAt(i, j);
                            tax = (price - discount) * taxper / 100;
                            String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                    + "','1051','tax in'," + tax * qty + ",0,'" + jTextArea2.getText() + "')";
                            System.out.println(sql);
                            DataBase.setExecuteUpdate(sql);
                        }
                    }
                }

                totalvalue = (total - discount + tax) * qty;
                DataBase.setExecuteUpdate("INSERT INTO inventory VALUES('P" + DataBase.purId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "', 'J" + DataBase.jurnalId + "','"
                        + tPur1.getModel().getValueAt(i, 1) + "'," + qty + "," + (total - discount + tax) + ","
                        + totalvalue + ",0,0,0,'purchase','" + cPurFrom.getSelectedItem() + "'," + discountper + "," + taxper + "," + price + ")");
                System.out.println("INSERT INTO inventory VALUES('P" + DataBase.purId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "', 'J" + DataBase.jurnalId + "','"
                        + tPur1.getModel().getValueAt(i, 1) + "'," + qty + "," + (total - discount + tax) + ","
                        + totalvalue + ",0,0,0,'purchase','" + cPurFrom.getSelectedItem() + "'," + discountper + "," + taxper + "," + price + ")");
                DataBase.setExecuteUpdate("INSERT INTO INVOICE(INVENTORY_ID ,JURNAL_DATE, JURNAL_ID,PAYMENT_ID) VALUES('P" + DataBase.purId + "','" + DataBase.jurnalDate + "-"
                        + tfPurDate.getText() + "', 'J" + DataBase.jurnalId + "','Y" + DataBase.payId + "')");
                System.out.println("INSERT INTO INVOICE(INVENTORY_ID ,JURNAL_DATE, JURNAL_ID,PAYMENT_ID) VALUES('P" + DataBase.purId + "','" + DataBase.jurnalDate + "-"
                        + tfPurDate.getText() + "', 'J" + DataBase.jurnalId + "','Y" + DataBase.payId + "')");
                pay += totalvalue;
                discount = 0;
                tax = 0;
                taxper = 0;
                discountper = 0;
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
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                            + "','1010','cash',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CASH','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tPur2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CASH','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tPur2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                }
                                if (tPur2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                            + "','1010','cash',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CASH','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CASH','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                }
                            }
                        }
                        if (tPur2.getModel().getValueAt(i, 1) == "credit") {
                            if (pay != 0) {
                                if (tPur2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tPur2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                            + "','2020','account payable',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CREDIT','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tPur2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CREDIT','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tPur2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                }
                                if (tPur2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                            + "','2020','account payable',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CREDIT','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','CREDIT','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                }
                            }
                        }
                        if (tPur2.getModel().getValueAt(i, 1) == "bank") {
                            if (pay != 0) {
                                if (tPur2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tPur2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','BANK','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tPur2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','BANK','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tPur2.getModel().getValueAt(i, j) + "," + totalpay + ")");
                                }
                                if (tPur2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','BANK','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE)"
                                            + " VALUES ('Y" + DataBase.payId + "','BANK','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ")");
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
            DataBase.purId++;
            DataBase.payId++;
            //icon detail
            Detail.setCash(DataBase.date);
            Detail.setBank(DataBase.date);
            //
            //clear text
            tfPurDate.setText("");
            DefaultTableModel model = (DefaultTableModel) tPur1.getModel();
            model.setRowCount(0);
            model.addRow(new Object[]{});
            DefaultTableModel model2 = (DefaultTableModel) tPur2.getModel();
            model2.setRowCount(0);
            model2.addRow(new Object[]{});
            jTextArea2.setText("");
            DataBase.setExecuteUpdate("UPDATE SYSTEM SET SYSTEM_JURNAL=" + DataBase.jurnalId + ", SYSTEM_SALES =" + DataBase.salesId + " , SYSTEM_PUR = " + DataBase.purId
                    + ",  SYSTEM_PAY = " + DataBase.payId + " WHERE SYSTEM_DATE ='" + DataBase.jurnalDate + "-1';");
            System.out.println("UPDATE SYSTEM SET SYSTEM_JURNAL=" + DataBase.jurnalId + ", SYSTEM_SALES =" + DataBase.salesId + " , SYSTEM_PUR = " + DataBase.purId
                    + ",  SYSTEM_PAY = " + DataBase.payId + " WHERE SYSTEM_DATE ='" + DataBase.jurnalDate + "-1';");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

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
            model.removeRow(tPur1.getSelectedRow());
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
            model.removeRow(tPur1.getSelectedRow());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void salesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_salesComponentShown
        DataBase.jurnalShow = 1;
        System.out.println("jurnal show " + DataBase.jurnalShow);
//        Detail.setJurnalDetail("(SALES)");
    }//GEN-LAST:event_salesComponentShown

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        Detail.setJurnalDetail("(PURCHASING)");
        DataBase.jurnalShow = 2;
        System.out.println("jurnal show " + DataBase.jurnalShow);

    }//GEN-LAST:event_jPanel2ComponentShown
//SALES REFRESH
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        setUpdateCombo();
    }//GEN-LAST:event_jButton15ActionPerformed
//PURCHE REFRESH
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        setUpdateCombo();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        DataBase.jurnalShow = 3;
        System.out.println("jurnal show " + DataBase.jurnalShow);
        Detail.setJurnalDetail(" (OPERASIONAL)");
    }//GEN-LAST:event_jPanel3ComponentShown

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentShown
        DataBase.jurnalShow = 4;
        System.out.println("jurnal show " + DataBase.jurnalShow);
        Detail.setJurnalDetail(" (PRIVET) ");
    }//GEN-LAST:event_jPanel4ComponentShown
// privet 
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        try {
            if (tfPrivetPrice.getText() != null) {
                DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPrivetDate.getText()
                        + "','3030','privet'," + tfPrivetPrice.getText() + ",0,'" + taPrivetDesc.getText() + "')");
            }
            if (cPrivet.getSelectedItem() == "cash") {
                DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPrivetDate.getText()
                        + "','1010','cash',0," + tfPrivetPrice.getText() + ",'" + taPrivetDesc.getText() + "')");
            }
            if (cPrivet.getSelectedItem() == "credit") {
                DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPrivetDate.getText()
                        + "','2020','account payable',0," + tfPrivetPrice.getText() + ",'" + taPrivetDesc.getText() + "')");
            }
            if (cPrivet.getSelectedItem() == "bank") {
                DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPrivetDate.getText()
                        + "','1020','bank',0," + tfPrivetPrice.getText() + ",'" + taPrivetDesc.getText() + "')");
            }
            //id
            DataBase.jurnalId++;

            DataBase.setExecuteUpdate("UPDATE SYSTEM SET SYSTEM_JURNAL=" + DataBase.jurnalId + ", SYSTEM_SALES =" + DataBase.salesId + " , SYSTEM_PUR = " + DataBase.purId
                    + ",  SYSTEM_PAY = " + DataBase.payId + " WHERE SYSTEM_DATE ='" + DataBase.jurnalDate + "-1';");
            System.out.println("UPDATE SYSTEM SET SYSTEM_JURNAL=" + DataBase.jurnalId + ", SYSTEM_SALES =" + DataBase.salesId + " , SYSTEM_PUR = " + DataBase.purId
                    + ",  SYSTEM_PAY = " + DataBase.payId + " WHERE SYSTEM_DATE ='" + DataBase.jurnalDate + "-1';");
            //icon detail
            Detail.setCash(DataBase.date);
            Detail.setBank(DataBase.date);
            //           
            //clear 
            tfPrivetDate.setText("");
            tfPrivetPrice.setText("");
            taPrivetDesc.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton20ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddProdcut;
    private javax.swing.JButton bRemoveProduct;
    private javax.swing.JButton bSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cPrivet;
    private javax.swing.JComboBox<String> cPurFrom;
    private javax.swing.JComboBox<String> cSalesTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel sales;
    private javax.swing.JTable tExped1;
    private javax.swing.JTable tExpend2;
    private javax.swing.JTable tPur1;
    private javax.swing.JTable tPur2;
    private javax.swing.JTextArea taPrivetDesc;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfPrivetDate;
    private javax.swing.JTextField tfPrivetPrice;
    private javax.swing.JTextField tfPurDate;
    private javax.swing.JTable tsales1;
    private javax.swing.JTable tsales2;
    // End of variables declaration//GEN-END:variables
}
