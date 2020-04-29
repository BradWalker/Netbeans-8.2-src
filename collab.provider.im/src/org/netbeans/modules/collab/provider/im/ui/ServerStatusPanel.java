/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package org.netbeans.modules.collab.provider.im.ui;

/**
 *
 * @author  Alexandr Scherbatiy
 */


import org.netbeans.modules.collab.core.Debug;
import org.openide.util.NbBundle;


import org.netbeans.modules.collab.provider.im.IMReconnect;
import java.awt.Dialog;
import java.awt.Frame;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.windows.WindowManager;

public class ServerStatusPanel extends javax.swing.JPanel {


    //private boolean showDialog;
    //private boolean doReconnect;

    private  IMReconnect reconnectClass;
    private boolean alive;
    private String server;
    
    
    
    
    /** Creates new form NewJPanel */
    public ServerStatusPanel(IMReconnect reconnectClass, String server) {
        super();
        this.server = server;
        initComponents();

        this.reconnectClass = reconnectClass;
        alive = true;
        createDialog();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        northPanel = new javax.swing.JPanel();
        centerPanel = new javax.swing.JPanel();
        labelPanel = new javax.swing.JPanel();
        connectionInterruptedLabel = new javax.swing.JLabel();
        attemptToReconnectLabel = new javax.swing.JLabel();
        progressPanel = new javax.swing.JPanel();
        progress = new javax.swing.JProgressBar();
        workPanel = new javax.swing.JPanel();
        checkBoxesPanel = new javax.swing.JPanel();
        doNotReconnect = new javax.swing.JCheckBox();
        doNotShow = new javax.swing.JCheckBox();
        buttonPanel = new javax.swing.JPanel();
        startStopPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        okCancelPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButtton = new javax.swing.JButton();
        westPanel = new javax.swing.JPanel();
        eastPanel = new javax.swing.JPanel();
        southPanel = new javax.swing.JPanel();

        FormListener formListener = new FormListener();

        setLayout(new java.awt.BorderLayout());

        setPreferredSize(new java.awt.Dimension(350, 175));
        northPanel.setPreferredSize(new java.awt.Dimension(400, 15));
        add(northPanel, java.awt.BorderLayout.NORTH);

        centerPanel.setLayout(new java.awt.BorderLayout());

        labelPanel.setLayout(new javax.swing.BoxLayout(labelPanel, javax.swing.BoxLayout.Y_AXIS));

        connectionInterruptedLabel.setForeground(java.awt.Color.red);
        org.openide.awt.Mnemonics.setLocalizedText(connectionInterruptedLabel, org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "LBL_ConnectionInterrupted"));
        labelPanel.add(connectionInterruptedLabel);
        connectionInterruptedLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_CONNECTIONLABEL"));

