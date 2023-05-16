package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class EditorTexto {

	public JFrame frmEditorDeTexto;
	/**
	 * Create the application.
	 */
	public EditorTexto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditorDeTexto = new JFrame();
		frmEditorDeTexto.setTitle("Editor de Texto");
		frmEditorDeTexto.setBounds(100, 100, 634, 520);
		frmEditorDeTexto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditorDeTexto.getContentPane().setLayout(null);
		
		JTextArea campoTexto = new JTextArea();
		campoTexto.setBounds(12, 24, 602, 404);
		frmEditorDeTexto.getContentPane().add(campoTexto);
		
		JButton botaoGerar = new JButton("Printar no Console");
		botaoGerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salvarTexto();
			}
			private void salvarTexto() {
				String texto = campoTexto.getText();
				System.out.println(texto);
			}
		});
		botaoGerar.setBounds(12, 455, 166, 25);
		frmEditorDeTexto.getContentPane().add(botaoGerar);
		
		JButton btnSalvarNoPc = new JButton("Salvar no PC");
		btnSalvarNoPc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					gravarTexto();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			private void gravarTexto() throws IOException {
				JFileChooser salvar = new JFileChooser();
				salvar.setCurrentDirectory(null);
				int escolha = salvar.showSaveDialog(null);
				if(escolha == JFileChooser.APPROVE_OPTION) {
					File arquivo = new File(salvar.getSelectedFile().getAbsolutePath());
					String[] linha = campoTexto.getText().split("/n");
					
					FileWriter escrita = new FileWriter(arquivo);
					PrintWriter print = new PrintWriter(escrita);
					
					for(int i=0;i<linha.length;i++) {
						if(i==linha.length-1) {
							print.write(linha[i]);
							print.flush();
						}else {
							print.write(linha[i]+"/n");
							print.flush();
						}
					}
					print.close();
				}
			}
		});
		btnSalvarNoPc.setBounds(448, 455, 166, 25);
		frmEditorDeTexto.getContentPane().add(btnSalvarNoPc);
	}
}
