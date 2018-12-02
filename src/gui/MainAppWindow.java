/*
 * Created on Dec 8, 2018
 *
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;

import music.Performer;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainAppWindow {

    private JFrame frmBecauseTheNight;
    private JPanel northPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel southPanel;
    private JPanel centralPanel;
    private JLabel lblSongs;
    private JSplitPane splitPane;
    private JScrollPane leftScrollPane;
    private JScrollPane rightScrollPane;
    private JTextArea textAreaLyrics;
    private JLabel lblIllustration;
    private JTextField textFieldTitle;
    private JLabel lblTitle;
    private JLabel lblYear;
    private JButton btnSaveSong;
    private JTextField textField_Year;
    private JLabel lblPerformer;
    private JComboBox comboBoxPerformer;
    private JLabel lblDetails;
    private JRadioButton rdbtnBasic;
    private JRadioButton rdbtnStandard;
    private JRadioButton rdbtnAll;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JMenuBar menuBar;
    private JMenu mnFile;
    private JMenu mnEdit;
    private JMenu mnHelp;
    private JMenuItem mntmNew;
    private JMenuItem mntmOpen;
    private JMenuItem mntmSave;
    private JMenuItem mntmExit;
    private JSeparator separator;
    private JButton btnNewPerformer;
    private JButton btnDeletePerformer;
    private JLabel lblSongsCombo;
    private JComboBox comboBoxSongs;
    
    private NewPerformerDialog newPerformerDialog;
    private Performer newPerformer;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainAppWindow window = new MainAppWindow();
                    window.frmBecauseTheNight.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainAppWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmBecauseTheNight = new JFrame();
        frmBecauseTheNight.setTitle("Because the Night");
        frmBecauseTheNight.setBounds(100, 100, 809, 498);
        frmBecauseTheNight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBecauseTheNight.getContentPane().add(getNorthPanel(), BorderLayout.NORTH);
        frmBecauseTheNight.getContentPane().add(getWestPanel(), BorderLayout.WEST);
        frmBecauseTheNight.getContentPane().add(getEastPanel(), BorderLayout.EAST);
        frmBecauseTheNight.getContentPane().add(getSouthPanel(), BorderLayout.SOUTH);
        frmBecauseTheNight.getContentPane().add(getCentralPanel(), BorderLayout.CENTER);
        frmBecauseTheNight.setJMenuBar(getMenuBar());
    }

    private JPanel getNorthPanel() {
        if (northPanel == null) {
        	northPanel = new JPanel();
        	northPanel.add(getLblSongs());
        }
        return northPanel;
    }
    private JPanel getWestPanel() {
        if (westPanel == null) {
        	westPanel = new JPanel();
        	westPanel.setPreferredSize(new Dimension(150, 10));
        	westPanel.setLayout(new MigLayout("", "[grow]", "[][][][][][][grow][]"));
        	westPanel.add(getLblSongsCombo(), "cell 0 0");
        	westPanel.add(getComboBox_1(), "cell 0 1,growx");
        	westPanel.add(getLblTitle(), "cell 0 2");
        	westPanel.add(getTextFieldTitle(), "cell 0 3,growx");
        	westPanel.add(getLblYear(), "cell 0 4");
        	westPanel.add(getTextField_Year(), "cell 0 5,growx");
        	westPanel.add(getBtnSaveSong(), "cell 0 7,growx");
        }
        return westPanel;
    }
    private JPanel getEastPanel() {
        if (eastPanel == null) {
        	eastPanel = new JPanel();
        	eastPanel.setPreferredSize(new Dimension(150, 10));
        	eastPanel.setLayout(new MigLayout("", "[grow]", "[][][grow][][]"));
        	eastPanel.add(getLblPerformer(), "cell 0 0");
        	eastPanel.add(getComboBoxPerformer(), "cell 0 1,growx");
        	eastPanel.add(getBtnNewPerformer(), "cell 0 3,growx");
        	eastPanel.add(getBtnDeletePerformer(), "cell 0 4,growx");
        }
        return eastPanel;
    }
    private JPanel getSouthPanel() {
        if (southPanel == null) {
        	southPanel = new JPanel();
        	southPanel.setLayout(new MigLayout("", "[grow][][][][grow]", "[][]"));
        	southPanel.add(getLblDetails(), "cell 1 0 3 1,alignx center");
        	southPanel.add(getRdbtnBasic(), "cell 1 1");
        	southPanel.add(getRdbtnStandard(), "cell 2 1");
        	southPanel.add(getRdbtnAll(), "cell 3 1");
        }
        return southPanel;
    }
    private JPanel getCentralPanel() {
        if (centralPanel == null) {
        	centralPanel = new JPanel();
        	centralPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
        	centralPanel.add(getSplitPane(), "cell 0 0,grow");
        }
        return centralPanel;
    }
    private JLabel getLblSongs() {
        if (lblSongs == null) {
        	lblSongs = new JLabel("A beautiful song: < ... >");
        	lblSongs.setForeground(new Color(0, 0, 204));
        	lblSongs.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        return lblSongs;
    }
    private JSplitPane getSplitPane() {
        if (splitPane == null) {
        	splitPane = new JSplitPane();
        	splitPane.setDividerLocation(200);
        	splitPane.setOneTouchExpandable(true);
        	splitPane.setLeftComponent(getLeftScrollPane());
        	splitPane.setRightComponent(getRightScrollPane());
        }
        return splitPane;
    }
    private JScrollPane getLeftScrollPane() {
        if (leftScrollPane == null) {
        	leftScrollPane = new JScrollPane();
        	leftScrollPane.setViewportView(getTextAreaLyrics());
        }
        return leftScrollPane;
    }
    private JScrollPane getRightScrollPane() {
        if (rightScrollPane == null) {
        	rightScrollPane = new JScrollPane();
        	rightScrollPane.setViewportView(getLblIllustration());
        }
        return rightScrollPane;
    }
    private JTextArea getTextAreaLyrics() {
        if (textAreaLyrics == null) {
        	textAreaLyrics = new JTextArea();
        }
        return textAreaLyrics;
    }
    private JLabel getLblIllustration() {
        if (lblIllustration == null) {
        	lblIllustration = new JLabel("");
        	lblIllustration.setHorizontalAlignment(SwingConstants.CENTER);
        	lblIllustration.setIcon(new ImageIcon("M:\\Vladan\\Courses\\P2\\My Java Programs\\Eclipse Workspace\\BecauseTheNight\\Because the Night.jpg"));
        }
        return lblIllustration;
    }
    private JTextField getTextFieldTitle() {
        if (textFieldTitle == null) {
        	textFieldTitle = new JTextField();
        	textFieldTitle.setColumns(10);
        }
        return textFieldTitle;
    }
    private JLabel getLblTitle() {
        if (lblTitle == null) {
        	lblTitle = new JLabel("Title");
        }
        return lblTitle;
    }
    private JLabel getLblYear() {
        if (lblYear == null) {
        	lblYear = new JLabel("Year");
        }
        return lblYear;
    }
    private JButton getBtnSaveSong() {
        if (btnSaveSong == null) {
        	btnSaveSong = new JButton("Save song");
        }
        return btnSaveSong;
    }
    private JTextField getTextField_Year() {
        if (textField_Year == null) {
        	textField_Year = new JTextField();
        	textField_Year.setColumns(10);
        }
        return textField_Year;
    }
    private JLabel getLblPerformer() {
        if (lblPerformer == null) {
        	lblPerformer = new JLabel("Performer");
        }
        return lblPerformer;
    }
    private JComboBox getComboBoxPerformer() {
        if (comboBoxPerformer == null) {
        	comboBoxPerformer = new JComboBox();
        }
        return comboBoxPerformer;
    }
    private JLabel getLblDetails() {
        if (lblDetails == null) {
        	lblDetails = new JLabel("Details");
        	lblDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
        	lblDetails.setForeground(new Color(153, 0, 255));
        }
        return lblDetails;
    }
    private JRadioButton getRdbtnBasic() {
        if (rdbtnBasic == null) {
        	rdbtnBasic = new JRadioButton("Basic");
        	rdbtnBasic.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	    }
        	});
        	buttonGroup.add(rdbtnBasic);
        }
        return rdbtnBasic;
    }
    private JRadioButton getRdbtnStandard() {
        if (rdbtnStandard == null) {
        	rdbtnStandard = new JRadioButton("Standard");
        	rdbtnStandard.setSelected(true);
        	buttonGroup.add(rdbtnStandard);
        }
        return rdbtnStandard;
    }
    private JRadioButton getRdbtnAll() {
        if (rdbtnAll == null) {
        	rdbtnAll = new JRadioButton("All");
        	buttonGroup.add(rdbtnAll);
        }
        return rdbtnAll;
    }
    private JMenuBar getMenuBar() {
        if (menuBar == null) {
        	menuBar = new JMenuBar();
        	menuBar.add(getMnFile());
        	menuBar.add(getMnEdit());
        	menuBar.add(getMnHelp());
        }
        return menuBar;
    }
    private JMenu getMnFile() {
        if (mnFile == null) {
        	mnFile = new JMenu("File");
        	mnFile.add(getMntmNew());
        	mnFile.add(getMntmOpen());
        	mnFile.add(getMntmSave());
        	mnFile.add(getSeparator());
        	mnFile.add(getMntmExit());
        }
        return mnFile;
    }
    private JMenu getMnEdit() {
        if (mnEdit == null) {
        	mnEdit = new JMenu("Edit");
        }
        return mnEdit;
    }
    private JMenu getMnHelp() {
        if (mnHelp == null) {
        	mnHelp = new JMenu("Help");
        }
        return mnHelp;
    }
    private JMenuItem getMntmNew() {
        if (mntmNew == null) {
        	mntmNew = new JMenuItem("New...");
        	mntmNew.setAlignmentX(Component.LEFT_ALIGNMENT);
        }
        return mntmNew;
    }
    private JMenuItem getMntmOpen() {
        if (mntmOpen == null) {
        	mntmOpen = new JMenuItem("Open...");
        }
        return mntmOpen;
    }
    private JMenuItem getMntmSave() {
        if (mntmSave == null) {
        	mntmSave = new JMenuItem("Save...");
        }
        return mntmSave;
    }
    private JMenuItem getMntmExit() {
        if (mntmExit == null) {
        	mntmExit = new JMenuItem("Exit");
        }
        return mntmExit;
    }
    private JSeparator getSeparator() {
        if (separator == null) {
        	separator = new JSeparator();
        }
        return separator;
    }
    private JButton getBtnNewPerformer() {
        if (btnNewPerformer == null) {
        	btnNewPerformer = new JButton("New performer");
        	btnNewPerformer.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        newPerformer = getNewPerformerDialog().showDialog();
        	    }
        	});
        }
        return btnNewPerformer;
    }
    private JButton getBtnDeletePerformer() {
        if (btnDeletePerformer == null) {
        	btnDeletePerformer = new JButton("Delete performer");
        }
        return btnDeletePerformer;
    }
    private JLabel getLblSongsCombo() {
        if (lblSongsCombo == null) {
        	lblSongsCombo = new JLabel("Songs");
        }
        return lblSongsCombo;
    }
    private JComboBox getComboBox_1() {
        if (comboBoxSongs == null) {
        	comboBoxSongs = new JComboBox();
        }
        return comboBoxSongs;
    }
    private NewPerformerDialog getNewPerformerDialog() {
        if (newPerformerDialog == null) {
            newPerformerDialog = new NewPerformerDialog(frmBecauseTheNight, true);
        }
        return newPerformerDialog;
    }
}
