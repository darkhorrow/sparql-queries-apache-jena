package sparql.queries;

import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QueryParseException;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

public class AppWindow extends javax.swing.JFrame {

    public AppWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formatGroupButton = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        outputPathField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        outputButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        localRadioButton = new javax.swing.JRadioButton();
        urlRadioButton = new javax.swing.JRadioButton();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SPARQL Queries");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SPARQL Queries");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data origin"));

        outputPathField.setEditable(false);
        outputPathField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                outputPathFieldCaretUpdate(evt);
            }
        });

        jLabel2.setText("Path of the file:");

        outputButton.setText("Load graph...");
        outputButton.setPreferredSize(new java.awt.Dimension(79, 20));
        outputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Origin:");

        formatGroupButton.add(localRadioButton);
        localRadioButton.setSelected(true);
        localRadioButton.setText("Local graph");
        localRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localRadioButtonActionPerformed(evt);
            }
        });

        formatGroupButton.add(urlRadioButton);
        urlRadioButton.setText("URL endpoint");
        urlRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(outputPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(localRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(urlRadioButton)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localRadioButton)
                    .addComponent(urlRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        submitButton.setText("Resolve query");
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        inputArea.setColumns(20);
        inputArea.setRows(5);
        inputArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inputAreaCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(inputArea);

        outputArea.setEditable(false);
        outputArea.setColumns(20);
        outputArea.setRows(5);
        jScrollPane2.setViewportView(outputArea);

        jLabel4.setText("SPARQL Query Input");

        jLabel5.setText("Query result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void outputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            outputPathField.setText(fc.getSelectedFile().getAbsolutePath());
        }
        submitButtonCheck();
    }//GEN-LAST:event_outputButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        submitButton.setText("Working...");
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                doQuery();
                submitButton.setText("Resolve query");
                return null;
            }
        };
        worker.execute();     
    }//GEN-LAST:event_submitButtonActionPerformed

    private void localRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localRadioButtonActionPerformed
        outputPathField.setEditable(false);
        outputPathField.setText("");
        outputButton.setVisible(true);
        submitButtonCheck();
    }//GEN-LAST:event_localRadioButtonActionPerformed

    private void urlRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlRadioButtonActionPerformed
        outputPathField.setEditable(true);
        outputPathField.setText("");
        outputButton.setVisible(false);
        submitButtonCheck();
    }//GEN-LAST:event_urlRadioButtonActionPerformed

    private void outputPathFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_outputPathFieldCaretUpdate
        submitButtonCheck();
    }//GEN-LAST:event_outputPathFieldCaretUpdate

    private void inputAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inputAreaCaretUpdate
        submitButtonCheck();
    }//GEN-LAST:event_inputAreaCaretUpdate

    private void submitButtonCheck() {
        if(!outputPathField.getText().equals("") 
                && !inputArea.getText().equals("")) {
            submitButton.setEnabled(true);
        } else {
            submitButton.setEnabled(false);
        }
    }
    
    private void doQuery() {
        Model data = null;
        boolean isLocalRDF = localRadioButton.isSelected();        
        String output = "";
        
        if(isLocalRDF) {
            try {
                data = RDFDataMgr.loadModel(outputPathField.getText());
            } catch (Exception e) {
                output = "Error loading the local file to a model: " 
                        + e.getMessage();
                printResult(output);
                return;
            }
        }
        
        try {
            Query query = QueryFactory.create(inputArea.getText());
            QueryExecution queryExec;
            
            if(isLocalRDF) {
                queryExec = QueryExecutionFactory.create(query, data);
            } else {
                queryExec = QueryExecutionFactory
                        .sparqlService(outputPathField.getText(), query);
                ((QueryEngineHTTP)queryExec).addParam("timeout", "5000");
            }
            
            ResultSet result = queryExec.execSelect();

            output = ResultSetFormatter.asText(result);

            queryExec.close();
        } catch(QueryParseException e) {
            output = "Syntax error: " + e.getMessage() + "\n in line: " + e.getLine();
        } catch(Exception e) {
            output = "The endpoint provided is not reachable or available.";
        } finally {
            printResult(output);
        }
    }
    
    private void printResult(String result) {
        outputArea.setText(result);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup formatGroupButton;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton localRadioButton;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JButton outputButton;
    private javax.swing.JTextField outputPathField;
    private javax.swing.JButton submitButton;
    private javax.swing.JRadioButton urlRadioButton;
    // End of variables declaration//GEN-END:variables
}
