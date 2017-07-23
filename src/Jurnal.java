
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

    Statement st = DataBase.getStatement();
    ResultSet rs;
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
    String giroDate;

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
//                            tExped1.setValueAt(cExpend.getSelectedItem(), tExped1.getSelectedRow(), 1);
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
//                    if (DataBase.jurnalShow == 4) {
//                        tExpend2.setValueAt(cPayment.getSelectedItem(), tExpend2.getSelectedRow(), 1);
//                    }
                    if (cPayment.getSelectedItem() == "giro") {
                        giroDate = JOptionPane.showInputDialog("DUE DATE");
                        System.out.println("due date :" + giroDate);
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
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void setComboCustomer() {
        try {
            Statement st = DataBase.getStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER");
            while (rs.next()) {
                cSalesTo.addItem(rs.getString("cust_name"));
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void setComboSupplier() {
        try {
            Statement st = DataBase.getStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Supplier");
            while (rs.next()) {
                cPurFrom.addItem(rs.getString("sup_name"));
            }
            rs.close();
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
        setComboSupplier();
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
//        tExped1.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cExpend));
//        tExpend2.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cPayment));
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
        jComboBox1 = new javax.swing.JComboBox<>();
        tfConvert = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfConvertPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        taConvertDesc = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfPaymentDate = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        tfPaymentPrice = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        taPaymentDesc = new javax.swing.JTextArea();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        tfOpDate = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cOpPay = new javax.swing.JComboBox<>();
        jButton26 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        tfOpPrice = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        taOpDesc = new javax.swing.JTextArea();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        cOperasionalType = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setLayout(new java.awt.BorderLayout());

        jTabbedPane8.setBackground(new java.awt.Color(248, 238, 160));
        jTabbedPane8.setFocusable(false);
        jTabbedPane8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sales.setBackground(new java.awt.Color(248, 238, 160));
        sales.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                salesComponentShown(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("DATE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("TO");

        tfDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jButton1.setText("CANCEL");

        bSubmit.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        bSubmit.setForeground(new java.awt.Color(0, 155, 0));
        bSubmit.setText("SUBMIT");
        bSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitActionPerformed(evt);
            }
        });

        cSalesTo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
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
                .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salesLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
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
                    .addGroup(salesLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(bSubmit)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(200, 200, 200))
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
                        .addGap(32, 32, 32)
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(salesLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSubmit))))
                .addContainerGap(1798, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("SALES", sales);

        jPanel2.setBackground(new java.awt.Color(248, 238, 160));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("DATE");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("FROM");

        tfPurDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        cPurFrom.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jButton5.setText("Add Product");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton6.setText("SUBMIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("DESCRIPTION");

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addGap(60, 60, 60)
                        .addComponent(jButton16))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5))
                .addGap(0, 295, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfPurDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1793, Short.MAX_VALUE))
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

        tfPrivetDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel21.setText("Description");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel22.setText("Payment");

        cPrivet.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cPrivet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cash", "bank", "credit", "giro" }));
        cPrivet.setName(""); // NOI18N

        jButton9.setText("Submit");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel24.setText("Price");

        tfPrivetPrice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tfPrivetPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrivetPriceActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton10.setText("REFRESH");

        taPrivetDesc.setColumns(20);
        taPrivetDesc.setRows(5);
        jScrollPane8.setViewportView(taPrivetDesc);

        jButton20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton20.setText("ADD");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
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
                            .addComponent(jScrollPane8)
                            .addComponent(cPrivet, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfPrivetPrice))))
                .addContainerGap(840, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1844, Short.MAX_VALUE)
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
                .addContainerGap(749, Short.MAX_VALUE))
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
                .addContainerGap(2232, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("RETURN", jPanel6);

        jPanel7.setBackground(new java.awt.Color(248, 238, 160));
        jPanel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentShown(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cash", "bank" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        tfConvert.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jButton22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton22.setText("SUBMIT");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("TO");

        tfConvertPrice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("DATE");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("PRICE");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        taConvertDesc.setColumns(20);
        taConvertDesc.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        taConvertDesc.setRows(5);
        jScrollPane10.setViewportView(taConvertDesc);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("DESCRIPTION");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(tfConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfConvertPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(812, 812, 812))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfConvertPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel8)))
                .addGap(39, 39, 39)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1968, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("CONVERT", jPanel7);

        jPanel1.setBackground(new java.awt.Color(248, 238, 160));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("DATE");

        tfPaymentDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sales", "purchase" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("PRICE");

        tfPaymentPrice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setText("PAY BY");

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cash", "bank", "giro" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setText("DESC");

        taPaymentDesc.setColumns(20);
        taPaymentDesc.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        taPaymentDesc.setRows(5);
        jScrollPane11.setViewportView(taPaymentDesc);

        jButton23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton23.setText("ADD");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton24.setText("CANCEL");

        jButton25.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton25.setText("REFRESH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfPaymentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(36, 36, 36)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(183, 183, 183)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(62, 62, 62)
                                .addComponent(tfPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButton25))
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jButton23)
                        .addGap(68, 68, 68)
                        .addComponent(jButton24)))
                .addContainerGap(431, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25))
                .addGap(37, 37, 37)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPaymentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(jButton24))
                .addContainerGap(1970, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("PAYMENT", jPanel1);

        jPanel5.setBackground(new java.awt.Color(248, 238, 160));
        jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentShown(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel23.setText("Date");

        tfOpDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel30.setText("Description");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel31.setText("Payment");

        cOpPay.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cOpPay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cash", "bank", "credit", "giro" }));
        cOpPay.setName(""); // NOI18N

        jButton26.setText("Submit");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel32.setText("Price");

        tfOpPrice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tfOpPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOpPriceActionPerformed(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton27.setText("REFRESH");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        taOpDesc.setColumns(20);
        taOpDesc.setRows(5);
        jScrollPane12.setViewportView(taOpDesc);

        jButton28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton28.setText("ADD");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton29.setText("CANCEL");

        cOperasionalType.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setText("Type");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton26)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel16))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tfOpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jButton27))
                            .addComponent(cOpPay, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfOpPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cOperasionalType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(306, 306, 306))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton27)
                            .addComponent(jLabel30))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cOperasionalType, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(cOpPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfOpPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1862, Short.MAX_VALUE)
                .addComponent(jButton26)
                .addGap(93, 93, 93))
        );

        jTabbedPane8.addTab("OPERSIONAL", jPanel5);

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
//                        
                        if (tsales2.getModel().getValueAt(i, 1).equals("giro")) {
                            if (pay != 0) {
                                if (tsales2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tsales2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                            + "','1070','giro receivable'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);

//                                    DataBase.jurnalId++;
//                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1070','giro receivable',0," + totalpay + ",'" + jTextArea1.getText() + "')");
//                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1070','giro receivable',0," + totalpay + ",'" + jTextArea1.getText() + "')");
//
//                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')");
//                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')");
//                                    DataBase.jurnalId--;
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE,payment_date)"
                                            + " VALUES ('Y" + DataBase.payId + "','GIRO','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tsales2.getModel().getValueAt(i, j) + "," + totalpay + ",'" + giroDate + "')");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE,payment_date)"
                                            + " VALUES ('Y" + DataBase.payId + "','giro','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tsales2.getModel().getValueAt(i, j) + "," + totalpay + ",'" + giroDate + "')");
