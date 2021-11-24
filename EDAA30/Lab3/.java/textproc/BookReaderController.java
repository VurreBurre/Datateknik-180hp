package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class BookReaderController{

	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 300, 500));
	}
	
	
	private void createWindow(GeneralWordCounter counter, String title, int width, int height)  {
		SortedListModel<Map.Entry<String, Integer>> model = new SortedListModel<>(counter.getWordList());
		JList<Map.Entry<String, Integer>> listView = new JList<>(model);
		listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.add(listView, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		pane.add(panel, BorderLayout.SOUTH);
		JButton ButtonOne = new JButton("Alphabetic");
		JButton ButtonTwo = new JButton("Frequency");
		JButton ButtonSearch = new JButton("Search");
		JTextField text = new JTextField(5);
		panel.add(ButtonOne);
		panel.add(ButtonTwo);
		panel.add(ButtonSearch);
		panel.add(text);
		ButtonTwo.addActionListener(event -> model.sort((o1,o2) -> o2.getValue() - o1.getValue()));
		ButtonOne.addActionListener(event -> model.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey())));
		frame.getRootPane().setDefaultButton(ButtonSearch);
		
		ButtonSearch.addActionListener(event -> {
			int k=0;
			/*for (Map.Entry<String, Integer> s: model.getList()) {
			
				if (s.getKey().compareTo(text.getText().toLowerCase().trim()) == 0) {
					System.out.println("sus");
					listView.ensureIndexIsVisible(model.getList().indexOf(s));
					listView.setSelectedIndex(model.getList().indexOf(s));
					k++;
					break;
					
				}
				
		}
		*/
			
			for (int i = 0; i < model.getSize(); i++) {
				if (model.getElementAt(i).getKey().compareTo(text.getText().toLowerCase().trim()) == 0) {
					k++;
					listView.ensureIndexIsVisible(i);
					listView.setSelectedIndex(i);
					break;
				}
				
			}
			if (k==0) {
				JOptionPane.showMessageDialog(null, "Ordet finns inte i listan");
			}
		
			
		});
		

		
		

		JScrollPane scrollPane = new JScrollPane(listView);
		 scrollPane.setPreferredSize(new Dimension(width, height));
		pane.add(scrollPane);
			 frame.pack();
				frame.setVisible(true);
			 }


	}
	


