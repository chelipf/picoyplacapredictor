package com.chelipinedaferrer.picoplaca;

import java.util.Scanner;

import com.chelipinedaferrer.picoplaca.predictor.PicoPlacaPredictor;

public class Main {

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);

		System.out.print("Plate Number:");
		String plateNumber = scanIn.nextLine();
		System.out.print("Date ('yyyy-MM-dd'):");
		String date = scanIn.nextLine();
		System.out.print("Time ('HH:mm):");
		String time = scanIn.nextLine();
		scanIn.close();

		try {
			if (PicoPlacaPredictor.isPicoPlaca(plateNumber, date, time)) {
				System.out.println("You are in 'Pico y Placa' time, your vehicle can not be on the road.");
			} else {
				System.out.println("You are not in 'Pico y Placa' time, go ahead.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
