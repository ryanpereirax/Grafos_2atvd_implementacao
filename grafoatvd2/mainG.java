package grafoatvd2;

import java.util.Scanner;
import java.io.*;

public class mainG {

	public static void main(String[] args) throws FileNotFoundException {

		String file = "C:\\pequenoG.txt";
		String[][] adjacent = new String[13][13];
		Scanner sc = new Scanner(new FileReader(file)).useDelimiter("\\s+|\\n");
		int inputC = 0;
		int countI = 0;
		int outputCont = 0;
		int outputC = 0;

		for (int line = 0; line < adjacent.length; line++) {
			for (int column = 0; column < adjacent[line].length; column++) {
				adjacent[line][column] = "0";
			}
		}

		String vtcfull = sc.next();
		String arstfull = sc.next();

		while (sc.hasNext()) {
			String vtc1 = sc.next();
			String vtc2 = sc.next();
			int line = Integer.parseInt(vtc1);
			int column = Integer.parseInt(vtc2);
			adjacent[line][column] = "1";
		}

		System.out.println("-------------------------------");
		System.out.println("Numero TOTAL de Vertices: " + vtcfull);
		System.out.println("Numero TOTAL de Arestas: " + arstfull);
		System.out.println("-------------------------------");

		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("TAMANHO = " + arstfull);
		System.out.println("ORDEM = " + vtcfull);
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println(">> GRAUS DE ENTRADA: << ");

		for (int x = 0; x < adjacent.length; x++) {
			for (int z = 0; z < adjacent[0].length; z++) {
				if (adjacent[z][x].equals("1")) {
					inputC++;
				}
				if (adjacent[x][z].equals("1")) {
					outputC++;
				}
			}

			System.out.println("-------------------------------");
			System.out.println("GRAU DE ENTRADA DO VERTICE " + x + " EH IGUAL A " + inputC
					+ " GRAU DE SAIDA EH IGUAL A: " + outputC);
			System.out.println("-------------------------------");

			if (outputC == 0) {
				System.out.println("VERTICE " + x + " (DE EXTREMIDADE!)");
				outputCont++;
			} else {
				System.out.println("VERTICE " + x + " (DE NAO EXTREMIDADE)");
			}

			if (inputC == 0 && outputC == 0) {
				System.out.println("VERTICE " + x + " (ISOLADO)");
				countI++;
				System.out.println("-------------------------------");
				System.out.println();
			} else {
				System.out.println("VERTICE " + x + " (NAO ISOLADO)");
				System.out.println();
			}
			inputC = 0;
			outputC = 0;
		}
		System.out.println("VERTICES DE EXTREMIDADE, TOTAL = " + outputCont);
		System.out.println("VERTICES ISOLADOS, TOTAL = " + countI);
		System.out.println();

		for (int y = 0; y < adjacent.length; y++) {
			for (int c = 0; c < adjacent[0].length; c++) {
				System.out.print(adjacent[y][c] + " ");
			}
			System.out.println(" ");
		}
	}
}
