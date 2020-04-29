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
package org.netbeans.modules.vmd.midpnb.propertyeditors;

import org.netbeans.modules.vmd.api.model.DesignComponent;
import org.netbeans.modules.vmd.api.model.TypeID;
import org.netbeans.modules.vmd.midp.actions.GoToSourceSupport;
import org.netbeans.modules.vmd.midp.propertyeditors.api.resource.element.PropertyEditorResourceElement;
import org.netbeans.modules.vmd.midpnb.components.resources.SimpleCancellableTaskCD;

import javax.swing.*;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import org.netbeans.modules.vmd.midp.propertyeditors.CleanUp;

/**
 *
 * @author Anton Chechel
 */
public class TaskEditorElement extends PropertyEditorResourceElement implements CleanUp {

    private WeakReference<DesignComponent> component;

    public void clean(DesignComponent component) {
        this.component = null;
        gotoButton = null;
        jScrollPane1 = null;
        jTextArea1 = null;
        taskLabel = null;
        this.removeAll();
    }

    public TaskEditorElement() {
         initComponents();
    }

    public JComponent getJComponent() {
        return this;
    }

    public TypeID getTypeID() {
        return SimpleCancellableTaskCD.TYPEID;
    }

    public List<String> getPropertyValueNames() {
        return Arrays.asList(SimpleCancellableTaskCD.PROP_CODE);
    }

    @Override
    public String getResourceNameSuggestion() {
        return "task"; // NOI18N
    }

    public void setDesignComponentWrapper(final DesignComponentWrapper wrapper) {
        boolean enableGoTo = true;
        if (wrapper != null) {
            DesignComponent _component = wrapper.getComponent();
            if (enableGoTo = _component != null) {
                component = new WeakReference<DesignComponent>(_component);
            }
        } else {
            component = null;
        }

        // UI stuff
        if (taskLabel == null) {
            return;
        }
        taskLabel.setEnabled(wrapper != null);
        gotoButton.setEnabled(wrapper != null && enableGoTo);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        taskLabel = new javax.swing.JLabel();
        gotoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        taskLabel.setLabelFor(jTextArea1);
        org.openide.awt.Mnemonics.setLocalizedText(taskLabel, org.openide.util.NbBundle.getMessage(TaskEditorElement.class, "TaskEditorElement.taskLabel.text")); // NOI18N
        taskLabel.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(gotoButton, org.openide.util.NbBundle.getMessage(TaskEditorElement.class, "TaskEditorElement.gotoButton.text")); // NOI18N
        gotoButton.setEnabled(false);
        gotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoButtonActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(org.openide.util.NbBundle.getMessage(TaskEditorElement.class, "TaskEditorElement.jTextArea1.text")); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TaskEditorElement.class, "ACSN_GoToSourceComment")); // NOI18N
        jTextArea1.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(TaskEditorElement.class, "ACSD_GoToSourceComment")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskLabel)
                    .addComponent(gotoButton))
                .addGap(43, 43, 43))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(taskLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gotoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
        );

        gotoButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TaskEditorElement.class, "ACSN_GoToSource")); // NOI18N
        gotoButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(TaskEditorElement.class, "ACSD_GoToSource")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void gotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoButtonActionPerformed
        if (component != null) {
            DesignComponent _component = component.get();
            if (_component != null) {
                GoToSourceSupport.goToSourceOfComponent(_component);
            }
        }
}//GEN-LAST:event_gotoButtonActionPerformed
    // Variables declaration - do not modify
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gotoButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel taskLabel;
    // End of variables declaration//GEN-END:variables
}