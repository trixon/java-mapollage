/*
 * Copyright 2018 Patrik Karlström.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.mapollage.ui;

import java.util.prefs.PreferenceChangeEvent;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import se.trixon.almond.util.Dict;
import se.trixon.almond.util.swing.LogPanel;
import se.trixon.mapollage.Options;

/**
 *
 * @author Patrik Karlström
 */
public class StatusPanel extends javax.swing.JPanel {

    private final Options mOptions = Options.getInstance();

    /**
     * Creates new form StatusPanel
     */
    public StatusPanel() {
        initComponents();
        mOptions.getPreferences().addPreferenceChangeListener((PreferenceChangeEvent evt) -> {
            if (evt.getKey().equalsIgnoreCase(Options.KEY_WORD_WRAP)) {
                logOutPanel.setWordWrap(mOptions.isWordWrap());
                logErrPanel.setWordWrap(mOptions.isWordWrap());
            }
        });

        logOutPanel.setWordWrap(mOptions.isWordWrap());
        logErrPanel.setWordWrap(mOptions.isWordWrap());
        autoOpenCheckBox.setSelected(mOptions.isAutoOpen());
    }

    public JCheckBox getAutoOpenCheckBox() {
        return autoOpenCheckBox;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public LogPanel getLogErrPanel() {
        return logErrPanel;
    }

    public LogPanel getLogOutPanel() {
        return logOutPanel;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void reset() {
        logErrPanel.clear();
        logOutPanel.clear();
        tabbedPane.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tabbedPane = new javax.swing.JTabbedPane();
        logOutPanel = new se.trixon.almond.util.swing.LogPanel();
        logErrPanel = new se.trixon.almond.util.swing.LogPanel();
        progressBar = new javax.swing.JProgressBar();
        autoOpenCheckBox = new javax.swing.JCheckBox();

        setLayout(new java.awt.GridBagLayout());

        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabbedPane.addTab(Dict.OUTPUT.toString().toLowerCase(), logOutPanel);
        tabbedPane.addTab(Dict.Dialog.ERROR.toString().toLowerCase(), logErrPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(tabbedPane, gridBagConstraints);

        progressBar.setString(" "); // NOI18N
        progressBar.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(progressBar, gridBagConstraints);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("se/trixon/mapollage/ui/Bundle"); // NOI18N
        autoOpenCheckBox.setText(bundle.getString("StatusPanel.autoOpenCheckBox.text")); // NOI18N
        autoOpenCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoOpenCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 0, 0);
        add(autoOpenCheckBox, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void autoOpenCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoOpenCheckBoxActionPerformed
        mOptions.setAutoOpen(autoOpenCheckBox.isSelected());
    }//GEN-LAST:event_autoOpenCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoOpenCheckBox;
    private se.trixon.almond.util.swing.LogPanel logErrPanel;
    private se.trixon.almond.util.swing.LogPanel logOutPanel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
