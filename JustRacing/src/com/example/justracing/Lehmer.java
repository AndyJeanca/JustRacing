package com.example.justracing;

public class Lehmer {
	// X=(ax + c)%m
	private long MAXNUMBER; 				// m
	private final long MULTIPLYNUMBER; 		// a
	private final long ADDNUMBER;			// c
	private long seed; 						// x
	
	public Lehmer () {
		MAXNUMBER = 2^60;
		MULTIPLYNUMBER = 600;
		ADDNUMBER = 600;
		seed = 0;
	}

	public long getMaxNumber() {
		return MAXNUMBER;
	}

	public void setMaxNumber(long mAXNUMBER) {
		MAXNUMBER = mAXNUMBER;
	}

	public final long getMULTIPLYNUMBER() {
		return MULTIPLYNUMBER;
	}


	public final long getADDNUMBER() {
		return ADDNUMBER;
	}

	public long getSeed() {
		return seed;
	}

	public void setSeed(long pSeed) {
		seed = pSeed;
	}
	
	public long doLhemer (long pSeed) {
		seed = pSeed;
		long randomNumber = (MULTIPLYNUMBER*pSeed + ADDNUMBER) % MAXNUMBER;
		return randomNumber;
	}
	
	
	
	
}