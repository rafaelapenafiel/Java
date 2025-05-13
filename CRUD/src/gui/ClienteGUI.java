/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.ClienteDAO;
import javax.swing.JOptionPane;
import modelo.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Rafaela Penafiel
 */
public class ClienteGUI extends javax.swing.JFrame {

    
    public ClienteGUI() {
        initComponents();
        tblClientes.setFillsViewportHeight(true);
        carregarTabela();
        
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked (java.awt.event.MouseEvent evt) {
                int linhaSelecionada = tblClientes.getSelectedRow();
                if (linhaSelecionada != -1){
                    txtNome.setText(tblClientes.getValueAt(linhaSelecionada, 1).toString());
                    txtCpf.setText(tblClientes.getValueAt(linhaSelecionada, 2).toString());
                    txtCpf.setEditable(false);
                    txtEmail.setText(tblClientes.getValueAt(linhaSelecionada, 3).toString());
                    txtTelefone.setText(tblClientes.getValueAt(linhaSelecionada, 4).toString());
                    txtEndereco.setText(tblClientes.getValueAt(linhaSelecionada, 5).toString());
                    txtDataNascimento.setText(tblClientes.getValueAt(linhaSelecionada, 6).toString());
                }
            }
        });
        
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost (java.awt.event.FocusEvent evt){
                String cpf = txtCpf.getText().replaceAll("[^0-9]", "");
                if (cpf.isEmpty()) {
                    try {
                        txtCpf.setValue(null);
                        txtCpf.setText("");
                        txtCpf.commitEdit();
                        txtCpf.setCaretPosition(0);
                    }catch (Exception ex){
                        txtCpf.setText("");
                    }
                }
            }
        });
        
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter(){
            public void focusLost(java.awt.event.FocusEvent evt){
                String telefone = txtTelefone.getText().replaceAll("[^0-9]", "");
                if (telefone.isEmpty()){
                    try {
                        txtTelefone.setValue(null);
                        txtTelefone.setText("");
                        txtTelefone.commitEdit();
                        txtTelefone.setCaretPosition(0);
                    } catch (Exception ex){
                        txtTelefone.setText("");
                    }
                }
            }
        });
        
        txtDataNascimento.addFocusListener(new java.awt.event.FocusAdapter(){
            public void focusLost (java.awt.event.FocusEvent evt){
                String data = txtDataNascimento.getText().replaceAll("[^0-9]", "");
                if (data.isEmpty()){
                    try {
                        txtDataNascimento.setValue(null);
                        txtDataNascimento.setText("");
                        txtDataNascimento.commitEdit();
                        txtDataNascimento.setCaretPosition(0);
                    } catch (Exception ex){
                        txtDataNascimento.setText("");
                    }
                }
            }
        });
    }
    
    private void listarClientesNaTabela(){
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.getLista();
        
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Nome", "CPF", "Email", "Telefone", "Endereço", "Data de Nascimento"},0
        ){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for (Cliente c: lista) {
            modelo.addRow(new Object[] {
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getEmail(),
                c.getTelefone(),
                c.getEndereco(),
                c.getDataNascimento()
            });
        }
        tblClientes.setModel(modelo);
    }
    
    private void carregarTabela() {
        listarClientesNaTabela();
    }
    
    private boolean emailValido(String email){
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
    
    private void limparCampos(){
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtDataNascimento.setText("");
        tblClientes.clearSelection();
    }
    
    
    private void preencherTabelaComLista(List<Cliente> lista){
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0);
        
        for (Cliente c: lista){
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getEmail(),
                c.getTelefone(),
                c.getEndereco(),
                c.getDataNascimento()
            });
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar novo Cliente"));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btnCadastrar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCadastrar.setPreferredSize(new java.awt.Dimension(85, 40));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.setPreferredSize(new java.awt.Dimension(85, 40));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.setPreferredSize(new java.awt.Dimension(85, 40));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Email: ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Endereço:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Telefone: ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("CPF: ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Data de Nascimento:");

        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtEmail.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtEmailComponentAdded(evt);
            }
        });

        txtEndereco.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btnAtualizar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAtualizar.setPreferredSize(new java.awt.Dimension(85, 40));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.setPreferredSize(new java.awt.Dimension(85, 40));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setPreferredSize(new java.awt.Dimension(85, 40));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblClientes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Email"
            }
        ));
        tblClientes.setRowHeight(30);
        jScrollPane3.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCpf))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataNascimento)))
                .addGap(216, 216, 216))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(76, 76, 76)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(78, 78, 78)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCpf)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefone))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndereco))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDataNascimento))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        txtNome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtEmail.setText("");
        txtDataNascimento.setText("");
        txtCpf.setText("");
        
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.listarTodos();
        preencherTabelaComLista(clientes);
        txtCpf.setEditable(true);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        if (txtNome.getText().isEmpty() || txtCpf.getText().trim().equals("   .   .   -  ") ||
        txtEmail.getText().isEmpty() || txtTelefone.getText().trim().equals("(  )      -    ") ||
        txtEndereco.getText().isEmpty() || txtDataNascimento.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Preecha todos os campos obrigatórios.");
            return;
        }
        
        if (!emailValido(txtEmail.getText())){
            JOptionPane.showMessageDialog(null, "E-mail inválido.");
            return;
        }
        
        Cliente cliente = new Cliente();
            cliente.setNome(txtNome.getText());
            cliente.setCpf(txtCpf.getText());
            cliente.setEmail(txtEmail.getText());
            cliente.setTelefone(txtTelefone.getText());
            cliente.setEndereco(txtEndereco.getText());
            
            if(txtDataNascimento.getText().contains("_")){
                JOptionPane.showMessageDialog(null, "Preencha completamente a data de nascimento.");
                return;
            }
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false); 
                java.util.Date dataUtil = sdf.parse(txtDataNascimento.getText());
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                cliente.setDataNascimento(dataSql);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida.");
                return;
            }

            
            ClienteDAO dao = new ClienteDAO();
            
            if (dao.existeCPF(cliente.getCpf())){
                JOptionPane.showMessageDialog(null, "CPF já cadastrado.");
                return;
            }
            
            dao.adiciona(cliente);
            JOptionPane.showMessageDialog(null, "Cliente "+txtNome.getText()+" inserido com sucesso!");
            listarClientesNaTabela();
            carregarTabela();
        
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtDataNascimento.setText("");
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtEmailComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtEmailComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailComponentAdded

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        int linhaSelecionada = tblClientes.getSelectedRow();
        if (linhaSelecionada == -1){
            JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela para atualizar.");
            return;
        }
        if (txtNome.getText().isEmpty() || 
        txtCpf.getText().trim().equals("   .   .   -  ") ||
        txtEmail.getText().isEmpty() || 
        txtTelefone.getText().trim().equals("(  )      -    ") ||
        txtEndereco.getText().isEmpty() || 
        txtDataNascimento.getText().isEmpty()) {
            
           JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios.");
           return;
        }
        if (!emailValido(txtEmail.getText())){
            JOptionPane.showMessageDialog(null, "E-mail inválido.");
            return;
        }
        Cliente cliente = new Cliente();
        int idCliente = (int) tblClientes.getValueAt(linhaSelecionada, 0);
        cliente.setId(idCliente);
        cliente.setNome(txtNome.getText());
        cliente.setCpf((String) tblClientes.getValueAt(linhaSelecionada, 2));
        cliente.setEmail(txtEmail.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setEndereco(txtEndereco.getText());
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataUtil = sdf.parse(txtDataNascimento.getText());
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            cliente.setDataNascimento(dataSql);
        }catch (ParseException e){
            JOptionPane.showMessageDialog(null, "Data de Nascimento inválida.");
            return;
        }
        
        ClienteDAO dao = new ClienteDAO();
        if (dao.existeCPFParaOutroCliente(cliente.getCpf(), cliente.getId())){
            JOptionPane.showMessageDialog(null, "Outro cliente já possui este CPF.");
            return;
        }
        dao.atualizar(cliente);
        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.");
        listarClientesNaTabela();
        carregarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String cpf = txtCpf.getText().trim();
        
        if (cpf.equals("   .   .   -  ")){
            JOptionPane.showMessageDialog(null, "Selecione um cliente válido para exclusão.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION){
            try {
                ClienteDAO dao = new ClienteDAO();
                dao.excluirPorCpf(cpf);
                carregarTabela();
                limparCampos();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String cpf = txtCpf.getText().trim();
        String nome = txtNome.getText().trim();
        
        try{
            ClienteDAO dao = new ClienteDAO();
            
            if (!cpf.replaceAll("[^0-9]", "").isEmpty()) {
                Cliente cliente = dao.buscarPorCpf(cpf);
                if (cliente != null){
                    List<Cliente> lista = new ArrayList<>();
                    lista.add(cliente);
                    preencherTabelaComLista(lista);
                }else {
                    JOptionPane.showMessageDialog(null, "Cliente com CPF informado não encontrado.");
                }
            }else if (!nome.isEmpty()){
                List<Cliente> clientes = dao.buscarPorNome(nome);
                if (!clientes.isEmpty()){
                    preencherTabelaComLista(clientes);
                }else {
                    JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado com esse nome.");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Informe o CPF ou Nome para buscar");
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblClientes;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    
}