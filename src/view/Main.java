package view;

import java.awt.EventQueue;

import controller.EditorTexto;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorTexto janela = new EditorTexto();
					janela.frmEditorDeTexto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