//                                    DataBase.jurnalId++;
                                }
                                if (tsales2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfDate.getText()
                                            + "','1070','giro receivable'," + totalpay + ",0,'" + jTextArea1.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);

//                                    DataBase.jurnalId++;
//                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1070','giro receivable',0," + totalpay + ",'" + jTextArea1.getText() + "')");
//                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1070','giro receivable',0," + totalpay + ",'" + jTextArea1.getText() + "')");
//
//                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')");
//                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')");
//                                    DataBase.jurnalId--;
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE,payment_date)"
                                            + " VALUES ('Y" + DataBase.payId + "','giro','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ",'" + giroDate + "')");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE,payment_date)"
                                            + " VALUES ('Y" + DataBase.payId + "','giro','" + DataBase.jurnalDate + "-" + tfDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ",'" + giroDate + "')");
//                                    DataBase.jurnalId++;
                                }
                            }
                        }
                    }
                }
            }
//        System.out.println(qty + " " + price + " " + discount+" "+tax);
            //add giro jurnal
            for (int i = 0; i < tsales2.getRowCount(); i++) {
                for (int j = 0; j < tsales2.getColumnCount(); j++) {
                    if (j == 2) {
                        if (tsales2.getModel().getValueAt(i, 1) == "giro") {
                            if (pay != 0) {
                                if (tsales2.getModel().getValueAt(i, j) != null) {
                                    DataBase.jurnalId++;
                                    totalpay = pay * (Integer) tsales2.getModel().getValueAt(i, j) / 100;
                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1070','giro receivable',0," + totalpay + ",'" + jTextArea1.getText() + "')");
                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1070','giro receivable',0," + totalpay + ",'" + jTextArea1.getText() + "')");

                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')");
                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')");
                                }
                                if (tsales2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    DataBase.jurnalId++;
                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1070','giro receivable',0," + totalpay + ",'" + jTextArea1.getText() + "')");
                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1070','giro receivable',0," + totalpay + ",'" + jTextArea1.getText() + "')");

                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')");
                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1020','bank'," + totalpay + ",0,'" + jTextArea1.getText() + "')");
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
                        if (tPur2.getModel().getValueAt(i, 1) == "giro") {
                            if (pay != 0) {
                                if (tPur2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tPur2.getModel().getValueAt(i, j) / 100;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                            + "','2030','giro payable',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);

//                                    DataBase.jurnalId++;
//                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','2030','giro payable'," + totalpay + ",0,'" + jTextArea2.getText() + "')");
//                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','2030','giro payable'," + totalpay + ",0,'" + jTextArea2.getText() + "')");
//
//                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')");
//                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')");
//                                    DataBase.jurnalId--;
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE,payment_date)"
                                            + " VALUES ('Y" + DataBase.payId + "','GIRO','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tPur2.getModel().getValueAt(i, j) + "," + totalpay + ",'" + giroDate + "')");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE,payment_date)"
                                            + " VALUES ('Y" + DataBase.payId + "','giro','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + tPur2.getModel().getValueAt(i, j) + "," + totalpay + ",'" + giroDate + "')");
//                                    DataBase.jurnalId++;
                                }
                                if (tPur2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    String sql = "INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPurDate.getText()
                                            + "','2030','giro payable',0," + totalpay + ",'" + jTextArea2.getText() + "')";
                                    System.out.println(sql);
                                    DataBase.setExecuteUpdate(sql);

//                                    DataBase.jurnalId++;
//                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','2030','giro payable'," + totalpay + ",0,'" + jTextArea2.getText() + "')");
//                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','2030','giro payable'," + totalpay + ",0,'" + jTextArea2.getText() + "')");
//
//                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')");
//                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
//                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')");
//                                    DataBase.jurnalId--;
                                    DataBase.setExecuteUpdate("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE,payment_date)"
                                            + " VALUES ('Y" + DataBase.payId + "','GIRO','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ",'" + giroDate + "')");
                                    System.out.println("INSERT INTO PAYMENT(PAYMENT_ID, PAYMENT_TYPE, JURNAL_DATE, JURNAL_ID, PAYMENT_PERCENT, PAYMENT_VALUE,payment_date)"
                                            + " VALUES ('Y" + DataBase.payId + "','giro','" + DataBase.jurnalDate + "-" + tfPurDate.getText() + "','J" + DataBase.jurnalId
                                            + "'," + 0 + "," + totalpay + ",'" + giroDate + "')");
//                                    DataBase.jurnalId++;
                                }
                            }
                        }
                    }
                }
            }
            //add giro jurnal
            for (int i = 0; i < tPur2.getRowCount(); i++) {
                for (int j = 0; j < tPur2.getColumnCount(); j++) {
                    if (j == 2) {
                        if (tPur2.getModel().getValueAt(i, 1) == "giro") {
                            if (pay != 0) {
                                if (tPur2.getModel().getValueAt(i, j) != null) {
                                    totalpay = pay * (Integer) tPur2.getModel().getValueAt(i, j) / 100;
                                    DataBase.jurnalId++;
                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','2030','giro payable'," + totalpay + ",0,'" + jTextArea2.getText() + "')");
                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','2030','giro payable'," + totalpay + ",0,'" + jTextArea2.getText() + "')");

                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')");
                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')");
                                }
                                if (tPur2.getModel().getValueAt(i, j) == null) {
                                    totalpay = pay;
                                    DataBase.jurnalId++;
                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','2030','giro payable'," + totalpay + ",0,'" + jTextArea2.getText() + "')");
                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','2030','giro payable'," + totalpay + ",0,'" + jTextArea2.getText() + "')");

                                    System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')");
                                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate
                                            + "','1020','bank',0," + totalpay + ",'" + jTextArea2.getText() + "')");
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
//            JOptionPane.showMessageDialog(this, e);
            e.printStackTrace();
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
        Detail.setJurnalDetail("");
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
//convert 
    private void jPanel7ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentShown
        DataBase.jurnalShow = 5;
        System.out.println("jurnal show " + DataBase.jurnalShow);
        Detail.setJurnalDetail(" (CONVERT) ");
    }//GEN-LAST:event_jPanel7ComponentShown

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //CONVERT COMBO BOX
        if (jComboBox1.getSelectedItem() == "cash") {
            jLabel7.setText("BANK");
        }
        if (jComboBox1.getSelectedItem() == "bank") {
            jLabel7.setText("CASH");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        //CONVERT
        try {
            String a = null, b = null;
            if (tfConvert.getText() != null) {
                if (jComboBox1.getSelectedItem() == "cash") {
                    a = "0," + tfConvertPrice.getText();
                    b = tfConvertPrice.getText() + ",0";
                }
                if (jComboBox1.getSelectedItem() == "bank") {
                    a = tfConvertPrice.getText() + ",0";
                    b = "0," + tfConvertPrice.getText();
                }
            }
            System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfConvert.getText()
                    + "','1010','cash'," + a + ",'" + taConvertDesc.getText() + "')");
            DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfConvert.getText()
                    + "','1010','cash'," + a + ",'" + taConvertDesc.getText() + "')");
            System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfConvert.getText()
                    + "','1020','bank'," + b + ",'" + taConvertDesc.getText() + "')");
            DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfConvert.getText()
                    + "','1020','bank'," + b + ",'" + taConvertDesc.getText() + "')");
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
            tfConvert.setText("");
            tfConvertPrice.setText("");
            taConvertDesc.setText("");
            jLabel7.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton22ActionPerformed
//PAYMENT
    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        DataBase.jurnalShow = 6;
        System.out.println("jurnal show " + DataBase.jurnalShow);
        Detail.setJurnalDetail(" (PAYMENT) ");
    }//GEN-LAST:event_jPanel1ComponentShown

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        //payment combo
        if (jComboBox3.getSelectedItem() == "giro") {
            giroDate = JOptionPane.showInputDialog("DUE DATE");
            System.out.println("due date :" + giroDate);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String a = null, b = null;
        try {
            if (jComboBox2.getSelectedItem() == "sales") {
                if (jComboBox3.getSelectedItem() == "cash") {
                    a = "'1030','account receivable',0," + tfPaymentPrice.getText();
                    b = "'1010','cash'," + tfPaymentPrice.getText() + ",0";
                }
                if (jComboBox3.getSelectedItem() == "bank") {
                    a = "'1030','account receivable',0," + tfPaymentPrice.getText();
                    b = "'1020','bank'," + tfPaymentPrice.getText() + ",0";
                }
                if (jComboBox3.getSelectedItem() == "giro") {
                    a = "'1070','giro receivable'," + tfPaymentPrice.getText() + ",0";
                    b = "'1030','account receivable',0," + tfPaymentPrice.getText();
                }
            }
            if (jComboBox2.getSelectedItem() == "purchase") {
                if (jComboBox3.getSelectedItem() == "cash") {
                    a = "'2020','account payable'," + tfPaymentPrice.getText() + ",0";
                    b = "'1010','cash',0," + tfPaymentPrice.getText();
                }
                if (jComboBox3.getSelectedItem() == "bank") {
                    a = "'1030','account payable'," + tfPaymentPrice.getText() + ",0";
                    b = "'1020','bank',0," + tfPaymentPrice.getText();
                }
                if (jComboBox3.getSelectedItem() == "giro") {
                    a = "'2030','giro payable',0," + tfPaymentPrice.getText();
                    b = "'2020','account payable'," + tfPaymentPrice.getText() + ",0";
                }
            }

            System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPaymentDate.getText() + "',"
                    + a + ",'" + taPaymentDesc.getText() + "')");
            DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPaymentDate.getText() + "',"
                    + a + ",'" + taPaymentDesc.getText() + "')");
            System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPaymentDate.getText() + "',"
                    + b + ",'" + taPaymentDesc.getText() + "')");
            DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfPaymentDate.getText() + "',"
                    + b + ",'" + taPaymentDesc.getText() + "')");

            if (jComboBox3.getSelectedItem() == "giro") {
                if (jComboBox2.getSelectedItem() == "sales") {
                    a = "'1070','giro receivable',0," + tfPaymentPrice.getText();
                    b = "'1020','bank'," + tfPaymentPrice.getText() + ",0";
                }
                if (jComboBox2.getSelectedItem() == "purchase") {
                    a = "'2030','giro payable'," + tfPaymentPrice.getText() + ",0";
                    b = "'1020','bank',0," + tfPaymentPrice.getText();
                }
                DataBase.jurnalId++;
                System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate + "',"
                        + a + ",'" + taPaymentDesc.getText() + "')");
                DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate + "',"
                        + a + ",'" + taPaymentDesc.getText() + "')");
                System.out.println("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate + "',"
                        + b + ",'" + taPaymentDesc.getText() + "')");
                DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + giroDate + "',"
                        + b + ",'" + taPaymentDesc.getText() + "')");
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
            tfPaymentPrice.setText("");
            tfPaymentDate.setText("");
            taPaymentDesc.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void tfOpPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOpPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfOpPriceActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        //OPERSIONAL REFRESH
        try {
            rs = st.executeQuery("SELECT CHART_NAME FROM CHART WHERE CHART_ID LIKE '6%'");
            cOperasionalType.removeAllItems();
            while (rs.next()) {
                cOperasionalType.addItem(rs.getString("chart_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        String a = null;
        try {
            rs = st.executeQuery("SELECT CHART_ID FROM CHART WHERE CHART_NAME LIKE '" + cOperasionalType.getSelectedItem() + "'");
            while (rs.next()) {
                a = rs.getString("chart_id");
            }
            if (tfOpPrice.getText() != null) {
                DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfOpDate.getText()
                        + "','" + a + "','" + cOperasionalType.getSelectedItem() + "'," + tfOpPrice.getText() + ",0,'" + taOpDesc.getText() + "')");

                if (cOpPay.getSelectedItem() == "cash") {
                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfOpDate.getText()
                            + "','1010','cash',0," + tfOpPrice.getText() + ",'" + taOpDesc.getText() + "')");
                }
                if (cOpPay.getSelectedItem() == "credit") {
                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfOpDate.getText()
                            + "','2020','account payable',0," + tfOpPrice.getText() + ",'" + taOpDesc.getText() + "')");
                }
                if (cOpPay.getSelectedItem() == "bank") {
                    DataBase.setExecuteUpdate("INSERT INTO JURNAL VALUES('J" + DataBase.jurnalId + "','" + DataBase.jurnalDate + "-" + tfOpDate.getText()
                            + "','1020','bank',0," + tfOpPrice.getText() + ",'" + taOpDesc.getText() + "')");
                }
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
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentShown
        DataBase.jurnalShow = 3;
        System.out.println("jurnal show " + DataBase.jurnalShow);
        Detail.setJurnalDetail(" (OPERASIONAL) ");
    }//GEN-LAST:event_jPanel5ComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddProdcut;
    private javax.swing.JButton bRemoveProduct;
    private javax.swing.JButton bSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cOpPay;
    private javax.swing.JComboBox<String> cOperasionalType;
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JPanel sales;
    private javax.swing.JTable tPur1;
    private javax.swing.JTable tPur2;
    private javax.swing.JTextArea taConvertDesc;
    private javax.swing.JTextArea taOpDesc;
    private javax.swing.JTextArea taPaymentDesc;
    private javax.swing.JTextArea taPrivetDesc;
    private javax.swing.JTextField tfConvert;
    private javax.swing.JTextField tfConvertPrice;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfOpDate;
    private javax.swing.JTextField tfOpPrice;
    private javax.swing.JTextField tfPaymentDate;
    private javax.swing.JTextField tfPaymentPrice;
    private javax.swing.JTextField tfPrivetDate;
    private javax.swing.JTextField tfPrivetPrice;
    private javax.swing.JTextField tfPurDate;
    private javax.swing.JTable tsales1;
    private javax.swing.JTable tsales2;
    // End of variables declaration//GEN-END:variables
}
