package com.example.justracing;

public class Lehmer {
	// X=(ax + c)%m
	private static long MAXNUMBER; 			// m
	private static long MULTIPLYNUMBER; 	// a
	private static long ADDNUMBER;			// C
	private static long seed; 				// x
	
	public Lehmer () {
		setMAXNUMBER(2^60);
		setMULTIPLYNUMBER(2);
		setADDNUMBER(2);
		setSeed(0);
	}

	public static long getMAXNUMBER() {
		return MAXNUMBER;
	}

	public static void setMAXNUMBER(long mAXNUMBER) {
		MAXNUMBER = mAXNUMBER;
	}

	public static long getMULTIPLYNUMBER() {
		return MULTIPLYNUMBER;
	}

	public static void setMULTIPLYNUMBER(long mULTIPLINUMBER) {
		MULTIPLYNUMBER = mULTIPLINUMBER;
	}

	public static long getADDNUMBER() {
		return ADDNUMBER;
	}

	public static void setADDNUMBER(long aDDNUMBER) {
		ADDNUMBER = aDDNUMBER;
	}

	public static long getSeed() {
		return seed;
	}

	public static void setSeed(long seed) {
		Lehmer.seed = seed;
	}
	
	
	public long doLhemer (long pSeed) {
		setSeed(pSeed);
		long randomNumber = (MULTIPLYNUMBER*pSeed) + ADDNUMBER % MAXNUMBER;
		return randomNumber;
	}
	
	
	
	
}