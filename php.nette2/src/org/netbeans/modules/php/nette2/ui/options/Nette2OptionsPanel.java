/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2013 Oracle and/or its affiliates. All rights reserved.
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
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2013 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.nette2.ui.options;

import java.io.File;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.modules.php.api.util.UiUtils;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileUtil;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;

/**
 *
 * @author Ondrej Brejla <obrejla@netbeans.org>
 */
@NbBundle.Messages({"Nette.options.keywords.TabTitle=Frameworks & Tools"})
@OptionsPanelController.Keywords(
    keywords = {"php", "nette", "nette2", "framework"},
    location = UiUtils.OPTIONS_PATH,
    tabTitle = "#Nette.options.keywords.TabTitle"
)
public class Nette2OptionsPanel extends javax.swing.JPanel {
    private static final String NETTE_DIRECTORY_SUFFIX = ".nette-directory"; //NOI18N
    private static final String NETTE_SANDBOX_SUFFIX = ".nette-sandbox"; //NOI18N
    private final ChangeSupport changeSupport = new ChangeSupport(this);

    public Nette2OptionsPanel() {
        initComponents();
        errorLabel.setText(" "); //NOI18N
        initListeners();
    }

    private void initListeners() {
        netteTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                processUpdate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                processUpdate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                processUpdate();
            }

            private void processUpdate() {
                fireChange();
            }
        });
        sandboxTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                processUpdate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                processUpdate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                processUpdate();
            }

            private void processUpdate() {
                fireChange();
            }
        });
    }

    private void fireChange() {
        changeSupport.fireChange();
    }

    public String getSandbox() {
        return sandboxTextField.getText();
    }

    public void setSandbox(String sandbox) {
        sandboxTextField.setText(sandbox);
    }

    public String getNetteDirectory() {
        return netteTextField.getText();
    }

    public void setNetteDirectory(String netteDirectory) {
        netteTextField.setText(netteDirectory);
    }

    public void setError(String message) {
        errorLabel.setText(" "); //NOI18N
        errorLabel.setForeground(UIManager.getColor("nb.errorForeground")); //NOI18N
        errorLabel.setText(message);
    }

    public void setWarning(String message) {
        errorLabel.setText(" "); //NOI18N
        errorLabel.setForeground(UIManager.getColor("nb.warningForeground")); //NOI18N
        errorLabel.setText(message);
    }

    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        netteLabel = new javax.swing.JLabel();
        netteTextField = new javax.swing.JTextField();
        browseNetteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sandboxLabel = new javax.swing.JLabel();
        sandboxTextField = new javax.swing.JTextField();
        browseSandboxButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.jButton1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(errorLabel, org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.errorLabel.text")); // NOI18N

        netteLabel.setDisplayedMnemonic('n');
        netteLabel.setLabelFor(netteTextField);
        org.openide.awt.Mnemonics.setLocalizedText(netteLabel, org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.netteLabel.text")); // NOI18N

        netteTextField.setText(org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.netteTextField.text")); // NOI18N

        browseNetteButton.setMnemonic('b');
        org.openide.awt.Mnemonics.setLocalizedText(browseNetteButton, org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.browseNetteButton.text")); // NOI18N
        browseNetteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseNetteButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.jLabel1.text")); // NOI18N

        sandboxLabel.setDisplayedMnemonic('s');
        sandboxLabel.setLabelFor(sandboxTextField);
        org.openide.awt.Mnemonics.setLocalizedText(sandboxLabel, org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.sandboxLabel.text")); // NOI18N

        sandboxTextField.setText(org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.sandboxTextField.text")); // NOI18N

        browseSandboxButton.setMnemonic('r');
        org.openide.awt.Mnemonics.setLocalizedText(browseSandboxButton, org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.browseSandboxButton.text")); // NOI18N
        browseSandboxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseSandboxButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(Nette2OptionsPanel.class, "Nette2OptionsPanel.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(errorLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sandboxLabel)
                    .addComponent(netteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(netteTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseNetteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sandboxTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseSandboxButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 66, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netteLabel)
                    .addComponent(netteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseNetteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sandboxLabel)
                    .addComponent(sandboxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseSandboxButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(errorLabel))
        );
    }// </editor-fold>//GEN-END:initComponents

    @NbBundle.Messages("LBL_SelectNetteDirectory=Select Nette Directory")
    private void browseNetteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseNetteButtonActionPerformed
        File netteDirectory = new FileChooserBuilder(Nette2OptionsPanel.class.getName() + NETTE_DIRECTORY_SUFFIX)
                .setTitle(Bundle.LBL_SelectNetteDirectory())
                .setDirectoriesOnly(true)
                .showOpenDialog();
        if (netteDirectory != null) {
            netteDirectory = FileUtil.normalizeFile(netteDirectory);
            netteTextField.setText(netteDirectory.getAbsolutePath());
        }
    }//GEN-LAST:event_browseNetteButtonActionPerformed

    @NbBundle.Messages("LBL_SelectNetteSandbox=Select Nette Sandbox Directory")
    private void browseSandboxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseSandboxButtonActionPerformed
        File sandboxDirectory = new FileChooserBuilder(Nette2OptionsPanel.class.getName() + NETTE_SANDBOX_SUFFIX)
                .setTitle(Bundle.LBL_SelectNetteSandbox())
                .setDirectoriesOnly(true)
                .showOpenDialog();
        if (sandboxDirectory != null) {
            sandboxDirectory = FileUtil.normalizeFile(sandboxDirectory);
            sandboxTextField.setText(sandboxDirectory.getAbsolutePath());
        }
    }//GEN-LAST:event_browseSandboxButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseNetteButton;
    private javax.swing.JButton browseSandboxButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel netteLabel;
    private javax.swing.JTextField netteTextField;
    private javax.swing.JLabel sandboxLabel;
    private javax.swing.JTextField sandboxTextField;
    // End of variables declaration//GEN-END:variables
}
