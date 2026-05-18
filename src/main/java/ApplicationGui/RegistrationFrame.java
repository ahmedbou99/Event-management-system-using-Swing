/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ApplicationGui;
import Classes.*;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Dell 2024
 */
public class RegistrationFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistrationFrame.class.getName());

    /**
     * Creates new form RegistrationFrame
     */
    public RegistrationFrame() {
        initComponents();
        this.setDefaultCloseOperation(RegistrationFrame.DISPOSE_ON_CLOSE);
        
        for (Event evt : EventFrame.eventsList){
            EventsCombo.addItem(evt.code + " " + evt.title);
        }
        
        for(Student std : StudentFrame.studentsList){
            StudentsCombo.addItem(std.id + " " +  std.name);
        }
         this.getContentPane().setBackground(new Color(18, 17, 17));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudentsCombo = new javax.swing.JComboBox<>();
        EventsCombo = new javax.swing.JComboBox<>();
        StudentSelectText = new javax.swing.JLabel();
        EventSelectText = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StudentsCombo.setBackground(new java.awt.Color(0, 0, 0));
        StudentsCombo.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 12)); // NOI18N
        StudentsCombo.setForeground(new java.awt.Color(255, 255, 255));

        EventsCombo.setBackground(new java.awt.Color(0, 0, 0));
        EventsCombo.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 12)); // NOI18N
        EventsCombo.setForeground(new java.awt.Color(255, 255, 255));

        StudentSelectText.setBackground(new java.awt.Color(0, 0, 0));
        StudentSelectText.setFont(new java.awt.Font("Simplified Arabic Fixed", 1, 12)); // NOI18N
        StudentSelectText.setForeground(new java.awt.Color(255, 255, 255));
        StudentSelectText.setText("Select Student");

        EventSelectText.setBackground(new java.awt.Color(0, 0, 0));
        EventSelectText.setFont(new java.awt.Font("Simplified Arabic Fixed", 1, 12)); // NOI18N
        EventSelectText.setForeground(new java.awt.Color(255, 255, 255));
        EventSelectText.setText("Select An Event");

        RegisterButton.setBackground(new java.awt.Color(0, 0, 0));
        RegisterButton.setFont(new java.awt.Font("Simplified Arabic Fixed", 1, 12)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(this::RegisterButtonActionPerformed);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell 2024\\Desktop\\miniProject_EventRegSys\\src\\main\\java\\ApplicationGui\\pen.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EventSelectText)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(StudentSelectText)))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(StudentsCombo, 0, 259, Short.MAX_VALUE)
                        .addComponent(EventsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentSelectText))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EventsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EventSelectText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
    Student student = StudentFrame.studentsList.get(StudentsCombo.getSelectedIndex());
    Event event = EventFrame.eventsList.get(EventsCombo.getSelectedIndex());
    int regId = ReportFrame.registrationsList.size() + 1 ;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate regDate = LocalDate.now();
    
    String regDatestring = regDate.format(formatter);
    
    Registration reg = new Registration(regId,regDatestring,"Pending",student,event);
    
    reg.confirmRegistration();
    ReportFrame.registrationsList.add(reg);
    this.dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EventSelectText;
    private javax.swing.JComboBox<String> EventsCombo;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel StudentSelectText;
    private javax.swing.JComboBox<String> StudentsCombo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
