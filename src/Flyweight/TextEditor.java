package Flyweight;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel fontLable;
    JComboBox fontBox;
    JComboBox colorBox;
    JComboBox sizeBox;

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null); // place window in middle of screen

        textArea = new JTextArea();
        //textArea.setPreferredSize(new Dimension(450,450));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Jokerman", Font.PLAIN, 20));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontLable = new JLabel("Font");

        String[] fonts = {"Arial", "Calibri", "Verdana"};
        fontBox = new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Arial");

        //--------------- menuBar----------------//
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        //--------------- menuBar----------------//


        Integer[] sizes = {12,14,16};
        sizeBox = new JComboBox(sizes);
        sizeBox.addActionListener(this);
        sizeBox.setSelectedItem(12);

        Color[] colors = {Color.red, Color.blue, Color.black};
        colorBox = new JComboBox(colors);
        colorBox.addActionListener(this);
        colorBox.setSelectedItem(Color.black);

        this.setJMenuBar(menuBar);
        this.add(fontLable);
        this.add(sizeBox);
        this.add(fontBox);
        this.add(colorBox);
        this.add(scrollPane);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == colorBox){
            textArea.setForeground((Color) colorBox.getSelectedItem());
        }
        if(e.getSource() == fontBox){
            textArea.setFont(new Font((String) fontBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }
        if(e.getSource() == sizeBox){
            textArea.setFont(new Font(textArea.getFont().toString(), Font.PLAIN, (Integer) sizeBox.getSelectedItem()));
        }
        if(e.getSource() == openItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;

                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()){
                        while (fileIn.hasNextLine()){
                            String line = fileIn.nextLine() + "\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                finally{
                    fileIn.close();
                }
            }
        }
        if(e.getSource() == saveItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file;
                PrintWriter fileOut = null;

                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(textArea.getText());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                finally{
                    fileOut.close();
                }
            }
        }
        if(e.getSource() == exitItem){
            System.exit(0);
        }
    }
}
