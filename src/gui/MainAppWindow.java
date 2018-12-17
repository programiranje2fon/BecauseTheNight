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
import util.Utility;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import music.Performer;
import music.Song;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.print.attribute.TextSyntax;
import javax.swing.ButtonGroup;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
    private JTextField textFieldYear;
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
    private Song song;
    private ArrayList<Performer> performers = new ArrayList<Performer>();
    private ArrayList<Song> songs = new ArrayList<Song>();
    private JButton btnSelectIllustration;

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
        frmBecauseTheNight.getContentPane().add(getCentralPanel(), BorderLayout.CENTER);
        frmBecauseTheNight.getContentPane().add(getSouthPanel(), BorderLayout.SOUTH);
        frmBecauseTheNight.setJMenuBar(getMenuBar());
        
        deserializeData();
    }

    private void deserializeData() {
//        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(Utility.mkProjectSubdir("resources") + '\\' + "performers")))) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(Utility.getPerformersFilename())))) {
            performers = (ArrayList<Performer>) in.readObject();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Performer performer : performers) {
            comboBoxPerformer.addItem(performer.getName());
        }
        
//        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(Utility.mkProjectSubdir("resources") + '\\' + "songs")))) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(Utility.getSongsFilename())))) {
            songs = (ArrayList<Song>) in.readObject();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Song song : songs) {
            comboBoxSongs.addItem(song.getTitle());
        }
        
        textAreaLyrics.setText(songs.get(0).getLyrics());
        lblIllustration.setIcon(songs.get(0).getIcon());
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
        	westPanel.setLayout(new MigLayout("", "[grow]", "[][][][][][][grow][][]"));
        	westPanel.add(getLblSongsCombo(), "cell 0 0");
        	westPanel.add(getComboBox_1(), "cell 0 1,growx");
        	westPanel.add(getLblTitle(), "cell 0 2");
        	westPanel.add(getTextFieldTitle(), "cell 0 3,growx");
        	westPanel.add(getLblYear(), "cell 0 4");
        	westPanel.add(getTextField_Year(), "cell 0 5,growx");
        	westPanel.add(getBtnSelectIllustration(), "cell 0 7,growx");
        	westPanel.add(getBtnSaveSong(), "cell 0 8,growx");
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
//            lblIllustration.setIcon(new ImageIcon("M:\\Vladan\\Courses\\P2\\My Java Programs\\Eclipse Workspace\\BecauseTheNight\\Because the Night Sheet.png"));
//            lblIllustration.setIcon(new ImageIcon(Utility.mkProjectSubdir("resources") + '\\' + "Because the Night Sheet.png"));
            lblIllustration.setIcon(new ImageIcon(Utility.getResourcesDir() + "Because the Night Sheet.png"));
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
        	btnSaveSong.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	        if ((textFieldTitle.getText() != null) && (!textFieldTitle.getText().equals(""))) {
        	            
        	            comboBoxSongs.addItem(textFieldTitle.getText());
        	            
        	            song = new Song();
        	            song.setTitle(textFieldTitle.getText());
        	            song.setYear(Integer.parseInt(textFieldYear.getText()));
        	            song.setLyrics(textAreaLyrics.getText());
        	            
        	            Performer performer = new Performer((String) comboBoxPerformer.getSelectedItem());
        	            boolean found = false;
        	            for (Performer p : performers) {
                            if (performer.getName().equals(p.getName())) {
                                performer = p;
                                found = true;
                                break;
                            }
                        }
        	            if (found) {
                            song.setPerformer(performer);
                        }
        	            
        	            if (lblIllustration.getIcon() != null) {
        	                song.setIcon(lblIllustration.getIcon());
        	            }
        	            
        	            lblSongs.setText("A nice song: " + (String) comboBoxSongs.getSelectedItem());
        	            
        	            songs.add(song);
        	        }
        	    }
        	});
        }
        return btnSaveSong;
    }
    private JTextField getTextField_Year() {
        if (textFieldYear == null) {
        	textFieldYear = new JTextField();
        	textFieldYear.setColumns(10);
        }
        return textFieldYear;
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
        	        splitPane.setVisible(false);
        	        lblPerformer.setVisible(false);
        	        comboBoxPerformer.setVisible(false);
        	        btnDeletePerformer.setVisible(false);
        	        btnNewPerformer.setVisible(false);
        	    }
        	});
        	buttonGroup.add(rdbtnBasic);
        }
        return rdbtnBasic;
    }
    private JRadioButton getRdbtnStandard() {
        if (rdbtnStandard == null) {
        	rdbtnStandard = new JRadioButton("Standard");
        	rdbtnStandard.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
                    splitPane.setVisible(true);
                    lblPerformer.setVisible(false);
                    comboBoxPerformer.setVisible(false);
                    btnDeletePerformer.setVisible(false);
                    btnNewPerformer.setVisible(false);
        	    }
        	});
        	rdbtnStandard.setSelected(true);
        	buttonGroup.add(rdbtnStandard);
        }
        return rdbtnStandard;
    }
    private JRadioButton getRdbtnAll() {
        if (rdbtnAll == null) {
        	rdbtnAll = new JRadioButton("All");
        	rdbtnAll.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    splitPane.setVisible(true);
                    lblPerformer.setVisible(true);
                    comboBoxPerformer.setVisible(true);
                    btnDeletePerformer.setVisible(true);
                    btnNewPerformer.setVisible(true);
        	    }
        	});
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
        	mntmSave.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        serialize();
        	    }

                private void serialize() {
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(Utility.getSongsFilename())))) {
                        out.writeObject(songs);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(Utility.getPerformersFilename())))) {
                        out.writeObject(performers);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(frmBecauseTheNight, "Data saved.");
                }
        	});
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
        	        if (newPerformer != null) {
        	            comboBoxPerformer.addItem(newPerformer.getName());
        	            performers.add(newPerformer);
        	        }
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
        	comboBoxSongs.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent e) {
        	        if (e.getStateChange() == ItemEvent.SELECTED) {
        	            boolean found = false;
        	            int i = 0;
        	            while (!found && (i < songs.size())) {
                            if (songs.get(i).getTitle().equals((String) comboBoxSongs.getSelectedItem())) {
                                found = true;
                                break;
                            }
                            i++;
        	            }
        	            if (found) {
        	                textFieldTitle.setText(songs.get(i).getTitle());
        	                textFieldYear.setText(Integer.toString(songs.get(i).getYear()));
        	                textAreaLyrics.setText(songs.get(i).getLyrics());
        	                lblSongs.setText("A nice song: " + (String) comboBoxSongs.getSelectedItem());
        	                lblIllustration.setIcon(songs.get(i).getIcon());
        	            }
        	        }
        	    }
        	});
        }
        return comboBoxSongs;
    }
    private NewPerformerDialog getNewPerformerDialog() {
        if (newPerformerDialog == null) {
            newPerformerDialog = new NewPerformerDialog(frmBecauseTheNight, true);
        }
        return newPerformerDialog;
    }
    private JButton getBtnSelectIllustration() {
        if (btnSelectIllustration == null) {
        	btnSelectIllustration = new JButton("Select illustration");
        	btnSelectIllustration.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	        JFileChooser c = new JFileChooser(Utility.mkProjectSubdir("resources"));
        	        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        	            "Image files", "jpg", "jpeg", "png", "gif");
        	        c.setFileFilter(filter);
        	        int returnVal = c.showOpenDialog(frmBecauseTheNight);
        	        if(returnVal == JFileChooser.APPROVE_OPTION) {
//        	           System.out.println("You chose to open this file: " +
//        	                c.getSelectedFile().getName());
        	            lblIllustration.setIcon(new ImageIcon(Utility.getResourcesDir() + c.getSelectedFile().getName()));
        	        }
        	    }
        	});
        }
        return btnSelectIllustration;
    }
}
