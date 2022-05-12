package futbolista;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class equiposerializable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// escritura //
	public void cargar(Object[] lista, String url) {

		// escritura //

		try {

			FileOutputStream fos = new FileOutputStream(url);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (Object ar : lista) {

				oos.writeObject(ar);

			}

			oos.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("error en añadir un fichero  " + e.getMessage());
		}

	}

	// lectura //
	public void lectura(equipo guardar , ArrayList<equipo> equipo) {

		FileInputStream fis;

		try {

			fis = new FileInputStream("./memoria/equipo.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			while (fis.available() > 0) {
				guardar = (equipo) ois.readObject();
				equipo.add(guardar);
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("error en leer un fichero  " + e.getMessage());
		}

	}

}