        org.openide.awt.Mnemonics.setLocalizedText(attemptToReconnectLabel, org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "LBL_AttemptingToReconnect", new Object[] {server}));
        labelPanel.add(attemptToReconnectLabel);
        attemptToReconnectLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_ATTEMPTTOCONNECTLABEL"));

        centerPanel.add(labelPanel, java.awt.BorderLayout.NORTH);

        progress.setPreferredSize(new java.awt.Dimension(250, 20));
        progress.setStringPainted(true);
        progressPanel.add(progress);

        centerPanel.add(progressPanel, java.awt.BorderLayout.CENTER);

        workPanel.setLayout(new java.awt.BorderLayout());

        checkBoxesPanel.setLayout(new javax.swing.BoxLayout(checkBoxesPanel, javax.swing.BoxLayout.Y_AXIS));

        org.openide.awt.Mnemonics.setLocalizedText(doNotReconnect, org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "LBL_DoNotReconnect"));
        checkBoxesPanel.add(doNotReconnect);
        doNotReconnect.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_NOTRECONNECTCKBOX"));

        org.openide.awt.Mnemonics.setLocalizedText(doNotShow, org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "LBL_DoNotShow"));
        checkBoxesPanel.add(doNotShow);
        doNotShow.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_NOTSHOWCKBOX"));

        workPanel.add(checkBoxesPanel, java.awt.BorderLayout.CENTER);

        buttonPanel.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(startButton, org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "LBL_Start"));
        startButton.addActionListener(formListener);

        startStopPanel.add(startButton);
        startButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_STARTBTN"));

        org.openide.awt.Mnemonics.setLocalizedText(stopButton, org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "LBL_Stop"));
        stopButton.addActionListener(formListener);

        startStopPanel.add(stopButton);
        stopButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_STOPBTN"));

        buttonPanel.add(startStopPanel, java.awt.BorderLayout.WEST);

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "LBL_OK"));
        okButton.addActionListener(formListener);

        okCancelPanel.add(okButton);
        okButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_OKBTN"));

        org.openide.awt.Mnemonics.setLocalizedText(cancelButtton, org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "LBL_Cancel"));
        cancelButtton.addActionListener(formListener);

        okCancelPanel.add(cancelButtton);
        cancelButtton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_CANCELBTN"));

        buttonPanel.add(okCancelPanel, java.awt.BorderLayout.EAST);

        workPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        centerPanel.add(workPanel, java.awt.BorderLayout.SOUTH);

        add(centerPanel, java.awt.BorderLayout.CENTER);

        westPanel.setPreferredSize(new java.awt.Dimension(15, 150));
        add(westPanel, java.awt.BorderLayout.WEST);

        eastPanel.setPreferredSize(new java.awt.Dimension(15, 150));
        add(eastPanel, java.awt.BorderLayout.EAST);

        southPanel.setPreferredSize(new java.awt.Dimension(400, 15));
        add(southPanel, java.awt.BorderLayout.SOUTH);

    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == startButton) {
                ServerStatusPanel.this.startButtonActionPerformed(evt);
            }
            else if (evt.getSource() == stopButton) {
                ServerStatusPanel.this.stopButtonActionPerformed(evt);
            }
            else if (evt.getSource() == okButton) {
                ServerStatusPanel.this.okButtonActionPerformed(evt);
            }
            else if (evt.getSource() == cancelButtton) {
                ServerStatusPanel.this.cancelButttonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButttonActionPerformed
        cancelAction();
    }//GEN-LAST:event_cancelButttonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        okAction();
    }//GEN-LAST:event_okButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        stopAction();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        startAction();
    }//GEN-LAST:event_startButtonActionPerformed
    
    
    public boolean isAlive(){
        return alive;
    }
    
    public void createDialog(){
        //SyncWaitPanel panel=new SyncWaitPanel();
        DialogDescriptor descriptor=new DialogDescriptor(this,
                NbBundle.getMessage(ServerStatusPanel.class,
                "LBL_CollaborationServerReconnect")); // NOI18N
        
        final Object[] OPTIONS=new Object[0];
        descriptor.setOptions(OPTIONS);
        descriptor.setClosingOptions(OPTIONS);
        descriptor.setModal(false);
        descriptor.setOptionsAlign(DialogDescriptor.BOTTOM_ALIGN);
        
        dialog=DialogDisplayer.getDefault().createDialog(descriptor);
        dialog.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(ServerStatusPanel.class, "A11Y_DESC_NbDialog"));
        Frame mainWindow=WindowManager.getDefault().getMainWindow();
        int windowX=mainWindow.getX();
        int windowY=mainWindow.getY();
        int windowWidth=mainWindow.getWidth();
        int windowHeight=mainWindow.getHeight();
        int dialogWidth=dialog.getWidth();
        int dialogHeight=dialog.getHeight();
        int dialogX=windowX+windowWidth-dialogWidth-25;
        int dialogY=windowY+500;
        
        dialog.setLocation(dialogX,dialogY);
        dialog.setVisible(true);
    }
    
    public void startAction(){
        progress.setString(NbBundle.getMessage(ServerStatusPanel.class, "LBL_StartConnecting"));
        progress.setIndeterminate(true);
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        reconnectClass.startAction();
    }
    
    public void stopAction(){
        progress.setString(NbBundle.getMessage(ServerStatusPanel.class, "LBL_StopConnecting"));
        progress.setIndeterminate(false);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        reconnectClass.stopAction();
        
    }
    
    
    public void okAction(){
        reconnectClass.setDoReconnect(!doNotReconnect.isSelected());
        reconnectClass.setShowStatusDialog(!doNotShow.isSelected());
        reconnectClass.okAction();
        
        endAction();
    }
    
    public void cancelAction(){
        reconnectClass.cancelAction();
        endAction();
    }
    
    public void endAction(){
        alive = false;
        setVisible(false);
        dialog.dispose();
    }
    
    private static Dialog dialog;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attemptToReconnectLabel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButtton;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel checkBoxesPanel;
    private javax.swing.JLabel connectionInterruptedLabel;
    private javax.swing.JCheckBox doNotReconnect;
    private javax.swing.JCheckBox doNotShow;
    private javax.swing.JPanel eastPanel;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JPanel northPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel okCancelPanel;
    private javax.swing.JProgressBar progress;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JPanel southPanel;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel startStopPanel;
    private javax.swing.JButton stopButton;
    private javax.swing.JPanel westPanel;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
    
}