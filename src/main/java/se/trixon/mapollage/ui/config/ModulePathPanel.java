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
package se.trixon.mapollage.ui.config;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import se.trixon.almond.util.Dict;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.mapollage.profile.Profile;
import se.trixon.mapollage.profile.ProfilePath;
import se.trixon.mapollage.profile.ProfilePath.SplitBy;

/**
 *
 * @author Patrik Karlström
 */
public class ModulePathPanel extends ModulePanel {

    private ProfilePath mPath;

    /**
     * Creates new form ModulePathPanel
     */
    public ModulePathPanel() {
        initComponents();
        init();
    }

    @Override
    public ImageIcon getIcon() {
        return MaterialIcon._Action.TIMELINE.get(ICON_SIZE);
    }

    @Override
    public boolean hasValidSettings() {
        return true;
    }

    @Override
    public void load(Profile profile) {
        mProfile = profile;

        if (mProfile != null) {
            mPath = profile.getPath();

            drawPathCheckBox.setSelected(mPath.isDrawPath());
            drawPolygonCheckBox.setSelected(mPath.isDrawPolygon());
            widthSpinner.setValue(mPath.getWidth());

            switch (mPath.getSplitBy()) {
                case HOUR:
                    hourRadioButton.setSelected(true);
                    hourRadioButtonActionPerformed(null);
                    break;

                case DAY:
                    dayRadioButton.setSelected(true);
                    dayRadioButtonActionPerformed(null);
                    break;

                case WEEK:
                    weekRadioButton.setSelected(true);
                    weekRadioButtonActionPerformed(null);
                    break;

                case MONTH:
                    monthRadioButton.setSelected(true);
                    monthRadioButtonActionPerformed(null);
                    break;

                case YEAR:
                    yearRadioButton.setSelected(true);
                    yearRadioButtonActionPerformed(null);
                    break;

                case NONE:
                    noSplitRadioButton.setSelected(true);
                    noSplitRadioButtonActionPerformed(null);
                    break;
            }
        }
    }

    private void init() {
        mTitle = Dict.PATH_GFX.toString();

        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(widthSpinner, "0.0");
        DecimalFormat format = editor.getFormat();
        format.setDecimalFormatSymbols(new DecimalFormatSymbols(getDefaultLocale()));
        widthSpinner.setEditor(editor);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        splitButtonGroup = new javax.swing.ButtonGroup();
        drawPathCheckBox = new javax.swing.JCheckBox();
        widthLabel = new javax.swing.JLabel();
        widthSpinner = new javax.swing.JSpinner();
        splitByLabel = new javax.swing.JLabel();
        hourRadioButton = new javax.swing.JRadioButton();
        dayRadioButton = new javax.swing.JRadioButton();
        weekRadioButton = new javax.swing.JRadioButton();
        monthRadioButton = new javax.swing.JRadioButton();
        yearRadioButton = new javax.swing.JRadioButton();
        noSplitRadioButton = new javax.swing.JRadioButton();
        drawPolygonCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("se/trixon/mapollage/ui/config/Bundle"); // NOI18N
        drawPathCheckBox.setText(bundle.getString("ModulePathPanel.drawPathCheckBox.text")); // NOI18N
        drawPathCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawPathCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(drawPathCheckBox, gridBagConstraints);

        widthLabel.setText(Dict.WIDTH.toString());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(widthLabel, gridBagConstraints);

        widthSpinner.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, 10.0d, 0.1d));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, drawPathCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), widthSpinner, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        widthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                widthSpinnerStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(widthSpinner, gridBagConstraints);

        splitByLabel.setText(Dict.SPLIT_BY.toString());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(splitByLabel, gridBagConstraints);

        splitButtonGroup.add(hourRadioButton);
        hourRadioButton.setText(Dict.Time.HOUR.toString());

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, drawPathCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), hourRadioButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        hourRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(hourRadioButton, gridBagConstraints);

        splitButtonGroup.add(dayRadioButton);
        dayRadioButton.setText(Dict.Time.DAY.toString());

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, drawPathCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), dayRadioButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        dayRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(dayRadioButton, gridBagConstraints);

        splitButtonGroup.add(weekRadioButton);
        weekRadioButton.setText(Dict.Time.WEEK.toString());

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, drawPathCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), weekRadioButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        weekRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weekRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(weekRadioButton, gridBagConstraints);

        splitButtonGroup.add(monthRadioButton);
        monthRadioButton.setText(Dict.Time.MONTH.toString());

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, drawPathCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), monthRadioButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        monthRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(monthRadioButton, gridBagConstraints);

        splitButtonGroup.add(yearRadioButton);
        yearRadioButton.setText(Dict.Time.YEAR.toString());

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, drawPathCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), yearRadioButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        yearRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(yearRadioButton, gridBagConstraints);

        splitButtonGroup.add(noSplitRadioButton);
        noSplitRadioButton.setText(Dict.DO_NOT_SPLIT.toString());

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, drawPathCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), noSplitRadioButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        noSplitRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noSplitRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(noSplitRadioButton, gridBagConstraints);

        drawPolygonCheckBox.setText(bundle.getString("ModulePathPanel.drawPolygonCheckBox.text")); // NOI18N
        drawPolygonCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawPolygonCheckBoxActionPerformed(evt);
            }
        });
        add(drawPolygonCheckBox, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void drawPathCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawPathCheckBoxActionPerformed
        mPath.setDrawPath(drawPathCheckBox.isSelected());
    }//GEN-LAST:event_drawPathCheckBoxActionPerformed

    private void widthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_widthSpinnerStateChanged
        mPath.setWidth((Double) widthSpinner.getModel().getValue());
    }//GEN-LAST:event_widthSpinnerStateChanged

    private void hourRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourRadioButtonActionPerformed
        mPath.setSplitBy(SplitBy.HOUR);
    }//GEN-LAST:event_hourRadioButtonActionPerformed

    private void dayRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayRadioButtonActionPerformed
        mPath.setSplitBy(SplitBy.DAY);
    }//GEN-LAST:event_dayRadioButtonActionPerformed

    private void weekRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekRadioButtonActionPerformed
        mPath.setSplitBy(SplitBy.WEEK);
    }//GEN-LAST:event_weekRadioButtonActionPerformed

    private void monthRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthRadioButtonActionPerformed
        mPath.setSplitBy(SplitBy.MONTH);
    }//GEN-LAST:event_monthRadioButtonActionPerformed

    private void yearRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearRadioButtonActionPerformed
        mPath.setSplitBy(SplitBy.YEAR);
    }//GEN-LAST:event_yearRadioButtonActionPerformed

    private void noSplitRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noSplitRadioButtonActionPerformed
        mPath.setSplitBy(SplitBy.NONE);
    }//GEN-LAST:event_noSplitRadioButtonActionPerformed

    private void drawPolygonCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawPolygonCheckBoxActionPerformed
        mPath.setDrawPolygon(drawPolygonCheckBox.isSelected());
    }//GEN-LAST:event_drawPolygonCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton dayRadioButton;
    private javax.swing.JCheckBox drawPathCheckBox;
    private javax.swing.JCheckBox drawPolygonCheckBox;
    private javax.swing.JRadioButton hourRadioButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton monthRadioButton;
    private javax.swing.JRadioButton noSplitRadioButton;
    private javax.swing.ButtonGroup splitButtonGroup;
    private javax.swing.JLabel splitByLabel;
    private javax.swing.JRadioButton weekRadioButton;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JSpinner widthSpinner;
    private javax.swing.JRadioButton yearRadioButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
