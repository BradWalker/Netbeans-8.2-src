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
package org.netbeans.modules.web.jsf.wizards;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.util.ChangeSupport;

/**
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
public class FacesComponentPanelVisual extends javax.swing.JPanel implements ChangeListener {

    private static final long serialVersionUID = 1L;

    private final ChangeSupport changeSupport = new ChangeSupport(this);

    /**
     * Creates new form FacesComponentPanelVisual
     */
    public FacesComponentPanelVisual() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tagNameLabel = new javax.swing.JLabel();
        tagNamespaceLabel = new javax.swing.JLabel();
        tagNamespaceTextField = new javax.swing.JTextField();
        tagNameTextField = new javax.swing.JTextField();
        sampleCodeCheckBox = new javax.swing.JCheckBox();

        tagNameLabel.setLabelFor(tagNameTextField);
        org.openide.awt.Mnemonics.setLocalizedText(tagNameLabel, org.openide.util.NbBundle.getMessage(FacesComponentPanelVisual.class, "FacesComponentPanelVisual.tagNameLabel.text")); // NOI18N

        tagNamespaceLabel.setLabelFor(tagNamespaceTextField);
        org.openide.awt.Mnemonics.setLocalizedText(tagNamespaceLabel, org.openide.util.NbBundle.getMessage(FacesComponentPanelVisual.class, "FacesComponentPanelVisual.tagNamespaceLabel.text")); // NOI18N

        tagNamespaceTextField.setText("http://xmlns.jcp.org/jsf/component"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(sampleCodeCheckBox, org.openide.util.NbBundle.getMessage(FacesComponentPanelVisual.class, "FacesComponentPanelVisual.sampleCodeCheckBox.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tagNamespaceLabel)
                    .addComponent(tagNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tagNamespaceTextField)
                    .addComponent(tagNameTextField)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(sampleCodeCheckBox)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tagNameLabel)
                    .addComponent(tagNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tagNamespaceLabel)
                    .addComponent(tagNamespaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sampleCodeCheckBox))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox sampleCodeCheckBox;
    private javax.swing.JLabel tagNameLabel;
    private javax.swing.JTextField tagNameTextField;
    private javax.swing.JLabel tagNamespaceLabel;
    private javax.swing.JTextField tagNamespaceTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void stateChanged(ChangeEvent e) {
    }

    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    public String getTagName() {
        return tagNameTextField.getText();
    }

    public String getTagNamespace() {
        return tagNamespaceTextField.getText();
    }

    public boolean isSampleCode() {
        return sampleCodeCheckBox.isSelected();
    }
}
