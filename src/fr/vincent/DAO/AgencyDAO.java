package fr.vincent.DAO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

import fr.vincent.DTO.Agency;

public class AgencyDAO {
	private byte[] data = null;
	private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	private File file;
	private ObjectOutput out = null;

	public AgencyDAO() {
		super();

	}

	public void saveAgency(List<Agency> agency) {
		file = new File("C:/Users/utilisateur/Documents/save");

		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			if (!file.exists()) {
				file.createNewFile();
			}

			out = new ObjectOutputStream(byteArrayOutputStream);
			out.writeObject(agency);
			out.flush();

			data = byteArrayOutputStream.toByteArray();

			outputStream.write(data);
			outputStream.flush();
			outputStream.close();

			System.out.println("Save done...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
