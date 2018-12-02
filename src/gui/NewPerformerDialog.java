/*
 * Created on Dec 8, 2018
 *
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import music.Performer;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewPerformerDialog extends JDialog {
    private JPanel southPanel;
    private JButton btnOk;
    private JButton btnCance;
    private JTabbedPane tabbedPane;
    private JPanel panelBasicInfo;
    private JPanel panelFirstPerformance;
    private JLabel lblName;
    private JLabel lblAge;
    private JTextField textFieldName;
    private JLabel lblLocation;
    private JLabel lblDate;
    private JTextField textFieldLocation;
    private JTextField textFieldAge;
    private JSpinner spinnerYear;
    private JSpinner spinnerMonth;
    private JSpinner spinnerDay;
    private JLabel lblAliveAndKicking;
    private JComboBox comboBox;
    
    private Performer performer;
    private NewPerformerDialog thisNewDialog = this;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewPerformerDialog dialog = new NewPerformerDialog();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the dialog.
     */
    public NewPerformerDialog(JFrame owner, boolean modal) {
        super(owner, modal);
        setTitle("New performer");
        setBounds(150, 150, 450, 300);
        getContentPane().add(getSouthPanel(), BorderLayout.SOUTH);
        getContentPane().add(getTabbedPane(), BorderLayout.CENTER);

    }
    public NewPerformerDialog() {
        setTitle("New performer");
        setBounds(150, 150, 450, 300);
        getContentPane().add(getSouthPanel(), BorderLayout.SOUTH);
        getContentPane().add(getTabbedPane(), BorderLayout.CENTER);

    }
    private JPanel getSouthPanel() {
        if (southPanel == null) {
        	southPanel = new JPanel();
        	FlowLayout fl_southPanel = (FlowLayout) southPanel.getLayout();
        	fl_southPanel.setAlignment(FlowLayout.RIGHT);
        	southPanel.add(getBtnOk());
        	southPanel.add(getBtnCance());
        }
        return southPanel;
    }
    private JButton getBtnOk() {
        if (btnOk == null) {
        	btnOk = new JButton("OK");
        	btnOk.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    thisNewDialog.setVisible(false);
        	        performer = null;
        	    }
        	});
        }
        return btnOk;
    }
    private JButton getBtnCance() {
        if (btnCance == null) {
        	btnCance = new JButton("Cancel");
        	btnCance.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        thisNewDialog.setVisible(false);
                    performer = null;
        	    }
        	});
        }
        return btnCance;
    }
    private JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
        	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        	tabbedPane.addTab("Basic info", null, getPanelBasicInfo(), null);
        	tabbedPane.addTab("First performance", null, getPanelFirstPerformance(), null);
        }
        return tabbedPane;
    }
    private JPanel getPanelBasicInfo() {
        if (panelBasicInfo == null) {
        	panelBasicInfo = new JPanel();
        	panelBasicInfo.setLayout(new MigLayout("", "[27px][86px,grow,fill]", "[20px][][]"));
        	panelBasicInfo.add(getLblName(), "cell 0 0,alignx left,aligny center");
        	panelBasicInfo.add(getTextFieldName(), "cell 1 0,alignx left,aligny top");
        	panelBasicInfo.add(getLblAge(), "cell 0 1,alignx leading,aligny center");
        	panelBasicInfo.add(getTextFieldAge(), "cell 1 1,growx");
        	panelBasicInfo.add(getLblAliveAndKicking(), "cell 0 2,alignx trailing");
        	panelBasicInfo.add(getComboBox(), "cell 1 2,growx");
        }
        return panelBasicInfo;
    }
    private JPanel getPanelFirstPerformance() {
        if (panelFirstPerformance == null) {
        	panelFirstPerformance = new JPanel();
        	panelFirstPerformance.setLayout(new MigLayout("", "[][grow][grow][grow]", "[][]"));
        	panelFirstPerformance.add(getLblLocation(), "cell 0 0,alignx trailing");
        	panelFirstPerformance.add(getTextFieldLocation(), "cell 1 0 3 1,growx");
        	panelFirstPerformance.add(getLblDate(), "cell 0 1");
        	panelFirstPerformance.add(getSpinner_1(), "cell 1 1,growx");
        	panelFirstPerformance.add(getSpinner_2(), "cell 2 1,growx");
        	panelFirstPerformance.add(getSpinnerDay(), "cell 3 1,growx");
        }
        return panelFirstPerformance;
    }
    private JLabel getLblName() {
        if (lblName == null) {
        	lblName = new JLabel("Name");
        }
        return lblName;
    }
    private JLabel getLblAge() {
        if (lblAge == null) {
        	lblAge = new JLabel("Age");
        }
        return lblAge;
    }
    private JTextField getTextFieldName() {
        if (textFieldName == null) {
        	textFieldName = new JTextField();
        	textFieldName.setColumns(10);
        }
        return textFieldName;
    }
    private JLabel getLblLocation() {
        if (lblLocation == null) {
        	lblLocation = new JLabel("Location");
        }
        return lblLocation;
    }
    private JLabel getLblDate() {
        if (lblDate == null) {
        	lblDate = new JLabel("Date");
        }
        return lblDate;
    }
    private JTextField getTextFieldLocation() {
        if (textFieldLocation == null) {
        	textFieldLocation = new JTextField();
        	textFieldLocation.setColumns(10);
        }
        return textFieldLocation;
    }
    private JTextField getTextFieldAge() {
        if (textFieldAge == null) {
        	textFieldAge = new JTextField();
        	textFieldAge.setColumns(10);
        }
        return textFieldAge;
    }
    private JSpinner getSpinner_1() {
        if (spinnerYear == null) {
        	spinnerYear = new JSpinner();
        }
        return spinnerYear;
    }
    private JSpinner getSpinner_2() {
        if (spinnerMonth == null) {
        	spinnerMonth = new JSpinner();
        }
        return spinnerMonth;
    }
    private JSpinner getSpinnerDay() {
        if (spinnerDay == null) {
        	spinnerDay = new JSpinner();
        }
        return spinnerDay;
    }
    private JLabel getLblAliveAndKicking() {
        if (lblAliveAndKicking == null) {
        	lblAliveAndKicking = new JLabel("Alive and kicking");
        }
        return lblAliveAndKicking;
    }
    private JComboBox getComboBox() {
        if (comboBox == null) {
        	comboBox = new JComboBox();
        }
        return comboBox;
    }
    public Performer showDialog() {
        this.setVisible(true);
        this.dispose();
        return performer;
    }
}
