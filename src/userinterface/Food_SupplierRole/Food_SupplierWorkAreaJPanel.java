/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Food_SupplierRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FoodOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodSupplier_WorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nares
 */
public class Food_SupplierWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Food_SupplierWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount userAccount;
    private FoodOrganization foodOrganization;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private Enterprise enterprise;
    private String seletedStatus;
    private Date date;
    public Food_SupplierWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, FoodOrganization foodOrganization, Enterprise enterprise,EcoSystem system) {
        
         initComponents();
         this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.system = system;
        this.foodOrganization = foodOrganization;
        this.enterprise=enterprise;
        populateTable();
        dB4OUtil.storeSystem(system);
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)FoodsupplierJTable.getModel();
        
        model.setRowCount(0);
        for(WorkRequest request : foodOrganization.getWorkQueue().getWorkRequestList()){
            if (request.getStatus().equalsIgnoreCase(seletedStatus)){
            Object[] row = new Object[9];
            row[0] = request;
            row[1] = ((FoodSupplier_WorkRequest)request).getHomeless().getName();
            row[2] = request.getSender().getEmployee().getName();
            row[3] = request.getReceiver()==null?null: request.getReceiver().getEmployee().getName();
            row[4] = request.getRequestDate();
            row[5] = request.getResolveDate();
            row[6] = request.getStatus();
            row[7] = ((FoodSupplier_WorkRequest)request).getItem();
            row[8] = ((FoodSupplier_WorkRequest)request).getItemtype();
            model.addRow(row);
            }}
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
        FoodsupplierJTable = new javax.swing.JTable();
        AssignButton = new javax.swing.JButton();
        ProcessRequestButton = new javax.swing.JButton();
        statusJComboBox = new javax.swing.JComboBox<>();
        btnResh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        FoodsupplierJTable.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        FoodsupplierJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Candidate ID", "Candidate Name", "Sender", "Receiver", "Request Date", "Resolve Date", "Request Status", "Item ", "Item Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(FoodsupplierJTable);

        AssignButton.setBackground(new java.awt.Color(102, 102, 255));
        AssignButton.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        AssignButton.setForeground(new java.awt.Color(255, 255, 255));
        AssignButton.setText("Assign");
        AssignButton.setBorder(new javax.swing.border.MatteBorder(null));
        AssignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignButtonActionPerformed(evt);
            }
        });

        ProcessRequestButton.setBackground(new java.awt.Color(102, 102, 255));
        ProcessRequestButton.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        ProcessRequestButton.setForeground(new java.awt.Color(255, 255, 255));
        ProcessRequestButton.setText("Process");
        ProcessRequestButton.setBorder(new javax.swing.border.MatteBorder(null));
        ProcessRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessRequestButtonActionPerformed(evt);
            }
        });

        statusJComboBox.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        statusJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sent", "Processing", "Request Processed" }));
        statusJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusJComboBoxActionPerformed(evt);
            }
        });

        btnResh.setBackground(new java.awt.Color(102, 102, 255));
        btnResh.setForeground(new java.awt.Color(255, 255, 255));
        btnResh.setText("Refresh");
        btnResh.setBorder(new javax.swing.border.MatteBorder(null));
        btnResh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel1.setText("Request Status");

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel2.setText("Food Supplier WorkArea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(statusJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                        .addComponent(btnResh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AssignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProcessRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProcessRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AssignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(228, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AssignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignButtonActionPerformed
        int selectedRow = FoodsupplierJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        
        FoodSupplier_WorkRequest request = (FoodSupplier_WorkRequest)FoodsupplierJTable.getValueAt(selectedRow, 0);
     if(request.getStatus().equalsIgnoreCase("sent")){
         request.setStatus("Processing");
        request.setReceiver(userAccount);
        dB4OUtil.storeSystem(system);
        populateTable();
     }else
     {
         JOptionPane.showMessageDialog(null, "Please select a pending request to Assign");
            return;
     }
         
    }//GEN-LAST:event_AssignButtonActionPerformed

    private void ProcessRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessRequestButtonActionPerformed
        date = new Date();
        int selectedRow = FoodsupplierJTable.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        FoodSupplier_WorkRequest request = (FoodSupplier_WorkRequest) FoodsupplierJTable.getValueAt(selectedRow, 0);
        if(request.getStatus().equalsIgnoreCase("Processing")){
            JOptionPane.showMessageDialog(null, "Request Processed Successfully");
            request.setReceiver(userAccount);
            request.setStatus("Request Processed");
            request.setResolveDate(date);
            dB4OUtil.storeSystem(system);
            populateTable();
        }else
        {
            JOptionPane.showMessageDialog(null, "Please select a pending request to process");
            return;
        }
        
    }//GEN-LAST:event_ProcessRequestButtonActionPerformed

    private void statusJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusJComboBoxActionPerformed
        
        seletedStatus = (String)(statusJComboBox.getSelectedItem());
        populateTable();
    }//GEN-LAST:event_statusJComboBoxActionPerformed

    private void btnReshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReshActionPerformed
        // TODO add your handling code here:
         populateTable();
    }//GEN-LAST:event_btnReshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AssignButton;
    private javax.swing.JTable FoodsupplierJTable;
    private javax.swing.JButton ProcessRequestButton;
    private javax.swing.JButton btnResh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> statusJComboBox;
    // End of variables declaration//GEN-END:variables
}
