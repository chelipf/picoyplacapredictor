package com.chelipinedaferrer.picoplaca.entities;

/**
 * Vehicle Entity class.
 * 
 * @author Cheli Pineda Ferrer
 *
 */
public class Vehicle {
	private String plateNumber;

	/**
	 * Constructs a Vehicle without any Plate Number.
	 */
	public Vehicle() {
	}

	/**
	 * Constructs a Vehicle with the specified Plate Number.
	 * 
	 * @param plateNumber The Plate Number of the Vehicle.
	 * @throws IllegalArgumentException If the argument is invalid.
	 */
	public Vehicle(String plateNumber) throws IllegalArgumentException {
		setPlateNumber(plateNumber);
	}

	/**
	 * Gets the Plate Number.
	 * 
	 * @return The Plate Number.
	 */
	public String getPlateNumber() {
		return plateNumber;
	}

	/**
	 * Gets the last digit of the Plate Number.
	 * 
	 * @return An int representing the last digit of the Plate Number.
	 */
	public int getLastPlateNumber() {
		int lastPlateNumber;
		try {
			lastPlateNumber = Integer.parseInt(plateNumber.substring(plateNumber.length() - 1));
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			lastPlateNumber = -1;
		}

		return lastPlateNumber;
	}

	/**
	 * Sets the Plate Number of the Vehicle. The validity of the Plate Number is verified.
	 * 
	 * @param plateNumber The Plate Number of the Vehicle.
	 * @throws IllegalArgumentException If the argument is invalid.
	 */
	public void setPlateNumber(String plateNumber) throws IllegalArgumentException {
		if (isPlateNumber(plateNumber)) {
			this.plateNumber = plateNumber;
		} else {
			throw new IllegalArgumentException("Argument " + plateNumber + " is not a valid plate number.");
		}
	}

	/**
	 * Checks the validity of the Plate Number.
	 * 
	 * @param plateNumber The Plate Number of the Vehicle.
	 * @return True if the Plate Number is valid.
	 */
	public static boolean isPlateNumber(String plateNumber) {
		return plateNumber.matches("^[a-zA-Z]{3}\\-[0-9]{3,4}$");
	}
}
