package assets.kk.models.item;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {
	public static void main(String[] args) {
		System.out.println("Starting program");
		int c = 0;
		final File folder = new File(".");
		File file = null;
		File tempFile = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;

		for (final File fileEntry : folder.listFiles()) {
			// System.out.println(fileEntry.getName());
			file = new File(fileEntry.getName());
			if (file.getName().contains(".mtl")) {
				System.out.println("mtl");
				tempFile = new File("temp" + file.getName());

				try {
					System.out.println(file.getAbsolutePath());
					reader = new BufferedReader(new FileReader(file));
					writer = new BufferedWriter(new FileWriter(tempFile));
					String text = null;
					int times = 0;
					while ((text = reader.readLine()) != null) {
						times++;

						if ((text.startsWith("Ns") || text.startsWith("Ks") || text.startsWith("Ke") || text.startsWith("Ni") || text.startsWith("illum") || text.startsWith("map_d"))) {
							System.out.println(times + ": " + text.substring(0, text.indexOf(" ")) + " found");
						} else {
							writer.write(text + System.getProperty("line.separator"));
							System.out.println(times + ": Nothing");
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (reader != null) {
							writer.close();
							reader.close();
							// Delete the original file
							if (!file.delete()) {
								System.out.println("Could not delete file");
								return;
							}

							// Rename the new file to the filename the original file had.
							if (!tempFile.renameTo(file))
								System.out.println("Could not rename file");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else if (file.getName().contains(".obj")) {
				tempFile = new File("temp" + file.getName());

				try {
					System.out.println(file.getAbsolutePath());
					reader = new BufferedReader(new FileReader(file));
					writer = new BufferedWriter(new FileWriter(tempFile));
					String text = null;
					int times = 0;
					while ((text = reader.readLine()) != null) {
						times++;

						if ((text.startsWith("s"))) {
							System.out.println(times + ": " + text.substring(0, text.indexOf(" ")) + " found");
						} else {
							writer.write(text + System.getProperty("line.separator"));
							System.out.println(times + ": Nothing");

						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (reader != null) {
							writer.close();
							reader.close();
							// Delete the original file
							if (!file.delete()) {
								System.out.println("Could not delete file");
								return;
							}

							// Rename the new file to the filename the original file had.
							if (!tempFile.renameTo(file))
								System.out.println("Could not rename file");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// Ns, Ke, Ni, illum, map_d
	}
	/*
	 * static void randomizador() {
	 * 
	 * @SuppressWarnings("resource") Scanner reader = new Scanner(System.in);
	 * System.out.println("Hola bienvenido al randomizador"); String[] users = new
	 * String[100]; boolean seguir = true; System.out.println(users.length);
	 * System.out.println("Introduce todos los usuarios:"); int vueltas = 0;
	 * while(seguir) { String input = reader.next(); if(input.equals(".")){ break; }
	 * else{ users[vueltas] = input; vueltas++; } } shuffleArray(users); for(int i =
	 * 0; i< users.length; i++) { if(users[i] != null) System.out.println(users[i]);
	 * } }
	 * 
	 * static void shuffleArray(String[] ar) { Random rnd =
	 * ThreadLocalRandom.current(); for (int i = ar.length - 1; i > 0; i--) { int
	 * index = rnd.nextInt(i + 1); // Simple swap String a = ar[index]; ar[index] =
	 * ar[i]; ar[i] = a; } }
	 */
}
